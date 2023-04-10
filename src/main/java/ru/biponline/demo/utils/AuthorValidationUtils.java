package ru.biponline.demo.utils;

import ru.biponline.demo.entity.AuthorEntity;
import ru.biponline.demo.entity.PublisherEntity;
import ru.biponline.demo.exception.ValidationExceptionAuthor;
import ru.biponline.demo.exception.ValidationExceptionPublisher;

public class AuthorValidationUtils
{
    public static void validationAuthor(AuthorEntity data)throws ValidationExceptionAuthor
    {
        String name = data.getName();
        if (name == null||name.isBlank())
        {
            throw new ValidationExceptionAuthor("Имя пустое");
        }
        String lastname = data.getLastname();
        if (lastname == null||lastname.isBlank())
        {
            throw new ValidationExceptionAuthor("Фамилия автора");
        }
        String surname = data.getSurname();
        if (surname == null||surname.isBlank())
        {
            throw new ValidationExceptionAuthor("Отчество автора");
        }
    }
}