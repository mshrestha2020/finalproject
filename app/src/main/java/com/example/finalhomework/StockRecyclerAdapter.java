package com.example.finalhomework;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class StockRecyclerAdapter extends RecyclerView.Adapter<StockRecyclerAdapter.ViewHolder> {

    private ArrayList<Stock> mLocalData;

    public static class ViewHolder extends RecyclerView.ViewHolder {
        private TextView cp;
        private TextView symbol;
        private TextView ltd;
        private TextView price;
        private TextView high;
        private TextView low;
        private TextView open;
        private TextView pc;

        public ViewHolder(View view) {
            super(view);
            // Define click listener for the ViewHolder's View
            cp = view.findViewById(R.id.cp);
            symbol = view.findViewById(R.id.symbol);
            price = view.findViewById(R.id.price);
            ltd = view.findViewById(R.id.ltd);
            high = view.findViewById(R.id.high);
            low = view.findViewById(R.id.low);
            open = view.findViewById(R.id.open);
            pc = view.findViewById(R.id.pc);

        }

        public TextView getltd() {
            return ltd;
        }

        public TextView getsymbol(){
            return symbol;
        }

        public TextView getcp(){
            return cp;
        }

        public TextView getprice(){
            return price;
        }

        public TextView gethigh() {
            return high;
        }

        public TextView getlow(){
            return low;
        }

        public TextView getopen(){
            return open;
        }

        public TextView getpc(){
            return pc;
        }
    }

    public StockRecyclerAdapter(ArrayList<Stock> dataSet) {
        mLocalData = dataSet;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int viewType) {
        // Create a new view, which defines the UI of the list item
        View view = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.recycler_view_item, viewGroup, false);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder viewHolder, final int position) {

        // Get element from your dataset at this position and replace the
        // contents of the view with that element
        viewHolder.getltd().setText("LTD: "+mLocalData.get(position).getLatest_trading_day());
        viewHolder.getprice().setText("Price: $" + mLocalData.get(position).getPrice());
        viewHolder.getcp().setText("Change %: "+mLocalData.get(position).getChange_percent());
        viewHolder.getsymbol().setText(mLocalData.get(position).getSymbol());
        viewHolder.gethigh().setText("High: $" + mLocalData.get(position).getHigh());
        viewHolder.getlow().setText("Low: $" + mLocalData.get(position).getLow());
        viewHolder.getopen().setText("Open: $" + mLocalData.get(position).getOpen());
        viewHolder.getpc().setText("Previous Close: $" + mLocalData.get(position).getPrevious_close());

    }

    @Override
    public int getItemCount() {
        return mLocalData.size();
    }





}