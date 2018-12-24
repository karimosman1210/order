package com.example.razy_1.order.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.razy_1.order.R;
import com.example.razy_1.order.gui.displayitem.DisplayItem;
import com.example.razy_1.order.gui.mainpage.HomePage;
import com.example.razy_1.order.gui.listproduct.ShowItemFragment;
import com.example.razy_1.order.data.beans.ResultProductList;
import com.squareup.picasso.Picasso;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

public class DisplayProductAdapter extends RecyclerView.Adapter<DisplayProductAdapter.VH> implements Filterable {
    private static final int REQUEST_FOR_ACTIVITY_CODE = 1;
    List<ResultProductList> resultProductLists;
    Context context;
    ShowItemFragment showItemFragment;
    List<ResultProductList> itemCopy;


    public DisplayProductAdapter(List<ResultProductList> resultProductLists, Context context, List<ResultProductList> itemCopy) {
        this.resultProductLists = resultProductLists;
        this.context = context;
        this.itemCopy = itemCopy;
        showItemFragment = new ShowItemFragment();
    }

    @NonNull
    @Override
    public VH onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_form, parent, false);

        return new VH(view);
    }

    @Override
    public void onBindViewHolder(@NonNull VH holder, int position) {
        final ResultProductList productList = resultProductLists.get(position);
        DecimalFormat f = new DecimalFormat("####.0");
        String formattedValue = f.format(Double.valueOf(productList.getPrice()));
        holder.priceItme.setText(formattedValue + " جنية");
        holder.codeItem.setText(productList.getCreatedOnUtc());
        holder.companyNameItem.setText(showItemFragment.name);
        holder.descriptionItem.setText(productList.getName());
        if (showItemFragment.id == 1) {
            Picasso.with(context).load(R.drawable.food).into(holder.imageItem);
        }
        if (showItemFragment.id == 2) {
            Picasso.with(context).load(R.drawable.milk).into(holder.imageItem);

        }
        if (showItemFragment.id == 3) {
            Picasso.with(context).load(R.drawable.juse).into(holder.imageItem);

        }
        if (showItemFragment.id == 4) {
            Picasso.with(context).load(R.drawable.clear).into(holder.imageItem);

        }
        if (showItemFragment.id == 5) {
            Picasso.with(context).load(R.drawable.cigorate).into(holder.imageItem);

        }

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(context, DisplayItem.class);
                i.putExtra("dsplayItemofProduct", productList);
                ((HomePage) context).startActivityForResult(i, REQUEST_FOR_ACTIVITY_CODE);
            }
        });

    }

    @Override
    public int getItemCount() {
        return resultProductLists.size();
    }

    @Override
    public Filter getFilter() {
        Filter filterSearch;
        filterSearch = new Filter() {
            @Override
            protected FilterResults performFiltering(CharSequence constraint) {
                List<ResultProductList> filterResult = null;
                if (constraint.length() == 0) {
                    filterResult = itemCopy;

                } else {

                    filterResult = getFilteredResults(constraint.toString().toLowerCase());

                }

                FilterResults results = new FilterResults();
                results.values = filterResult;
                return results;
            }

            @Override
            protected void publishResults(CharSequence constraint, FilterResults results) {
                resultProductLists = (List<ResultProductList>) results.values;
                DisplayProductAdapter.this.notifyDataSetChanged();

            }
        };
        return filterSearch;

    }

    private ArrayList<ResultProductList> getFilteredResults(String constraint) {
        ArrayList<ResultProductList> results = new ArrayList<>();
        for (ResultProductList item : itemCopy) {
            if (item.getName().toLowerCase().contains(constraint)) {
                results.add(item);
            }
        }
        return results;
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


// fulter2
//    private ArrayList<ResultProductList> getFilteredResults2(String constraint) {
//        ArrayList<ResultProductList> results = new ArrayList<>();
//        for (ResultProductList item : itemCopy) {
//            if (item.getPrice().toLowerCase().contains(constraint)) {
//                results.add(item);
//            }
//
//        }
//        return results;
//    }
//    public Filter getFilter2() {
//        Filter filterSearch ;
//        filterSearch = new Filter() {
//            @Override
//            protected FilterResults performFiltering(CharSequence constraint) {
//                List<ResultProductList> filterResult=null;
//                if (constraint.length()==0){
//                    filterResult=itemCopy;
//
//                }else {
//
//                    filterResult=getFilteredResults2(constraint.toString().toLowerCase());
//
//                }
//
//                FilterResults results = new FilterResults();
//                results.values=filterResult;
//                return results;
//            }
//
//            @Override
//            protected void publishResults(CharSequence constraint, FilterResults results) {
//                resultProductLists = (List<ResultProductList>) results.values;
//                DisplayProductAdapter.this.notifyDataSetChanged();
//
//            }
//        };
//        return filterSearch;
//
//    }

}
