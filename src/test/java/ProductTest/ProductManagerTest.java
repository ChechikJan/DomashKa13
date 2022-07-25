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
    Product product1 = new Book(1, "Мать", 500, "Максим Горький");
    Product product2 = new Book(2, "Ведьмак", 1500, "Анджей Сапковский");
    Product product3 = new Book(3, "Сказки", 1000, "Александр Пушкин");
    Product product4 = new Book(4, "Бородино", 500, "Михаил Лермонтов");
    Product product5= new Smartphone(5, "Galaxy A5", 5000, "Samsung");
    Product product6 = new Smartphone(6, "RedmiNote 9", 14000, "Xiaomi");
    Product product7 = new Smartphone(7, "Iphone 9S", 25000, "Samsung");

    @Test
    public void addNewProduct(){
        manager.addProduct(product1);
        manager.addProduct(product2);
        manager.addProduct(product3);
        manager.addProduct(product4);
        manager.addProduct(product5);
        manager.addProduct(product6);
        manager.addProduct(product7);
        Product[] expected = {product1, product2, product3,product4, product5, product6, product7};
        Product[] actual = manager.getProducts();
        Assertions.assertArrayEquals(expected, actual);

    }
    @Test
    public void removeProduct(){
        manager.addProduct(product1);
        manager.addProduct(product2);
        manager.addProduct(product3);
        manager.addProduct(product4);
        manager.addProduct(product5);
        manager.addProduct(product6);
        manager.addProduct(product7);
        manager.removeById(4);
        Product[] expected = {product1, product2, product3, product5, product6, product7};
        Product[] actual = manager.getProducts();
        Assertions.assertArrayEquals(expected, actual);

    }
    @Test
    public void searchProduct() {
        manager.addProduct(product1);
        manager.addProduct(product2);
        manager.addProduct(product3);
        manager.addProduct(product4);
        manager.addProduct(product5);
        manager.addProduct(product6);
        manager.addProduct(product7);
        Product[] expected = {product2};
        Product[] actual = manager.searchBy("Ведьмак");
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void searchNotProduct() {
        manager.addProduct(product1);
        manager.addProduct(product2);
        manager.addProduct(product3);
        manager.addProduct(product4);
        manager.addProduct(product5);
        manager.addProduct(product6);
        manager.addProduct(product7);

        Product[] expected = {};
        Product[] actual = manager.searchBy("Огонь");
        Assertions.assertArrayEquals(expected, actual);
    }

    }



