package com.artitech.tsalano.tukisha;

/**
 * Created by solly on 2017/08/20.
 */

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class RewardProductsAdapter extends BaseAdapter {

    private final Context mContext;
    private final RewardProduct[] rewardProducts;

    public RewardProductsAdapter(Context context, RewardProduct[] rewardProducts) {
        this.mContext = context;
        this.rewardProducts = rewardProducts;
    }

    @Override
    public int getCount() {
        return rewardProducts.length;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        final RewardProduct rewardProduct = rewardProducts[position];

        // view holder pattern
        if (convertView == null) {
            final LayoutInflater layoutInflater = LayoutInflater.from(mContext);
            convertView = layoutInflater.inflate(R.layout.list_reward_product_layout, null);

            final ImageView imageViewCoverArt = (ImageView) convertView.findViewById(R.id.ivCover);
            final TextView nameTextView = (TextView) convertView.findViewById(R.id.nameTextView);
            final TextView pointsTextView = (TextView) convertView.findViewById(R.id.pointsTextView);

            final ViewHolder viewHolder = new ViewHolder(nameTextView, pointsTextView, imageViewCoverArt);
            convertView.setTag(viewHolder);
        }

        final ViewHolder viewHolder = (ViewHolder) convertView.getTag();
        viewHolder.nameTextView.setText(rewardProduct.getName());
        viewHolder.pointsTextView.setText(rewardProduct.getPoints());
        viewHolder.imageViewCoverArt.setImageResource(rewardProduct.getImageResource());

        //Picasso.with(mContext).load(book.getImageUrl()).into(viewHolder.imageViewCoverArt);

        return convertView;
    }

    private class ViewHolder {
        private final TextView nameTextView;
        private final TextView pointsTextView;
        private final ImageView imageViewCoverArt;

        public ViewHolder(TextView nameTextView, TextView pointsTextView, ImageView imageViewCoverArt) {
            this.nameTextView = nameTextView;
            this.pointsTextView = pointsTextView;
            this.imageViewCoverArt = imageViewCoverArt;
        }
    }

}
