package com.artitech.tsalano.tukisha;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.GridView;

/**
 * Created by rammamn on 2017/08/07.
 */

public class RewardsFragment extends Fragment {
    private static final String CHINESE = "GBK";
    private static String balance, agentid;
    TukishaApplication tukishaApplication;



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_products, container, false);
        tukishaApplication = (TukishaApplication) getActivity().getApplicationContext();

        Button btnGetMoreResults = (Button)rootView.findViewById(R.id.BalanceResults);
        btnGetMoreResults.setText("Trading Balance : " + tukishaApplication.getBalance() + "  |   Cash Back : R " + tukishaApplication.getTotalRewards());

        GridView gridView = (GridView)rootView.findViewById(R.id.gridview);
        final ProductsAdapter rewardProductsAdapter = new ProductsAdapter(gridView.getContext(), rewardProducts);
        gridView.setAdapter(rewardProductsAdapter);

        return rootView;
    }


    private Product[] rewardProducts = {
            new Product(R.drawable.rewardsappliances),
            new Product(R.drawable.rewardsgadgets),
            new Product(R.drawable.rewardstablets)
    };
}

