package com.case01_javalibrarymanagement.dto.response;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class AllMemberResponseDto {
    private long oid;
    private String name;
    private String surname;
}
