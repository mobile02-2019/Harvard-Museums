package com.example.andreza.harvardmuseums.fragment;
import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.andreza.harvardmuseums.R;
import com.example.andreza.harvardmuseums.activity.HomeActivity;
import com.example.andreza.harvardmuseums.calendar.CalendarHandler;
import com.example.andreza.harvardmuseums.pojo.Exhibition;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.UserInfo;

public class ExhibitionDetailFragment extends Fragment {

   private Exhibition exhibition;
   private TextView titulo;
   private TextView tituloApi;
   private TextView descricao;
   private TextView descricaoApi;
   private TextView dataInicioApi;
   private TextView dataInicio;
   private TextView data;
   private TextView dataFimApi;
//   private WebView wv;
   private TextView localizacao;
   private ImageView calendar;
   private FirebaseAuth firebaseAuth;

   public ExhibitionDetailFragment() {

    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        this.exhibition = (Exhibition) getArguments().getSerializable(HomeActivity.OBJ_EXHIBITION);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_exhibition_detail, container, false);
//        setupRecyclerView(view);
        firebaseAuth = FirebaseAuth.getInstance();
        titulo = view.findViewById(R.id.titulo_detailExhibition_id);
        descricao = view.findViewById(R.id.descrition_detailex_id);
        dataInicioApi = view.findViewById(R.id.text_view_api_data_begin_id);
        dataFimApi = view.findViewById(R.id.text_view_api_data_end_id);
        localizacao = view.findViewById(R.id.text_view_api_localizacao_id);
        calendar = view.findViewById(R.id.btn_add_to_my_calendar_id);



//        wv = view.findViewById(R.id.web_view_exibition_item_id);

//
//        WebSettings ws = wv.getSettings();
//        ws.setJavaScriptEnabled(true);
//        ws.setSupportZoom(false);
//        wv.loadUrl("https://www.harvardartmuseums.org/visit/exhibitions");


        settarExhibition();
        return view;
    }

 

   private void settarExhibition(){

       if (exhibition.getTitle()!=null)
           titulo.setText(exhibition.getTitle());

       if (exhibition.getDescription()!=null)
           descricao.setText(exhibition.getDescription());

       if (exhibition.getBeginDate()!=null)
           dataInicioApi.setText(exhibition.getBeginDate());

       if (exhibition.getEndDate() != null)
           dataFimApi.setText(exhibition.getEndDate());

       if(exhibition.getAddress() != null)
           localizacao.setText(exhibition.getAddress().get(0).toString());

       calendar.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
//               for (UserInfo userInfo : firebaseAuth.getCurrentUser().getProviderData()) {
//                   if(userInfo.getProviderId().equals("google.com")){
                       new CalendarHandler(v.getContext(), exhibition.getTitle(), exhibition.getDescription()).execute();

//                   }else{
//                       Toast.makeText(getContext(),"You must sign in with Google to access the calendar",Toast.LENGTH_LONG).show();
//                   }
               }

//           }
       });
   }


}