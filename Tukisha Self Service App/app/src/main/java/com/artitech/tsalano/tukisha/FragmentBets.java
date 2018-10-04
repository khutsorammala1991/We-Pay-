package com.artitech.tsalano.tukisha;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

public class FragmentBets extends Fragment {
    private static final String CHINESE = "GBK";
    private static String balance, agentid;
    TukishaApplication tukishaApplication;



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_bets, container, false);

        tukishaApplication = (TukishaApplication) getActivity().getApplicationContext();

        Button btnGetMoreResults = (Button)rootView.findViewById(R.id.btnGetMoreResults);
        btnGetMoreResults.setText("Trading Balance : " + tukishaApplication.getBalance() + "  |   Cash Back : R " + tukishaApplication.getTotalRewards());

        return rootView;
    }



}

