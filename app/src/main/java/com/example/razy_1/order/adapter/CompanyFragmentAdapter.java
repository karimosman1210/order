package com.example.razy_1.order.adapter;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.example.razy_1.order.R;
import com.example.razy_1.order.gui.mainpage.HomePage;
import com.example.razy_1.order.gui.listproduct.ShowItemFragment;
import com.example.razy_1.order.data.beans.ResultCompany;
import com.squareup.picasso.Picasso;

import java.util.List;

public class CompanyFragmentAdapter extends RecyclerView.Adapter<CompanyFragmentAdapter.VH> {
    List<ResultCompany> items;
    Context context;
    ShowItemFragment showItemFragment;


    public CompanyFragmentAdapter(List<ResultCompany> items, Context context) {
        this.items = items;
        this.context = context;
        showItemFragment = new ShowItemFragment();
    }


    @Override
    public CompanyFragmentAdapter.VH onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.product_item, parent, false);
        return new VH(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CompanyFragmentAdapter.VH holder, final int position) {
        final ResultCompany product = items.get(position);
        holder.itemName.setText(product.getName());

        if (position == 0) {
            holder.itemName.setText("P&G");

            Picasso.with(context).load(R.drawable.pg).into(holder.itemImg);
        }
        if (position == 1) {
            Picasso.with(context).load(R.drawable.aga).into(holder.itemImg);

        }
        if (position == 2) {
            Picasso.with(context).load(R.drawable.edita).into(holder.itemImg);

        }
        if (position == 3) {
            Picasso.with(context).load(R.drawable.ragab).into(holder.itemImg);

        }
        if (position == 4) {
            Picasso.with(context).load(R.drawable.pyrameds).into(holder.itemImg);

        }
        if (position == 5) {
            Picasso.with(context).load(R.drawable.pwady).into(holder.itemImg);

        }
        if (position == 6) {
            Picasso.with(context).load(R.drawable.gawhara).into(holder.itemImg);

        }
        if (position == 7) {
            Picasso.with(context).load(R.drawable.rashed).into(holder.itemImg);

        }
        if (position == 8) {
            Picasso.with(context).load(R.drawable.rashedy).into(holder.itemImg);

        }
        if (position == 9) {
            Picasso.with(context).load(R.drawable.zahar).into(holder.itemImg);

        }

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ((HomePage) context).setFragment(showItemFragment);
                ((HomePage) context).changeHome();
                ((HomePage) context).setBack(product.getName());
                if (position == 0) {
                    ((HomePage) context).setBack("P&G");
                }

                Bundle bundle = new Bundle();
                bundle.putParcelable("supp", product);
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
