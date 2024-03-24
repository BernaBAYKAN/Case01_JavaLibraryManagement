package com.case01_javalibrarymanagement.Service;

import com.case01_javalibrarymanagement.Repository.*;
import com.case01_javalibrarymanagement.Repository.base.BaseRepository;
import com.case01_javalibrarymanagement.dto.request.BorrowBookRequestDto;
import com.case01_javalibrarymanagement.dto.request.CreateLibraryRequestDto;
import com.case01_javalibrarymanagement.entity.*;
import com.case01_javalibrarymanagement.entity.BaseClass.Book;
import com.case01_javalibrarymanagement.entity.enums.State;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class LibraryService {
    private final LibraryRepository libraryRepository;
    private final MemberRepository memberRepository;
    private final BaseRepository baseRepository;
    private final BookHistoryRepository bookHistoryRepository;
    private final BookNovelRepository bookNovelRepository;
    private final BookScienceRepository bookScienceRepository;


    public void save(CreateLibraryRequestDto library) {
        libraryRepository.save(Library.builder()
                .libraryName(library.getLibraryName())
                .build());
    }

    public void borrowBook(BorrowBookRequestDto borrowRequestDto) {
        Optional<Book> optionalBook = baseRepository.findById(borrowRequestDto.getBookOid());
        Optional<Member> optionalMember = memberRepository.findById(borrowRequestDto.getMemberOid());
        if (optionalBook.isEmpty()){
            throw new RuntimeException(); //TODO exception
        }
        else if(optionalMember.isEmpty()){
            throw new RuntimeException(); //TODO exception
        }
        if (optionalBook.get() instanceof BookNovel){
            BookNovel bookNovel = (BookNovel) optionalBook.get();
            if (bookNovel.getState().equals(State.CAN_BE_BORROWED)){
                bookNovel.setState(State.ON_LOAN);
                bookNovelRepository.save(bookNovel);
            }

        }
        else if (optionalBook.get() instanceof BookScience){
            BookScience bookScience = (BookScience) optionalBook.get();
            if (bookScience.getState().equals(State.CAN_BE_BORROWED)){
                bookScience.setState(State.ON_LOAN);
                bookScienceRepository.save(bookScience);
            }
        }
        else if (optionalBook.get() instanceof BookHistory){
            BookHistory bookHistory = (BookHistory) optionalBook.get();
            if (bookHistory.getState().equals(State.CAN_BE_BORROWED)){
                bookHistory.setState(State.ON_LOAN);
                bookHistoryRepository.save(bookHistory);
            }
        }
        optionalMember.get().borrowBook(optionalBook.get());
    }

    public void returnBook(BorrowBookRequestDto returnBookRequestDto) {
        Optional<Book> optionalBook = baseRepository.findById(returnBookRequestDto.getBookOid());
        Optional<Member> optionalMember = memberRepository.findById(returnBookRequestDto.getMemberOid());
        if (optionalBook.isEmpty()){
            throw new RuntimeException(); //TODO exception
        }
        else if(optionalMember.isEmpty()){
            throw new RuntimeException(); //TODO exception
        }
        if (optionalBook.get() instanceof BookNovel){
            BookNovel bookNovel = (BookNovel) optionalBook.get();
            bookNovel.setState(State.CAN_BE_BORROWED);
            bookNovelRepository.save(bookNovel);
        }
        else if (optionalBook.get() instanceof BookScience){
            BookScience bookScience = (BookScience) optionalBook.get();
            bookScience.setState(State.CAN_BE_BORROWED);
            bookScienceRepository.save(bookScience);
        }
        else if (optionalBook.get() instanceof BookHistory){
            BookHistory bookHistory = (BookHistory) optionalBook.get();
            bookHistory.setState(State.CAN_BE_BORROWED);
            bookHistoryRepository.save(bookHistory);
        }
        optionalMember.get().returnBook(optionalBook.get());
    }



}
