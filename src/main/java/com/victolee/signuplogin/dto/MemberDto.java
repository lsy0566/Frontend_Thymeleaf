package com.victolee.signuplogin.dto;

import com.victolee.signuplogin.domain.entity.MemberEntity;
import lombok.*;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import java.time.LocalDateTime;

@Data
@ToString
@NoArgsConstructor
public class MemberDto {
    private Long id;

    @Email(message = "이메일 형식에 맞지 않습니다.")
    @NotBlank(message = "email은 필수 입력 값입니다.")
    private String email;

    @NotBlank(message = "password는 필수 입력 값입니다.")
    private String password;
    private LocalDateTime createdDate;
    private LocalDateTime modifiedDate;

    public MemberEntity toEntity(){
        return MemberEntity.builder()
                .id(id)
                .email(email)
                .password(password)
                .build();
    }

    @Builder
    public MemberDto(Long id, String email, String password) {
        this.id = id;
        this.email = email;
        this.password = password;
    }
}