package ru.yandex.practicum.filmorate.model;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.PastOrPresent;
import jakarta.validation.constraints.Pattern;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

/**
 * Класс, представляющий пользователя. Содержит информацию об email, логине, имени и дате рождения
 * пользователя.
 */
@Data
@Builder
public class User {

    private int id;

    @NotBlank(message = "Email не может быть пустым")
    @Email(message = "Email должен быть корректным адресом")
    private String email;

    @NotBlank(message = "Логин не может быть пустым")
    @Pattern(regexp = "\\S+", message = "Логин не может содержать пробелы")
    private String login;

    private String name;

    @PastOrPresent(message = "Дата рождения не может быть в будущем")
    private LocalDate birthday;

    private final Set<Integer> friendIds = new HashSet<>();

    public void setFriendId(Integer friendId) {
        friendIds.add(friendId);
    }

    public void removeFriendId(Integer id) {
        friendIds.remove(id);
    }
}
