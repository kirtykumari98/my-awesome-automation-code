package com.automation.project.design_principles.isp.violating_isp;


public interface OrderService {
    void orderBurger(int quantity);

    void orderFries(int fries);

    void orderCombo(int quantity, int fries);
}

