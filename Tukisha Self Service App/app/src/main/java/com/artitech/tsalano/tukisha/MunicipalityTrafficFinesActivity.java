package com.artitech.tsalano.tukisha;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;

public class MunicipalityTrafficFinesActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_municipality);

        GridView gridView = (GridView) findViewById(R.id.gridview);
        final ProductsAdapter productsAdapter = new ProductsAdapter(this, products);
        gridView.setAdapter(productsAdapter);

        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView parent, View view, int position, long id) {

                Intent int1 = new Intent(MunicipalityTrafficFinesActivity.this,TrafficFinesActivity.class);
                startActivity(int1);
            }
        });

    }

    private Product[] products = {
            new Product(R.drawable.municipality1),
            new Product(R.drawable.municipality2),
            new Product(R.drawable.municipality3),
            new Product(R.drawable.municipality4),
            new Product(R.drawable.municipality5),
            new Product(R.drawable.municipality6)
    };
}
