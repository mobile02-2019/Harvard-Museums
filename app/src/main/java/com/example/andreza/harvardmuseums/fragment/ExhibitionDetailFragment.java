package com.example.andreza.harvardmuseums.fragment;
import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.widget.TextView;

import com.example.andreza.harvardmuseums.R;
import com.example.andreza.harvardmuseums.activity.HomeActivity;
import com.example.andreza.harvardmuseums.adapter.RecyclerViewExhibitionDetailAdapter;
import com.example.andreza.harvardmuseums.pojo.Exhibition;
import java.util.ArrayList;
import java.util.List;

public class ExhibitionDetailFragment extends Fragment {

   private Listener listener;
   private Exhibition exhibition;
   private TextView titulo;
   private TextView descricao;
   private TextView data;
   private WebView wv;



   public interface Listener{
       void goToArtworkDetail();

   }

   public ExhibitionDetailFragment() {

    }


    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        this.listener = (Listener) context;
        this.exhibition = (Exhibition) getArguments().getSerializable(HomeActivity.OBJ_EXHIBITION);

    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_exhibition_detail, container, false);
       // setupRecyclerView(view);
//        titulo = view.findViewById(R.id.titulo_detailExhibition_id);
//        descricao = view.findViewById(R.id.descrition_detailex_id);
//        data = view.findViewById(R.id.date_exhibition_id);
        wv = view.findViewById(R.id.web_view_exibition_item_id);


        WebSettings ws = wv.getSettings();
        ws.setJavaScriptEnabled(true);
        ws.setSupportZoom(false);
        wv.loadUrl("https://www.harvardartmuseums.org/visit/exhibitions");


//        settarExhibition();
        return view;
    }

   /* private void setupRecyclerView(View view) {
        RecyclerView recyclerView = view.findViewById(R.id.recyclerview_exhibitionDetail_id);
        LinearLayoutManager horizontalLayoutManager = new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL, false);
        RecyclerViewExhibitionDetailAdapter adapter = new RecyclerViewExhibitionDetailAdapter(createGalleryList(), listener);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(horizontalLayoutManager);
    }

    private List<Exhibition> createGalleryList() {
        List<Exhibition> galleryList = new ArrayList<>();

        Exhibition exhibition1 = new Exhibition();
        exhibition1.setImagemDetalhes(R.drawable.image_exhibition);
        galleryList.add(exhibition1);

        Exhibition exhibition2 = new Exhibition();
        exhibition2.setImagemDetalhes(R.drawable.image_exhibition);
        galleryList.add(exhibition2);

        Exhibition exhibition3 = new Exhibition();
        exhibition3.setImagemDetalhes(R.drawable.image_exhibition);
        galleryList.add(exhibition3);

        Exhibition exhibition4 = new Exhibition();
        exhibition4.setImagemDetalhes(R.drawable.image_exhibition);
        galleryList.add(exhibition4);

        Exhibition exhibition5 = new Exhibition();
        exhibition5.setImagemDetalhes(R.drawable.image_exhibition);
        galleryList.add(exhibition5);

        Exhibition exhibition6 = new Exhibition();
        exhibition6.setImagemDetalhes(R.drawable.image_exhibition);
        galleryList.add(exhibition6);

        Exhibition exhibition7 = new Exhibition();
        exhibition7.setImagemDetalhes(R.drawable.image_exhibition);
        galleryList.add(exhibition7);

        Exhibition exhibition8 = new Exhibition();
        exhibition8.setImagemDetalhes(R.drawable.image_exhibition);
        galleryList.add(exhibition8);

        return galleryList;
    }*/

//   private void settarExhibition(){
//       titulo.setText(exhibition.getTitle());
//       descricao.setText(exhibition.getDescription());
//       data.setText(exhibition.getEndDate());
//
//
//   }


}