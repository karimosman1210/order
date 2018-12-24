package com.example.razy_1.order.gui.basket;

import com.example.razy_1.order.utels.StaticConfig;
import com.example.razy_1.order.data.beans.CartItem;

import java.util.ArrayList;

public class CartPresenter {
    getCartList getCartList;

    public CartPresenter(getCartList getCartList) {
        this.getCartList = getCartList;
    }
    public void getDataCart(){
        if (StaticConfig.items.isEmpty()){
            getCartList.NoDatainCart();
        }else {
            getCartList.myCart(new ArrayList<CartItem>(StaticConfig.items.values()));
        }
    }
}
