package com.case01_javalibrarymanagement.Controller;

import com.case01_javalibrarymanagement.Repository.LibraryRepository;
import com.case01_javalibrarymanagement.Service.LibraryService;
import com.case01_javalibrarymanagement.dto.request.BorrowBookRequestDto;
import com.case01_javalibrarymanagement.dto.request.CreateLibraryRequestDto;
import com.case01_javalibrarymanagement.dto.request.NewBookRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/library")
@RequiredArgsConstructor
public class LibraryController {
    private final LibraryService libraryService;

    @PostMapping("/create")
    public ResponseEntity<Void> createLibrary(@RequestBody @Valid CreateLibraryRequestDto library) {
        libraryService.save(library);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }
    @PostMapping("/borrowbook")
    public ResponseEntity<Void> borrowBook(@RequestBody @Valid BorrowBookRequestDto borrowRequestDto){
        libraryService.borrowBook(borrowRequestDto);
        return ResponseEntity.ok().build();
    }
    @PostMapping("/returnbook")
    public ResponseEntity<Void> returnBook(@RequestBody @Valid BorrowBookRequestDto returnBookRequestDto){
        libraryService.returnBook(returnBookRequestDto);
        return ResponseEntity.ok().build();
    }


}
