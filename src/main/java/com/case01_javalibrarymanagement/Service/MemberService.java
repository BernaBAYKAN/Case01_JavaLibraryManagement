package com.case01_javalibrarymanagement.Service;

import com.case01_javalibrarymanagement.Repository.LibraryRepository;
import com.case01_javalibrarymanagement.Repository.MemberRepository;
import com.case01_javalibrarymanagement.dto.request.NewMemberRequestDto;
import com.case01_javalibrarymanagement.dto.request.UpdateMemberRequestDto;
import com.case01_javalibrarymanagement.dto.response.AllMemberResponseDto;
import com.case01_javalibrarymanagement.entity.Library;
import com.case01_javalibrarymanagement.entity.Member;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
@Service
@RequiredArgsConstructor
public class MemberService {
    private final MemberRepository memberRepository;
    private final LibraryRepository libraryRepository;


    public void save(NewMemberRequestDto memberRequestDto) {
        Optional<Library> library = libraryRepository.findById(1L);
        if(library.isPresent()) {
            Member member = Member.builder()
                    .name(memberRequestDto.getName())
                    .surname(memberRequestDto.getSurname())
                    .library(library.get())
                    .build();
            memberRepository.save(member);
            library.get().getMemberList().add(member);
        }
    }

    public List<AllMemberResponseDto> findAll() {
        List<Member> memberList = memberRepository.findAll();
        if ((memberList.isEmpty())){
            throw new RuntimeException(); // TODO: exception yazılacak
        }
        return memberList.stream().map(member -> AllMemberResponseDto.builder()
                .oid(member.getOid())
                .name(member.getName())
                .surname(member.getSurname())
                .build()).collect(Collectors.toList());
    }

    public Boolean deleteMember(Long id) {
        Optional<Member> member = memberRepository.findById(id);
        if (member.isEmpty()){
            throw new RuntimeException(); //TODO: exception yazılacak
        }
        memberRepository.delete(member.get());
        libraryRepository.findById(1L).get().getMemberList().remove(member);
        return true;
    }

    public void update(UpdateMemberRequestDto updateDto) {
        if (memberRepository.findById(updateDto.getOid()).isEmpty()){
            throw new RuntimeException();//TODO exception
        }
        Optional<Member> memberOptional = memberRepository.findById(updateDto.getOid());
        if (memberOptional.isEmpty()){
            throw new RuntimeException();//TODO exception
        }
        Member member = Member.builder()
                .oid(updateDto.getOid())
                .library(libraryRepository.findById(1L).get())
                .name(updateDto.getName())
                .surname(updateDto.getSurname())
                .build();
        memberRepository.save(member);
    }
}
