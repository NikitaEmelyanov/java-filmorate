package ru.yandex.practicum.filmorate.storage.film;

import org.springframework.stereotype.Repository;
import ru.yandex.practicum.filmorate.model.Film;

import java.util.*;

@Repository
public class FilmStorageImpl implements FilmStorage {

    private final Map<Integer, Film> filmMap = new HashMap<>();
    private Integer id = 1;

    @Override
    public Film create(Film film) {
        film.setId(nexId());
        filmMap.put(film.getId(), film);

        return filmMap.get(film.getId());
    }

    @Override
    public Optional<Film> update(Film film) {
        Optional<Film> updatedFilm = Optional.empty();

        if (checkId(film.getId())) {
            filmMap.replace(film.getId(), film);
            updatedFilm = Optional.of(filmMap.get(film.getId()));
        }

        return updatedFilm;
    }

    @Override
    public List<Film> getAll() {
        return filmMap.values().stream().toList();
    }

    @Override
    public Optional<Boolean> addLike(Integer filmId, Integer userId) {
        if (checkId(filmId)) {
            Film film = filmMap.get(filmId);
            film.setLike(userId);
            update(film);

            return Optional.of(true);
        }
        return Optional.empty();
    }

    @Override
    public Optional<Boolean> removeLike(Integer filmId, Integer userId) {
        if (checkId(filmId)) {
            Film film = filmMap.get(filmId);
            film.removeLike(userId);
            update(film);
            return Optional.of(true);
        }
        return Optional.empty();
    }

    @Override
    public List<Film> getPopularFilms(int count) {
        return filmMap.values().stream()
                .sorted(Comparator.comparingInt(film -> -film.getLikes().size()))
                .limit(count)
                .toList();
    }

    private int nexId() {
        return this.id++;
    }

    private boolean checkId(Integer id) {
        return filmMap.containsKey(id);
    }
}