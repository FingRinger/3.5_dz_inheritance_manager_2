package ru.netology.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.netology.manager.ProductManager;
import ru.netology.repository.ProductRepository;

import static org.junit.jupiter.api.Assertions.*;

class SmartphoneTest {
    private ProductRepository repository = new ProductRepository();

    private Product firstSmartphone = new Smartphone(3, "Google Pixel 5 8/128Gb Black", 60000, "HTC Corporation");
    private  Product secondSmartphone = new Smartphone(4, "Смартфон Xiaomi Mi 11 256GB Horizon Blue", 62000, "Xiaomi Corporation");

    @BeforeEach
    public void setUp(){
        repository.save(firstSmartphone);
        repository.save(secondSmartphone);
    }

    @Test
    public void shouldNotBeTrueSmartphone(){
        boolean actual = firstSmartphone.matches("HTC vive pro 2");
        assertFalse(actual);
    }

    @Test
    public void shouldBeTrueSmartphone(){
        boolean actual = firstSmartphone.matches("HTC");
        assertTrue(actual);
    }
}