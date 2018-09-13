package com.examples.dmozo.cardview.adapters;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.examples.dmozo.cardview.entities.Product;
import com.examples.dmozo.cardview.R;

import java.util.ArrayList;

public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.ViewHolder> implements View.OnClickListener{

    ArrayList<Product> dataList;
    ViewHolder viewHolder;

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btnAdd:
                Toast.makeText(v.getContext(), "ADD", Toast.LENGTH_SHORT).show();
                break;
            case R.id.btnSus:
                Toast.makeText(v.getContext(), "SUS", Toast.LENGTH_SHORT).show();
                break;
            default:
                break;
        }
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        TextView title;
        TextView price;
        ImageView imageView;
        EditText editText;
        Button buttonAdd, buttonSus;

        public ViewHolder(final View itemView) {
            super(itemView);
            title = itemView.findViewById(R.id.title);
            price = itemView.findViewById(R.id.subtitle);
            imageView = itemView.findViewById(R.id.imagen);
            editText = itemView.findViewById(R.id.quantity);
            buttonAdd = itemView.findViewById(R.id.btnAdd);
            buttonSus = itemView.findViewById(R.id.btnSus);
        }
    }

    public RecyclerAdapter(ArrayList<Product> dataList) {
        this.dataList = dataList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_list, parent,
                false);
        view.setLayoutParams(new RecyclerView.LayoutParams(RecyclerView.LayoutParams.MATCH_PARENT,
                RecyclerView.LayoutParams.WRAP_CONTENT));
        return new ViewHolder(view);
    }


    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.title.setText(dataList.get(position).getName());
        holder.price.setText(dataList.get(position).getPrice());
        holder.imageView.setImageResource(dataList.get(position).getImage());
        holder.buttonAdd.setOnClickListener(this);
        holder.buttonSus.setOnClickListener(this);
    }


    @Override
    public int getItemCount() {
        return this.dataList.size();
    }


/**
 * String text = "";
 switch (v.getId()){
 case R.id.btnSus:
 text = viewHolder.editText.getText().toString();
 if (text.equals("")){
 dataList.get(viewHolder.getAdapterPosition()).setQuantity(0);
 viewHolder.editText.setText("0");
 }else{
 int sus = Integer.parseInt(text);
 if (sus>0) {
 sus--;
 dataList.get(viewHolder.getAdapterPosition()).setQuantity(sus);
 viewHolder.editText.setText(""+sus);
 }
 }
 break;
 case R.id.btnAdd:
 text = viewHolder.editText.getText().toString();
 if (text.equals("")){
 text = "0";
 }int add = Integer.parseInt(text)+1;
 dataList.get(viewHolder.getAdapterPosition()).setQuantity(add);
 viewHolder.editText.setText(""+add);
 break;
 */

}
