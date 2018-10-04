package com.artitech.tsalano.tukisha;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.TextView;

public class OnLinePayActivity extends AppCompatActivity {

    private TextView mToolbarTitleTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_online_pay);


        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        configureToolbar();


        GridView gridView = (GridView) findViewById(R.id.gridview);
        final ProductsAdapter productsAdapter = new ProductsAdapter(this, products);
        gridView.setAdapter(productsAdapter);

        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView parent, View view, int position, long id) {

                Intent int1 = new Intent(OnLinePayActivity.this, PayAccountPageActivity.class);
                startActivity(int1);
            }
        });

    }

    private void configureToolbar() {
        Toolbar mainToolbar = (Toolbar) findViewById(R.id.toolbar);

        if (mainToolbar != null) {
            mToolbarTitleTextView = (TextView) mainToolbar.findViewById(R.id.toolbar_title_textView);
            mToolbarTitleTextView.setText(getString(R.string.app_name));
            setSupportActionBar(mainToolbar);

            if (getSupportActionBar() != null) {
                getSupportActionBar().setDisplayHomeAsUpEnabled(true);
                getSupportActionBar().setHomeButtonEnabled(true);
                getSupportActionBar().setDisplayShowTitleEnabled(false);
            }
        }

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {

            case android.R.id.home:
                onBackPressed();
                return true;

            default:
                return super.onOptionsItemSelected(item);
        }
    }

    private Product[] products = {
            new Product(R.drawable.store1),
            new Product(R.drawable.store2),
            new Product(R.drawable.store3),
            new Product(R.drawable.store4),
            new Product(R.drawable.store5),
            new Product(R.drawable.store6),

            new Product(R.drawable.store7),
            new Product(R.drawable.store8),
            new Product(R.drawable.store9),
            new Product(R.drawable.store10),
            new Product(R.drawable.store11),
            new Product(R.drawable.store12)
    };
}