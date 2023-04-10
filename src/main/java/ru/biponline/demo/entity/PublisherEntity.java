package ru.biponline.demo.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.List;

@Entity
@Data
@Table(name = "publishing")
public class PublisherEntity
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long publisher_id;
    @NotBlank(message =  "имя")
    private String publisher;
    @NotBlank(message =  "адрес7")
    private String city;
    @JsonIgnore
    @OneToMany(cascade =  CascadeType.ALL,mappedBy = "publishing")
    private List<BookEntity> book;
}
