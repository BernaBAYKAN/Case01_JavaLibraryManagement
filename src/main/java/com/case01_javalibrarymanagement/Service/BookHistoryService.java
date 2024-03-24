package com.case01_javalibrarymanagement.Service;

import com.case01_javalibrarymanagement.dto.request.NewBookRequestDto;
import com.case01_javalibrarymanagement.dto.request.UpdateBookRequestDto;
import com.case01_javalibrarymanagement.dto.response.AllBookResponseDto;
import com.case01_javalibrarymanagement.entity.BookHistory;
import com.case01_javalibrarymanagement.entity.Library;
import com.case01_javalibrarymanagement.entity.enums.State;
import com.case01_javalibrarymanagement.Repository.BookHistoryRepository;
import com.case01_javalibrarymanagement.Repository.LibraryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class BookHistoryService {
    private final BookHistoryRepository bookHistoryRepository;
    private final LibraryRepository libraryRepository;

    public void save(NewBookRequestDto historyRequestDto) {
        Optional<Library> library = libraryRepository.findById(1L);
        if (library.isPresent()){
            BookHistory bookHistory = new BookHistory();
            bookHistory.setISBN(historyRequestDto.getISBN());
            bookHistory.setAuthor(historyRequestDto.getAuthor());
            bookHistory.setTitle(historyRequestDto.getTitle());
            bookHistory.setLibrary(library.get());
            bookHistory.setPublicationYear(historyRequestDto.getPublicationYear());
            bookHistory.setState(State.CAN_BE_BORROWED);
            bookHistoryRepository.save(bookHistory);
        }
    }

    public List<AllBookResponseDto> findAll() {
        List<BookHistory> bookHistoryList = bookHistoryRepository.findAll();
        if (bookHistoryList.isEmpty()){
            throw new RuntimeException(); //TODO exception
        }
        return bookHistoryList.stream().map(historyBook -> AllBookResponseDto.builder()
                .author(historyBook.getAuthor())
                .ISBN(historyBook.getISBN())
                .title(historyBook.getTitle())
                .state(historyBook.getState())
                .publicationYear(historyBook.getPublicationYear())
                .build()).collect(Collectors.toList());
    }

    public void update(UpdateBookRequestDto updateDto) {
        if(bookHistoryRepository.findById(updateDto.getOid()).isEmpty()){
            throw new RuntimeException(); //TODO exception
        }
        BookHistory bookHistory = new BookHistory();
        bookHistory.setOid(updateDto.getOid());
        bookHistory.setLibrary(libraryRepository.findById(1L).get());
        bookHistory.setAuthor(updateDto.getAuthor());
        bookHistory.setTitle(updateDto.getTitle());
        bookHistory.setISBN(updateDto.getISBN());
        bookHistory.setPublicationYear(updateDto.getPublicationYear());
        bookHistory.setState(updateDto.getState());
        bookHistoryRepository.save(bookHistory);
    }

    public Boolean deleteCompany(Long id) {
        Optional<BookHistory> optionalBook = bookHistoryRepository.findById(id);
        if(optionalBook.isEmpty()){
            throw new RuntimeException("Company is not found"); //TODO exception
        }
        bookHistoryRepository.delete(optionalBook.get());
        return true;
    }
}
