package com.example.andreza.harvardmuseums.adapter;
import android.annotation.SuppressLint;
import android.support.annotation.NonNull;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.example.andreza.harvardmuseums.R;
import com.example.andreza.harvardmuseums.interfaces.ComunicacaoArtwork;
import com.example.andreza.harvardmuseums.interfaces.ListenerArtwork;
import com.example.andreza.harvardmuseums.pojo.Artwork;
import com.squareup.picasso.Picasso;

import java.util.List;

public class RecyclerViewArtworkAdapter extends RecyclerView.Adapter<RecyclerViewArtworkAdapter.ViewHolder>{

    private ListenerArtwork listener;
    private List<Artwork> artworkList;
    private Artwork artwork;

    public RecyclerViewArtworkAdapter(List<Artwork> artworkList, ListenerArtwork listener) {
        this.artworkList = artworkList;
        this.listener = listener;
    }

    @NonNull
    @Override
    public RecyclerViewArtworkAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.content_artwork_item, viewGroup, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerViewArtworkAdapter.ViewHolder viewHolder, final int position) {
        final Artwork artwork = artworkList.get(position);
        viewHolder.bind(artwork);
//        viewHolder.itemView.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                listener.goToArtworkDetail();
//            }
//        });
    }

    @Override
    public int getItemCount() {
        return artworkList.size();
    }

    public void setArtworkList (List<Artwork> artworkList){
        this.artworkList = artworkList;
        notifyDataSetChanged();
    }

    //Criei esse método para poder usar no ArtworkDetailFragment
    public void setArtwork (Artwork artwork){
        this.artwork = artwork;
        notifyDataSetChanged();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        private TextView title;
        private ImageView picture;
        private CardView item;

        private TextView titulo;
        private TextView classification;
        //private TextView worktype;
        private TextView date;
        private TextView places;
        private TextView period;
        private TextView culture;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            title = itemView.findViewById(R.id.titulo_obra_id);
            picture = itemView.findViewById(R.id.imagem_obra_id);
            item = itemView.findViewById(R.id.card_item_id);

            titulo = itemView.findViewById(R.id.text_title_detail_artwork_id);
            classification = itemView.findViewById(R.id.text_classification_detail_artwork_id);
            date = itemView.findViewById(R.id.text_date_detail_artwork_id);
            places = itemView.findViewById(R.id.text_places_detail_artwork_id);
            period = itemView.findViewById(R.id.text_period_detail_artwork_id);
            culture = itemView.findViewById(R.id.text_culture_detail_artwork_id);

        }

        @SuppressLint("ResourceType")
        public void bind(Artwork artwork) {
            final int id = artwork.getId();
            title.setText(artwork.getTitle());
            if (artwork.getPicture() != null) {
                Picasso.get().load(artwork.getPicture()).into(picture);
            }
            item.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    listener.goToArtworkDetail(id);
                }
            });
          /*  classification.setText(artwork.getClassification());
            date.setText(artwork.getDate());
            places.setText(artwork.getPlaceCreation());
            period.setText(artwork.getPeriod());
            culture.setText(artwork.getPeriod());*/



        }
    }
}
