package me.demo.transaction.dto;

import lombok.*;

import java.io.Serializable;


public class BookDTO implements Serializable {

    private Long id;

    private String name;

    private Integer price;

    private String author;


    public BookDTO() {
    }

    public BookDTO(Long id, String name, String author, Integer price) {
        this.id = id;
        this.name = name;
        this.author = author;
        this.price = price;
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }
}
