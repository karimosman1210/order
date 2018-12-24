package com.example.razy_1.order.gui.history;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.SearchView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.razy_1.order.R;
import com.example.razy_1.order.adapter.MyOrderAdapter;
import com.example.razy_1.order.data.beans.ResultHistory;
import com.example.razy_1.order.gui.listproduct.ShowItemFragment;
import com.example.razy_1.order.gui.mainpage.HomePage;
import com.github.ybq.android.spinkit.SpinKitView;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonArray;

import org.angmarch.views.NiceSpinner;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;

import static com.example.razy_1.order.utels.StaticMethod.setSearchviewTextSize;

public class MyOrderFragment extends Fragment implements GetMyOrder {

    @BindView(R.id.myorderRecycler)
    RecyclerView myorderRecycler;
    Unbinder unbinder;
    @BindView(R.id.itemSearchOrder)
    SearchView itemSearchOrder;
    ShowItemFragment showItemFragment;
    @BindView(R.id.allTv)
    TextView allTv;
    MyOrderAdapter myOrderAdapter;
    @BindView(R.id.priceSpinner)
    NiceSpinner priceSpinner;
    @BindView(R.id.companySPinner2)
    NiceSpinner companySPinner2;
    @BindView(R.id.contact_swipe_refresh)
    SwipeRefreshLayout contactSwipeRefresh;
    @BindView(R.id.historyProgress)
    SpinKitView historyProgress;
    @BindView(R.id.historyLinear)
    LinearLayout historyLinear;
    @BindView(R.id.emptyImge)
    ImageView emptyImge;
    @BindView(R.id.connectionTvOrder)
    TextView connectionTvOrder;
    MyOrderPresenter myOrderPresenter;

    public MyOrderFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_my_order, container, false);
        unbinder = ButterKnife.bind(this, view);
        inittems();
        return view;
    }

    private void inittems() {
        showItemFragment = new ShowItemFragment();
        myorderRecycler.setLayoutManager(new LinearLayoutManager(getActivity()));
        myOrderPresenter = new MyOrderPresenter(this);
        myOrderPresenter.myOrder(getContext());
        ((HomePage) getActivity()).inVisableBack();
       setSearchviewTextSize(itemSearchOrder, 15);
        initRefresh();
    }

    private void initRefresh() {
        contactSwipeRefresh.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                myOrderPresenter.myOrder(getContext());
            }
        });
    }

    @Override
    public void myOrder(List<ResultHistory> historyResultList) {
        myOrderAdapter = new MyOrderAdapter(historyResultList, getContext());
        //convery arraylist to gson
        Gson gson = new GsonBuilder().create();
        JsonArray myCustomArray = gson.toJsonTree(historyResultList).getAsJsonArray();
        Log.v("testjson", myCustomArray.toString());


        historyProgress.setVisibility(View.GONE);
        historyLinear.setVisibility(View.VISIBLE);
        connectionTvOrder.setVisibility(View.GONE);
        myorderRecycler.setAdapter(myOrderAdapter);

//        itemSearchOrder.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
//            @Override
//            public boolean onQueryTextSubmit(String query) {
//                myOrderAdapter.getFilter().filter(query);
//                itemSearchOrder.setFocusable(false);
//                itemSearchOrder.clearFocus();
//                return false;
//            }
//
//            @Override
//            public boolean onQueryTextChange(String newText) {
//                myOrderAdapter.getFilter().filter(newText);
//                return false;
//            }
//        });

        contactSwipeRefresh.setRefreshing(false);
    }

    @Override
    public void noOrder() {
        historyProgress.setVisibility(View.GONE);
        historyLinear.setVisibility(View.GONE);
        emptyImge.setVisibility(View.VISIBLE);
        contactSwipeRefresh.setRefreshing(false);
    }

    @Override
    public void noConnection() {
        historyProgress.setVisibility(View.GONE);
        connectionTvOrder.setVisibility(View.VISIBLE);
        contactSwipeRefresh.setRefreshing(false);

    }

    @OnClick(R.id.connectionTvOrder)
    public void onViewClicked() {
        connectionTvOrder.setVisibility(View.GONE);
        historyProgress.setVisibility(View.VISIBLE);
        myOrderPresenter.myOrder(getContext());

    }


//
//    @OnClick(R.id.allTv)
//    public void onViewClicked() {
//        itemSearchOrder.setIconified(true);
//        itemSearchOrder.setFocusable(false);
//        itemSearchOrder.clearFocus();
//        priceSpinner.setSelectedIndex(0);
//        companySPinner2.setSelectedIndex(0);
//    }


}
