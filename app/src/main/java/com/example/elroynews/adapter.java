package com.example.elroynews;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

public class adapter extends  RecyclerView.Adapter<adapter.viewHolder> {



        ArrayList<model> list;
        Context context;

        public adapter(ArrayList<model> list, Context context) {
            this.list = list;
            this.context = context;
        }

        @NonNull
        @Override
        public viewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            View view = LayoutInflater.from(context).inflate(R.layout.sample,parent,false);
            return new viewHolder(view);
        }

        @Override
        public void onBindViewHolder(@NonNull viewHolder holder, int position) {
            model m = list.get(position);

            holder.t1.setText(m.getTitle());
            holder.t2.setText(m.getAuthor());
            Glide.with(context).load(m.getImageUrl()).into(holder.i1);

            holder.t1.setOnClickListener(v -> {
                Toast.makeText(context,"clicked" + position,Toast.LENGTH_SHORT).show();
            });


        }

        @Override
        public int getItemCount() {
            return list.size() ;
        }

        public class viewHolder extends RecyclerView.ViewHolder{


            ImageView i1;
            TextView t1,t2;
LinearLayout l1;
            public viewHolder(@NonNull View itemView) {
                super(itemView);

                i1= itemView.findViewById(R.id.imageView);
                t1=itemView.findViewById(R.id.textViewtitle);
                t2=itemView.findViewById(R.id.textView2auther);
                l1=itemView.findViewById(R.id.linear);

            }
        }

}
