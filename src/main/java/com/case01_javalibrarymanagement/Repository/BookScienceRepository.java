package com.case01_javalibrarymanagement.Repository;

import com.case01_javalibrarymanagement.Repository.base.BaseRepository;
import com.case01_javalibrarymanagement.entity.BookScience;
import org.springframework.stereotype.Repository;

@Repository
public interface BookScienceRepository  extends BaseRepository<BookScience, Long> {
}
