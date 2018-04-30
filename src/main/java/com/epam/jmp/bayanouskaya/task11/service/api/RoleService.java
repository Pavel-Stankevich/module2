package com.epam.jmp.bayanouskaya.task11.service.api;

import com.epam.jmp.bayanouskaya.task11.domain.Role;

import java.util.List;

public interface RoleService {

    Role getRole(Long id);

    List<Role> getRoles();
}
