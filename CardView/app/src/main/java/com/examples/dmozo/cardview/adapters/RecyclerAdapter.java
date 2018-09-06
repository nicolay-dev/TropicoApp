package com.examples.dmozo.cardview.adapters;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.examples.dmozo.cardview.pojo.Producto;
import com.examples.dmozo.cardview.R;

import java.util.ArrayList;

public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.ViewHolder>{

    ArrayList<Producto> dataList;

    public RecyclerAdapter(ArrayList<Producto> dataList) {
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
    public void onBindViewHolder(@NonNull final ViewHolder holder, final int position) {

        holder.title.setText(dataList.get(position).getTitle());
        holder.subtitle.setText(dataList.get(position).getSubtitle());
        holder.imageView.setImageResource(dataList.get(position).getImage());
        holder.buttonAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String text = holder.editText.getText().toString();
                if (text.equals("")){
                    text = "0";
                }int add = Integer.parseInt(text)+1;
                dataList.get(position).setQuantity(add);
                holder.editText.setText(""+add);
            }
        });
        holder.buttonSus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String text = holder.editText.getText().toString();
                if (text.equals("")){
                    dataList.get(position).setQuantity(0);
                    holder.editText.setText("0");
                }else{
                    int sus = Integer.parseInt(text);
                    if (sus>0) {
                        sus--;
                        dataList.get(position).setQuantity(sus);
                        holder.editText.setText(""+sus);
                    }
                }for (int i = 0; i < dataList.size(); i++) {
                    Log.d("***************","Cantidades*********"+dataList.get(i).getQuantity());
                }

            }
        });
    }

    @Override
    public int getItemCount() {
        return this.dataList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        TextView title;
        TextView subtitle;
        ImageView imageView;
        EditText editText;
        Button buttonAdd, buttonSus;

        public ViewHolder(final View itemView) {
            super(itemView);
            title = itemView.findViewById(R.id.title);
            subtitle = itemView.findViewById(R.id.subtitle);
            imageView = itemView.findViewById(R.id.imagen);
            editText = itemView.findViewById(R.id.quantity);
            buttonAdd = itemView.findViewById(R.id.btnAdd);
            buttonSus = itemView.findViewById(R.id.btnSus);
        }
    }
}
