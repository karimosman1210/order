package com.example.razy_1.order.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.example.razy_1.order.R;
import com.example.razy_1.order.data.beans.ResultHistory;
import com.squareup.picasso.Callback;
import com.squareup.picasso.Picasso;

import java.util.List;

import static com.example.razy_1.order.utels.StaticMethod.convertDecemal;

public class MyOrderAdapter extends RecyclerView.Adapter<MyOrderAdapter.VH> {
    List<ResultHistory> resultHistory;
    Context context;

    public MyOrderAdapter(List<ResultHistory> cartItems, Context context) {
        this.resultHistory = cartItems;
        this.context = context;
    }

    @NonNull
    @Override
    public MyOrderAdapter.VH onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(context).inflate(R.layout.item_checkout, parent, false);
        return new VH(v);
    }

    @Override
    @NonNull
    public void onBindViewHolder(@NonNull final MyOrderAdapter.VH holder, final int position) {
        final ResultHistory resutlHistory = resultHistory.get(position);
        Picasso.with(context).load(resutlHistory.getProductImage()).into(holder.imageItem, new Callback() {
            @Override
            public void onSuccess() {
                holder.prgressOrder.setVisibility(View.GONE);
            }

            @Override
            public void onError() {

            }
        });
        holder.barcodeCard.setText(resutlHistory.getBarcode());
        holder.descriptionCard.setText(resutlHistory.getProductName());
        holder.companyNameCard.setText(resutlHistory.getSupllierName());
        holder.amountCard.setText(String.valueOf(resutlHistory.getQuantity()));
        holder.dateCard.setText(String.valueOf("17/11/2018"));
        holder.totalPriceCard.setText(convertDecemal(resutlHistory.getTotalPrice())+"  جنية");

    }

    @Override
    public int getItemCount() {
        return resultHistory.size();
    }

//    @Override
//    public Filter getFilter() {
//        return new Filter() {
//            @Override
//            protected FilterResults performFiltering(CharSequence constraint) {
//                List<CartItem> filterResult=null;
//                if (constraint.length()==0){
//                    filterResult=itemCopy;
//
//                }else {
//
//                    filterResult=getFilteredResults(constraint.toString().toLowerCase());
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
//                resultHistory = (List<CartItem>) results.values;
//                MyOrderAdapter.this.notifyDataSetChanged();
//
//            }
//        };
//    }
//
//    private ArrayList<CartItem> getFilteredResults(String constraint) {
//        ArrayList<CartItem> results = new ArrayList<>();
//        for (CartItem item : itemCopy) {
//            if (item.items.getName().toLowerCase().contains(constraint)) {
//                results.add(item);
//            }
//
//        }
//        return results;
//    }

    public class VH extends RecyclerView.ViewHolder {
        TextView dateCard, totalPriceCard, amountCard, companyNameCard, descriptionCard, barcodeCard;
        ImageView imageItem;
        ProgressBar prgressOrder;
        public VH(View itemView) {
            super(itemView);
            dateCard = (TextView) itemView.findViewById(R.id.dateCard);
            totalPriceCard = (TextView) itemView.findViewById(R.id.totalPriceCard);
            amountCard = (TextView) itemView.findViewById(R.id.amountCard);
            companyNameCard = (TextView) itemView.findViewById(R.id.companyNameCard);
            descriptionCard = (TextView) itemView.findViewById(R.id.descriptionCard);
            barcodeCard = (TextView) itemView.findViewById(R.id.barcodeCard);
            imageItem = (ImageView) itemView.findViewById(R.id.imageItem);
            prgressOrder=itemView.findViewById(R.id.prgressOrder);
        }
    }
}
