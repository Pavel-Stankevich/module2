package com.epam.jmp.bayanouskaya.task11.repository.impl;

import com.epam.jmp.bayanouskaya.task11.domain.Good;
import com.epam.jmp.bayanouskaya.task11.domain.Order;
import com.epam.jmp.bayanouskaya.task11.domain.OrderStatus;
import com.epam.jmp.bayanouskaya.task11.domain.User;
import com.epam.jmp.bayanouskaya.task11.repository.api.GoodRepository;
import com.epam.jmp.bayanouskaya.task11.repository.api.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
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
    private GoodRepository goodRepository;

    @Autowired
    public OrderRepositoryImpl(DataSource dataSource) {
        setDataSource(dataSource);
    }

    @Override
    public List<Order> findAll() {
        String findAllSql = "SELECT o.id, o.id_user, u.email, u.full_name ,u.address, o.status " +
                "FROM task11_part2.orders o " +
                "LEFT JOIN task11_part2.users u ON o.id_user = u.id ";
        return getJdbcTemplate().query(findAllSql, new OrderMapper());
    }

    @Override
    public Order findOpenByUserId(final Long userId) {
        String findByUserIdSql = "SELECT o.id, o.id_user, u.email, u.full_name ,u.address, o.status " +
                "FROM task11_part2.orders o " +
                "LEFT JOIN task11_part2.users u ON o.id_user = u.id " +
                "WHERE o.id_user = ? AND o.status = '" + OrderStatus.OPEN + "'";
        Order order = null;
        try {
            order = getJdbcTemplate().queryForObject(findByUserIdSql, new OrderMapper(), userId);
        } catch (EmptyResultDataAccessException ex) {
        }
        return order;
    }

    @Override
    public void addGood(final Order order, final Good good) {
        String addGoodSql = "INSERT INTO task11_part2.order_goods(id_order, id_good) VALUES (?, ?)";
        getJdbcTemplate().update(addGoodSql, order.getId(), good.getId());
    }

    @Override
    public void create(final Order order) {
        String updateSql = "INSERT INTO task11_part2.orders(id_user, status) VALUES (?, ?)";
        order.setId((long) getJdbcTemplate().update(updateSql, order.getOwner().getId(), order.getOrderStatus().name()));
        String createSql = "INSERT INTO task11_part2.order_goods(id_order, id_good) VALUES (?, ?)";
        order.getGoods().forEach(good -> {
            getJdbcTemplate().update(createSql, order.getId(), good.getId());
        });
    }

    @Override
    public Order read(final Long orderId) {
        String readSql = "SELECT o.id, o.id_user, u.email, u.full_name ,u.address, o.status " +
                "FROM task11_part2.orders o " +
                "LEFT JOIN task11_part2.users u ON o.id_user = u.id " +
                "WHERE o.id = ?";
        Order order = null;
        try {
            order = getJdbcTemplate().queryForObject(readSql, new OrderMapper(), orderId);
        } catch (EmptyResultDataAccessException ex) {
        }
        return order;
    }

    @Override
    public void update(final Order order) {
        String updateSql = "UPDATE task11_part2.orders " +
                "SET (id_user, status) = (?, ?) " +
                "WHERE id = ?";
        getJdbcTemplate().update(updateSql, order.getOwner().getId(), order.getOrderStatus().name());
    }

    @Override
    public void delete(final Long orderId) {
        getJdbcTemplate().update("DELETE FROM task11_part2.order_goods WHERE id_order = ?", orderId);
        getJdbcTemplate().update("DELETE FROM task11_part2.orders WHERE id = ?", orderId);
    }

    private class OrderMapper implements RowMapper<Order> {

        public Order mapRow(ResultSet resultSet, int i) throws SQLException {
            Order order = new Order();
            User owner = new User();
            order.setId(resultSet.getLong("id"));
            owner.setId(resultSet.getLong("id_user"));
            owner.setEmail(resultSet.getString("email"));
            owner.setFullName(resultSet.getString("full_name"));
            owner.setAddress(resultSet.getString("address"));
            order.setOwner(owner);
            order.setOrderStatus(OrderStatus.valueOf(resultSet.getString("status").toUpperCase()));
            order.setGoods(goodRepository.findGoodByIdOrder(order.getId()));
            return order;
        }
    }
}
