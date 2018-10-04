package com.artitech.tsalano.tukisha;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.GravityCompat;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

/**
 * Created by Tsheko on 13-Apr-17.
 */

public class ElectricityActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    static CharSequence[] electricity = new String[]{"Purchase Token", "Redeem FBE", "Blind Vend", "Issue Advise", "Re-Print Receipt"};
    private static String message;
    AppSectionsPagerAdapter mAppSectionsPagerAdapter;
    private Toolbar toolbar;
    private Button menuButton;
    private TabLayout tabLayout;
    private ViewPager viewPager;
    private NavigationView navigationView;
    private TukishaApplication tukishaApplication;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tabs_main);

        message ="from_main_activity";

        tukishaApplication = (TukishaApplication) getApplication();

        viewPager = (ViewPager) findViewById(R.id.viewpager);
        //setupViewPager(viewPager);
        mAppSectionsPagerAdapter = new AppSectionsPagerAdapter(getSupportFragmentManager());
        viewPager.setAdapter(mAppSectionsPagerAdapter);

        tabLayout = (TabLayout) findViewById(R.id.tabs);
        tabLayout.setupWithViewPager(viewPager);


        menuButton = (Button) findViewById(R.id.btn_menu);
        menuButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
                drawer.openDrawer(GravityCompat.START);
            }
        });

        //NavigationView
        navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
        navigationView.getHeaderView(0);


    }

    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_call_center) {

            String phone = "+27861852853";
            Intent intent = new Intent(Intent.ACTION_DIAL, Uri.fromParts("tel", phone, null));
            startActivity(intent);

        } else if (id == R.id.nav_cash_mini_statement) {

            Intent i = new Intent(ElectricityActivity.this, CashMiniStatementActivity.class);
            startActivity(i);


        } else if (id == R.id.nav_transactionHistory) {

            Intent i = new Intent(ElectricityActivity.this, TransactionHistoryActivityEskom.class);
            startActivity(i);


        } else if (id == R.id.nav_cash_back) {

            Intent i = new Intent(ElectricityActivity.this, TopUpAccountActivity.class);
            startActivity(i);

        } else if (id == R.id.nav_send) {

            Intent sendIntent = new Intent();
            sendIntent.setAction(Intent.ACTION_SEND);
            sendIntent.putExtra(Intent.EXTRA_TEXT, "This is my text to send.");
            sendIntent.setType("text/plain");
            startActivity(sendIntent);

        } else if (id == R.id.nav_logout) {

            Intent i = new Intent(ElectricityActivity.this, LoginActivity.class);
            startActivity(i);

        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
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

    public static class AppSectionsPagerAdapter extends FragmentPagerAdapter {

        public AppSectionsPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int i) {

            switch (i) {
                case 0:
                    return new PurchaseCreditNoteFragment();
                case 1:
                    return new IssueFBEFragment();

                case 2:
                    return new BlindVendFragment();

                case 3:
                    return new IssueAdviceFragment();

                case 4:
                    return new Re_PrintFragment();

                default:

                    return null;
            }

        }

        @Override
        public int getCount() {
            return 5;
        }

        /*public CharSequence getSubCategories(int position){


        }*/


        public CharSequence shopDataTabs(String name, int position){
            return electricity[position];


        }

        @Override
        public CharSequence getPageTitle(int position) {
            //return "Section " + (position + 1);

            return shopDataTabs(message, position);


        }


    }

}

