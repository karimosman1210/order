package com.example.razy_1.order.gui.basket;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.example.razy_1.order.R;
import com.example.razy_1.order.utels.StaticConfig;
import com.example.razy_1.order.gui.mainpage.HomePage;
import com.example.razy_1.order.adapter.AdapterInterface;
import com.example.razy_1.order.adapter.CartAdapter;
import com.example.razy_1.order.gui.mainpage.HomeFragment;
import com.example.razy_1.order.data.beans.CartItem;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;

import static com.example.razy_1.order.utels.ToastUtel.showToast;

/**
 * A simple {@link Fragment} subclass.
 */
public class CartFragment extends Fragment implements getCartList, AdapterInterface {

    @BindView(R.id.cartRecycler)
    RecyclerView cartRecycler;
    Unbinder unbinder;
    @BindView(R.id.checkOutBtn)
    Button checkOutBtn;
    CartAdapter cartAdapter;
    HomeFragment homeFragment;
    @BindView(R.id.totalAmountCart)
    TextView totalAmountCart;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_cart, container, false);
        unbinder = ButterKnife.bind(this, view);
        CartPresenter cartPresenter = new CartPresenter(this);
        cartPresenter.getDataCart();
        cartRecycler.setLayoutManager(new LinearLayoutManager(getActivity()));
        homeFragment = new HomeFragment();
        ((HomePage) getActivity()).inVisableBack();
        return view;
    }

    @OnClick(R.id.checkOutBtn)
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.checkOutBtn:
                StaticConfig.items.clear();
                showToast(getActivity(),getString(R.string.buyIsDone));
                ((HomePage) getActivity()).changeHomeSelect();
                ((HomePage) getActivity()).frameCount.setVisibility(View.GONE);

                break;
        }
    }

    @Override
    public void myCart(ArrayList<CartItem> cartItemArrayList) {
        if (!cartItemArrayList.isEmpty()) {
            cartAdapter = new CartAdapter(cartItemArrayList, getActivity(), this);
            cartRecycler.setAdapter(cartAdapter);
        }
    }

    @Override
    public void NoDatainCart() {
        showToast(getActivity(),getString(R.string.basketIsEmpty));
    }

    @Override
    public void total(String s) {
        if (s.equals("0")) {
            ((HomePage) getActivity()).changeHomeSelect();
            ((HomePage) getActivity()).frameCount.setVisibility(View.GONE);
        }else {
            totalAmountCart.setText(s +"  "+ getString(R.string.pound));

        }

    }
}
