package com.epam.jmp.bayanouskaya.task11.service.impl;

import com.epam.jmp.bayanouskaya.task11.domain.Role;
import com.epam.jmp.bayanouskaya.task11.repository.api.RoleRepository;
import com.epam.jmp.bayanouskaya.task11.service.api.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoleServiceImpl implements RoleService {

    @Autowired
    private RoleRepository roleRepository;

    @Override
    public Role getRole(Long id) {
        return roleRepository.read(id);
    }

    @Override
    public List<Role> getRoles() {
        return roleRepository.findAll();
    }
}
