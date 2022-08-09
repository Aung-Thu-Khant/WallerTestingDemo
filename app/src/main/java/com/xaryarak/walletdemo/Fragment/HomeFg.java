package com.xaryarak.walletdemo.Fragment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.xaryarak.walletdemo.Adapter.TransactionAdapter;
import com.xaryarak.walletdemo.R;
import com.xaryarak.walletdemo.model.TransactionModel;

import java.util.ArrayList;
import java.util.List;


public class HomeFg extends Fragment {
    TransactionAdapter transactionAdapter;
    ArrayList<TransactionModel> transactionModels;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_home_fg, container, false);
        RecyclerView home_rv = view.findViewById(R.id.home_rv);
        LinearLayout payLayout = view.findViewById(R.id.payLayout);

        payLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                loadFragment(new PayFg(),true);
            }
        });

        LinearLayoutManager layoutManager = new LinearLayoutManager(getContext());
        layoutManager.setReverseLayout(true);
        layoutManager.setStackFromEnd(true);
        home_rv.setLayoutManager(layoutManager);

        transactionModels = new ArrayList<>();

        TransactionModel m1 = new TransactionModel("0001","1500 MMK","08-Aug-2022");
        TransactionModel m2 = new TransactionModel("0002","2500 MMK","04-Aug-2022");
        TransactionModel m3 = new TransactionModel("0003","3500 MMK","10-Aug-2022");
        TransactionModel m4 = new TransactionModel("0001","1500 MMK","08-Aug-2022");
        TransactionModel m5 = new TransactionModel("0002","2500 MMK","04-Aug-2022");
        TransactionModel m6 = new TransactionModel("0003","3500 MMK","10-Aug-2022");
        TransactionModel m7 = new TransactionModel("0001","1500 MMK","08-Aug-2022");
        TransactionModel m8 = new TransactionModel("0002","2500 MMK","04-Aug-2022");
        TransactionModel m9 = new TransactionModel("0003","3500 MMK","10-Aug-2022");
        transactionModels.add(m1);
        transactionModels.add(m2);
        transactionModels.add(m3);
        transactionModels.add(m4);
        transactionModels.add(m5);
        transactionModels.add(m6);
        transactionModels.add(m7);
        transactionModels.add(m8);
        transactionModels.add(m9);

//        transactionAdapter = new TransactionAdapter(getContext(),transactionModels);
//        home_rv.setAdapter(transactionAdapter);

        return view;
    }

    private void loadFragment(Fragment fragment,boolean stack){
        FragmentManager manager = getActivity().getSupportFragmentManager();
        FragmentTransaction transaction = manager.beginTransaction();
        if(stack){
            transaction.addToBackStack(fragment.getTag());
        }
        transaction.replace(R.id.flayout,fragment);
        transaction.commit();
    }
}