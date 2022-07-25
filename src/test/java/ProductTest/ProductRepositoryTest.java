package ProductTest;

import ProductRepository.ProductRepository;
import org.Product.Book;
import org.Product.Product;
import org.Product.Smartphone;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class ProductRepositoryTest {
    ProductRepository repository = new ProductRepository();
    Product product1 = new Book(1, "Мать", 500, "Максим Горький");
    Product product2 = new Book(2, "Сказки", 1500, "Шарль Перро");
    Product product3 = new Book(3, "Сказки", 1000, "Александр Пушкин");
    Product product4 = new Book(4, "Бородино", 500, "Михаил Лермонтов");
    Product product5 = new Smartphone(5, "Galaxy A5", 5000, "Samsung");
    Product product6 = new Smartphone(6, "RedmiNote 9", 14000, "Xiaomi");
    Product product7 = new Smartphone(7, "Iphone 9S", 25000, "Samsung");


    @Test
    void save() {
        repository.save(product1);
        repository.save(product2);
        repository.save(product3);
        repository.save(product4);
        repository.save(product5);
        repository.save(product6);
        repository.save(product7);
        Product[] expected = {product1, product2, product3, product4, product5, product6, product7};
        Product[] actual = repository.getProducts();
        Assertions.assertArrayEquals(expected, actual);


    }

    @Test
    void removeById() {
        repository.save(product1);
        repository.save(product2);
        repository.save(product3);
        repository.save(product4);
        repository.save(product5);
        repository.save(product6);
        repository.save(product7);
        repository.removeById(product4.getId());
        Product[] expected = {product1, product2, product3,  product5, product6, product7};

        Product[] actual = repository.getProducts();
        Assertions.assertArrayEquals(expected, actual);
    }


}