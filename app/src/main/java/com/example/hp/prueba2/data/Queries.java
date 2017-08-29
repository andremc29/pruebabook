package com.example.hp.prueba2.data;

import com.example.hp.prueba2.Model.Book;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by HP on 26-08-2017.
 */

public class Queries {
    public List<Book> books(){
        List<Book> books = new ArrayList<>();
        List<Book> listBooks = Book.find(Book.class, "bought = '0'");
        if (listBooks != null && listBooks.size() > 0){
            books.addAll(listBooks);
        }
        return books;
    }

    public List<Book> booksbought(String doneVal){
        List<Book> books = new ArrayList<>();
        List<Book> listBooks = Book.find(Book.class, "bought ="+doneVal);
        if (listBooks != null && listBooks.size() > 0){
            books.addAll(listBooks);
        }
        return books;
    }

}
