package com.epam.jmp.bayanouskaya.task11.service.api;

import com.epam.jmp.bayanouskaya.task11.domain.Good;

import java.util.List;

public interface GoodService {

    Good getGood(Long id);

    void save(Good good);

    void delete(Long id);

    List<Good> getGoods();
}
