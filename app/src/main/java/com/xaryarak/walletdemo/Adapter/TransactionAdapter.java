package com.xaryarak.walletdemo.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.xaryarak.walletdemo.R;
import com.xaryarak.walletdemo.model.TransactionModel;

import java.util.List;

public class TransactionAdapter extends RecyclerView.Adapter<TransactionAdapter.MyViewHolder> {
    Context context;
    List<TransactionModel> transactionModelList;

    public TransactionAdapter(Context context, List<TransactionModel> transactionModelList) {
        this.context = context;
        this.transactionModelList = transactionModelList;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.my_list_home, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        holder.vno.setText(transactionModelList.get(position).getVno());
        holder.price.setText(transactionModelList.get(position).getPrice());
        holder.date.setText(transactionModelList.get(position).getDate());
    }

    @Override
    public int getItemCount() {
        return transactionModelList.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        TextView vno,price,date;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            vno = itemView.findViewById(R.id.vno);
            price = itemView.findViewById(R.id.price);
            date = itemView.findViewById(R.id.date);
        }
    }
}
