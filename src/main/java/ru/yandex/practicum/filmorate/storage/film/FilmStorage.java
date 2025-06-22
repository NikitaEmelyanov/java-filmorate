package ru.yandex.practicum.filmorate.storage.film;

import java.util.List;
import java.util.Optional;
import ru.yandex.practicum.filmorate.model.Film;

public interface FilmStorage {

    Film create(Film film);

    Optional<Film> update(Film film);

    List<Film> getAll();

    Optional<Boolean> addLike(Integer filmId, Integer userId);

    Optional<Boolean> removeLike(Integer filmId, Integer userId);

    List<Film> getPopularFilms(int count);
}