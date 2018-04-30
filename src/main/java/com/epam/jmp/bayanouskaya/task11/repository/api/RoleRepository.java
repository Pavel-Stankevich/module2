package com.epam.jmp.bayanouskaya.task11.repository.api;

import com.epam.jmp.bayanouskaya.task11.domain.Role;

import java.util.List;

public interface RoleRepository extends CrudRepository<Role, Long> {

    List<Role> findAll();
}
