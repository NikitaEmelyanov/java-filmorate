package ru.yandex.practicum.filmorate.dto.classes;

import java.time.LocalDate;
import java.util.List;
import lombok.Data;

@Data
public class FilmResponseDto {

    private Long id;
    private String name;
    private String description;
    private LocalDate releaseDate;
    private Integer duration;
    private MpaWithIdAndName mpa;
    private List<GenreWithIdAndName> genres;
}