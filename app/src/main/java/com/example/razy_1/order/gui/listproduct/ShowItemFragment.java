package com.example.razy_1.order.gui.listproduct;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.SearchView;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AutoCompleteTextView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.example.razy_1.order.R;
import com.example.razy_1.order.gui.supplierslist.getListSupp;
import com.example.razy_1.order.gui.supplierslist.SuppListPresenter;
import com.example.razy_1.order.gui.mainpage.HomePage;
import com.example.razy_1.order.adapter.DisplayProductAdapter;
import com.example.razy_1.order.adapter.DisplaySupppAdapter;
import com.example.razy_1.order.data.beans.ResultCompany;
import com.example.razy_1.order.data.beans.ResultListSuppList;
import com.example.razy_1.order.data.beans.ResultProduct;
import com.example.razy_1.order.data.beans.ResultProductList;

import org.angmarch.views.NiceSpinner;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;

import static com.example.razy_1.order.utels.StaticMethod.setSearchviewTextSize;
import static com.example.razy_1.order.utels.ToastUtel.showToast;

/**
 * A simple {@link Fragment} subclass.
 */
public class ShowItemFragment extends Fragment implements getListSupp, getListProduct {

    @BindView(R.id.itemRecycler)
    RecyclerView itemRecycler;
    Unbinder unbinder;
    DisplaySupppAdapter displayItemAdapter;
    @BindView(R.id.spin_kit)
    ProgressBar itemProgress;
    public static String name;
    @BindView(R.id.itemSearch)
    SearchView itemSearch;
    public static int id;
    @BindView(R.id.allitemTv)
    TextView allitemTv;
    ResultCompany resultSuppitems;
    ResultProduct resultProductitem;
    DisplayProductAdapter displayProductAdapter;
    @BindView(R.id.priceSpinner)
    NiceSpinner priceSpinner;
    @BindView(R.id.companySPinner2)
    NiceSpinner companySPinner2;

    public ShowItemFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_show_item, container, false);
        unbinder = ButterKnife.bind(this, view);
        receveData();
        setSearchviewTextSize(itemSearch, 15);
        return view;
    }

    @Override
    public void getSupp(List<ResultListSuppList> listSupp) {
        if (listSupp.isEmpty()) {
            showToast(getActivity(),getString(R.string.NoProductInCompany));
            itemProgress.setVisibility(View.GONE);
        } else {
            displayItemAdapter = new DisplaySupppAdapter(listSupp, getActivity());
            itemRecycler.setAdapter(displayItemAdapter);
            displayItemAdapter.notifyDataSetChanged();
            itemProgress.setVisibility(View.GONE);
            itemRecycler.setVisibility(View.VISIBLE);
        }
    }

    @Override
    public void myProduct(List<ResultProductList> listProduct) {
        if (listProduct.isEmpty()) {
            showToast(getActivity(),getString(R.string.NoProductInCompany));
            itemProgress.setVisibility(View.GONE);

        } else {

            displayProductAdapter = new DisplayProductAdapter(listProduct, getActivity(), listProduct);

            itemSearch.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
                @Override
                public boolean onQueryTextSubmit(String query) {
                    displayProductAdapter.getFilter().filter(query);
                    itemSearch.setFocusable(false);
                    itemSearch.clearFocus();
                    return false;
                }

                @Override
                public boolean onQueryTextChange(String newText) {
                    displayProductAdapter.getFilter().filter(newText);

                    return false;
                }
            });

            itemRecycler.setAdapter(displayProductAdapter);
            displayProductAdapter.notifyDataSetChanged();
            itemProgress.setVisibility(View.GONE);
            itemRecycler.setVisibility(View.VISIBLE);

        }
    }


    @OnClick(R.id.allitemTv)
    public void onViewClicked() {
        itemSearch.setFocusable(false);
        itemSearch.setIconified(true);
        itemSearch.clearFocus();
    }

    private void receveData() {
        Bundle bundle = this.getArguments();
        itemRecycler.setLayoutManager(new LinearLayoutManager(getActivity()));
        ((HomePage) getActivity()).VisableBack();
        if (bundle != null) {
            resultSuppitems = (ResultCompany) bundle.getParcelable("supp");
            resultProductitem = (ResultProduct) bundle.getParcelable("product");
        }
        if (resultSuppitems != null) {
            name = resultSuppitems.getName();
            SuppListPresenter suppListPresenter = new SuppListPresenter(this);
            id = resultSuppitems.getSupplierId();
            suppListPresenter.getListSupp(resultSuppitems.getSupplierId());

        } else if (resultProductitem != null) {
            name = resultProductitem.getName();
            ProductListPresenter productListPresenter = new ProductListPresenter(this);
            id = resultProductitem.getCategoryId();
            productListPresenter.getMyProduct(resultProductitem.getCategoryId());

        }
    }


}
