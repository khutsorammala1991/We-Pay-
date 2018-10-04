package com.artitech.tsalano.tukisha.viewholder;

import android.content.Context;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.artitech.tsalano.tukisha.R;
import com.artitech.tsalano.tukisha.model.CategoryTypesModel;
import com.artitech.tsalano.tukisha.model.MunicipalityModel;
import com.artitech.tsalano.tukisha.model.UnipinModel;
import com.squareup.picasso.Picasso;

/**
 * Created by Lenovo on 17-Apr-17.
 */

public class CategoryTypesViewHolder extends RecyclerView.ViewHolder {

    public CardView mCardListItem;
    public TextView mItemName;
    public TextView mItemShortDesc;
    public TextView mItemPrice;
    public ImageView mProductThumb;
    public LinearLayout mTopView;

    public CategoryTypesViewHolder(View itemView) {
        super(itemView);

        mCardListItem = (CardView) itemView.findViewById(R.id.cardlist_item);
        mItemName = (TextView) itemView.findViewById(R.id.item_address);
        mItemShortDesc = (TextView) itemView.findViewById(R.id.item_short_desc);
        mProductThumb = (ImageView) itemView.findViewById(R.id.product_thumb);
        mTopView = (LinearLayout) itemView.findViewById(R.id.top_view);
    }


    public void bindtoCategoriesTypes(Context context, CategoryTypesModel post,
                                      View.OnClickListener relativeLayoutClickListener) {


        mItemName.setText(post.getName());
        mItemShortDesc.setText(post.getDescription());
        //mItemPrice.setText(post.getRs());
        mTopView.setOnClickListener(relativeLayoutClickListener);
        Picasso.with(context).load(post.getImgurl()).fit().centerCrop().into(mProductThumb);

    }

    public void bindtoSelectedMunicipalities(Context context, MunicipalityModel post,
                                             View.OnClickListener relativeLayoutClickListener) {


        mItemName.setText(post.getName());

        if(post.getName().contains("metro") || post.getName().contains(" of "))
            mItemShortDesc.setText("Metro");
        else
            mItemShortDesc.setText("Local Municipality");

        mTopView.setOnClickListener(relativeLayoutClickListener);
        Picasso.with(context).load(post.getImgurl()).fit().centerCrop().into(mProductThumb);

    }


    public void bindtoSelectedDenomination(Context context, UnipinModel post,
                                           View.OnClickListener relativeLayoutClickListener) {


        mItemName.setText(post.getName());
        mItemShortDesc.setText(post.getName());
        mTopView.setOnClickListener(relativeLayoutClickListener);
        Picasso.with(context).load(post.getImgurl()).fit().centerCrop().into(mProductThumb);

    }

}

