package com.case01_javalibrarymanagement.entity;

import com.case01_javalibrarymanagement.entity.BaseClass.Book;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.*;
import com.case01_javalibrarymanagement.entity.enums.State;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Table(name = "book_science")
@Builder
public class BookScience extends Book {
    private State state;
}
