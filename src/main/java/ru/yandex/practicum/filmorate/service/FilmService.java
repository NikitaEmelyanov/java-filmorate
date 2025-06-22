package ru.yandex.practicum.filmorate.service;

import java.util.List;
import ru.yandex.practicum.filmorate.dto.film.RequestFilmDto;
import ru.yandex.practicum.filmorate.dto.film.ResponseFilmDto;

public interface FilmService {

    ResponseFilmDto create(RequestFilmDto requestFilmDto);

    ResponseFilmDto update(RequestFilmDto requestFilmWithIdDto);

    List<ResponseFilmDto> getAll();

    void addLike(Integer filmId, Integer userId);

    void removeLike(Integer filmId, Integer userId);

    List<ResponseFilmDto> getPopularFilms(int count);
}