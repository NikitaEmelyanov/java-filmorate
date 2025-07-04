package ru.yandex.practicum.filmorate.storage.user;

import java.util.List;
import java.util.Optional;
import ru.yandex.practicum.filmorate.model.User;

public interface UserStorage {

    User create(User user);

    Optional<User> update(User user);

    List<User> getAll();

    Optional<Boolean> addFriend(Integer userId, Integer friendId);

    Optional<Boolean> removeFriend(Integer userId, Integer friendId);

    Optional<List<User>> getCommonFriends(Integer userId, Integer friendId);

    Optional<List<User>> getUserFriends(Integer userId);

    Optional<Boolean> checkUserId(Integer id);
}