package com.example.project.UI.Adapter;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.project.R;
import com.example.project.UI.data.LocalData.contacDBHandler;

import java.text.BreakIterator;
import java.util.ArrayList;

public class cartadapter extends RecyclerView.Adapter<cartadapter.viewholder>{
    Context context;
    ArrayList<String> name,price;
    private contacDBHandler sql;

    public cartadapter(Context context, ArrayList<String> name, ArrayList<String> price) {
        this.context = context;
        this.name = name;
        this.price = price;
    }
    @NonNull
    @Override
    public cartadapter.viewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v= LayoutInflater.from(parent.getContext()).inflate(R.layout.cell_fav_cart,parent,false);
        return new viewholder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull cartadapter.viewholder holder, int position) {
        Log.d("anss","fad1");
//        final contact con = sql.getContact();

//        Toast.makeText(context, "done", Toast.LENGTH_SHORT).show();
        holder.title.setText(name.get(position));
        holder.price.setText(price.get(position));
//        int x= Integer.parseInt(contact.get(position).getImage());
//        holder.img.setImageResource(x);
        Log.d("anss","fad2");
    }

    @Override
    public int getItemCount() {
        return name.size();
    }

    public class viewholder extends RecyclerView.ViewHolder {

        TextView title,price;

        public viewholder(@NonNull View itemView) {
            super(itemView);
            title=itemView.findViewById(R.id.product_title_fav);
            price=itemView.findViewById(R.id.product_price_fav);
        }
    }
}
