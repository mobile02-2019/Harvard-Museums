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
import com.example.andreza.harvardmuseums.model.Classification;
import com.squareup.picasso.Picasso;

import java.util.List;

public class RecyclerViewFiltroArtworkAdapter extends RecyclerView.Adapter<RecyclerViewFiltroArtworkAdapter.ViewHolder> {

    private List<Classification> classificationList;

    public RecyclerViewFiltroArtworkAdapter(List<Classification> classificationList) {
        this.classificationList = classificationList;
    }

    public void setClassificationList(List<Classification> classificationList) {
        this.classificationList = classificationList;
    }

    @NonNull
    @Override
    public RecyclerViewFiltroArtworkAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.filtro_artwork_item, viewGroup, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerViewFiltroArtworkAdapter.ViewHolder viewHolder, int i) {
        final Classification classification = classificationList.get(i);
        viewHolder.bind(classification);
    }

    @Override
    public int getItemCount() {
        return classificationList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        private TextView nomeClassificacao;
        //TODO bind esta vazio. Descobrir o que precisa setar aqui

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            nomeClassificacao = itemView.findViewById(R.id.nome_classificacao_item);
        }

        public void bind (Classification classification){
            nomeClassificacao.setText(classification.getClassificationName());

        }
    }
}
