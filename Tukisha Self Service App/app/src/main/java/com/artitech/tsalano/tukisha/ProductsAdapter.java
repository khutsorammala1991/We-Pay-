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

public class ProductsAdapter extends BaseAdapter {

    private final Context mContext;
    private final Product[] products;

    public ProductsAdapter(Context context, Product[] products) {
        this.mContext = context;
        this.products = products;
    }

    @Override
    public int getCount() {
        return products.length;
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
        final Product product = products[position];

        // view holder pattern
        if (convertView == null) {
            final LayoutInflater layoutInflater = LayoutInflater.from(mContext);
            convertView = layoutInflater.inflate(R.layout.list_product_layout, null);

            final ImageView imageViewCoverArt = (ImageView) convertView.findViewById(R.id.ivCover);
            final ViewHolder viewHolder = new ViewHolder(imageViewCoverArt);
            convertView.setTag(viewHolder);
        }

        final ViewHolder viewHolder = (ViewHolder) convertView.getTag();
        viewHolder.imageViewCoverArt.setImageResource(product.getImageResource());

        return convertView;
    }

    private class ViewHolder {

        private final ImageView imageViewCoverArt;

        public ViewHolder(ImageView imageViewCoverArt) {

            this.imageViewCoverArt = imageViewCoverArt;
        }
    }

}
