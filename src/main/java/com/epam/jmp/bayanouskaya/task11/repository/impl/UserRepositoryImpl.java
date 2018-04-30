package com.epam.jmp.bayanouskaya.task11.repository.impl;

import com.epam.jmp.bayanouskaya.task11.domain.User;
import com.epam.jmp.bayanouskaya.task11.repository.api.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.stereotype.Repository;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import javax.sql.DataSource;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class UserRepositoryImpl extends JdbcDaoSupport implements UserRepository {

    @Autowired
    public UserRepositoryImpl(DataSource dataSource) {
        setDataSource(dataSource);
    }

    @Override
    public void create(User user) {
        String updateSql = "INSERT INTO task11.users(login, password, image) VALUES (?,?,?)";
        user.setId((long) getJdbcTemplate().update(updateSql, user.getLogin(), user.getPassword(), user.getImage()));
    }

    @Override
    public User read(Long userId) {
        String readSql = "SELECT id, login, password, image " +
                "FROM task11.users " +
                "WHERE id = ?";
        return getJdbcTemplate().queryForObject(readSql, new UserMapper(), userId);
    }

    @Override
    public void update(User user) {
        String updateSql = "UPDATE task11.users " +
                "SET (login, password, image) = (?, ?, ?) " +
                "WHERE id = ?";
        getJdbcTemplate().update(updateSql, user.getLogin(), user.getPassword(), user.getImage(), user.getId());
    }

    @Override
    public void delete(Long userId) {
        String deleteSql = "DELETE FROM task11.users " +
                "WHERE id = ?";
        getJdbcTemplate().update(deleteSql, userId);
    }

    @Override
    public List<User> findAll() {
        String findAllSql = "SELECT id, login, password, image " +
                "FROM task11.users";
        return getJdbcTemplate().query(findAllSql, new UserMapper());
    }

    private static final class UserMapper implements RowMapper<User> {

        public User mapRow(ResultSet resultSet, int i) throws SQLException {
            User user = new User();
            user.setId(resultSet.getLong("id"));
            user.setLogin(resultSet.getString("login"));
            user.setPassword(resultSet.getString("password"));
            user.setImage(resultSet.getBytes("image"));
            return user;
        }
    }
}
