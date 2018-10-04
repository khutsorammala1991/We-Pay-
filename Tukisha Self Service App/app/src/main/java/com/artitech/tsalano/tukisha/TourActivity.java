package com.artitech.tsalano.tukisha;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ExpandableListView;

import com.artitech.tsalano.tukisha.model.ExpandebleListAdapter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class TourActivity extends AppCompatActivity {


    private ExpandableListView listView;
    private ExpandebleListAdapter listAdapter;
    private List<String> listDataHeader;
    private HashMap<String,List<String>> listHash;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tour);

        listView = (ExpandableListView) findViewById(R.id.IVxp);
        initData();
        listAdapter= new ExpandebleListAdapter(this,listDataHeader,listHash);
       listView.setAdapter(listAdapter);



    }

    private void initData() {

        listDataHeader =  new ArrayList<>();
        listHash = new HashMap<>();

        listDataHeader.add("Get Started");
        listDataHeader.add("How to buy");
        listDataHeader.add("how to top up");
        listDataHeader.add("how to het password");
        listDataHeader.add("how to set password ");
        listDataHeader.add("Airtime top up");
        listDataHeader.add("municipality");
        listDataHeader.add("ideal");


        List<String>emdtcee= new ArrayList<>();
       emdtcee.add("hjdsjiefjfejjkkjd");

        List<String>khutso= new ArrayList<>();
        khutso.add("jmdcjdscjkdcjkdsckjdc");

        List<String>androidStudio= new ArrayList<>();
        androidStudio.add("mdwkfjnwd cefvwefvfv");

        List<String>fevrvrgvbr= new ArrayList<>();
       fevrvrgvbr.add("wevqiudhiewruvbhjefberihwvbif");

        List<String>emdtcee1= new ArrayList<>();
        emdtcee1.add("hjdsjiefjfejjkkjd");

        List<String>khutso2= new ArrayList<>();
        khutso2.add("jmdcjdscjkdcjkdsckjdc");

        List<String>androidStudio3= new ArrayList<>();
        androidStudio3.add("mdwkfjnwd cefvwefvfv");

        List<String>fevrvrgvbr4= new ArrayList<>();
        fevrvrgvbr4.add("wevqiudhiewruvbhjefberihwvbif");



        listHash.put(listDataHeader.get(0),emdtcee);
        listHash.put(listDataHeader.get(1),khutso);
        listHash.put(listDataHeader.get(2),androidStudio);
        listHash.put(listDataHeader.get(3),fevrvrgvbr);
        listHash.put(listDataHeader.get(4),emdtcee);
        listHash.put(listDataHeader.get(5),khutso);
        listHash.put(listDataHeader.get(6),androidStudio);
        listHash.put(listDataHeader.get(7),fevrvrgvbr);









    }

}
