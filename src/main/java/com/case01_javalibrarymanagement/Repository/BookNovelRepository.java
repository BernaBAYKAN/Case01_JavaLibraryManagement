package com.case01_javalibrarymanagement.Repository;

import com.case01_javalibrarymanagement.Repository.base.BaseRepository;
import com.case01_javalibrarymanagement.entity.BookNovel;
import org.springframework.stereotype.Repository;

@Repository
public interface BookNovelRepository extends BaseRepository<BookNovel, Long> {
}
