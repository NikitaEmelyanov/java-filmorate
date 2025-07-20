//package ru.yandex.practicum.filmorate.storage.user;
//
//import java.sql.Date;
//import java.sql.PreparedStatement;
//import java.util.List;
//import java.util.Optional;
//import lombok.RequiredArgsConstructor;
//import org.springframework.beans.factory.annotation.Qualifier;
//import org.springframework.jdbc.core.JdbcTemplate;
//import org.springframework.jdbc.support.GeneratedKeyHolder;
//import org.springframework.jdbc.support.KeyHolder;
//import org.springframework.stereotype.Repository;
//import ru.yandex.practicum.filmorate.mapper.UserMapper;
//import ru.yandex.practicum.filmorate.model.User;
//
//@Repository
//@Qualifier("userDbStorage")
//@RequiredArgsConstructor
//public class UserDbStorage implements UserStorage {
//    private final JdbcTemplate jdbcTemplate;
//    private final UserMapper userMapper;
//
//    @Override
//    public List<User> getAllUsers() {
//        String sql = "SELECT * FROM users";
//        return jdbcTemplate.query(sql, userMapper);
//    }
//
//    @Override
//    public Optional<User> getUserById(int id) {
//        String sql = "SELECT * FROM users WHERE user_id = ?";
//        return jdbcTemplate.query(sql, userMapper, id).stream().findFirst();
//    }
//
//    @Override
//    public User createUser(User user) {
//        String sql = "INSERT INTO users (email, login, name, birthday) VALUES (?, ?, ?, ?)";
//        KeyHolder keyHolder = new GeneratedKeyHolder();
//
//        jdbcTemplate.update(connection -> {
//            PreparedStatement stmt = connection.prepareStatement(sql, new String[]{"user_id"});
//            stmt.setString(1, user.getEmail());
//            stmt.setString(2, user.getLogin());
//            stmt.setString(3, user.getName());
//            stmt.setDate(4, Date.valueOf(user.getBirthday()));
//            return stmt;
//        }, keyHolder);
//
//        user.setId(keyHolder.getKey().intValue());
//        return user;
//    }
//
//    @Override
//    public User updateUser(User user) {
//        String sql = "UPDATE users SET email = ?, login = ?, name = ?, birthday = ? WHERE user_id = ?";
//        jdbcTemplate.update(sql,
//            user.getEmail(),
//            user.getLogin(),
//            user.getName(),
//            user.getBirthday(),
//            user.getId());
//        return user;
//    }
//
//    @Override
//    public void deleteUser(int id) {
//        jdbcTemplate.update("DELETE FROM users WHERE user_id = ?", id);
//    }
//
//    @Override
//    public List<User> getUserFriends(int id) {
//        String sql = "SELECT u.* FROM users u JOIN friends f ON u.user_id = f.friend_id WHERE f.user_id = ?";
//        return jdbcTemplate.query(sql, userMapper, id);
//    }
//
//    @Override
//    public void addFriend(int userId, int friendId) {
//        String sql = "INSERT INTO friends (user_id, friend_id) VALUES (?, ?)";
//        jdbcTemplate.update(sql, userId, friendId);
//    }
//
//    @Override
//    public void removeFriend(int userId, int friendId) {
//        String sql = "DELETE FROM friends WHERE user_id = ? AND friend_id = ?";
//        jdbcTemplate.update(sql, userId, friendId);
//    }
//
//    @Override
//    public List<User> getCommonFriends(int id1, int id2) {
//        String sql = "SELECT u.* FROM users u JOIN friends f1 ON u.user_id = f1.friend_id " +
//                     "JOIN friends f2 ON u.user_id = f2.friend_id " +
//                     "WHERE f1.user_id = ? AND f2.user_id = ?";
//        return jdbcTemplate.query(sql, userMapper, id1, id2);
//    }
//
//    @Override
//    public User create(User user) {
//        return null;
//    }
//
//    @Override
//    public Optional<User> update(User user) {
//        return Optional.empty();
//    }
//
//    @Override
//    public List<User> getAll() {
//        return List.of();
//    }
//
//    @Override
//    public Optional<Boolean> addFriend(Integer userId, Integer friendId) {
//        return Optional.empty();
//    }
//
//    @Override
//    public Optional<Boolean> removeFriend(Integer userId, Integer friendId) {
//        return Optional.empty();
//    }
//
//    @Override
//    public Optional<List<User>> getCommonFriends(Integer userId, Integer friendId) {
//        return Optional.empty();
//    }
//
//    @Override
//    public Optional<List<User>> getUserFriends(Integer userId) {
//        return Optional.empty();
//    }
//
//    @Override
//    public Optional<Boolean> checkUserId(Integer id) {
//        return Optional.empty();
//    }
//}