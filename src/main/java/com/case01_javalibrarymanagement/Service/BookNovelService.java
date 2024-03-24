package com.case01_javalibrarymanagement.Service;

import com.case01_javalibrarymanagement.dto.request.NewBookRequestDto;
import com.case01_javalibrarymanagement.dto.request.UpdateBookRequestDto;
import com.case01_javalibrarymanagement.dto.response.AllBookResponseDto;
import com.case01_javalibrarymanagement.entity.BookNovel;
import com.case01_javalibrarymanagement.entity.Library;
import com.case01_javalibrarymanagement.Repository.BookNovelRepository;
import com.case01_javalibrarymanagement.Repository.LibraryRepository;
import com.case01_javalibrarymanagement.entity.enums.State;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;


@Service
@RequiredArgsConstructor
public class BookNovelService {

    private final BookNovelRepository bookNovelRepository;
    private final LibraryRepository libraryRepository;

    public void save(NewBookRequestDto historyRequestDto) {
        Optional<Library> library = libraryRepository.findById(1L);
        if (library.isPresent()){
            BookNovel bookNovel = new BookNovel();
            bookNovel.setISBN(historyRequestDto.getISBN());
            bookNovel.setAuthor(historyRequestDto.getAuthor());
            bookNovel.setTitle(historyRequestDto.getTitle());
            bookNovel.setLibrary(library.get());
            bookNovel.setPublicationYear(historyRequestDto.getPublicationYear());
            bookNovel.setState(State.CAN_BE_BORROWED);
            bookNovelRepository.save(bookNovel);
        }
    }

    public List<AllBookResponseDto> findAll() {
        List<BookNovel> bookNovelList = bookNovelRepository.findAll();
        if (bookNovelList.isEmpty()){
            throw new RuntimeException(); //TODO exception
        }
        return bookNovelList.stream().map(historyBook -> AllBookResponseDto.builder()
                .author(historyBook.getAuthor())
                .ISBN(historyBook.getISBN())
                .title(historyBook.getTitle())
                .state(historyBook.getState())
                .publicationYear(historyBook.getPublicationYear())
                .build()).collect(Collectors.toList());
    }

    public void update(UpdateBookRequestDto updateDto) {
        if(bookNovelRepository.findById(updateDto.getOid()).isEmpty()){
            throw new RuntimeException(); //TODO exception
        }
        BookNovel bookNovel = new BookNovel();
        bookNovel.setOid(updateDto.getOid());
        bookNovel.setLibrary(libraryRepository.findById(1L).get());
        bookNovel.setAuthor(updateDto.getAuthor());
        bookNovel.setTitle(updateDto.getTitle());
        bookNovel.setISBN(updateDto.getISBN());
        bookNovel.setPublicationYear(updateDto.getPublicationYear());
        bookNovel.setState(updateDto.getState());
        bookNovelRepository.save(bookNovel);
    }

    public Boolean deleteCompany(Long id) {
        Optional<BookNovel> optionalBook = bookNovelRepository.findById(id);
        if(optionalBook.isEmpty()){
            throw new RuntimeException("Company is not found"); //TODO exception
        }
        bookNovelRepository.delete(optionalBook.get());
        return true;
    }
}
