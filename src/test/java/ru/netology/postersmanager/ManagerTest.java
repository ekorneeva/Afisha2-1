package ru.netology.postersmanager;

import org.junit.jupiter.api.Test;
import ru.netology.domain.Movie;
import ru.netology.manager.Manager;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

class ManagerTest {

    Movie first = new Movie(1, "saw", "horror");
    Movie second = new Movie(2, "saw2", "horror");
    Movie third = new Movie(3, "saw3", "horror");
    Movie fourth = new Movie(4, "saw4", "horror");
    Movie fifth = new Movie(5, "saw5", "horror");
    Movie sixth = new Movie(6, "saw6", "horror");
    Movie seventh = new Movie(7, "saw7", "horror");
    Movie eighth = new Movie(8, "saw8", "horror");
    Movie ninth = new Movie(9, "saw9", "horror");
    Movie tenth = new Movie(10, "saw10", "horror");
    Movie eleventh = new Movie(11, "saw11", "horror");


    @Test
    public void shouldNullMovie() {   //   пустой список
        Manager movie = new Manager();
        Movie[] expected = {};
        Movie[] actual = movie.findAll();

        assertArrayEquals(expected, actual);
    }


    @Test
    public void shouldAddMovie() {   // Добавление нового фильма.

        Manager movie = new Manager();
        movie.addMovie(first);


        Movie[] expected = {first};
        Movie[] actual = movie.findAll();
        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldAddMovie2() {   // Добавление нового фильма, у уже имеющимся

        Manager movie = new Manager();
        movie.addMovie(first);
        movie.addMovie(second);

        Movie[] expected = {first, second};
        Movie[] actual = movie.findAll();
        assertArrayEquals(expected, actual);
    }


    @Test
    public void shouldAddMovie3() {
        Manager manager = new Manager(11); // Вывод всех фильмов в порядке добавления (findAll)
        manager.addMovie(first);
        manager.addMovie(second);
        manager.addMovie(third);
        manager.addMovie(fourth);
        manager.addMovie(fifth);
        manager.addMovie(sixth);
        manager.addMovie(seventh);
        manager.addMovie(eighth);
        manager.addMovie(ninth);
        manager.addMovie(tenth);
        manager.addMovie(eleventh);

        Movie[] expected = {first, second, third, fourth, fifth, sixth, seventh, eighth, ninth, tenth, eleventh};
        Movie[] actual = manager.findAll();
        assertArrayEquals(expected, actual); // на массивах не работает без Array
    }

    @Test
    public void shouldAddTenMovie() {       // добавим 10 фильмов
        Manager manager = new Manager(10);
        manager.addMovie(first);
        manager.addMovie(second);
        manager.addMovie(third);
        manager.addMovie(fourth);
        manager.addMovie(fifth);
        manager.addMovie(sixth);
        manager.addMovie(seventh);
        manager.addMovie(eighth);
        manager.addMovie(ninth);
        manager.addMovie(tenth);


        Movie[] expected = {first, second, third, fourth, fifth, sixth, seventh, eighth, ninth, tenth};
        Movie[] actual = manager.findAll();
        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldAddOneMovie() { //добавим первый фильм
        Manager manager = new Manager(1);
        manager.addMovie(first);

        Movie[] expected = {first};
        Movie[] actual = manager.findAll();
        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldFindLastTenOverLimitMovie() {   // найдем последние 10 фильмов
        Manager manager = new Manager(10);
        manager.addMovie(first);
        manager.addMovie(second);
        manager.addMovie(third);
        manager.addMovie(fourth);
        manager.addMovie(fifth);
        manager.addMovie(sixth);
        manager.addMovie(seventh);
        manager.addMovie(eighth);
        manager.addMovie(ninth);
        manager.addMovie(tenth);
        manager.addMovie(eleventh);

        Movie[] expected = {eleventh, tenth, ninth, eighth, seventh, sixth, fifth, fourth, third, second};
        Movie[] actual = manager.findLast();
        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldFindLastTenMovie() {  // найдем предыдущие 10 мильмов
        Manager manager = new Manager(10);
        manager.addMovie(first);
        manager.addMovie(second);
        manager.addMovie(third);
        manager.addMovie(fourth);
        manager.addMovie(fifth);
        manager.addMovie(sixth);
        manager.addMovie(seventh);
        manager.addMovie(eighth);
        manager.addMovie(ninth);
        manager.addMovie(tenth);

        Movie[] expected = {tenth, ninth, eighth, seventh, sixth, fifth, fourth, third, second, first};
        Movie[] actual = manager.findLast();
        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldFindLastFiveMovie() { // найти последние 5 фильмов в обратном порядке
        Manager manager = new Manager();
        manager.addMovie(first);
        manager.addMovie(second);
        manager.addMovie(third);
        manager.addMovie(fourth);
        manager.addMovie(fifth);

        Movie[] expected = {fifth, fourth, third, second, first};
        Movie[] actual = manager.findLast();
        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldAddMovieNoArgs() {  // @NoArgsConstructor
        Manager manager = new Manager();
        Movie one = new Movie();
        Movie two = new Movie();
        Movie three = new Movie();
        Movie four = new Movie();
        Movie five = new Movie();
        Movie six = new Movie();
        Movie seven = new Movie();
        Movie eight = new Movie();
        Movie nine = new Movie();
        Movie ten = new Movie();
        Movie eleven = new Movie();

        manager.addMovie(one);
        Movie[] expected = {one};
        Movie[] actual = manager.findAll();
        assertArrayEquals(expected, actual);
    }
}



