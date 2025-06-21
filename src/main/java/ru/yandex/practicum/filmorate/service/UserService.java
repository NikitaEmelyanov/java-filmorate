package ru.yandex.practicum.filmorate.service;

import java.util.List;
import ru.yandex.practicum.filmorate.dto.user.RequestUserDto;
import ru.yandex.practicum.filmorate.dto.user.ResponseUserDto;

public interface UserService {

    ResponseUserDto create(RequestUserDto requestUserDto);

    ResponseUserDto update(RequestUserDto requestUserDto);

    List<ResponseUserDto> getAll();

    void addFriend(Integer userId, Integer friendId);

    void removeFriend(Integer userId, Integer friendId);

    List<ResponseUserDto> getCommonFriends(Integer userId, Integer friendId);

    List<ResponseUserDto> getUserFriends(Integer userId);
}