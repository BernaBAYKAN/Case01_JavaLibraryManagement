package com.case01_javalibrarymanagement.Repository;

import com.case01_javalibrarymanagement.entity.Library;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LibraryRepository  extends JpaRepository<Library, Long> {
}
