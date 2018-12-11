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

public class Museum3DetailFragment extends Fragment {

    private Museum museum;
    private TextView title;
    private TextView description;

    public Museum3DetailFragment() {
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
        View view = inflater.inflate(R.layout.fragment_museum3_detail, container, false);
        museum = getMuseum();
        title = view.findViewById(R.id.textView_museum3_title_id);
        title.setText(museum.getTitle());
        //title.setJustificationMode(JUSTIFICATION_MODE_INTER_WORD);

        description = view.findViewById(R.id.textView_museum3_description_id);
        description.setText(museum.getDescription());
//        description.setJustificationMode(JUSTIFICATION_MODE_INTER_WORD);

        return view;
    }

    public Museum getMuseum() {
        Museum museum = new Museum();
        museum.setTitle("Arthur M. Sackler Museum");
        museum.setDescription(
                "In 1912, Langdon Warner taught the first courses in Asian art at Harvard, and the first at any American university." +
                "\n\n" +
                "By 1977, Harvard’s collections of Asian, ancient, and Islamic and later Indian art had grown sufficiently in size and importance to require a larger space for their display and study." +
                "\n\n" +
                "With the generosity of Dr. Arthur M. Sackler, a leading psychiatrist, entrepreneur, art collector, and philanthropist, the Harvard Art Museums founded a museum dedicated to works from Asia, the Middle East, and the Mediterranean." +
                "\n\n" +
                "The Arthur M. Sackler Museum, a new museum building at 485 Broadway designed by James Stirling, opened in 1985." +
                "\n\n" +
                "This structure remains the home of the History of Art and Architecture Department and the Media Slide Library.");
        return museum;
    }

}