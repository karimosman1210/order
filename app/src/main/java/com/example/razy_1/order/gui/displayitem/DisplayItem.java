package com.example.razy_1.order.gui.displayitem;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.razy_1.order.R;
import com.example.razy_1.order.utels.StaticConfig;
import com.example.razy_1.order.gui.listproduct.ShowItemFragment;
import com.example.razy_1.order.data.beans.CartItem;
import com.example.razy_1.order.data.beans.ResultListSuppList;
import com.example.razy_1.order.data.beans.ResultProductList;
import com.squareup.picasso.Picasso;

import java.text.DecimalFormat;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

import static com.example.razy_1.order.utels.StaticMethod.addToCart;
import static com.example.razy_1.order.utels.StaticMethod.convertDecemal;
import static com.example.razy_1.order.utels.StaticMethod.oriantation;
import static com.example.razy_1.order.utels.ToastUtel.showToast;

public class DisplayItem extends AppCompatActivity {
    ResultProductList itemsProduct;
    ResultListSuppList itemCompany;
    @BindView(R.id.itemCode)
    TextView itemCode;
    @BindView(R.id.descrItem)
    TextView descrItem;
    @BindView(R.id.priceId)
    TextView priceId;
    @BindView(R.id.compItem)
    TextView compItem;
    @BindView(R.id.imageProudict)
    ImageView imageProudict;
    @BindView(R.id.decBtn)
    ImageView decBtn;
    @BindView(R.id.amountTv)
    TextView amountTv;
    @BindView(R.id.incBtn)
    ImageView incBtn;
    @BindView(R.id.totalPriceTv)
    TextView totalPriceTv;
    @BindView(R.id.addCard)
    Button addCard;
    int amount = 1;
    double result;
    int quantity;
    ShowItemFragment  showItemFragment;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        oriantation(this);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_item);
        ButterKnife.bind(this);
        setData();
    }

    private void setData() {
        showItemFragment=new ShowItemFragment();
        Intent intent = getIntent();
        itemsProduct = (ResultProductList) intent.getParcelableExtra("dsplayItemofProduct");
        itemCompany = (ResultListSuppList) intent.getParcelableExtra("dsplayItemofSupp");
        if (itemsProduct != null) {
            displayItemProduct();
        } else if (itemCompany != null) {
            displayItemCompany();
        }
    }

    private void displayItemProduct() {
        amountTv.setText("1");
        itemCode.setText(itemsProduct.getUpdatedOnUtc());
        descrItem.setText(itemsProduct.getName());
        compItem.setText(ShowItemFragment.name);
        priceId.setText(decimalConverter(itemsProduct.getPrice()) + " جنية ");
        if (showItemFragment.id==1){
            Picasso.with(this).load(R.drawable.food).into(imageProudict);
        }
        if (showItemFragment.id==2){
            Picasso.with(this).load(R.drawable.milk).into(imageProudict);

        }if (showItemFragment.id==3){
            Picasso.with(this).load(R.drawable.juse).into(imageProudict);

        }if (showItemFragment.id==4){
            Picasso.with(this).load(R.drawable.clear).into(imageProudict);

        }if (showItemFragment.id==5){
            Picasso.with(this).load(R.drawable.cigorate).into(imageProudict);

        }
        totalPriceTv.setText(decimalConverter(itemsProduct.getPrice()));
    }

    private void displayItemCompany() {
        amountTv.setText("1");
        itemCode.setText(itemCompany.getUpdatedOnUtc());
        descrItem.setText(itemCompany.getName());
        compItem.setText(ShowItemFragment.name);
        priceId.setText(decimalConverter(itemCompany.getPrice()) + " جنية ");
        if (showItemFragment.id==1){
            compItem.setText("P&G");
            Picasso.with(this).load(R.drawable.pg).into(imageProudict);
        }
        if (showItemFragment.id==2){
            Picasso.with(this).load(R.drawable.aga).into(imageProudict);

        }if (showItemFragment.id==3){
            Picasso.with(this).load(R.drawable.edita).into(imageProudict);

        }if (showItemFragment.id==4){
            Picasso.with(this).load(R.drawable.ragab).into(imageProudict);

        }if (showItemFragment.id==5){
            Picasso.with(this).load(R.drawable.pyrameds).into(imageProudict);

        }if (showItemFragment.id==6){
            Picasso.with(this).load(R.drawable.pwady).into(imageProudict);

        }if (showItemFragment.id==7){
            Picasso.with(this).load(R.drawable.gawhara).into(imageProudict);

        }if (showItemFragment.id==8){
            Picasso.with(this).load(R.drawable.rashed).into(imageProudict);

        }if (showItemFragment.id==9){
            Picasso.with(this).load(R.drawable.rashedy).into(imageProudict);

        }if (showItemFragment.id==10){
            Picasso.with(this).load(R.drawable.zahar).into(imageProudict);

        }

        totalPriceTv.setText(decimalConverter(itemCompany.getPrice()));
    }

    @OnClick({R.id.addCard, R.id.incBtn, R.id.decBtn})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.incBtn:
                amountTv.setText(String.valueOf(++amount));
                if (itemsProduct != null) {
                    result = amount * Double.parseDouble(itemsProduct.getPrice());
                } else {
                    result = amount * Double.parseDouble(itemCompany.getPrice());
                }

                result = Math.round(result * 1000000.0) / 1000000.0;
                totalPriceTv.setText(convertDecemal(result + ""));
                if (!decBtn.isEnabled()) {
                    decBtn.setEnabled(true);
                }

                break;
            case R.id.decBtn:
                if (amount > 1) {
                    amountTv.setText(String.valueOf(--amount));
                    if (itemsProduct != null) {
                        result = amount * Double.parseDouble(itemsProduct.getPrice());
                    } else {
                        result = amount * Double.parseDouble(itemCompany.getPrice());
                    }
                    result = Math.round(result * 1000000.0) / 1000000.0;

                    totalPriceTv.setText(convertDecemal(result + ""));
                    if (amount == 1) {
                        decBtn.setEnabled(false);
                    }
                }
                break;
            case R.id.addCard:
                quantity = Integer.parseInt(amountTv.getText().toString());
                if (itemsProduct != null) {
                    addToCart(new CartItem(itemsProduct, quantity));

                } else {
//                    addToCart(new CartItem(itemsProduct, quantity));
                }
                resultVoid();
                showToast(this,getString(R.string.ItemIsAdded));
                finish();
                break;
        }
    }

    public void resultVoid() {
        setResult(0);
    }

    public String decimalConverter(String num) {
        result = amount * Double.parseDouble(num);
        result = Math.round(result * 1000000.0) / 1000000.0;
        DecimalFormat f = new DecimalFormat("####.0");
        String formattedValue = f.format(result);
        return formattedValue;

    }
}
