package ru.yandex.practicum.filmorate.controller;

import jakarta.validation.constraints.NotNull;
import java.util.List;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.yandex.practicum.filmorate.dto.user.RequestUserDto;
import ru.yandex.practicum.filmorate.dto.user.ResponseUserDto;
import ru.yandex.practicum.filmorate.group.validation.user.UserCreateValidation;
import ru.yandex.practicum.filmorate.group.validation.user.UserUpdateValidation;
import ru.yandex.practicum.filmorate.service.UserService;

@RestController
@RequestMapping("/users")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping
    public ResponseUserDto createUser(
        @Validated(UserCreateValidation.class) @RequestBody RequestUserDto requestUserDto) {
        return userService.create(requestUserDto);
    }

    @PutMapping
    public ResponseUserDto updateUser(
        @Validated(UserUpdateValidation.class) @RequestBody RequestUserDto requestUserDto) {
        return userService.update(requestUserDto);
    }

    @GetMapping
    public List<ResponseUserDto> getAll() {
        return userService.getAll();
    }

    @PutMapping("/{userId}/friends/{friendId}")
    public void addFriend(
        @PathVariable Integer userId,
        @PathVariable Integer friendId
    ) {
        userService.addFriend(userId, friendId);
    }

    @DeleteMapping("/{userId}/friends/{friendId}")
    public void removeFriend(
        @PathVariable Integer userId,
        @PathVariable Integer friendId
    ) {
        userService.removeFriend(userId, friendId);
    }

    @GetMapping("/{userId}/friends/common/{friendId}")
    public List<ResponseUserDto> getCommonFriends(
        @PathVariable(required = false) @NotNull(message = "Не указан id пользователя") Integer userId,
        @PathVariable(required = false) @NotNull(message = "Не указан id друга") Integer friendId
    ) {
        return userService.getCommonFriends(userId, friendId);
    }

    @GetMapping("/{userId}/friends")
    public List<ResponseUserDto> getUserFriends(
        @PathVariable Integer userId
    ) {
        return userService.getUserFriends(userId);
    }
}