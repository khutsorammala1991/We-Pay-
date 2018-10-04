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

public class ProductsFragment extends Fragment {
    private static final String CHINESE = "GBK";
    private static String balance, agentid;
    TukishaApplication tukishaApplication;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.fragment_products, container, false);
        tukishaApplication = (TukishaApplication) getActivity().getApplicationContext();


        Button btnGetMoreResults = (Button)rootView.findViewById(R.id.BalanceResults);
        btnGetMoreResults.setText("Trading Balance : " + tukishaApplication.getBalance() + "  |   Cash Back :  " + tukishaApplication.getTotalRewards());



        GridView gridView = (GridView)rootView.findViewById(R.id.gridview);
        final ProductsAdapter productsAdapter = new ProductsAdapter(gridView.getContext(), products);
        gridView.setAdapter(productsAdapter);

        return rootView;
    }


    private Product[] products = {
            new Product(R.drawable.product1),
            new Product(R.drawable.product2),
            new Product(R.drawable.product3),
            new Product(R.drawable.product4),
            new Product(R.drawable.product5),
            new Product(R.drawable.product6),
            new Product(R.drawable.product7),
            new Product(R.drawable.product8),
            new Product(R.drawable.product9)




    };


}

