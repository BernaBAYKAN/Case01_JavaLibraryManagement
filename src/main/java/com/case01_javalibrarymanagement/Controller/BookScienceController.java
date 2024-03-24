package com.case01_javalibrarymanagement.Controller;

import com.case01_javalibrarymanagement.Service.BookScienceService;
import com.case01_javalibrarymanagement.dto.request.NewBookRequestDto;
import com.case01_javalibrarymanagement.dto.request.UpdateBookRequestDto;
import com.case01_javalibrarymanagement.dto.response.AllBookResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/bookscience")
@RequiredArgsConstructor
public class BookScienceController {
    private final BookScienceService bookScienceService;


    @PostMapping("/create")
    public ResponseEntity<Void> createBookScience(@RequestBody @Valid NewBookRequestDto scienceBookDto) {
        bookScienceService.save(scienceBookDto);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }
    @GetMapping("/findall")
    public ResponseEntity<List<AllBookResponseDto>> findAllBook(){
        return ResponseEntity.ok(bookScienceService.findAll());
    }
    @PutMapping("/update")
    public ResponseEntity<Void> updateBookScience(@RequestBody @Valid UpdateBookRequestDto updateDto){
        bookScienceService.update(updateDto);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/delete/{id}")
    public  ResponseEntity<Void> deleteBook(@PathVariable("id") Long id){
        bookScienceService.deleteCompany(id);
        return ResponseEntity.ok().build();
    }
}
