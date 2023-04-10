package ru.biponline.demo.response;

import lombok.Data;
import lombok.EqualsAndHashCode;
import ru.biponline.demo.entity.BookEntity;

@Data
@EqualsAndHashCode(callSuper = false)
public class BookResponse extends BaseResponse
{
    public BookResponse(boolean success, String message, BookEntity publisher)
    {
        super(success,message);
        this.publisher = publisher;
    }
    public BookResponse(BookEntity publisher)
    {
        super(true,"pub data");

    }
    private BookEntity publisher;
}
