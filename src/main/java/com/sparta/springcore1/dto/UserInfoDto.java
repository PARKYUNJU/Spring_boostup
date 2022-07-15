package com.sparta.springcore1.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class UserInfoDto {
    String username;
    boolean isAdmin;
}
