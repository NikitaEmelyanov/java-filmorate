package ru.yandex.practicum.filmorate.mapper;

import org.mapstruct.Mapper;
import ru.yandex.practicum.filmorate.dto.user.RequestUserDto;
import ru.yandex.practicum.filmorate.dto.user.ResponseUserDto;
import ru.yandex.practicum.filmorate.model.User;

@Mapper(componentModel = "spring")
public interface UserMapper {
    User convertRequestUserDtoToUser(RequestUserDto requestUserDto);

    ResponseUserDto convertUserToResponseUserDto(User user);
}
