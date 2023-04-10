package ru.biponline.demo.repo;

import org.springframework.data.repository.CrudRepository;
import ru.biponline.demo.entity.PublisherEntity;

public interface PublisherRepo extends CrudRepository<PublisherEntity, Long> {
}