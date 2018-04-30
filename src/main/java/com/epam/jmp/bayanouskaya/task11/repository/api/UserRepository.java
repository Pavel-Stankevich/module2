package com.epam.jmp.bayanouskaya.task11.repository.api;

import com.epam.jmp.bayanouskaya.task11.domain.User;

public interface UserRepository extends CrudRepository<User, Long> {

    User findUserByEmail(String email);
}
