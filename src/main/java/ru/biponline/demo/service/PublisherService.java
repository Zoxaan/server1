package ru.biponline.demo.service;

import org.springframework.stereotype.Service;
import ru.biponline.demo.entity.PublisherEntity;
import ru.biponline.demo.repo.PublisherRepo;

@Service
public class PublisherService {
    private final PublisherRepo repo;
    public PublisherService(PublisherRepo repo) {
        this.repo = repo;
    }
    public void save(PublisherEntity book) {repo.save(book);}
    public void delete(Long id){repo.deleteById(id);}
    public Iterable<PublisherEntity> getAll(){return repo.findAll();}
}
