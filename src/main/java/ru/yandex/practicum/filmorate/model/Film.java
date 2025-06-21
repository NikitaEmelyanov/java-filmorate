package ru.yandex.practicum.filmorate.model;

import jakarta.validation.ValidationException;
import jakarta.validation.constraints.*;
import java.time.LocalDate;
import lombok.Data;

@Data
public class Film {
    private int id;

    @NotBlank(message = "Название не может быть пустым")
    private String name;

    @Size(max = 200, message = "Максимальная длина описания — 200 символов")
    private String description;

    @NotNull(message = "Дата релиза обязательна")
    private LocalDate releaseDate;

    @Positive(message = "Продолжительность должна быть положительной")
    private int duration;

    // Добавьте этот метод
    public boolean isValid() {
        LocalDate minDate = LocalDate.of(1895, 12, 28);
        if (releaseDate.isBefore(minDate)) {
            throw new ValidationException("Дата релиза не может быть раньше 28 декабря 1895 года");
        }
        return true;
    }
}