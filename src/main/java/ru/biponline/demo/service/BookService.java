package ru.biponline.demo.service;

import org.springframework.stereotype.Service;

import ru.biponline.demo.entity.BookEntity;
import ru.biponline.demo.exception.ValidationExceptionBook;
import ru.biponline.demo.repo.BookRepo;
import ru.biponline.demo.utils.ValidationUtils;
/*import ru.biponline.demo.utils.ValidationUtils;*/

@Service
public class BookService {
    private final BookRepo repo;
    public BookService(BookRepo repo) {
        this.repo = repo;
    }
    public void save(BookEntity book) {repo.save(book);}
    public void delete(Long id){repo.deleteById(id);}
    public Iterable<BookEntity> getAll(){return repo.findAll();}
    public Iterable<BookEntity> getName(String name){
        return repo.findByAuthor_name(name); }
}
