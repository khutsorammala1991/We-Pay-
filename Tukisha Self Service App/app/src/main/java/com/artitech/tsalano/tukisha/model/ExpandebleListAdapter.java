package com.artitech.tsalano.tukisha.model;

import android.content.Context;
import android.graphics.Typeface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.TextView;

import com.artitech.tsalano.tukisha.R;

import java.util.HashMap;
import java.util.List;

/**
 * Created by rammamn on 2018/03/23.
 */

public class ExpandebleListAdapter extends BaseExpandableListAdapter {
    private Context context;
    private List<String> listDataHeader;
    private HashMap<String,List<String>> listHashMap;

    public ExpandebleListAdapter(Context context, List<String> listDataHeader, HashMap<String, List<String>> listHashMap) {
        this.context = context;
        this.listDataHeader = listDataHeader;
        this.listHashMap = listHashMap;
    }

    @Override
    public int getGroupCount() {
        return listDataHeader.size();
    }

    @Override
    public int getChildrenCount(int i) {
        return listHashMap.get(listDataHeader.get(i)).size();
    }

    @Override
    public Object getGroup(int i) {
        return listDataHeader.get(i);
    }

    @Override
    public Object getChild(int i, int i1) {
        return listHashMap.get(listDataHeader.get(i)).get(i1);
    }

    @Override
    public long getGroupId(int i) {
        return i;
    }

    @Override
    public long getChildId(int i, int i1) {
        return i1;
    }

    @Override
    public boolean hasStableIds() {
        return false;
    }

    @Override
    public View getGroupView(int i, boolean isExpanded, View View, ViewGroup parent) {
        String headerTitle = (String)getGroup(i) ;
        if (View ==null){

            LayoutInflater inflater= (LayoutInflater)this.context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            View = inflater.inflate(R.layout.list_group,null);
        }

        TextView lblListHeader = (TextView) View.findViewById(R.id.lblListHeader);
        lblListHeader.setTypeface(null, Typeface.BOLD);
        lblListHeader.setText(headerTitle);
        return View;
    }

    @Override
    public View getChildView(int i, int i1, boolean b, View View, ViewGroup parent) {
       final String childText = (String)getChild(i,i1);
       if(View ==null)
       {

           LayoutInflater inflater= (LayoutInflater)this.context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
           View = inflater.inflate(R.layout.list_items,null);
       }

       TextView txtListChild = (TextView) View.findViewById(R.id.lblListItem);
       txtListChild.setText(childText);
       return View;
    }

    @Override
    public boolean isChildSelectable(int i, int i1) {
        return true;
    }
}
