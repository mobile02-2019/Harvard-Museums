package com.example.andreza.harvardmuseums.adapter;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.andreza.harvardmuseums.R;
import com.example.andreza.harvardmuseums.pojo.Gallery;

import java.util.List;

public class RecyclerViewFilterAdapter extends RecyclerView.Adapter<RecyclerViewFilterAdapter.ViewHolder> {

    private List<Gallery> galleryList;

    public RecyclerViewFilterAdapter(List<Gallery> galleryList) {
        this.galleryList = galleryList;
    }

    @NonNull
    @Override
    public RecyclerViewFilterAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.content_filter_item, viewGroup, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerViewFilterAdapter.ViewHolder viewHolder, int position) {
        Gallery gallery = galleryList.get(position);
        viewHolder.bind(gallery);
    }

    @Override
    public int getItemCount() {
        return galleryList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        private TextView galleryName;


        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            galleryName = itemView.findViewById(R.id.recyclerview_gallery_filter_id);
        }

        public void bind (Gallery gallery) {
            galleryName.setText(gallery.getGalleryName());
        }

    }

}
