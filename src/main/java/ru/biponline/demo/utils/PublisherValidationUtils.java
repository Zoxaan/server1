package ru.biponline.demo.utils;

import ru.biponline.demo.entity.PublisherEntity;
import ru.biponline.demo.exception.ValidationExceptionPublisher;

public class PublisherValidationUtils
{
    public static void validationPublisher(PublisherEntity data)throws ValidationExceptionPublisher
    {
        String title = data.getPublisher();
        if (title == null||title.isBlank())
        {
            throw new ValidationExceptionPublisher("Название пустое");
        }
        String city = data.getCity();
        if (city == null||city.isBlank())
        {
            throw new ValidationExceptionPublisher("издательство адрес");
        }
    }
}
