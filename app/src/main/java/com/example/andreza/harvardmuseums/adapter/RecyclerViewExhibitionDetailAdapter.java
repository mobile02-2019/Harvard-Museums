package com.example.andreza.harvardmuseums.adapter;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.example.andreza.harvardmuseums.R;
import com.example.andreza.harvardmuseums.fragment.ExhibitionDetailFragment;
import com.example.andreza.harvardmuseums.pojo.Exhibition;
import java.util.List;

public class RecyclerViewExhibitionDetailAdapter extends RecyclerView.Adapter<RecyclerViewExhibitionDetailAdapter.ViewHolder> {

    private List<Exhibition> galleryList;

    public RecyclerViewExhibitionDetailAdapter(List<Exhibition> exhibitionList) {
        this.galleryList = exhibitionList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.content_exhibition_detail_item, viewGroup, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int position) {
        Exhibition exhibition = galleryList.get(position);
        viewHolder.bind(exhibition);
    }

    @Override
    public int getItemCount() {
        return galleryList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        private ImageView image;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            image = itemView.findViewById(R.id.imagem_detalhe_exibicao_recycler_view);
        }

        public void bind(Exhibition exhibition) {
            image.setImageResource(exhibition.getImagemDetalhes());
        }
    }

}