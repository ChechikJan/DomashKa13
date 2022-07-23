package ProductTest;

import ProductRepository.ProductRepository;
import org.Product.Book;
import org.Product.Product;
import org.Product.Smartphone;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class ProductRepositoryTest {
    ProductRepository repository = new ProductRepository();
    Product book1 = new Book(1, "Мать", 500, "Максим Горький");
    Product book2 = new Book(2, "Ведьмак", 1500, "Анджей Сапковский");
    Product book3 = new Book(3, "Сказки", 1000, "Александр Пушкин");
    Product book4 = new Book(4, "Бородино", 500, "Михаил Лермонтов");
    Product smartphone1 = new Smartphone(5, "Galaxy A5", 5000, "Samsung");
    Product smartphone2 = new Smartphone(6, "RedmiNote 9", 14000, "Xiaomi");
    Product smartphone3 = new Smartphone(7, "Iphone 9S", 25000, "Samsung");


    @Test
    void save() {
        repository.save(book1);
        repository.save(book2);
        repository.save(book3);
        repository.save(book4);
        repository.save(smartphone1);
        repository.save(smartphone2);
        repository.save(smartphone3);
        Product[] expected = {book1, book2, book3, book4, smartphone1, smartphone2, smartphone3};
        Product[] actual = repository.getProducts();
        Assertions.assertArrayEquals(expected, actual);


    }

    @Test
    void removeById() {
        repository.save(book1);
        repository.save(book2);
        repository.save(book3);
        repository.save(book4);
        repository.save(smartphone1);
        repository.save(smartphone2);
        repository.save(smartphone3);
        repository.removeById(book4.getId());
        Product[] expected = {book1, book2, book3, smartphone1, smartphone2, smartphone3};

        Product[] actual = repository.getProducts();
        Assertions.assertArrayEquals(expected, actual);
    }


}