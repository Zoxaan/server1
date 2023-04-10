package ru.biponline.demo.response;

import lombok.Data;
import lombok.EqualsAndHashCode;
import ru.biponline.demo.entity.PublisherEntity;
@Data
@EqualsAndHashCode(callSuper=false)
public class PublisherResponse extends BaseResponse
{
    public PublisherResponse(boolean success, String message, PublisherEntity publisher)
    {
        super(success,message);
        this.publisher = publisher;
    }
    public PublisherResponse(PublisherEntity publisher)
    {
        super(true,"publishing data");
    }
    private PublisherEntity publisher;
}
