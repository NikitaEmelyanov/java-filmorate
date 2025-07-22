package ru.yandex.practicum.filmorate.model;

import java.util.List;
import lombok.Data;

@Data
public class Friends {

    private List<Friendship> friends;
}