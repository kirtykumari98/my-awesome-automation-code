package com.automation.project.design_principles.isp.violating_isp;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class FriesOrderService implements OrderService {
    static Logger logger = LogManager.getLogger(FriesOrderService.class);

    @Override
    public void orderBurger(int quantity) {
        throw new UnsupportedOperationException("No Burger in Fries order");
    }

    @Override
    public void orderFries(int fries) {
        logger.info("Received " + fries + "order");
    }

    @Override
    public void orderCombo(int quantity, int fries) {
        throw new UnsupportedOperationException("No combo in burger only order!");
    }
}
