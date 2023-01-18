package com.example.project.UI.Adapter;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import com.example.project.R;
import com.example.project.UI.UI.details;
import com.example.project.UI.data.LocalData.contacDBHandler;
import com.example.project.UI.data.RemoteData.ProductModel;

public class productAdapter extends RecyclerView.Adapter<productAdapter.MyViewHolder> {
    Context context;
   ProductModel data;
    private contacDBHandler DBhandler;

    public productAdapter(Context context, ProductModel data) {
        this.context = context;
        this.data = data;

    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v= LayoutInflater.from(parent.getContext()).inflate(R.layout.product_cell,parent,false);

        return new MyViewHolder(v);
    }



    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
            holder.title.setText(data.getProducts().get(position).getTitle());
            holder.cat.setText(data.getProducts().get(position).getCategory());
            holder.price.setText("$" + String.valueOf(data.getProducts().get(position).getPrice()));
            Glide.with(context)
                    .load(data.getProducts().get(position).getThumbnail())
                    .centerCrop()
                    .into(holder.img);

holder.itemView.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View view) {
        Intent intent =new Intent(context, details.class);
        intent.putExtra("position",holder.getAdapterPosition());
        context.startActivity(intent);
    }
});
        holder.favo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DBhandler =new contacDBHandler(context);
                String name=data.getProducts().get(holder.getAdapterPosition()).getTitle();
                String price= String.valueOf(data.getProducts().get(holder.getAdapterPosition()).getPrice());
                String image= String.valueOf(holder.getAdapterPosition());

                DBhandler.addContact(name,price,image);
//                Toast.makeText(context, "done", Toast.LENGTH_SHORT).show();
                Toast.makeText(context, "done, "+name, Toast.LENGTH_SHORT).show();


            }
        });



    }

    @Override
    public int getItemCount() {

        return data.getProducts().size();
    }



    public class MyViewHolder extends RecyclerView.ViewHolder{
ImageView img;
TextView title, cat,price;
        CardView card;
        Button favo;


        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            title=itemView.findViewById(R.id.product_title);
            cat=itemView.findViewById(R.id.product_desc);
            price=itemView.findViewById(R.id.product_price);
            img= itemView.findViewById(R.id.product_img);
            card=itemView.findViewById(R.id.card);
            favo=itemView.findViewById(R.id.product_btn);


        }
    }
}
