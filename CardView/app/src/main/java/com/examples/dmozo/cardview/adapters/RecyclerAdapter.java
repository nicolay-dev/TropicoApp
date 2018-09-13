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

import com.examples.dmozo.cardview.entities.Product;
import com.examples.dmozo.cardview.R;

import java.util.ArrayList;

public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.ViewHolder> {

    ArrayList<Product> dataList;
    private OnItemClickListener listener;

    interface OnItemClickListener {
        public void addProduct(ViewHolder holder, int position);
        public void susProduct(ViewHolder holder, int position);
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
        holder.subtitle.setText(dataList.get(position).getPrice());
        holder.imageView.setImageResource(dataList.get(position).getImage());
    }

    @Override
    public int getItemCount() {
        return this.dataList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener, OnItemClickListener {

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
            buttonAdd.setOnClickListener(this);
            buttonSus.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            switch (v.getId()){
                case R.id.btnAdd:
                    addProduct(this, getAdapterPosition());
                    break;
                case R.id.btnSus:
                    susProduct(this, getAdapterPosition());
                    break;
                default:
                    break;
            }
        }


        @Override
        public void addProduct(ViewHolder holder, int position) {
            String text = holder.editText.getText().toString();
            if (text.equals("")){
                text = "0";
            }int add = Integer.parseInt(text)+1;
            dataList.get(position).setQuantity(add);
            holder.editText.setText(""+add);
        }

        @Override
        public void susProduct(ViewHolder holder, int position) {
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
            }
        }
    }
}


/*
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
 */