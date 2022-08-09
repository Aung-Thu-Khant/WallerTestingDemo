package com.xaryarak.walletdemo.Adapter;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.RecyclerView;

import com.xaryarak.walletdemo.Fragment.PayDetailFg;
import com.xaryarak.walletdemo.R;
import com.xaryarak.walletdemo.model.TransactionModel;

import java.util.ArrayList;
import java.util.List;

public class TransactionAdapter extends RecyclerView.Adapter<TransactionAdapter.MyViewHolder> implements Filterable{
    Context context;
    List<TransactionModel> transactionModelList;
    List<TransactionModel> transactionModelListFull;
    ItemClickListener itemClickListener;
    public TransactionAdapter(Context context, List<TransactionModel> transactionModelList,
                              ItemClickListener itemClickListener) {
        this.context = context;
        this.transactionModelList = transactionModelList;
        transactionModelListFull = new ArrayList<>(transactionModelList);
        this.itemClickListener = itemClickListener;
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
        holder.listLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                itemClickListener.ClickLister(transactionModelList.get(position));
            }
        });
    }

    @Override
    public int getItemCount() {
        return transactionModelList.size();
    }

    @Override
    public Filter getFilter() {
        return payListFilter;
    }

    public class MyViewHolder extends RecyclerView.ViewHolder{
        TextView vno,price,date;
        ConstraintLayout listLayout;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            vno = itemView.findViewById(R.id.vno);
            price = itemView.findViewById(R.id.price);
            date = itemView.findViewById(R.id.date);
            listLayout = itemView.findViewById(R.id.listLayout);
            listLayout.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    loadFragment(new PayDetailFg(),true);
                }
            });
        }
    }

    private Filter payListFilter = new Filter() {
        @Override
        protected FilterResults performFiltering(CharSequence constraint) {

            List<TransactionModel> transactionFilterList = new ArrayList<>();

            if (constraint == null || constraint.length() == 0) {
                transactionFilterList.addAll(transactionModelListFull);
            } else {
                String filterPattern = constraint.toString().toLowerCase().trim();

                for (TransactionModel section : transactionModelListFull) {
                    if (section.getVno().toLowerCase().contains(filterPattern)) {
                        transactionFilterList.add(section);
                    }
                }
            }

            FilterResults results = new FilterResults();
            results.values = transactionFilterList;

            return results;
        }

        @Override
        protected void publishResults(CharSequence constraint, FilterResults results) {

            transactionModelList.clear();
            transactionModelList.addAll((List) results.values);
            notifyDataSetChanged();

        }
    };

    public interface ItemClickListener{
         void ClickLister(TransactionModel model);
    }



    private void loadFragment(Fragment fragment, boolean stack){
        if(fragment != null){
            FragmentManager manager = fragment.getFragmentManager();
            FragmentTransaction transaction = manager.beginTransaction();
            if(stack){
                transaction.addToBackStack(fragment.getTag());
            }
            transaction.replace(R.id.flayout,fragment);
            transaction.commit();
        }else{
            Log.d("Fragment null","Null");
        }

    }

}
