package com.epam.jmp.bayanouskaya.task11.repository.impl;

import com.epam.jmp.bayanouskaya.task11.domain.Role;
import com.epam.jmp.bayanouskaya.task11.domain.User;
import com.epam.jmp.bayanouskaya.task11.repository.api.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.sql.ResultSet;
import java.sql.SQLException;

@Repository
public class UserRepositoryImpl extends JdbcDaoSupport implements UserRepository {

    @Autowired
    public UserRepositoryImpl(DataSource dataSource) {
        setDataSource(dataSource);
    }

    @Override
    public void create(User user) {
        String updateSql = "INSERT INTO task11_part2.users(email, password, full_name, address, id_role) VALUES (?, ?, ?, ?, ?)";
        user.setId((long) getJdbcTemplate().update(updateSql, user.getEmail(), user.getPassword(), user.getFullName(), user.getAddress(), user.getRole().getId()));
    }

    @Override
    public User read(Long userId) {
        String readSql = "SELECT u.id, u.email, u.password, u.full_name, u.address, u.id_role, r.name " +
                "FROM task11_part2.users AS u  " +
                "LEFT JOIN task11_part2.roles AS r ON u.id_role = r.id " +
                "WHERE u.id = ?";
        return getJdbcTemplate().queryForObject(readSql, new UserMapper(), userId);
    }

    @Override
    public void update(User user) {
        String updateSql = "UPDATE task11_part2.users " +
                "SET (email, password, full_name, address, id_role) = (?, ?, ?, ?, ?) " +
                "WHERE id = ?";
        getJdbcTemplate().update(updateSql, user.getEmail(), user.getPassword(), user.getFullName(), user.getAddress(), user.getRole().getId(), user.getId());
    }

    @Override
    public void delete(Long userId) {
        String deleteSql = "DELETE FROM task11_part2.users " +
                "WHERE id = ?";
        getJdbcTemplate().update(deleteSql, userId);
    }

    @Override
    public User findUserByEmail(String email) {
        String readSql = "SELECT u.id, u.email, u.password, u.full_name, u.address, u.id_role, r.name " +
                "FROM task11_part2.users AS u  " +
                "LEFT JOIN task11_part2.roles AS r ON u.id_role = r.id " +
                "WHERE u.email = ?";
        return getJdbcTemplate().queryForObject(readSql, new UserMapper(), email);
    }

    private static final class UserMapper implements RowMapper<User> {

        public User mapRow(ResultSet resultSet, int i) throws SQLException {
            User user = new User();
            user.setId(resultSet.getLong("id"));
            user.setEmail(resultSet.getString("email"));
            user.setPassword(resultSet.getString("password"));
            user.setFullName(resultSet.getString("full_name"));
            user.setAddress(resultSet.getString("address"));
            Role role = new Role();
            role.setId(resultSet.getLong("id_role"));
            role.setName(resultSet.getString("name"));
            user.setRole(role);
            return user;
        }
    }
}
