package com.case01_javalibrarymanagement.Controller;

import com.case01_javalibrarymanagement.Service.BookNovelService;
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
@RequestMapping("/booknovel")
@RequiredArgsConstructor
public class BookNovelController {
    private final BookNovelService bookNovelService;

    @PostMapping("/create")
    public ResponseEntity<Void> createBookNovel(@RequestBody @Valid NewBookRequestDto novelRequestDto) {
        bookNovelService.save(novelRequestDto);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }
    @GetMapping("/findall")
    public ResponseEntity<List<AllBookResponseDto>> findAllBook(){
        return ResponseEntity.ok(bookNovelService.findAll());
    }
    @PutMapping("/update")
    public ResponseEntity<Void> updateBookNovel(@RequestBody @Valid UpdateBookRequestDto updateDto){
        bookNovelService.update(updateDto);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/delete/{id}")
    public  ResponseEntity<Void> deleteBook(@PathVariable("id") Long id){
        bookNovelService.deleteCompany(id);
        return ResponseEntity.ok().build();
    }
}
