package com.artitech.tsalano.tukisha;

/**
 * Created by rammamn on 2017/08/07.
 */

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class BuyFragment extends Fragment {


    /******************************************************************************************************/
    // Debugging
    private static final String TAG = "MainActivity";
    private static final boolean DEBUG = true;
    /*******************************************************************************************************/

    /******************************************************************************************************/
    private static final int REQUEST_ENABLE_BT = 2;
    private static final String CHINESE = "GBK";
    private static String balance, agentid;
    TukishaApplication tukishaApplication;
    private Button btnGetMoreResults;

    @Override
    public void onStart() {
        super.onStart();

    }

    @Override
    public synchronized void onResume() {
        super.onResume();

    }

    @Override
    public synchronized void onPause() {
        super.onPause();
        if (DEBUG)
            Log.e(TAG, "- ON PAUSE -");
    }

    @Override
    public void onDestroy() {
        super.onDestroy();

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        tukishaApplication = (TukishaApplication) getActivity().getApplicationContext();
        View view = inflater.inflate(R.layout.fragment_buy, container, false);

        final View municipal = view.findViewById(R.id.ivMunicipality);
        municipal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent int1 = new Intent(getActivity(), Municipalities.class);
                startActivity(int1);
            }
        });


        final View eskom = view.findViewById(R.id.ivEskom);
        eskom.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent int1 = new Intent(getActivity(), ElectricityActivity.class);
                startActivity(int1);
            }
        });


        final View voda = view.findViewById(R.id.ivVodacom);
        voda.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getActivity(), AirtimeActivity.class);
                i.putExtra("from_main_activity", "Vodacom");
                startActivity(i);
            }
        });


        final View telkom = view.findViewById(R.id.ivMTN);
        telkom.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getActivity(), AirtimeActivity.class);
                i.putExtra("from_main_activity", "MTN");
                startActivity(i);
            }
        });
        final View cellc = view.findViewById(R.id.ivCellc);
        cellc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getActivity(), AirtimeActivity.class);
                i.putExtra("from_main_activity", "Cell C");
                startActivity(i);
            }
        });

        final View active = view.findViewById(R.id.ivVirgin);
        active.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getActivity(), AirtimeActivity.class);
                i.putExtra("from_main_activity", "Virgin Mobile");
                startActivity(i);
            }
        });

        final View kom = view.findViewById(R.id.ivTelkom);
        kom.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getActivity(), AirtimeActivity.class);
                i.putExtra("from_main_activity", "Telkom Mobile");
                startActivity(i);
            }
        });

        final View unipin = view.findViewById(R.id.unipin);
        unipin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getActivity(), UnipinDenominationActivity.class);
                startActivity(i);
            }
        });

        final View ideal = view.findViewById(R.id.ideal);
        ideal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getActivity(), ElectricityMunicipalityActivity.class);
                i.putExtra("prevend", 988);
                i.putExtra("tokennumber", 0);
                i.putExtra("name", "Ideal Prepaid");
                i.putExtra("endpoint", "https://munipoiapp.herokuapp.com/api/selfservice/idealelectricity?meternumber=");
                startActivity(i);
            }
        });

        final View protea = view.findViewById(R.id.protea);
        protea.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getActivity(), ElectricityMunicipalityActivity.class);
                i.putExtra("prevend", 111);
                i.putExtra("tokennumber", 0);
                i.putExtra("name", "Protea Metering");
                i.putExtra("endpoint", "https://munipoiapp.herokuapp.com/api/selfservice/proteaelectricity?meternumber=");
                startActivity(i);
            }
        });

        btnGetMoreResults = (Button)view.findViewById(R.id.btnGetMoreResults);
        btnGetMoreResults.setText("Trading Balance : " + tukishaApplication.getBalance() + "  |   Cash Back : " + tukishaApplication.getTotalRewards());

        // Inflate the layout for this fragment
        return view;

    }


    public static String getStartDateTimeString() {

        Date today = Calendar.getInstance().getTime();

        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");

        return formatter.format(today);

    }

    public static String getEndDateTimeString() {

        Calendar c = Calendar.getInstance();

        c.add(Calendar.DATE, 1);

        Date today = c.getInstance().getTime();

        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");

        return formatter.format(today);

    }


}

