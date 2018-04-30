package com.epam.jmp.bayanouskaya.task11.service.api;

import com.epam.jmp.bayanouskaya.task11.domain.User;

import java.util.List;

public interface UserService {

    User getUser(Long id);

    void save(User user);

    void delete(Long id);

    User getUserByEmail(String email);
}
