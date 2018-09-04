package com.examples.dmozo.cardview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ArrayList<Producto> dataList;
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
        cargarProductos();

        RecyclerAdapter recyclerAdapter = new RecyclerAdapter(dataList);

        recycler.setAdapter(recyclerAdapter);

    }

    private void cargarProductos(){
        dataList.add(new Producto("Producto 1", "Descripción del producto 1", R.drawable.ic_class_black_24dp));
        dataList.add(new Producto("Producto 2", "Descripción del producto 2", R.drawable.ic_class_black_24dp));
        dataList.add(new Producto("Producto 3", "Descripción del producto 3", R.drawable.ic_class_black_24dp));
        dataList.add(new Producto("Producto 4", "Descripción del producto 4", R.drawable.ic_class_black_24dp));
        dataList.add(new Producto("Producto 5", "Descripción del producto 5", R.drawable.ic_class_black_24dp));
    }

}
