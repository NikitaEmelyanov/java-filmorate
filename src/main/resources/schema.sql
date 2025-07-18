CREATE TABLE IF NOT EXISTS mpaa (
    mpaa_id INTEGER PRIMARY KEY,
    name CHARACTER VARYING(5)
);

CREATE TABLE IF NOT EXISTS users (
    user_id INTEGER PRIMARY KEY,
    email CHARACTER VARYING (128),
    login CHARACTER VARYING (128) NOT NULL,
    name CHARACTER VARYING (128),
    birthday DATE
);

CREATE TABLE IF NOT EXISTS films (
    film_id INTEGER PRIMARY KEY,
    name CHARACTER VARYING (128) NOT NULL,
    description CHARACTER VARYING (255),
    release_date DATE,
    duration INTEGER,
    mpaa_id INTEGER REFERENCES mpaa(mpaa_id)
);

CREATE TABLE IF NOT EXISTS friends (
    user_id INTEGER REFERENCES users(user_id),
    friend_id INTEGER REFERENCES users(user_id),
    PRIMARY KEY (user_id, friend_id)
);

CREATE TABLE IF NOT EXISTS likes (
    like_id INTEGER PRIMARY KEY,
    film_id INTEGER REFERENCES films(film_id),
    user_id INTEGER REFERENCES users(user_id)
);