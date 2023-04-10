package ru.biponline.demo.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.biponline.demo.entity.BookEntity;
import ru.biponline.demo.response.BaseResponse;
import ru.biponline.demo.response.BookListResponse;
import ru.biponline.demo.response.BookResponse;
import ru.biponline.demo.service.BookService;
import ru.biponline.demo.utils.BookValidationUtils;

import javax.validation.Valid;
import javax.validation.executable.ValidateOnExecution;

@RestController
@RequestMapping("api/v1/book")
public class BookController {
    private BookService service;


    private BookController(BookService service){ this.service = service; }

    @GetMapping("/all")
    public ResponseEntity<BaseResponse> getAll(){
        return ResponseEntity.ok(new BookListResponse(service.getAll()));
    }


    @ValidateOnExecution
    @PostMapping("/add")
    public ResponseEntity<BaseResponse> add(@RequestBody BookEntity data){
        try {
            BookValidationUtils.bookValidationUtils(data);
            service.save(data);
            return ResponseEntity.ok(new BaseResponse(true,"Книга добавленна"));
        } catch (Exception e){
            return ResponseEntity. badRequest().body(new BaseResponse(false,e.getMessage()));
        }
    }


    @PostMapping("/update")
    public ResponseEntity <BaseResponse> update(@RequestBody BookEntity data){
        try {
            service.save(data);
            return ResponseEntity.ok(new BaseResponse(true, "В книгу внесены изменения"));
        } catch (Exception e) {
            return ResponseEntity. badRequest().body(new BaseResponse(false,e.getMessage()));
        }
    }


    @DeleteMapping("/delete")
    public ResponseEntity <BaseResponse> delete(@RequestParam Long id){
        try {
            service.delete(id);
            return ResponseEntity.ok(new BaseResponse(true, "Книга успешно удалена"));
        } catch (Exception e) {
            return ResponseEntity. badRequest().body(new BaseResponse(false, e.getMessage()));
        }
    }
    @GetMapping()
    public ResponseEntity<BaseResponse> getPublisher(@RequestParam String name){
        return ResponseEntity.ok(new BookListResponse(service.getName(name)));
    }
}
