package com.example.l;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class Adapter extends RecyclerView.Adapter<Adapter.myviewholder> {
    ArrayList<modelQuran> arrayList;
    OnClickListener_Stories mylistener;

    public Adapter(ArrayList<modelQuran> arrayList1, OnClickListener_Stories onClickListener_stories) {
        this.arrayList = arrayList1;
        this.mylistener = onClickListener_stories;

    }

    @NonNull
    @Override
    public Adapter.myviewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.main2, parent, false);
        myviewholder myviewholder = new myviewholder(view);

        return myviewholder;
    }

    @Override
    public void onBindViewHolder(@NonNull Adapter.myviewholder holder, int position) {
        holder.textView.setText(arrayList.get(position).getName());
        holder.imageView.setImageResource(arrayList.get(position).getImage());

    }

    @Override
    public int getItemCount() {
        return arrayList.size();
    }

    public class myviewholder extends RecyclerView.ViewHolder {
        ImageView imageView;
        TextView textView;


        public myviewholder(@NonNull View itemView) {
            super(itemView);
            imageView = (ImageView) itemView.findViewById(R.id.icon);
            textView = (TextView) itemView.findViewById(R.id.text);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    mylistener.onClick(getAdapterPosition());


                }
            });
        }
    }
}
