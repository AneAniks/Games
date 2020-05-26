package com.example.softdev;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

class CustomAdapter extends RecyclerView.Adapter<CustomAdapter.MyViewHolder> {

    ArrayList<String> titles;
    ArrayList<String> steamUrls;
    Context context;

    public CustomAdapter(Context context, ArrayList<String> title, ArrayList<String> steamUrl) {
        this.context = context;
        this.titles = title;
        this.steamUrls = steamUrl;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        // infalte the item Layout
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.rowlayout, parent, false);
        MyViewHolder vh = new MyViewHolder(v); // pass the view to View Holder
        return vh;
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, final int position) {
        // set the data in items
        holder.title.setText(titles.get(position));
        holder.steamUrl.setText(steamUrls.get(position));
        // implement setOnClickListener event on item view.
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // display a toast with person name on item click
                Toast.makeText(context, titles.get(position), Toast.LENGTH_SHORT).show();
            }
});
    }
    @Override
    public int getItemCount() {
        return titles.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        TextView title, steamUrl;// init the item view's

        public MyViewHolder(View itemView) {
            super(itemView);

            // get the reference of item view's
            title = (TextView) itemView.findViewById(R.id.title);
            steamUrl = (TextView) itemView.findViewById(R.id.steamUrl);
        }
    }
}

