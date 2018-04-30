package com.epam.jmp.bayanouskaya.task11.repository.impl;

import com.epam.jmp.bayanouskaya.task11.domain.Good;
import com.epam.jmp.bayanouskaya.task11.repository.api.GoodRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class GoodRepositoryImpl extends JdbcDaoSupport implements GoodRepository {

    @Autowired
    public GoodRepositoryImpl(DataSource dataSource) {
        setDataSource(dataSource);
    }

    @Override
    public List<Good> findAll() {
        String findAllSql = "SELECT id, name, count " +
                "FROM task11_part2.goods";
        return getJdbcTemplate().query(findAllSql, new GoodMapper());
    }

    @Override
    public void create(final Good good) {
        String updateSql = "INSERT INTO task11_part2.goods(name, count) VALUES (?, ?)";
        good.setId((long) getJdbcTemplate().update(updateSql, good.getName(), good.getCount()));
    }

    @Override
    public Good read(final Long goodId) {
        String readSql = "SELECT id, name, count " +
                "FROM task11_part2.goods " +
                "WHERE id = ? ";
        return getJdbcTemplate().queryForObject(readSql, new GoodMapper(), goodId);
    }

    @Override
    public void update(final Good good) {
        String updateSql = "UPDATE task11_part2.goods " +
                "SET (name, count) = (?, ?) " +
                "WHERE id = ?";
        getJdbcTemplate().update(updateSql, good.getName(), good.getCount(), good.getId());
    }

    @Override
    public void delete(final Long goodIs) {
        String deleteSql = "DELETE FROM task11_part2.goods " +
                "WHERE id = ?";
        getJdbcTemplate().update(deleteSql, goodIs);
    }

    private static final class GoodMapper implements RowMapper<Good> {

        public Good mapRow(ResultSet resultSet, int i) throws SQLException {
            Good good = new Good();
            good.setId(resultSet.getLong("id"));
            good.setName(resultSet.getString("name"));
            good.setCount(resultSet.getLong("count"));
            return good;
        }
    }
}
