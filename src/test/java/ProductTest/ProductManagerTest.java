package ProductTest;

import ProductManager.ProductManager;
import ProductRepository.ProductRepository;
import org.Product.Book;
import org.Product.Product;
import org.Product.Smartphone;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class ProductManagerTest {
    ProductRepository repository = new ProductRepository();
ProductManager manager = new ProductManager(repository);
    Product book1 = new Book(1, "Мать", 500, "Максим Горький");
    Product book2 = new Book(2, "Ведьмак", 1500, "Анджей Сапковский");
    Product book3 = new Book(3, "Сказки", 1000, "Александр Пушкин");
    Product book4 = new Book(4, "Бородино", 500, "Михаил Лермонтов");
    Product smartphone1 = new Smartphone(5, "Galaxy A5", 5000, "Samsung");
    Product smartphone2 = new Smartphone(6, "RedmiNote 9", 14000, "Xiaomi");
    Product smartphone3 = new Smartphone(7, "Iphone 9S", 25000, "Samsung");

    @Test
    public void addNewProduct(){
        manager.addProduct(book1);
        manager.addProduct(book2);
        manager.addProduct(book3);
        manager.addProduct(book4);
        manager.addProduct(smartphone1);
        manager.addProduct(smartphone2);
        manager.addProduct(smartphone3);
        Product[] expected = {book1, book2, book3, book4, smartphone1, smartphone2, smartphone3};
        Product[] actual = manager.getProducts();
        Assertions.assertArrayEquals(expected, actual);

    }
    @Test
    public void removeProduct(){
        manager.addProduct(book1);
        manager.addProduct(book2);
        manager.addProduct(book3);
        manager.addProduct(book4);
        manager.addProduct(smartphone1);
        manager.addProduct(smartphone2);
        manager.addProduct(smartphone3);
        manager.removeById(4);
        Product[] expected = {book1, book2, book3,  smartphone1, smartphone2, smartphone3};
        Product[] actual = manager.getProducts();
        Assertions.assertArrayEquals(expected, actual);

    }
    @Test
    public void searchProduct() {
        manager.addProduct(book1);
        manager.addProduct(book2);
        manager.addProduct(book3);
        manager.addProduct(book4);
        manager.addProduct(smartphone1);
        manager.addProduct(smartphone2);
        manager.addProduct(smartphone3);

        Product[] expected = {book2};
        Product[] actual = manager.searchBy("Ведьмак");
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void searchNotProduct() {
        manager.addProduct(book1);
        manager.addProduct(book2);
        manager.addProduct(book3);
        manager.addProduct(book4);
        manager.addProduct(smartphone1);
        manager.addProduct(smartphone2);
        manager.addProduct(smartphone3);

        Product[] expected = {};
        Product[] actual = manager.searchBy("Огонь");
        Assertions.assertArrayEquals(expected, actual);
    }

    }



