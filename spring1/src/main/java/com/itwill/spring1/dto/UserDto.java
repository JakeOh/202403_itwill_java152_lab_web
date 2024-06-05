package com.itwill.spring1.dto;

import lombok.Builder;
import lombok.Data;

@Data //-> @Getter, @Setter, @ToString, @EqualsAndHashCode, @RequiredArgsConstructor
@Builder
public class UserDto {
    private String username;
    private int age;
}
