package com.example.andreza.harvardmuseums.adapter;

import android.annotation.SuppressLint;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.andreza.harvardmuseums.R;
import com.example.andreza.harvardmuseums.model.Artwork;
import com.example.andreza.harvardmuseums.model.Exhibition;

import java.util.List;

public class RecyclerViewArtworkAdapter extends RecyclerView.Adapter<RecyclerViewArtworkAdapter.ViewHolder> {

    private List<Artwork> artworkList;

    public RecyclerViewArtworkAdapter(List<Artwork> artworkList) {
        this.artworkList = artworkList;
    }

    @NonNull
    @Override
    public RecyclerViewArtworkAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.content_artwork_item, viewGroup, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerViewArtworkAdapter.ViewHolder viewHolder, int position) {
        Artwork artwork = artworkList.get(position);
        viewHolder.bind(artwork);
    }

    @Override
    public int getItemCount() {
        return artworkList.size();
    }


    public class ViewHolder extends RecyclerView.ViewHolder{
        private TextView title;
        private ImageView picture;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            title = itemView.findViewById(R.id.titulo_obra_id);
            picture = itemView.findViewById(R.id.imagem_obra_id);

        }

        @SuppressLint("ResourceType")
        public void bind(Artwork artwork) {
            title.setText(artwork.getTitle());
        }
    }
}
