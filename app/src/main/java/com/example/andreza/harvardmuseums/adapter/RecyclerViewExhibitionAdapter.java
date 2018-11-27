package com.example.andreza.harvardmuseums.adapter;
import android.support.annotation.NonNull;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.widget.ImageView;
import android.widget.TextView;
import com.example.andreza.harvardmuseums.R;
import com.example.andreza.harvardmuseums.fragment.ExhibitionFragment;
import com.example.andreza.harvardmuseums.interfaces.RecyclerListenerExhibiton;
import com.example.andreza.harvardmuseums.model.ExhibitionResponse;
import com.example.andreza.harvardmuseums.pojo.Exhibition;
import com.squareup.picasso.Picasso;

import java.util.List;

public class RecyclerViewExhibitionAdapter extends RecyclerView.Adapter<RecyclerViewExhibitionAdapter.ViewHolder> {


   // private ExhibitionFragment.Listener listener;
    private List<Exhibition> exhibitionList;
    private RecyclerListenerExhibiton listenerExhibiton;
    private CardView cardView;


    public RecyclerViewExhibitionAdapter(List<Exhibition> exhibitionList, RecyclerListenerExhibiton listenerExhibiton) {
        this.exhibitionList = exhibitionList;
        this.listenerExhibiton = listenerExhibiton;

    }


    @NonNull
    @Override
    public RecyclerViewExhibitionAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.content_exhibition_item, viewGroup, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerViewExhibitionAdapter.ViewHolder viewHolder, int position) {
         final Exhibition exhibition = exhibitionList.get(position);
        viewHolder.bind(exhibition);

        viewHolder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                listenerExhibiton.onExhibitionClicado(exhibition);
            }
        });

    }

    public void setExhibitionList (List<Exhibition> exhibitionList){
        this.exhibitionList = exhibitionList;
        notifyDataSetChanged();
    }

    @Override
    public int getItemCount() {
        return exhibitionList.size();
    }



    public class ViewHolder extends RecyclerView.ViewHolder {

        private TextView name;
        private TextView begindate;
        private TextView endDate;
        private WebView wv;


      //  private ImageView imagem;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            name = itemView.findViewById(R.id.textView_nameExhibition_id);
//            begindate = itemView.findViewById(R.id.begin_date_set);
//            endDate = itemView.findViewById(R.id.end_date_set);
            cardView = itemView.findViewById(R.id.card_exhibition);
            wv = itemView.findViewById(R.id.web_view_exibition_item_id);
          //  imagem = itemView.findViewById(R.id.imageView_exhibition_id);


        }

        public void bind (final Exhibition exhibition) {
            name.setText(exhibition.getTitle());
//           begindate.setText(exhibition.getBeginDate());
//           endDate.setText(exhibition.getEndDate());

            cardView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
//                    todo: fazer um webview pra webpage do museu

//                    WebSettings ws = wv.getSettings();
//                    ws.setJavaScriptEnabled(true);
//                    ws.setSupportZoom(false);
//                    wv.loadUrl("https://www.harvardartmuseums.org/visit/exhibitions");





                }
            });

           // Picasso.get().load(exhibition.getImage().get(0).getUrl()).into(imagem);

        }



    }
}