package com.epam.jmp.bayanouskaya.task11.domain;

import lombok.Data;

import java.util.List;

@Data
public class Order {

    private Long id;
    private User owner;
    private List<Good> goods;
    private OrderStatus orderStatus;
}
