package com.example.andreza.harvardmuseums.adapter;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.andreza.harvardmuseums.R;
import com.example.andreza.harvardmuseums.model.Artwork;

import java.util.List;

public class RecyclerViewUserAdapter extends RecyclerView.Adapter<RecyclerViewUserAdapter.ViewHolder> {


    private List<Artwork> favoriteList;

    public RecyclerViewUserAdapter(List<Artwork> favoriteList) {
        this.favoriteList = favoriteList;
    }

    @NonNull
    @Override
    public RecyclerViewUserAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.content_user_item,viewGroup,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerViewUserAdapter.ViewHolder viewHolder, int i) {

    }

    @Override
    public int getItemCount() {
        return favoriteList.size();
    }


    public class ViewHolder extends RecyclerView.ViewHolder{
        private TextView title;
        private ImageView picture;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            title = itemView.findViewById(R.id.titulo_obra_fav_id);
            picture = itemView.findViewById(R.id.imagem_obra_fav_id);
        }

        public void bind (Artwork artwork){
            title.setText(artwork.getTitle());
        }
    }
}
