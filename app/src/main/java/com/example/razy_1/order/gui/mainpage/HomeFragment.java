package com.example.razy_1.order.gui.mainpage;


import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Bundle;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import com.example.razy_1.order.R;
import com.example.razy_1.order.gui.barcode.BarcodeProcess;
import com.example.razy_1.order.gui.suppliers.CompanyFragment;
import com.example.razy_1.order.gui.products.ProductFragment;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;
import info.hoang8f.android.segmented.SegmentedGroup;

import static com.example.razy_1.order.utels.StaticMethod.pemissionCamera;

/**
 * A simple {@link Fragment} subclass.
 */
public class HomeFragment extends Fragment {
    @BindView(R.id.companyRadio)
    RadioButton companyRadio;
    @BindView(R.id.ProductRadio)
    RadioButton prductRadio;
    @BindView(R.id.rg_reset_options)
    SegmentedGroup rgResetOptions;
    Unbinder unbinder;
    @BindView(R.id.barcodeBtn)
    Button barcodeBtn;
    @BindView(R.id.contnerProductandCompany)
    FrameLayout contnerProductandCompany;
    ProductFragment productFragment;
    CompanyFragment companyFragment;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_home, container, false);
        unbinder = ButterKnife.bind(this, view);
        productFragment = new ProductFragment();
        companyFragment = new CompanyFragment();
        prductRadio.setChecked(true);
        checkRadio();
        ((HomePage)getActivity()).inVisableBack();

        return view;
    }

    @OnClick({R.id.barcodeBtn})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.barcodeBtn:
                if (pemissionCamera(getActivity()) == true) {
                } else if (pemissionCamera(getActivity()) == false) {
                    Intent i = new Intent(getActivity(), BarcodeProcess.class);
                    getActivity().startActivityForResult(i, 1);
                }
                break;
        }
    }


    public void setFragment(Fragment fragment) {
        FragmentTransaction fragmentTransaction = getChildFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.contnerProductandCompany, fragment);
        fragmentTransaction.commit();
    }

    public void checkRadio() {
        if (prductRadio.isChecked()) {
            setFragment(productFragment);
        } else if (companyRadio.isChecked()) {
            setFragment(companyFragment);
        }
        rgResetOptions.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                if (prductRadio.isChecked()) {
                    setFragment(productFragment);
                } else {
                    setFragment(companyFragment);
                }
            }
        });
    }
}
