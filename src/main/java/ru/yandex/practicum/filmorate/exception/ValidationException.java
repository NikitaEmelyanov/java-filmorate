package ru.yandex.practicum.filmorate.exception;

/**
 * Исключение, выбрасываемое при нарушении правил валидации.
 */
public class ValidationException extends RuntimeException {

    /**
     * Конструктор исключения с сообщением об ошибке.
     *
     * @param message Сообщение об ошибке
     */
    public ValidationException(String message) {
        super(message);
    }

}
