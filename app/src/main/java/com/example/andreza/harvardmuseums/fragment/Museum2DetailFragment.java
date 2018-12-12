package com.example.andreza.harvardmuseums.fragment;
import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.RequiresApi;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.example.andreza.harvardmuseums.R;
import com.example.andreza.harvardmuseums.pojo.Museum;

import static android.text.Layout.JUSTIFICATION_MODE_INTER_WORD;

public class Museum2DetailFragment extends Fragment {

    private Museum museum;
    private TextView title;
    private TextView description;

    public Museum2DetailFragment() {
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
    }

    //@RequiresApi(api = Build.VERSION_CODES.O)
    @RequiresApi(api = Build.VERSION_CODES.O)
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_museum2_detail, container, false);
        museum = getMuseum();
        title = view.findViewById(R.id.textView_museum2_title_id);
        title.setText(museum.getTitle());
        //title.setJustificationMode(JUSTIFICATION_MODE_INTER_WORD);

        description = view.findViewById(R.id.textView_museum2_description_id);
        description.setText(museum.getDescription());
//        description.setJustificationMode(JUSTIFICATION_MODE_INTER_WORD);

        return view;
    }

    public Museum getMuseum() {
        Museum museum = new Museum();
        museum.setTitle("Busch-Reisinger Museum");
        museum.setDescription(
                "The Busch-Reisinger Museum was founded in 1901 as the Germanic Museum. Unique among North American museums, the Busch-Reisinger is dedicated to the study of all modes and periods of art from central and northern Europe, with an emphasis on German-speaking countries." +
                "\n\n" +
                "In 1921 the Germanic Museum moved to Adolphus Busch Hall, built partly with funds from Adolphus Busch’s son-in-law, Hugo Reisinger, and in 1950 it was renamed the Busch-Reisinger Museum." +
                "\n\n" +
                "The museum moved again in 1991, this time to Werner Otto Hall at 32 Quincy Street, designed by Gwathmey Siegel and Associates." +
                "\n\n" +
                "Adolphus Busch Hall continues to house the founding collection of plaster casts of medieval art and is the venue for concerts on its world-renowned Flentrop pipe organ, while the Busch-Reisinger Museum’s holdings include significant works of Austrian Secession art, German expressionism, 1920s abstraction, and materials related to the Bauhaus." +
                "\n\n" +
                "Other strengths include late-medieval sculpture and eighteenth-century art." +
                "\n\n" +
                "The museum also holds noteworthy postwar and contemporary art from German-speaking Europe.");
        return museum;
    }

}