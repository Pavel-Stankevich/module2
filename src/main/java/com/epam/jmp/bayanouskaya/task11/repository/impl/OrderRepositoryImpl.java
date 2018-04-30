package com.epam.jmp.bayanouskaya.task11.repository.impl;

import com.epam.jmp.bayanouskaya.task11.domain.Order;
import com.epam.jmp.bayanouskaya.task11.repository.api.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class OrderRepositoryImpl extends JdbcDaoSupport implements OrderRepository {

    @Autowired
    public OrderRepositoryImpl(DataSource dataSource) {
        setDataSource(dataSource);
    }

    @Override
    public List<Order> findAll() {
        String findAllSql = "SELECT o.id, o.id_user, u.email, u.full_name ,u.address, o.id_status, os.name " +
                "FROM task11_part2.orders o " +
                "LEFT JOIN task11_part2.order_goods og ON o.id = og.id_order " +
                "LEFT JOIN task11_part2.goods g ON og.id_good = g.id " +
                "LEFT JOIN task11_part2.users u ON o.id_user = u.id " +
                "LEFT JOIN task11_part2.order_statuses os ON o.id_status = os.id";
        return getJdbcTemplate().query(findAllSql, new OrderMapper() );
    }

    @Override
    public void create(final Order obj) {

    }

    @Override
    public Order read(final Long aLong) {
        return null;
    }

    @Override
    public void update(final Order obj) {

    }

    @Override
    public void delete(final Long aLong) {

    }

    private static final class OrderMapper implements RowMapper<Order> {

        public Order mapRow(ResultSet resultSet, int i) throws SQLException {
            Order order = new Order();
            return order;
        }
    }
}
