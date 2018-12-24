package com.example.razy_1.order.gui.history;

import com.example.razy_1.order.data.beans.CartItem;
import com.example.razy_1.order.data.beans.ResultHistory;

import java.util.ArrayList;
import java.util.List;

public interface GetMyOrder {
    void myOrder(List<ResultHistory> cartItemArrayList);
    void noOrder();
    void noConnection();

}
