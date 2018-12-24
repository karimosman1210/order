package com.example.razy_1.order.gui.suppliers;


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
import com.example.razy_1.order.adapter.CompanyFragmentAdapter;
import com.example.razy_1.order.data.beans.ResultCompany;
import com.example.razy_1.order.gui.mainpage.HomePage;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;

/**
 * A simple {@link Fragment} subclass.
 */
public class CompanyFragment extends Fragment implements dataCompany {
    CompanyFragmentAdapter companyFragmentAdapter;
    @BindView(R.id.companyRecycler)
    RecyclerView companyRecycler;
    @BindView(R.id.companyProgress)
    ProgressBar companyProgress;
    Unbinder unbinder;
    CompanyPresenter companyPresenter;
    @BindView(R.id.contact_swipe_refreshCompany)
    SwipeRefreshLayout contactSwipeRefreshCompany;
    @BindView(R.id.connectioncompanyTv)
    TextView connectioncompanyTv;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_company, container, false);
        unbinder = ButterKnife.bind(this, view);
        companyRecycler.setLayoutManager(new GridLayoutManager(getActivity(), 5));
        companyPresenter = new CompanyPresenter(this);
        companyPresenter.getCompanyData(getContext());
        ((HomePage) getActivity()).inVisableBack();
        initRefresh();
        return view;
    }

    private void initRefresh() {
        contactSwipeRefreshCompany.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                companyPresenter.getCompanyData(getContext());

            }
        });
    }


    @Override
    public void companyData(List<ResultCompany> companyArrayList) {
        companyFragmentAdapter = new CompanyFragmentAdapter(companyArrayList, getActivity());
        companyRecycler.setAdapter(companyFragmentAdapter);
        companyFragmentAdapter.notifyDataSetChanged();
        companyRecycler.setVisibility(View.VISIBLE);
        companyProgress.setVisibility(View.GONE);
        contactSwipeRefreshCompany.setRefreshing(false);
    }

    @Override
    public void noConnection() {
        companyProgress.setVisibility(View.GONE);
        connectioncompanyTv.setVisibility(View.VISIBLE);
        contactSwipeRefreshCompany.setRefreshing(false);
    }


    @OnClick(R.id.connectioncompanyTv)
    public void onViewClicked() {
        connectioncompanyTv.setVisibility(View.GONE);
        companyProgress.setVisibility(View.VISIBLE);
        companyPresenter.getCompanyData(getContext());
        contactSwipeRefreshCompany.setRefreshing(false);
    }
}
