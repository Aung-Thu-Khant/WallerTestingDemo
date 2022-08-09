package com.xaryarak.walletdemo.Fragment;

import android.os.Bundle;

import androidx.appcompat.widget.SearchView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;

import com.xaryarak.walletdemo.Adapter.TransactionAdapter;
import com.xaryarak.walletdemo.R;
import com.xaryarak.walletdemo.model.TransactionModel;

import java.util.ArrayList;


public class PayFg extends Fragment implements TransactionAdapter.ItemClickListener {
    View view;
    TransactionAdapter transactionAdapter;
    ArrayList<TransactionModel> transactionModels;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_pay_fg, container, false);

        RecyclerView payRv = view.findViewById(R.id.payRv);
        LinearLayoutManager layoutManager = new LinearLayoutManager(getContext());
        layoutManager.setReverseLayout(true);
        layoutManager.setStackFromEnd(true);
        payRv.setLayoutManager(layoutManager);

        transactionModels = new ArrayList<>();

        TransactionModel m1 = new TransactionModel("0001","1500 MMK","Pending");
        TransactionModel m2 = new TransactionModel("0002","2500 MMK","Pending");
        TransactionModel m3 = new TransactionModel("0003","3500 MMK","Pending");
        TransactionModel m4 = new TransactionModel("0001","1500 MMK","Pending");
        TransactionModel m5 = new TransactionModel("0002","2500 MMK","Pending");
        TransactionModel m6 = new TransactionModel("0003","3500 MMK","Pending");
        TransactionModel m7 = new TransactionModel("0001","1500 MMK","Pending");
        TransactionModel m8 = new TransactionModel("0002","2500 MMK","Pending");
        TransactionModel m9 = new TransactionModel("0003","3500 MMK","Pending");
        transactionModels.add(m1);
        transactionModels.add(m2);
        transactionModels.add(m3);
        transactionModels.add(m4);
        transactionModels.add(m5);
        transactionModels.add(m6);
        transactionModels.add(m7);
        transactionModels.add(m8);
        transactionModels.add(m9);
        transactionAdapter = new TransactionAdapter(getContext(),transactionModels,this);
        payRv.setAdapter(transactionAdapter);
        SearchView payListSearch = view.findViewById(R.id.payListSearch);
        payListSearch.onActionViewExpanded();
        payListSearch.clearFocus();

        payListSearch.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                transactionAdapter.getFilter().filter(newText);
                return false;
            }
        });

        return view;
    }
    @Override
    public void ClickLister(TransactionModel model) {
        FragmentManager manager = getActivity().getSupportFragmentManager();
        FragmentTransaction transaction = manager.beginTransaction();
        transaction.addToBackStack(null);
        transaction.replace(R.id.flayout,new PayDetailFg());
        transaction.commit();
    }
}