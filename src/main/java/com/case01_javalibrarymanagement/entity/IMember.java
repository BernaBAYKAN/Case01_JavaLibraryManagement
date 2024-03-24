package com.case01_javalibrarymanagement.entity;

import com.case01_javalibrarymanagement.entity.BaseClass.Book;

public interface IMember {
    void borrowBook(Book book);
    void returnBook(Book book);
}
