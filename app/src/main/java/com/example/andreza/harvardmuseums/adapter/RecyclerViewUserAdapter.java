package com.example.andreza.harvardmuseums.adapter;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.andreza.harvardmuseums.R;
import com.example.andreza.harvardmuseums.fragment.UserFragment;
import com.example.andreza.harvardmuseums.interfaces.ArtworkListenerDetail;
import com.example.andreza.harvardmuseums.interfaces.ComunicadorRecyclerUser;
import com.example.andreza.harvardmuseums.pojo.Artwork;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.squareup.picasso.Picasso;

import java.util.List;

public class RecyclerViewUserAdapter extends RecyclerView.Adapter<RecyclerViewUserAdapter.ViewHolder> {

    private List<Artwork> favoriteList;
    private ComunicadorRecyclerUser comunicador;
    private FirebaseAuth mAuth;

    private ArtworkListenerDetail listenerDetail;



    public RecyclerViewUserAdapter(List<Artwork> favoriteList,
                                   ComunicadorRecyclerUser comunicador,ArtworkListenerDetail listenerDetail) {
        this.favoriteList = favoriteList;
        this.comunicador = comunicador;
        this.listenerDetail = listenerDetail;
    }

    public void setFavoriteList(List<Artwork> favoriteList) {
        this.favoriteList = favoriteList;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public RecyclerViewUserAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.content_user_item,viewGroup,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerViewUserAdapter.ViewHolder viewHolder, int position) {
        Artwork artwork = favoriteList.get(position);
        viewHolder.bind(artwork);
    }

    @Override
    public int getItemCount() {
        return favoriteList.size();
    }

    public void excluirFavoritado(Artwork artwork){
        mAuth = FirebaseAuth.getInstance();
        favoriteList.remove(artwork);
        notifyDataSetChanged();
        DatabaseReference myRef = FirebaseDatabase.getInstance().getReference("users/"+mAuth.getUid());
        myRef.child(artwork.getDatabaseKey()).removeValue();
    }


    public class ViewHolder extends RecyclerView.ViewHolder{
        private TextView title;
        private ImageView picture;
        private ImageView trash;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            title = itemView.findViewById(R.id.titulo_obra_fav_id);
            picture = itemView.findViewById(R.id.imagem_obra_fav_id);
            trash = itemView.findViewById(R.id.image_trash_id);

        }

        public void bind (final Artwork artwork){
            title.setText(artwork.getTitle());
            Picasso.get().load(artwork.getPicture()).into(picture);

            trash.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    comunicador.exluirFavorito(artwork);
                    Toast.makeText(itemView.getContext(), "Excluir", Toast.LENGTH_SHORT).show();
                }
            });
            picture.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    listenerDetail.iniciarFragmentArtworkDetail(artwork);

                }
            });
        }
    }
}