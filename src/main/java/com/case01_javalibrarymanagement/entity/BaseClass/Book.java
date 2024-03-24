package com.case01_javalibrarymanagement.entity.BaseClass;


import com.case01_javalibrarymanagement.entity.Library;
import jakarta.persistence.*;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;



@Getter
@Setter
@RequiredArgsConstructor
@EqualsAndHashCode
@MappedSuperclass
public abstract class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long oid;
    private String ISBN;
    private String title;
    private String author;
    @Column(name = "publication_year")
    private int publicationYear;

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "library_id", referencedColumnName = "oid")
    private Library library;


}
