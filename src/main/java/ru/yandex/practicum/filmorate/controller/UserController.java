package ru.yandex.practicum.filmorate.controller;

import jakarta.validation.Valid;
import java.util.Collection;
import lombok.AllArgsConstructor;
import lombok.NonNull;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.yandex.practicum.filmorate.dto.classes.UserDto;
import ru.yandex.practicum.filmorate.service.UserService;

@RestController
@RequestMapping("/users")
@Slf4j
@AllArgsConstructor
public class UserController {

    private final UserService userService;

    @PostMapping
    public UserDto create(@Valid @NonNull @RequestBody UserDto user) {
        log.trace("Контроллер создания пользователя");
        return userService.create(user);
    }

    @PutMapping
    public UserDto update(@Valid @NonNull @RequestBody UserDto user) {
        log.trace("Контроллер обновление пользователя");
        return userService.update(user);
    }

    @GetMapping
    public Collection<UserDto> findAll() {
        log.trace("Контроллер получения пользователей");
        return userService.findAll();
    }

    @PutMapping("/{id}/friends/{friendId}")
    public boolean addFriend(@PathVariable long id, @PathVariable long friendId) {
        log.trace("Добавление в друзья");
        return userService.addFriend(id, friendId);
    }

    @DeleteMapping("/{id}/friends/{friendId}")
    public boolean deleteFriend(@PathVariable long id, @PathVariable long friendId) {
        log.trace("Удаление дружбы");
        return userService.deleteFriend(id, friendId);
    }

    @GetMapping("/{id}/friends")
    public Collection<UserDto> findAllFriends(@PathVariable long id) {
        log.trace("Получение списка друзей пользователя");
        return userService.findAllFriends(id);
    }

    @GetMapping("/{id}/friends/common/{otherId}")
    public Collection<UserDto> findMutualFriends(@PathVariable long id,
        @PathVariable long otherId) {
        log.trace("Получение общих друзей");
        return userService.findMutualFriends(id, otherId);
    }
}