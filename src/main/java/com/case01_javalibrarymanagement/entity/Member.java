package com.case01_javalibrarymanagement.entity;

import com.case01_javalibrarymanagement.entity.BaseClass.Book;
import jakarta.persistence.*;
import lombok.*;


@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Table(name = "member")
@Builder
public class Member implements IMember {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long oid;
    private String name;
    private String surname;

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "library_id", referencedColumnName = "library_id")
    private Library library;

    @Override
    public void borrowBook(Book book) {
        library.getBookList().remove(book);
    }

    @Override
    public void returnBook(Book book) {
        library.getBookList().add(book);
    }
}
