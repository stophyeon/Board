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
    @Min(7)
    private String password;
    @Email
    private String email;

}
