package com.epam.jmp.bayanouskaya.task11.repository.impl;

import com.epam.jmp.bayanouskaya.task11.domain.Role;
import com.epam.jmp.bayanouskaya.task11.repository.api.RoleRepository;
import org.springframework.jdbc.core.support.JdbcDaoSupport;

import java.util.List;

public class RoleRepositoryImpl extends JdbcDaoSupport implements RoleRepository {

    @Override
    public List<Role> findAll() {
        return null;
    }

    @Override
    public void create(final Role obj) {

    }

    @Override
    public Role read(final Long aLong) {
        return null;
    }

    @Override
    public void update(final Role obj) {

    }

    @Override
    public void delete(final Long aLong) {

    }
}
