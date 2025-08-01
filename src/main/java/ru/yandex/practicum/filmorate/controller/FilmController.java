package ru.yandex.practicum.filmorate.controller;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import java.util.Collection;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import ru.yandex.practicum.filmorate.dto.classes.FilmResponseDto;
import ru.yandex.practicum.filmorate.dto.classes.LikeResponseDto;
import ru.yandex.practicum.filmorate.dto.create.FilmCreateRequestDto;
import ru.yandex.practicum.filmorate.dto.update.FilmUpdateDto;
import ru.yandex.practicum.filmorate.service.FilmService;

@RestController
@RequestMapping("/films")
@Slf4j
@AllArgsConstructor
public class FilmController {

    private final FilmService filmService;

    @PostMapping
    public FilmResponseDto create(@Valid @NotNull @RequestBody FilmCreateRequestDto film) {
        log.trace("добавление фильма");
        return filmService.createFilm(film);
    }

    @PutMapping
    public FilmResponseDto update(@Valid @NotNull @RequestBody FilmUpdateDto film) {
        log.trace("обновление фильма");
        return filmService.updateFilm(film);
    }

    @GetMapping
    public Collection<FilmResponseDto> findAll() {
        log.trace("получение фильмов");
        return filmService.findAllFilms();
    }

    @PutMapping("/{id}/like/{userId}")
    public LikeResponseDto likeFilm(@PathVariable("id") long filmId, @PathVariable long userId) {
        log.trace("Добавление лайка фильму");
        return filmService.likeFilm(filmId, userId);
    }

    @DeleteMapping("/{id}/like/{userId}")
    public boolean deleteLikeFilm(@PathVariable("id") long filmId, @PathVariable long userId) {
        log.trace("Удаление лайка");
        return filmService.deleteLikeFilm(filmId, userId);
    }

    @GetMapping("/popular")
    public Collection<FilmResponseDto> getPopularFilms(
        @RequestParam(name = "count", defaultValue = "10") int count) {
        log.trace("Получить топ популярных фильмов");
        return filmService.getPopularFilms(count);
    }

    @GetMapping("/{id}")
    public FilmResponseDto findFilmById(@PathVariable Integer id) {
        return filmService.findFilmById(id);
    }
}