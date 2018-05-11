package com.chris.ch1.entity.logicbean;

import com.chris.ch1.entity.Detail;
import com.chris.ch1.entity.Order;

public class OrderPostForm {

    private Order order;
    private Detail detail;

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

    public Detail getDetail() {
        return detail;
    }

    public void setDetail(Detail detail) {
        this.detail = detail;
    }
}
