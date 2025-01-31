package ru.netology.arrays;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class PosterManagerTest {

    Movie movie1 = new Movie("Бладшот", "боевик", false, true);
    Movie movie2 = new Movie("Вперед", "мультфильм", false, true);
    Movie movie3 = new Movie("Отель\"Белград\"", "комедия", false, false);
    Movie movie4 = new Movie("Джентельмены", "боевик", false, true);
    Movie movie5 = new Movie("Человек-невидимка", "ужасы", false, true);
    Movie movie6 = new Movie("Тролли. Мировой тур", "мультфильм", true, false);
    Movie movie7 = new Movie("Номер один", "комедия", true, false);

    @Test
    public void shouldNotAddMovie() {   // не добавлять фильм
        PosterManager manager = new PosterManager();

        Movie[] actual = manager.findAll();
        String[] expected = {};

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldAddOneMovie() {   // добавить один фильм в порядке добавления
        PosterManager manager = new PosterManager();

        manager.addMovie(movie1);

        Movie[] actual = manager.findAll();
        Movie[] expected = {movie1};

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldAddThreeMovies() {   // добавить три фильма в порядке добавления
        PosterManager manager = new PosterManager();

        manager.addMovie(movie1);
        manager.addMovie(movie2);
        manager.addMovie(movie3);

        Movie[] actual = manager.findAll();
        Movie[] expected = {movie1, movie2, movie3};

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldAddLastFiveMovies() {   //добавить пять последних фильмов
        PosterManager manager = new PosterManager();

        manager.addMovie(movie1);
        manager.addMovie(movie2);
        manager.addMovie(movie3);
        manager.addMovie(movie4);
        manager.addMovie(movie5);

        Movie[] actual = manager.findLast();
        Movie[] expected = {movie5, movie4, movie3, movie2, movie1};

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldAddLastFiveMoviesOutOfSix() {   //добавить пять последних фильмов из шести
        PosterManager manager = new PosterManager();

        manager.addMovie(movie1);
        manager.addMovie(movie2);
        manager.addMovie(movie3);
        manager.addMovie(movie4);
        manager.addMovie(movie5);
        manager.addMovie(movie6);

        Movie[] actual = manager.findLast();
        Movie[] expected = {movie6, movie5, movie4, movie3, movie2};

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldAddLastFourMovies() {   // должен добавить четыре последних фильма
        PosterManager manager = new PosterManager();

        manager.addMovie(movie4);
        manager.addMovie(movie5);
        manager.addMovie(movie6);
        manager.addMovie(movie7);


        Movie[] actual = manager.findLast();
        Movie[] expected = {movie7, movie6, movie5, movie4};

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldAddLastThreeMovies() {   // должен добавить три последних фильма
        PosterManager manager = new PosterManager(3);

        manager.addMovie(movie1);
        manager.addMovie(movie2);
        manager.addMovie(movie3);

        Movie[] actual = manager.findLast();
        Movie[] expected = {movie3, movie2, movie1};

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldNotAddLastMoviesOverLimit() {   // не должен добавить четыре последних фильма
        PosterManager manager = new PosterManager(3);

        manager.addMovie(movie1);
        manager.addMovie(movie2);
        manager.addMovie(movie3);
        manager.addMovie(movie4);

        Movie[] actual = manager.findLast();
        Movie[] expected = {movie4, movie3, movie2};

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldAddLastTwoMovies() {   // должен добавить два последних фильма
        PosterManager manager = new PosterManager(3);

        manager.addMovie(movie6);
        manager.addMovie(movie7);

        Movie[] actual = manager.findLast();
        Movie[] expected = {movie7, movie6};

        Assertions.assertArrayEquals(expected, actual);
    }
}
