package com.bookstore.dto;

import com.bookstore.model.Author;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.OneToMany;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class BookDto {

    private Long id;
    private String name;
    private String year;
    private double price;
    private String author;

    @OneToMany
    private List<Author> authorList;
}
