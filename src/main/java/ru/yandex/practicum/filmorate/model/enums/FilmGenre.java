package ru.yandex.practicum.filmorate.model.enums;

public enum FilmGenre {
    COMEDY("Комедия"),
    DRAMA("Драма"),
    ANIMATION("Мультфильм"),
    THRILLER("Триллер"),
    DOCUMENTARY("Документальный"),
    ACTION("Боевик");

    private final String name;

    FilmGenre(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}