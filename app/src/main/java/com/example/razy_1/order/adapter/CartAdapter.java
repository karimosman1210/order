package com.example.razy_1.order.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.razy_1.order.R;
import com.example.razy_1.order.data.DialogData.DialogListener;
import com.example.razy_1.order.utels.DialogPoP;
import com.example.razy_1.order.utels.StaticConfig;
import com.example.razy_1.order.gui.mainpage.HomePage;
import com.example.razy_1.order.gui.mainpage.HomeFragment;
import com.example.razy_1.order.gui.listproduct.ShowItemFragment;
import com.example.razy_1.order.data.beans.CartItem;
import com.squareup.picasso.Picasso;

import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Locale;

public class CartAdapter extends RecyclerView.Adapter<CartAdapter.VH> {
    ArrayList<CartItem> cartItems;
    Context context;
    HomeFragment homeFragment;
    AdapterInterface sendCountTotal;

    public CartAdapter(ArrayList<CartItem> cartItems, Context context, AdapterInterface sendCountTotal) {
        this.cartItems = cartItems;
        this.context = context;
        this.sendCountTotal = sendCountTotal;
    }

//    public CartAdapter(ArrayList<CartItem> resultHistory, Context context,) {
//        this.resultHistory = resultHistory;
//        this.context = context;
//        homeFragment = new HomeFragment();
//        cartFragment=new CartFragment();
//    }


    @NonNull
    @Override
    public CartAdapter.VH onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(context).inflate(R.layout.carditem, parent, false);
        return new VH(v);
    }

    @Override
    public void onBindViewHolder(@NonNull final CartAdapter.VH holder, final int position) {
        final CartItem cartItem = cartItems.get(position);
//        holder.totalPriceCard.setText(cartItem.items.getTotalPrice());
        Picasso.with(context).load(R.drawable.bakr).into(holder.imageItem);
        holder.barcodeCard.setText(cartItem.items.getUpdatedOnUtc());
        holder.descriptionCard.setText(cartItem.items.getName());
        holder.companyNameCard.setText(ShowItemFragment.name);
        holder.amountCard.setText(String.valueOf(cartItem.quantity));
        String date = new SimpleDateFormat("yyyy-MM-dd", Locale.getDefault()).format(new Date());
        holder.dateCard.setText(date);

        double result = cartItem.quantity * Double.parseDouble(cartItem.items.getPrice());
        result = Math.round(result * 1000000.0) / 1000000.0;
        DecimalFormat f = new DecimalFormat("####.0");
        String formattedValue = f.format(result);
        holder.totalPriceCard.setText(formattedValue);
        sendCountTotal.total(String.valueOf(grandTotal(cartItems)));

        holder.delete_item.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                new DialogPoP.Builder(context)
                        .setTitle("انتبه !!!!")
                        .setMessage(" هل تريد حذف " + "' " + cartItem.items.getName() + " '" + " من السله ")
                        .setNegativeBtnText("لا")
                        .setPositiveBtnBackground("#611F7E")
                        .setPositiveBtnText("نعم")
                        .isCancellable(true)
                        .OnPositiveClicked(new DialogListener() {
                            @Override
                            public void OnClick() {
                                try {
                                    cartItems.remove(position);
                                    StaticConfig.items.remove(cartItem.items.getProductId());
                                    if (cartItems.isEmpty()) {
                                        sendCountTotal.total("0");
                                        Toast.makeText(context, "السله فارغه ", Toast.LENGTH_SHORT).show();

                                        ((HomePage) context).changeHomeSelect();
                                        ((HomePage) context).frameCount.setVisibility(View.GONE);

                                    } else {
                                        ((HomePage) context).setdataCount(cartItems.size());
                                    }
                                } catch (Exception e) {

                                }

                                notifyDataSetChanged();
                            }
                        })
                        .OnNegativeClicked(new DialogListener() {
                            @Override
                            public void OnClick() {

                            }
                        })
                        .build();


            }
        });

    }

    @Override
    public int getItemCount() {
        return cartItems.size();
    }

    public class VH extends RecyclerView.ViewHolder {
        TextView dateCard, totalPriceCard, amountCard, companyNameCard, descriptionCard, barcodeCard;
        ImageView imageItem;
        Button delete_item;

        public VH(View itemView) {
            super(itemView);
            dateCard = (TextView) itemView.findViewById(R.id.dateCard);
            totalPriceCard = (TextView) itemView.findViewById(R.id.totalPriceCard);
            amountCard = (TextView) itemView.findViewById(R.id.amountCard);
            companyNameCard = (TextView) itemView.findViewById(R.id.companyNameCard);
            descriptionCard = (TextView) itemView.findViewById(R.id.descriptionCard);
            barcodeCard = (TextView) itemView.findViewById(R.id.barcodeCard);
            imageItem = (ImageView) itemView.findViewById(R.id.imageItem);
            delete_item = (Button) itemView.findViewById(R.id.delete_item);

        }
    }

    public double grandTotal(ArrayList<CartItem> items) {

        double result = 0;
        for (int i = 0; i < items.size(); i++) {
             result+= items.get(i).quantity * Double.parseDouble(items.get(i).items.getPrice());
//            totalPrice += Integer.parseInt(items.get(i).items.getPrice());
        }

        return result;
    }
}
