package com.example.app16;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class RecuclerAdapter extends RecyclerView.Adapter<RecuclerAdapter.ViewHolder> {
    private RecyclerViewInterface recyclerViewInterface;
    private Context context;
    private ArrayList<Anime> animeList;

    public  RecuclerAdapter(Context context, ArrayList<Anime> animeList, RecyclerViewInterface recyclerViewInterface){
        this.recyclerViewInterface = recyclerViewInterface;
        this.animeList = animeList;
        this.context = context;
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        TextView Title;
        ViewHolder(View view, RecyclerViewInterface recyclerViewInterface){
            super(view);
            Title = view.findViewById(R.id.TitleName);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if(RecuclerAdapter.this.recyclerViewInterface !=null){
                        int pos= getAdapterPosition();
                        if (pos !=RecyclerView.NO_POSITION){
                            RecuclerAdapter.this.recyclerViewInterface.onItemClick(pos);
                        }
                    }
                }
            });
        }
    }

    public  int getItemCount(){
        return animeList.size();
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_card, parent, false);
        return  new ViewHolder(view, recyclerViewInterface);
    }

    public void onBindViewHolder(@NonNull ViewHolder holder, int position){
        Anime anime = animeList.get(position);
        holder.Title.setText(anime.getTitleName());
    }
}
