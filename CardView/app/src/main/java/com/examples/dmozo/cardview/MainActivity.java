package com.examples.dmozo.cardview;

import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.net.Uri;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;

import com.examples.dmozo.cardview.adapters.ViewpagerAdapter;
import com.examples.dmozo.cardview.fragments.FragmentPrint;
import com.examples.dmozo.cardview.fragments.FragmentProducts;
import com.examples.dmozo.cardview.persistence.SQLiteConnectionHelper;
import com.examples.dmozo.cardview.utils.DbUtilities;

public class MainActivity extends AppCompatActivity implements FragmentPrint.OnFragmentInteractionListener,
        FragmentProducts.OnFragmentInteractionListener{
    ViewpagerAdapter mViewPagerAdapter;
    ViewPager mViewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        // Create the adapter that will return a fragment for each of the three
        // primary sections of the activity.
        mViewPagerAdapter = new ViewpagerAdapter(getSupportFragmentManager());

        // Set up the ViewPager with the sections adapter.
        mViewPager = (ViewPager) findViewById(R.id.container);
        mViewPager.setAdapter(mViewPagerAdapter);

        TabLayout tabLayout = findViewById(R.id.tabs);
        mViewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));
        tabLayout.addOnTabSelectedListener(new TabLayout.ViewPagerOnTabSelectedListener(mViewPager));

    }


    @Override
    public void onFragmentInteraction(Uri uri) {

    }

}
