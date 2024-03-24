package com.case01_javalibrarymanagement.Repository.base;

import com.case01_javalibrarymanagement.entity.BaseClass.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;

@NoRepositoryBean
public interface BaseRepository <T extends Book, Oid> extends JpaRepository<T, Oid> {
}
