package com.epam.jmp.bayanouskaya.task11.repository.api;

import com.epam.jmp.bayanouskaya.task11.domain.Good;

import java.util.List;

public interface GoodRepository extends CrudRepository<Good, Long> {

    List<Good> findAll();

    List<Good> findGoodByIdOrder(Long orderId);

    void deleteGoodFromOrder(Long orderId, Long goodId);
}
