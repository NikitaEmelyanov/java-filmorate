//package ru.yandex.practicum.filmorate.storage.film;
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
//import ru.yandex.practicum.filmorate.mapper.FilmMapper;
//import ru.yandex.practicum.filmorate.model.Film;
//import ru.yandex.practicum.filmorate.storage.film.FilmStorage;
//
//@Repository
//@Qualifier("filmDbStorage")
//@RequiredArgsConstructor
//public class FilmDbStorage implements FilmStorage {
//    private final JdbcTemplate jdbcTemplate;
//    private final FilmMapper filmMapper;
//
//    @Override
//    public Film create(Film film) {
//        return null;
//    }
//
//    @Override
//    public Optional<Film> update(Film film) {
//        return Optional.empty();
//    }
//
//    @Override
//    public List<Film> getAll() {
//        return List.of();
//    }
//
//    @Override
//    public Optional<Boolean> addLike(Integer filmId, Integer userId) {
//        return Optional.empty();
//    }
//
//    @Override
//    public Optional<Boolean> removeLike(Integer filmId, Integer userId) {
//        return Optional.empty();
//    }
//
//    @Override
//    public List<Film> getAllFilms() {
//        String sql = "SELECT f.*, m.name AS mpa_name FROM films f JOIN mpa m ON f.mpa_id = m.mpa_id";
//        return jdbcTemplate.query(sql, filmMapper);
//    }
//
//    @Override
//    public Optional<Film> getFilmById(int id) {
//        String sql = "SELECT f.*, m.name AS mpa_name FROM films f JOIN mpa m ON f.mpa_id = m.mpa_id WHERE f.film_id = ?";
//        return jdbcTemplate.query(sql, filmMapper, id).stream().findFirst();
//    }
//
//    @Override
//    public Film createFilm(Film film) {
//        String sql = "INSERT INTO films (name, description, release_date, duration, mpa_id) VALUES (?, ?, ?, ?, ?)";
//        KeyHolder keyHolder = new GeneratedKeyHolder();
//
//        jdbcTemplate.update(connection -> {
//            PreparedStatement stmt = connection.prepareStatement(sql, new String[]{"film_id"});
//            stmt.setString(1, film.getName());
//            stmt.setString(2, film.getDescription());
//            stmt.setDate(3, Date.valueOf(film.getReleaseDate()));
//            stmt.setInt(4, film.getDuration());
//            stmt.setInt(5, film.getMpa().getId());
//            return stmt;
//        }, keyHolder);
//
//        film.setId(keyHolder.getKey().intValue());
//        updateFilmGenres(film);
//        return film;
//    }
//
//    @Override
//    public Film updateFilm(Film film) {
//        String sql = "UPDATE films SET name = ?, description = ?, release_date = ?, duration = ?, mpa_id = ? WHERE film_id = ?";
//        jdbcTemplate.update(sql,
//            film.getName(),
//            film.getDescription(),
//            film.getReleaseDate(),
//            film.getDuration(),
//            film.getMpa().getId(),
//            film.getId());
//
//        // Обновляем жанры
//        jdbcTemplate.update("DELETE FROM film_genres WHERE film_id = ?", film.getId());
//        updateFilmGenres(film);
//
//        return film;
//    }
//
//    private void updateFilmGenres(Film film) {
//        if (film.getGenres() != null && !film.getGenres().isEmpty()) {
//            String sql = "INSERT INTO film_genres (film_id, genre_id) VALUES (?, ?)";
//            jdbcTemplate.batchUpdate(sql, film.getGenres(), film.getGenres().size(),
//                (PreparedStatement ps, FilmGenre genre) -> {
//                    ps.setInt(1, film.getId());
//                    ps.setInt(2, genre.getId());
//                });
//        }
//    }
//
//    @Override
//    public void deleteFilm(int id) {
//        jdbcTemplate.update("DELETE FROM films WHERE film_id = ?", id);
//    }
//
//    @Override
//    public List<Film> getPopularFilms(int count) {
//        String sql = "SELECT f.*, m.name AS mpa_name FROM films f " +
//                     "JOIN mpa m ON f.mpa_id = m.mpa_id " +
//                     "LEFT JOIN film_likes fl ON f.film_id = fl.film_id " +
//                     "GROUP BY f.film_id ORDER BY COUNT(fl.user_id) DESC LIMIT ?";
//        return jdbcTemplate.query(sql, filmMapper, count);
//    }
//
//    @Override
//    public void addLike(int filmId, int userId) {
//        String sql = "INSERT INTO film_likes (film_id, user_id) VALUES (?, ?)";
//        jdbcTemplate.update(sql, filmId, userId);
//    }
//
//    @Override
//    public void removeLike(int filmId, int userId) {
//        String sql = "DELETE FROM film_likes WHERE film_id = ? AND user_id = ?";
//        jdbcTemplate.update(sql, filmId, userId);
//    }
//}