package ru.yandex.practicum.filmorate.mapper;

import org.mapstruct.Mapper;
import ru.yandex.practicum.filmorate.dto.film.RequestFilmDto;
import ru.yandex.practicum.filmorate.dto.film.ResponseFilmDto;
import ru.yandex.practicum.filmorate.model.Film;

@Mapper(componentModel = "spring")
public interface FilmMapper {

    Film convertRequestFilmDtoToFilm(RequestFilmDto requestFilmDto);

    ResponseFilmDto convertFilmToResponseFilmDto(Film film);
}
