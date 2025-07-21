package ru.yandex.practicum.filmorate.model;

import java.time.LocalDate;
import java.util.List;
import lombok.Data;
import ru.yandex.practicum.filmorate.dto.classes.MpaWithIdAndName;

@Data
public class Film {

    private Long id;
    private String name;
    private String description;
    private LocalDate releaseDate;
    private Integer duration;
    private MpaWithIdAndName mpa;
    private List<GenreWithId> genres;

}