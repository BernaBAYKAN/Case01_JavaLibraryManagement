package com.case01_javalibrarymanagement.Repository;

import com.case01_javalibrarymanagement.Repository.base.BaseRepository;
import com.case01_javalibrarymanagement.entity.BookHistory;
import org.springframework.stereotype.Repository;

@Repository
public interface BookHistoryRepository extends BaseRepository<BookHistory, Long> {
}
