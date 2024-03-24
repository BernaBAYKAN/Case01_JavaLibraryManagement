package com.case01_javalibrarymanagement.entity;

import com.case01_javalibrarymanagement.entity.BaseClass.Book;
import com.case01_javalibrarymanagement.entity.enums.State;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.*;


@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Table(name = "book_novel")
@Builder
public class BookNovel extends Book {
    private State state;
}
