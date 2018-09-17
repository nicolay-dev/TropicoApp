package com.examples.dmozo.cardview.fragments;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.examples.dmozo.cardview.entities.Product;
import com.examples.dmozo.cardview.R;
import com.examples.dmozo.cardview.adapters.RecyclerAdapter;
import com.examples.dmozo.cardview.persistence.SQLiteConnectionHelper;
import com.examples.dmozo.cardview.utils.DbUtilities;

import java.util.ArrayList;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link FragmentProducts.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link FragmentProducts#newInstance} factory method to
 * create an instance of this fragment.
 */
public class FragmentProducts extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private RecyclerView recycler;
    private ArrayList<Product> dataList;
    private OnFragmentInteractionListener mListener;

    public FragmentProducts() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment FragmentProducts.
     */
    // TODO: Rename and change types and number of parameters
    public static FragmentProducts newInstance(String param1, String param2) {
        FragmentProducts fragment = new FragmentProducts();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        dataList = new ArrayList<>();
        cargarProductos();
        recycler = view.findViewById(R.id.recyclerId);
        //PARAMS: (Context,Rows)
        //recycler.setLayoutManager(new GridLayoutManager(this, 3));
        recycler.setLayoutManager(new LinearLayoutManager(getActivity()));
        RecyclerAdapter recyclerAdapter = new RecyclerAdapter(dataList);
        recycler.setAdapter(recyclerAdapter);
}

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_fragment_products, container, false);
        return view;
    }


    private void cargarProductos(){
        /*
            dataList.add(new Product("Product 1", 15000, R.drawable.ic_class_black_24dp ));
        dataList.add(new Product("Product 1", 15000, R.drawable.ic_class_black_24dp ));
        dataList.add(new Product("Product 1", 15000, R.drawable.ic_class_black_24dp ));
        dataList.add(new Product("Product 1", 15000, R.drawable.ic_class_black_24dp ));
        dataList.add(new Product("Product 1", 15000, R.drawable.ic_class_black_24dp ));
        dataList.add(new Product("Product 1", 15000, R.drawable.ic_class_black_24dp ));
         */
        SQLiteConnectionHelper connectionHelper = new SQLiteConnectionHelper(this.getContext(),
                DbUtilities.DB_NAME,null,1);
        SQLiteDatabase db = connectionHelper.getReadableDatabase();
        Product product = null;
        //String[] columns = {DbUtilities.ROW_NAME, DbUtilities.ROW_PRICE, DbUtilities.ROW_IMAGE,};
        try{
            Log.d("************","Log desde cargar productos");
            Cursor cursor = db.rawQuery(DbUtilities.SELECT_TABLE_PRODUCTS, null);
            Log.d("************","Cursor creado");
            //Cursor cursor = db.query(DbUtilities.TABLE_PRODUCTS_NAME, columns, null, null, null, null,null);
            while (cursor.moveToNext()){
                product = new Product(cursor.getString(1), cursor.getInt(2), Integer.parseInt(cursor.getString(3)));
                this.dataList.add(product);
            }
            Log.d("************","Fin del cursor"+cursor.getCount()+"Tamaño de la lista = "+dataList.size());
            cursor.close();
            db.close();
        }catch (Exception e){
            Toast.makeText(this.getContext(), "Error al cargar productos: "+e.getMessage(), Toast.LENGTH_LONG).show();
        }

    }

    // TODO: Rename method, update argument and hook method into UI event
    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onFragmentInteraction(uri);
        }
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnFragmentInteractionListener) {
            mListener = (OnFragmentInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onFragmentInteraction(Uri uri);
    }
}
