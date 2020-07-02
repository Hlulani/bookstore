package com.bookstore.jaxb;

import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="errorresource", namespace = "com.bookstore.jaxb")
public class Bookstore {

    @XmlElementWrapper(name = "bookstore")
    @XmlElement(name = "book")
    private List <Book> bookList;

    public void setBookList(List <Book> bookList) {
        this.bookList = bookList;
    }

    public List <Book> getBooksList() {
        return bookList;
    }
}