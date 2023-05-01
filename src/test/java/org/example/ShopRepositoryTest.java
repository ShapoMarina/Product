package org.example;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ShopRepositoryTest {


    @Test
    public void shouldDeleteExistingElement() {
        ShopRepository repo = new ShopRepository();

        Product product1 = new Product(12, "Чайник", 6_000);
        Product product2 = new Product(56, "Микроволновая печь", 20_000);
        Product product3 = new Product(33, "Хлебопечка", 30_000);

        repo.add(product1);
        repo.add(product2);
        repo.add(product3);

        repo.remove(12);

        Product[] actual = repo.findAll();
        Product[] expected = {product2, product3};

        Assertions.assertArrayEquals(actual, expected);
    }

    @Test
    public void shouldDeleteNotExistingElement() {
        ShopRepository repo = new ShopRepository();

        Product product1 = new Product(12, "Чайник", 6_000);
        Product product2 = new Product(56, "Микроволновая печь", 20_000);
        Product product3 = new Product(33, "Хлебопечка", 30_000);

        repo.add(product1);
        repo.add(product2);
        repo.add(product3);

        Assertions.assertThrows(NotFoundException.class, () -> repo.remove(3));

    }
}
