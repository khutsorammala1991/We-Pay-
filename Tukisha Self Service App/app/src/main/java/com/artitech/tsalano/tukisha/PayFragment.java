package com.artitech.tsalano.tukisha;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

/**
 * Created by rammamn on 2017/08/07.
 */

public class PayFragment extends Fragment {


    private static final String CHINESE = "GBK";
    private static String balance, agentid;
    TukishaApplication tukishaApplication;
    private Button goHome;



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_pay, container, false);


        tukishaApplication = (TukishaApplication) getActivity().getApplicationContext();


        View pay = view.findViewById(R.id.ivPayAccount);
        pay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent int1 = new Intent(getActivity(),PayAccountActivity.class);
                startActivity(int1);
            }
        });

        /* final View shop= view.findViewById(R.id.ivShopOnline);
        shop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent int1 = new Intent(getActivity(),ShopOnlineActivity.class);
                startActivity(int1);
            }
        });*/
        final View dstv = view.findViewById(R.id.ivDSTV);
        dstv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent int1 = new Intent(getActivity(),DSTVActivity.class);
                startActivity(int1);
            }
        });
        final View trafic = view.findViewById(R.id.ivTrafficFines);
        trafic.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent int1 = new Intent(getActivity(),MunicipalityTrafficFinesActivity.class);
                startActivity(int1);
            }
        });

        Button goHome = (Button)view.findViewById(R.id.gohome);
        goHome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getActivity(), MainTabProductActivity.class);
                startActivity(i);
            }
        });

        Button btnGetMoreResults = (Button)view.findViewById(R.id.BalanceResults);
        btnGetMoreResults.setText("Trading Balance : " + tukishaApplication.getBalance() + "  |   Cash Back :  " + tukishaApplication.getTotalRewards());


        // Inflate the layout for this fragment
        return view;

    }


}

