package ru.yandex.practicum.filmorate.model;

import java.time.LocalDate;
import java.util.Collection;
import java.util.Comparator;
import java.util.LinkedHashSet;
import java.util.Set;
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
    private Set<GenreWithId> genres = new LinkedHashSet<>();

    public void setGenres(Collection<GenreWithId> genres) {
        this.genres.clear();
        if (genres != null) {
            genres.stream()
                .sorted(Comparator.comparing(GenreWithId::getId))
                .forEach(this.genres::add);
        }
    }
}