package com.automation.project.design_principles.isp.fixed_isp;

import com.automation.project.design_principles.isp.violating_isp.ComboOrderService;

public class OrderServiceTest {
    public static void main(String[] args) {
        BurgerOrderService burgerOrderService= new OrderServiceObjectAdapter(new ComboOrderService());
        burgerOrderService.orderBurger(5);
    }
}
