package com.case01_javalibrarymanagement.dto.request;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UpdateMemberRequestDto {

    private Long oid;
    private String name;
    private String surname;
}
