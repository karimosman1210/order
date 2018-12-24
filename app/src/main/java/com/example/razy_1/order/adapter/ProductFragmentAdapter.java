package com.example.razy_1.order.adapter;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.razy_1.order.R;
import com.example.razy_1.order.gui.mainpage.HomePage;
import com.example.razy_1.order.gui.listproduct.ShowItemFragment;
import com.example.razy_1.order.data.beans.ResultProduct;
import com.squareup.picasso.Picasso;

import java.util.List;

public class ProductFragmentAdapter extends RecyclerView.Adapter<ProductFragmentAdapter.VH> {
    List<ResultProduct> items;
    Context context;
    ShowItemFragment showItemFragment;


    public ProductFragmentAdapter(List<ResultProduct> items, Context context) {
        this.items = items;
        this.context = context;
        showItemFragment=new ShowItemFragment();
    }

    @NonNull
    @Override
    public ProductFragmentAdapter.VH onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.product_item, parent, false);
        return new VH(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ProductFragmentAdapter.VH holder, int position) {
        final ResultProduct product = items.get(position);
        holder.itemName.setText(product.getName());
//        Picasso.get().load(R.drawable.bakr).into(holder.itemImg);
        if (position==0){
            Picasso.with(context).load(R.drawable.food).into(holder.itemImg);

        }if (position==1){
            Picasso.with(context).load(R.drawable.milk).into(holder.itemImg);

        }if (position==2){
            Picasso.with(context).load(R.drawable.juse).into(holder.itemImg);

        }if (position==3){
            Picasso.with(context).load(R.drawable.clear).into(holder.itemImg);

        }if (position==4){
            Picasso.with(context).load(R.drawable.cigorate).into(holder.itemImg);

        }
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ((HomePage)context).setFragment(showItemFragment);
                ((HomePage)context).changeHome();
                ((HomePage)context).setBack(product.getName());
                Bundle bundle = new Bundle();
                bundle.putParcelable("product", product);
                showItemFragment.setArguments(bundle);

            }
        });
    }
    @Override
    public int getItemCount() {
        return items.size();
    }

    public class VH extends RecyclerView.ViewHolder {
        ImageView itemImg;
        TextView itemName;

        public VH(View itemView) {
            super(itemView);
            itemImg = (ImageView) itemView.findViewById(R.id.itemImg);
            itemName = (TextView) itemView.findViewById(R.id.itemName);

        }
    }
}
