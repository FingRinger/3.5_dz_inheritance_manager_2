package ru.netology.manager;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.netology.domain.Book;
import ru.netology.domain.Product;
import ru.netology.domain.Smartphone;
import ru.netology.repository.ProductRepository;

import static org.junit.jupiter.api.Assertions.*;

class ProductManagerTest {
    private ProductRepository repository = new ProductRepository();
    private ProductManager manager = new ProductManager(repository);

    private Product firstBook = new Book(1, "Good Omens", 700, "Pratchett Terry");
    private  Product secondBook = new Book(2, "The Joy of JavaScript", 900, "Luis Atencio");
    private Product firstSmartphone = new Smartphone(3, "Google Pixel 5 8/128Gb Black", 60000, "HTC Corporation");
    private  Product secondSmartphone = new Smartphone(4, "Смартфон Xiaomi Mi 11 256GB Horizon Blue", 62000, "Xiaomi Corporation");

    @BeforeEach
    public void setUp(){
        repository.save(firstBook);
        repository.save(secondBook);
        repository.save(firstSmartphone);
        repository.save(secondSmartphone);
    }

    @Test // позитивный сценарий/поиск книги по названию
    public void findBookWithName() {
        manager.matches(firstBook, "Good Omens");

        Product[] expected = new Product[]{firstBook};
        Product[] actual = manager.searchBy("Good Omens");

        assertArrayEquals(expected, actual);
    }

    @Test // позитивный сценарий/поиск книги по автору
    public void findBookWithAuthor() {
        manager.matches(secondBook, "Pratchett Terry");

        Product[] expected = new Product[]{firstBook};
        Product[] actual = manager.searchBy("Pratchett Terry");

        assertArrayEquals(expected, actual);
    }

    @Test // негативный сценарий/найти книгу,которой нет в массиве
    public void thereIsNoBookWhithSuchNameInRepo() {
        Product[] expected = new Product[0];
        Product[] actual = manager.searchBy("Alice's Adventures in Wonderland");

        assertArrayEquals(expected, actual);
    }

    @Test // негативный сценарий/поиск по автору книги,которой нет в массиве
    public void thereIsNoBookOfSuchAuthorInRepo() {
        Product[] expected = new Product[0];
        Product[] actual = manager.searchBy("Lewis Carroll");

        assertArrayEquals(expected, actual);
    }

    @Test //
    public void findSmartphoneWithName() {

        Product[] expected = new Product[]{firstSmartphone};
        Product[] actual = manager.searchBy("Pixel");

        assertArrayEquals(expected, actual);
    }

    @Test //
    public void findSmartphoneWithManufacturer() {

        Product[] expected = new Product[]{firstSmartphone};
        Product[] actual = manager.searchBy("HTC");

        assertArrayEquals(expected, actual);
    }
    @Test
    public void thereIsNoSmartphoneWhithSuchNameInRepo() {
        Product[] expected = new Product[0];
        Product[] actual = manager.searchBy("Samsung");

        assertArrayEquals(expected, actual);
    }

    @Test
    public void thereIsNoSmartphoneWhithSuchManufacturerInRepo() {
        Product[] expected = new Product[0];
        Product[] actual = manager.searchBy("Huawei");

        assertArrayEquals(expected, actual);
    }
}