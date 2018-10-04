
package com.artitech.tsalano.tukisha;

        import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.artitech.tsalano.tukisha.model.BeneficiariesModel;

import java.util.ArrayList;

/**
 * Created by solly on 2017/06/29.
 */


public class BeneficiariesListAdopter extends ArrayAdapter<BeneficiariesModel> {

    int vg;

    ArrayList<BeneficiariesModel> list;

    Context context;

    public BeneficiariesListAdopter(Context context, int vg, int id, ArrayList<BeneficiariesModel> list) {

        super(context, vg, id, list);

        this.context = context;

        this.vg = vg;

        this.list = list;

    }

    public View getView(int position, View convertView, ViewGroup parent) {

        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        View itemView = inflater.inflate(vg, parent, false);


        TextView name = (TextView) itemView.findViewById(R.id.item_VoucherNumber);

        TextView meter= (TextView) itemView.findViewById(R.id.item_ProductType);

        TextView provider = (TextView) itemView.findViewById(R.id.item_Amount);



        try {

            name.setText(list.get(position).getName());

            meter.setText(list.get(position).getMeterNumber());

            provider.setText(list.get(position).getCell());





        } catch (Exception e) {

            Log.d("ERROR", e.toString());

        }

        return itemView;

    }


}
