package com.example.board.dto;

import jakarta.validation.constraints.Email;

import jakarta.validation.constraints.Min;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserDto {
    private String userName;

    private String password;
    @Email
    private String email;

    public UserDto(String password, String email) {
        this.password = password;
        this.email = email;
    }
}
