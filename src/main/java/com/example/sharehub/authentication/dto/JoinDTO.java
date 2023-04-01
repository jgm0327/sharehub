package com.example.sharehub.authentication.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class JoinDTO {
    @JsonProperty("userId")
    private String username;
    @JsonProperty("userPassword")
    private String password;
    @JsonProperty("nickName")
    private String nickname;

    private String role;
}
