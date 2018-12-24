package com.example.razy_1.order.adapter;


import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.razy_1.order.R;
import com.example.razy_1.order.gui.displayitem.DisplayItem;
import com.example.razy_1.order.gui.listproduct.ShowItemFragment;
import com.example.razy_1.order.data.beans.ResultListSuppList;
import com.squareup.picasso.Picasso;

import java.text.DecimalFormat;
import java.util.List;

public class DisplaySupppAdapter extends RecyclerView.Adapter<DisplaySupppAdapter.VH> {
    List<ResultListSuppList> itemsArrayList;
    Context context;
    ShowItemFragment showItemFragment;
    public DisplaySupppAdapter(List<ResultListSuppList> itemsArrayList, Context context) {
        this.itemsArrayList = itemsArrayList;
        this.context = context;

        showItemFragment=new ShowItemFragment();
    }

    @NonNull
    @Override
    public VH onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_form, parent, false);

        return new VH(view);
    }

    @Override
    public void onBindViewHolder(@NonNull VH holder, int position) {
        final ResultListSuppList items = itemsArrayList.get(position);
        DecimalFormat decimalFormat=new DecimalFormat("####.0");
        holder.priceItme.setText(decimalFormat.format(Double.valueOf(items.getPrice())));
        holder.codeItem.setText(items.getCreatedOnUtc());
        holder.companyNameItem.setText(showItemFragment.name);
        holder.descriptionItem.setText(items.getName());
        if (showItemFragment.id==1){
            holder.companyNameItem.setText("P&G");
            Picasso.with(context).load(R.drawable.pg).into(holder.imageItem);
        }
        if (showItemFragment.id==2){
            Picasso.with(context).load(R.drawable.aga).into(holder.imageItem);

        }if (showItemFragment.id==3){
            Picasso.with(context).load(R.drawable.edita).into(holder.imageItem);

        }if (showItemFragment.id==4){
            Picasso.with(context).load(R.drawable.ragab).into(holder.imageItem);

        }if (showItemFragment.id==5){
            Picasso.with(context).load(R.drawable.pyrameds).into(holder.imageItem);

        }if (showItemFragment.id==6){
            Picasso.with(context).load(R.drawable.pwady).into(holder.imageItem);

        }if (showItemFragment.id==7){
            Picasso.with(context).load(R.drawable.gawhara).into(holder.imageItem);

        }if (showItemFragment.id==8){
            Picasso.with(context).load(R.drawable.rashed).into(holder.imageItem);

        }if (showItemFragment.id==9){
            Picasso.with(context).load(R.drawable.rashedy).into(holder.imageItem);

        }if (showItemFragment.id==10){
            Picasso.with(context).load(R.drawable.zahar).into(holder.imageItem);

        }

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context, DisplayItem.class);
                intent.putExtra("dsplayItemofSupp", items);
                context.startActivity(intent);
//////                ((DisplayItem) context).startActivityForResult(intent, 0);

            }
        });


    }

    @Override
    public int getItemCount() {
        return itemsArrayList.size();
    }

    public class VH extends RecyclerView.ViewHolder {
        TextView priceItme, companyNameItem, codeItem, descriptionItem;
        ImageView imageItem;

        public VH(View itemView) {
            super(itemView);

            priceItme = (TextView) itemView.findViewById(R.id.priceItme);
            companyNameItem = (TextView) itemView.findViewById(R.id.companyNameItem);
            codeItem = (TextView) itemView.findViewById(R.id.codeItem);
            priceItme = (TextView) itemView.findViewById(R.id.priceItme);
            descriptionItem = (TextView) itemView.findViewById(R.id.descriptionItem);
            imageItem = (ImageView) itemView.findViewById(R.id.imageItem);
        }
    }
}
