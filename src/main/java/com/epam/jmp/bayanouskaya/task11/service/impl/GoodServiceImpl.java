package com.epam.jmp.bayanouskaya.task11.service.impl;

import com.epam.jmp.bayanouskaya.task11.domain.Good;
import com.epam.jmp.bayanouskaya.task11.repository.api.GoodRepository;
import com.epam.jmp.bayanouskaya.task11.service.api.GoodService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GoodServiceImpl implements GoodService {

    @Autowired
    private GoodRepository goodRepository;

    @Override
    public Good getGood(Long id) {
        return goodRepository.read(id);
    }

    @Override
    public void save(Good good) {
        if (null == good.getId()) {
            goodRepository.create(good);
        } else {
            goodRepository.update(good);
        }
    }

    @Override
    public void delete(Long id) {
        goodRepository.delete(id);
    }

    @Override
    public List<Good> getGoods() {
        return goodRepository.findAll();
    }
}
