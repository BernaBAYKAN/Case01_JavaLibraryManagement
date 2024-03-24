package com.case01_javalibrarymanagement.dto.request;

import com.case01_javalibrarymanagement.entity.enums.State;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class NewBookRequestDto {
    private String ISBN;
    private String title;
    private String author;
    private int publicationYear;

}
