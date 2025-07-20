package ru.yandex.practicum.filmorate.dto.update;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;
import java.time.LocalDate;
import java.util.Set;
import lombok.Data;
import ru.yandex.practicum.filmorate.annotation.DateNoEarlierThan;
import ru.yandex.practicum.filmorate.model.GenreWithId;
import ru.yandex.practicum.filmorate.model.MpaWithId;

@Data
public class FilmUpdateDto {

    @NotNull
    private Long id;
    @NotBlank
    private String name;
    @NotNull
    @Size(max = 200)
    private String description;
    @DateNoEarlierThan(date = "1895.12.28", format = "yyyy.MM.dd")
    private LocalDate releaseDate;
    @NotNull
    @Positive
    private Integer duration;
    private MpaWithId mpa;
    private Set<GenreWithId> genres;

    public boolean hasMpa() {
        return !(mpa == null || mpa.getId() == null);
    }

    public boolean hasGenres() {
        return !(genres == null || genres.isEmpty());
    }
}