package com.example.razy_1.order.data.beans;

public class CartItem {
    public ResultProductList items;
    public int quantity;


    public CartItem() {
    }

    public CartItem(ResultProductList items, int quantity) {
        this.items = items;
        this.quantity = quantity;
    }
}
