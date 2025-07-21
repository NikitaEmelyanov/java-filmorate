package ru.yandex.practicum.filmorate.mapper;

import java.util.List;
import java.util.stream.Collectors;
import lombok.NoArgsConstructor;
import ru.yandex.practicum.filmorate.dto.classes.GenreWithIdAndName;
import ru.yandex.practicum.filmorate.model.GenreWithId;

@NoArgsConstructor
public class GenreMapper {

    public static GenreWithId mapToGenreWithId(GenreWithIdAndName genreWithIdAndName) {
        GenreWithId genreWithId = new GenreWithId();
        genreWithId.setId(genreWithIdAndName.getId());
        return genreWithId;
    }

    public static List<GenreWithId> mapToListGenreWithId(
        List<GenreWithIdAndName> genreWithIdAndNames) {
        return genreWithIdAndNames.stream().map(GenreMapper::mapToGenreWithId)
            .collect(Collectors.toList());
    }
}