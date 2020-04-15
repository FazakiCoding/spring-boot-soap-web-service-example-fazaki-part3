package com.fazaki.springbootsoapwebserviceexamplefazakipart3.service;


import com.fazaki.spring_boot_soap_example_fazaki.Book;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.HashMap;
import java.util.Map;

@Service
public class BookService {
    private static final Map<String, Book> books=new HashMap<String, Book>();

    @PostConstruct
    public void initialize(){
            Book book1=new Book();
            Book book2=new Book();
            Book book3=new Book();

            book1.setId(1);
            book1.setTitle("The little prince");
            book1.setDescription("A story of .....");
            book1.setPrice(20);

            book1.setId(2);
            book1.setTitle("The Alchemist");
            book1.setDescription("A story of .....");
            book1.setPrice(25);

            book1.setId(3);
            book1.setTitle("Clean code");
            book1.setDescription("A book .....");
            book1.setPrice(25);

            this.books.put(book1.getTitle(),book1);
            this.books.put(book2.getTitle(),book2);
            this.books.put(book3.getTitle(),book3);

    }
    public Book getBook(String title){
        return books.get(title);
    }
}
