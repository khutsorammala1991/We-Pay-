package com.artitech.tsalano.tukisha;

import android.content.Context;
import android.content.res.AssetManager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.artitech.tsalano.tukisha.model.TopUpModel;

import java.util.ArrayList;

/**
 * Created by solly on 2017/06/29.
 */


public class TopUpAdapter extends ArrayAdapter<TopUpModel> {

    int vg;

    ArrayList<TopUpModel> list;

    Context context;

    private AssetManager assetManager;

    public TopUpAdapter(Context context, int vg, int id, ArrayList<TopUpModel> list) {

        super(context, vg, id, list);

        this.context = context;

        this.vg = vg;

        this.list = list;

    }

    public View getView(int position, View convertView, ViewGroup parent) {

        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        View itemView = inflater.inflate(vg, parent, false);

        TextView topUpAmount = (TextView) itemView.findViewById(R.id.editTopUpAmount);



        try {

            topUpAmount.setText(list.get(position).getTopUpAmount());



        } catch (Exception e) {

            Log.d("ERROR", e.toString());

        }

        return itemView;

    }


}