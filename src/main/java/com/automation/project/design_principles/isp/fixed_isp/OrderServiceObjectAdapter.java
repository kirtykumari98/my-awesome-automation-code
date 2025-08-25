package com.automation.project.design_principles.isp.fixed_isp;

import com.automation.project.design_principles.isp.violating_isp.OrderService;

public class OrderServiceObjectAdapter implements BurgerOrderService {
    private OrderService adaptee;

    public OrderServiceObjectAdapter(OrderService adaptee) {
        super();
        this.adaptee = adaptee;
    }

    @Override
    public void orderBurger(int quantity) {
        adaptee.orderBurger(quantity);
    }
}
