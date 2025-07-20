//package ru.yandex.practicum.filmorate.storage.user;
//
//import java.util.List;
//import java.util.Optional;
//import ru.yandex.practicum.filmorate.model.User;
//
//public interface UserStorage {
//
//    List<User> getAllUsers();
//
//    Optional<User> getUserById(int id);
//
//    User createUser(User user);
//
//    User updateUser(User user);
//
//    void deleteUser(int id);
//
//    List<User> getUserFriends(int id);
//
//    void addFriend(int userId, int friendId);
//
//    void removeFriend(int userId, int friendId);
//
//    List<User> getCommonFriends(int id1, int id2);
//
//    User create(User user);
//
//    Optional<User> update(User user);
//
//    List<User> getAll();
//
//    Optional<Boolean> addFriend(Integer userId, Integer friendId);
//
//    Optional<Boolean> removeFriend(Integer userId, Integer friendId);
//
//    Optional<List<User>> getCommonFriends(Integer userId, Integer friendId);
//
//    Optional<List<User>> getUserFriends(Integer userId);
//
//    Optional<Boolean> checkUserId(Integer id);
//}