package ru.biponline.demo.response;

import lombok.Data;
import lombok.EqualsAndHashCode;
import ru.biponline.demo.entity.PublisherEntity;

@Data
@EqualsAndHashCode(callSuper = false)
public class PublisherListResponse extends BaseResponse
{
    public PublisherListResponse(Iterable<PublisherEntity>data)
    {
        super(true,"Издательства");
        this.data = data;
    }
    private Iterable<PublisherEntity>data;
}
