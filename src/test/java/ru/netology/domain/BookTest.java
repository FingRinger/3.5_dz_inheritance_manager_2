package ru.netology.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.netology.repository.ProductRepository;

import static org.junit.jupiter.api.Assertions.*;

class BookTest {
    private ProductRepository repository = new ProductRepository();
    private Product firstBook = new Book(1, "Good Omens", 700, "Pratchett Terry");
    private  Product secondBook = new Book(2, "The Joy of JavaScript", 900, "Luis Atencio");


    @BeforeEach
    public void setUp(){
        repository.save(firstBook);
        repository.save(secondBook);
    }

    @Test
    public void shouldBeTrueBook() {
        boolean actual = secondBook.matches("Java");
        assertTrue(actual);
    }

    @Test
    public void shouldNotBeTrueName() {
        boolean actual = secondBook.matches("LadyBird");
        assertFalse(actual);
    }

    @Test
    public void shouldBeTrueAuthor(){
        boolean actual = firstBook.matches("Pratchett Terry");
        assertTrue(actual);
    }

    @Test
    public void shouldNotBeTrueAuthor(){
        boolean actual = firstBook.matches("Luis Terry");

        assertFalse(actual);
    }

}