package com.epam.jmp.bayanouskaya.task11.domain;

import lombok.Data;

@Data
public class User {

    private Long id;
    private Role role;
    private String email;
    private String password;
    private String fullName;
    private String address;
}
