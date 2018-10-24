package com.example.andreza.harvardmuseums.adapter;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.example.andreza.harvardmuseums.R;
import com.example.andreza.harvardmuseums.model.Exhibition;
import java.util.List;

public class RecyclerViewExhibitionAdapter extends RecyclerView.Adapter<RecyclerViewExhibitionAdapter.ViewHolder> {

    private List<Exhibition> exhibitionList;

    public RecyclerViewExhibitionAdapter(List<Exhibition> exhibitionList) {
        this.exhibitionList = exhibitionList;
    }

    @NonNull
    @Override
    public RecyclerViewExhibitionAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.content_exhibition_item, viewGroup, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerViewExhibitionAdapter.ViewHolder viewHolder, int position) {
        Exhibition exhibition = exhibitionList.get(position);
        viewHolder.bind(exhibition);
    }

    @Override
    public int getItemCount() {
        return exhibitionList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        private TextView name;
        private TextView date;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            name = itemView.findViewById(R.id.textView_nameExhibition_id);
            date = itemView.findViewById(R.id.textView_dateExhibition_id);
        }

        public void bind (Exhibition exhibition) {
            name.setText(exhibition.getTitle());
            date.setText(exhibition.getDate());
        }

    }

}