package ru.yandex.practicum.filmorate.dto.create;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Past;
import java.time.LocalDate;
import lombok.Data;

@Data
public class CreateUserDto {

    private Long id;
    @NotNull
    @Email
    private String email;
    @NotBlank
    private String login;
    private String name;
    @NotNull
    @Past
    private LocalDate birthday;
}