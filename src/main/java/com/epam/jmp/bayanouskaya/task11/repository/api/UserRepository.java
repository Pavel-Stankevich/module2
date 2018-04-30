package com.epam.jmp.bayanouskaya.task11.repository.api;

import com.epam.jmp.bayanouskaya.task11.domain.User;

import java.util.List;

public interface UserRepository extends CrudRepository<User, Long> {

    List<User> findAll();
}
