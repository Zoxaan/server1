package ru.biponline.demo.controller;


import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.biponline.demo.entity.PublisherEntity;
import ru.biponline.demo.response.BaseResponse;
import ru.biponline.demo.response.PublisherListResponse;
import ru.biponline.demo.service.PublisherService;

import static ru.biponline.demo.utils.PublisherValidationUtils.validationPublisher;

@RestController
@RequestMapping("api/v1/publisher")
public class PublisherController {

    private final PublisherService service;
    public PublisherController(PublisherService service) {this.service = service;}

    @PostMapping("/add")
    public ResponseEntity<BaseResponse> add(@RequestBody PublisherEntity data){
        try {
            validationPublisher(data);
            service.save(data);
            return ResponseEntity.ok(new BaseResponse(true, "Издательство добавленна") );
        }catch (Exception e){
            return ResponseEntity.badRequest().body(new BaseResponse(false, e.getMessage()));
        }
    }

    @PostMapping("/update")
    public ResponseEntity<BaseResponse> update(@RequestBody PublisherEntity data){
        try {
            validationPublisher(data);
            service.save(data);
            return ResponseEntity.ok(new BaseResponse(true, "Издательство изминено"));
        } catch (Exception e){
            return ResponseEntity.badRequest().body(new BaseResponse(false, e.getMessage()));
        }
    }
    @DeleteMapping("/delete")
    public ResponseEntity <BaseResponse> delete(@RequestParam Long id){
        try {
            service.delete(id);
            return ResponseEntity.ok(new BaseResponse(true, "Издательство успешно удалено"));
        } catch (Exception e) {
            return ResponseEntity. badRequest().body(new BaseResponse(false, e.getMessage()));
        }
    }

    @GetMapping("/all")
    public ResponseEntity<BaseResponse> getAll(){return ResponseEntity.ok(new PublisherListResponse(service.getAll())); }



}
