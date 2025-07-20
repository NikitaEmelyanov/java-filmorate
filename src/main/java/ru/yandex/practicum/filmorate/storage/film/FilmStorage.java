//package ru.yandex.practicum.filmorate.storage.film;
//
//import java.util.List;
//import java.util.Optional;
//import ru.yandex.practicum.filmorate.model.Film;
//
//public interface FilmStorage {
//
//    Film create(Film film);
//
//    Optional<Film> update(Film film);
//
//    List<Film> getAll();
//
//    Optional<Boolean> addLike(Integer filmId, Integer userId);
//
//    Optional<Boolean> removeLike(Integer filmId, Integer userId);
//
//    List<Film> getAllFilms();
//
//    Optional<Film> getFilmById(int id);
//
//    Film createFilm(Film film);
//
//    Film updateFilm(Film film);
//
//    void deleteFilm(int id);
//
//    List<Film> getPopularFilms(int count);
//
//    void addLike(int filmId, int userId);
//
//    void removeLike(int filmId, int userId);
//}