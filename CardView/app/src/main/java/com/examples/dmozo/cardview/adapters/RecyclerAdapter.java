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
        ViewHolder viewHolder = new ViewHolder(view);
        viewHolder.productName = view.findViewById(R.id.name);
        viewHolder.price = view.findViewById(R.id.price);
        viewHolder.imageView = view.findViewById(R.id.imagen);
        viewHolder.editText = view.findViewById(R.id.quantity);
        viewHolder.buttonAdd = view.findViewById(R.id.btnAdd);
        viewHolder.buttonSus = view.findViewById(R.id.btnSus);
        viewHolder.buttonAdd.setOnClickListener(viewHolder);
        viewHolder.buttonSus.setOnClickListener(viewHolder);
        return viewHolder;
    }


    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.productName.setText(dataList.get(position).getName());
        holder.price.setText(String.valueOf(dataList.get(position).getPrice()));
        holder.imageView.setImageResource(dataList.get(position).getImage());
        holder.editText.setText(String.valueOf(dataList.get(position).getQuantity()));
    }

    @Override
    public int getItemCount() {
        return this.dataList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{

        private TextView productName;
        private TextView price;
        private ImageView imageView;
        private EditText editText;
        private Button buttonAdd, buttonSus;

        public ViewHolder(final View itemView) {
            super(itemView);
        }

        @Override
        public void onClick(View v) {
            switch (v.getId()){
                case R.id.btnAdd:
                    addProduct();
                    break;
                case R.id.btnSus:
                    susProduct();
                    break;
                default:
                    break;
            }
        }

        public void addProduct() {
            String text = this.editText.getText().toString();
            if (text.equals("")){
                text = "0";
            }int add = Integer.parseInt(text)+1;
            dataList.get(getAdapterPosition()).setQuantity(add);
            this.editText.setText(""+add);
        }

        public void susProduct() {
            String text = this.editText.getText().toString();
            if (text.equals("")){
                dataList.get(getAdapterPosition()).setQuantity(0);
                this.editText.setText("0");
            }else{
                int sus = Integer.parseInt(text);
                if (sus>0) {
                    sus--;
                    dataList.get(getAdapterPosition()).setQuantity(sus);
                    this.editText.setText(""+sus);
                }
            }
        }
    }
}