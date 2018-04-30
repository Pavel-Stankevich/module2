package com.epam.jmp.bayanouskaya.task11.repository.api;

import com.epam.jmp.bayanouskaya.task11.domain.Role;

import java.util.List;

public interface RoleRepository {

    List<Role> findAll();

    Role read(Long id);
}
