package ru.netology.arrays;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class PosterManagerTest {

    @Test
    public void shouldNotAddMovie() {   // не добавлять фильм
        PosterManager manager = new PosterManager();

        String[] actual = manager.findAll();
        String[] expected = {};

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldAddOneMovie() {   // добавить один фильм в порядке добавления
        PosterManager manager = new PosterManager();

        manager.addMovie("Бладшот");

        String[] actual = manager.findAll();
        String[] expected = {"Бладшот"};

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldAddThreeMovies() {   // добавить три фильма в порядке добавления
        PosterManager manager = new PosterManager();

        manager.addMovie("Бладшот");
        manager.addMovie("Вперед");
        manager.addMovie("Отель\"Белград\"");

        String[] actual = manager.findAll();
        String[] expected = {"Бладшот", "Вперед", "Отель\"Белград\""};

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldAddLastFiveMovies() {   //добавить пять последних фильмов
        PosterManager manager = new PosterManager();

        manager.addMovie("Бладшот");
        manager.addMovie("Вперед");
        manager.addMovie("Отель\"Белград\"");
        manager.addMovie("Джентельмены");
        manager.addMovie("Человек-невидимка");

        String[] actual = manager.findLast();
        String[] expected = {"Человек-невидимка", "Джентельмены", "Отель\"Белград\"", "Вперед", "Бладшот"};

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldAddLastFiveMoviesOutOfSix() {   //добавить пять последних фильмов из шести
        PosterManager manager = new PosterManager();

        manager.addMovie("Бладшот");
        manager.addMovie("Вперед");
        manager.addMovie("Отель\"Белград\"");
        manager.addMovie("Джентельмены");
        manager.addMovie("Человек-невидимка");
        manager.addMovie("Тролли. Мировой тур");

        String[] actual = manager.findLast();
        String[] expected = {"Тролли. Мировой тур", "Человек-невидимка", "Джентельмены", "Отель\"Белград\"", "Вперед"};

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldAddLastFourMovies() {   // должен добавить четыре последних фильма
        PosterManager manager = new PosterManager();

        manager.addMovie("Бладшот");
        manager.addMovie("Вперед");
        manager.addMovie("Отель\"Белград\"");
        manager.addMovie("Джентельмены");

        String[] actual = manager.findLast();
        String[] expected = {"Джентельмены", "Отель\"Белград\"", "Вперед", "Бладшот"};

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldAddLastThreeMovies() {   // должен добавить три последних фильма
        PosterManager manager = new PosterManager(3);

        manager.addMovie("Бладшот");
        manager.addMovie("Вперед");
        manager.addMovie("Отель\"Белград\"");

        String[] actual = manager.findLast();
        String[] expected = {"Отель\"Белград\"", "Вперед", "Бладшот"};

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldNotAddLastMoviesOverLimit() {   // не должен добавить четыре последних фильма
        PosterManager manager = new PosterManager(3);

        manager.addMovie("Бладшот");
        manager.addMovie("Вперед");
        manager.addMovie("Отель\"Белград\"");
        manager.addMovie("Джентельмены");

        String[] actual = manager.findLast();
        String[] expected = {"Джентельмены", "Отель\"Белград\"", "Вперед"};

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldAddLastTwoMovies() {   // должен добавить два последних фильма
        PosterManager manager = new PosterManager(3);

        manager.addMovie("Бладшот");
        manager.addMovie("Вперед");

        String[] actual = manager.findLast();
        String[] expected = {"Вперед", "Бладшот"};

        Assertions.assertArrayEquals(expected, actual);
    }
}
