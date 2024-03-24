package com.case01_javalibrarymanagement.dto.request;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CreateLibraryRequestDto {
    private String LibraryName;
}
