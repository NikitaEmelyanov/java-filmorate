package ru.yandex.practicum.filmorate.controller;

import jakarta.validation.Valid;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.yandex.practicum.filmorate.exception.ValidationException;
import ru.yandex.practicum.filmorate.model.Film;

/**
 * Контроллер для работы с фильмами. Обрабатывает HTTP-запросы для создания, обновления и получения
 * фильмов.
 */
@RestController
@RequestMapping("/films")
@Slf4j
public class FilmController {

    private final Map<Integer, Film> films = new HashMap<>();
    private int idCounter = 1;

    /**
     * Создает новый фильм.
     *
     * @param film Объект фильма для создания
     * @return Созданный фильм
     */
    @PostMapping
    public Film createFilm(@Valid @RequestBody Film film) {
        log.info("Получен запрос на добавление фильма {}", film);
        film.isValid(); // Проверка даты релиза
        film.setId(idCounter++);
        films.put(film.getId(), film);
        log.info("Фильм успешно добавлен: {}", film);
        return film;
    }

    /**
     * Обновляет существующий фильм.
     *
     * @param film Объект фильма с обновленными данными
     * @return Обновленный фильм
     * @throws ValidationException если фильм с указанным ID не найден
     */
    @PutMapping
    public Film updateFilm(@Valid @RequestBody Film film) {
        log.info("Получен запрос на обновление фильма: {}", film);
        film.isValid(); // Проверка даты релиза
        if (!films.containsKey(film.getId())) {
            throw new ValidationException("Фильм с id=" + film.getId() + " не найден");
        }
        films.put(film.getId(), film);
        log.info("Фильм успешно обновлен: {}", film);
        return film;
    }

    /**
     * Возвращает список всех фильмов.
     *
     * @return Коллекция всех сохраненных фильмов
     */
    @GetMapping
    public Collection<Film> findAllFilms() {
        log.info("Получен запрос на получение всех фильм");
        return films.values();
    }
}
