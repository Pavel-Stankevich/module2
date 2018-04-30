package com.epam.jmp.bayanouskaya.task11.repository.impl;

import com.epam.jmp.bayanouskaya.task11.domain.Role;
import com.epam.jmp.bayanouskaya.task11.repository.api.RoleRepository;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.support.JdbcDaoSupport;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class RoleRepositoryImpl extends JdbcDaoSupport implements RoleRepository {

    @Override
    public List<Role> findAll() {
        String findAllSql = "SELECT id, name " +
                "FROM task11_part2.roles";
        return getJdbcTemplate().query(findAllSql, new RoleMapper());
    }

    @Override
    public Role read(final Long roleId) {
        String readSql = "SELECT id, name " +
                "FROM task11_part2.roles " +
                "WHERE id = ? ";
        return getJdbcTemplate().queryForObject(readSql, new RoleMapper(), roleId);
    }

    private static final class RoleMapper implements RowMapper<Role> {

        public Role mapRow(ResultSet resultSet, int i) throws SQLException {
            Role role = new Role();
            role.setId(resultSet.getLong("id"));
            role.setName(resultSet.getString("name"));
            return role;
        }
    }
}
