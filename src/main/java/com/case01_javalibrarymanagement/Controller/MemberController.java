package com.case01_javalibrarymanagement.Controller;

import com.case01_javalibrarymanagement.Service.MemberService;
import com.case01_javalibrarymanagement.entity.Library;
import com.case01_javalibrarymanagement.entity.Member;
import com.case01_javalibrarymanagement.Repository.LibraryRepository;
import com.case01_javalibrarymanagement.Repository.MemberRepository;
import com.case01_javalibrarymanagement.dto.request.NewMemberRequestDto;
import com.case01_javalibrarymanagement.dto.request.UpdateMemberRequestDto;
import com.case01_javalibrarymanagement.dto.response.AllMemberResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/member")
@RequiredArgsConstructor
public class MemberController {
    private final MemberService memberService;

    @PostMapping("/create")
    public ResponseEntity<Void> createMember(@RequestBody @Valid NewMemberRequestDto memberRequestDto) {
        memberService.save(memberRequestDto);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }
    @GetMapping("/findall")
    public ResponseEntity<List<AllMemberResponseDto>> findAllMember(){
        return ResponseEntity.ok(memberService.findAll());
    }
    @PutMapping("/update")
    public ResponseEntity<Void> updateMember(@RequestBody @Valid UpdateMemberRequestDto updateDto){
        memberService.update(updateDto);
        return ResponseEntity.ok().build();
    }
    @DeleteMapping("/delete/{id}")
    public  ResponseEntity<Void> deleteMember(@PathVariable("id") Long id){
        memberService.deleteMember(id);
        return ResponseEntity.ok().build();
    }
}
