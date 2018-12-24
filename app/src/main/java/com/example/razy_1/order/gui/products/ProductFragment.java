package com.example.razy_1.order.gui.products;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.example.razy_1.order.R;
import com.example.razy_1.order.adapter.ProductFragmentAdapter;
import com.example.razy_1.order.data.beans.ResultProduct;
import com.example.razy_1.order.gui.mainpage.HomePage;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;

/**
 * A simple {@link Fragment} subclass.
 */
public class ProductFragment extends Fragment implements dataProduct {
    ProductFragmentAdapter productFragmentAdapter;
    @BindView(R.id.prductRecycler)
    RecyclerView prductRecycler;
    @BindView(R.id.productProgress)
    ProgressBar productProgress;
    Unbinder unbinder;
    ProductPresenter productPresenter;
    @BindView(R.id.contact_swipe_refresh_product)
    SwipeRefreshLayout contactSwipeRefreshProduct;
    @BindView(R.id.connectionProduct)
    TextView connectionProduct;

    public ProductFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_product, container, false);
        unbinder = ButterKnife.bind(this, view);
        prductRecycler.setLayoutManager(new GridLayoutManager(getActivity(), 5));
        productPresenter = new ProductPresenter(this);
        productPresenter.getDataPrdocut(getContext());
        ((HomePage) getActivity()).inVisableBack();
        initRefresh();
        return view;
    }

    private void initRefresh() {
        contactSwipeRefreshProduct.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                productPresenter.getDataPrdocut(getContext());
            }
        });
    }


    @Override
    public void prduct(List<ResultProduct> prductArrayList) {
        productFragmentAdapter = new ProductFragmentAdapter(prductArrayList, getActivity());
        prductRecycler.setAdapter(productFragmentAdapter);
        productFragmentAdapter.notifyDataSetChanged();
        productProgress.setVisibility(View.GONE);
        prductRecycler.setVisibility(View.VISIBLE);

        contactSwipeRefreshProduct.setRefreshing(false);

    }

    @Override
    public void noConnection() {
        productProgress.setVisibility(View.GONE);
        connectionProduct.setVisibility(View.VISIBLE);
        contactSwipeRefreshProduct.setRefreshing(false);
    }


    @OnClick(R.id.connectionProduct)
    public void onViewClicked() {
        connectionProduct.setVisibility(View.GONE);
        productProgress.setVisibility(View.VISIBLE);
        productPresenter.getDataPrdocut(getContext());
    }
}
