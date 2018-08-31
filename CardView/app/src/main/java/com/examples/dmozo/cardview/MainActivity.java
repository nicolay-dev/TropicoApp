package com.examples.dmozo.cardview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ArrayList<String> dataList;
    RecyclerView recycler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recycler = findViewById(R.id.recyclerId);
        recycler.setLayoutManager(new LinearLayoutManager(this));
        //PARAMS: (Context,Rows)
        //recycler.setLayoutManager(new GridLayoutManager(this, 3));
        dataList = new ArrayList<>();
        for (int i = 0; i < 30; i++) {
            dataList.add("Item "+i);
        }

        RecyclerAdapter recyclerAdapter = new RecyclerAdapter(dataList);
        recycler.setAdapter(recyclerAdapter);
    }
}
