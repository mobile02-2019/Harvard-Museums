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

public class Museum1DetailFragment extends Fragment {

    private Museum museum;
    private TextView title;
    private TextView description;

    public Museum1DetailFragment() {
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
        View view = inflater.inflate(R.layout.fragment_museum1_detail, container, false);
        museum = getMuseum();
        title = view.findViewById(R.id.textView_museum1_title_id);
        title.setText(museum.getTitle());
      //title.setJustificationMode(JUSTIFICATION_MODE_INTER_WORD);

        description = view.findViewById(R.id.textView_museum1_description_id);
        description.setText(museum.getDescription());
//        description.setJustificationMode(JUSTIFICATION_MODE_INTER_WORD);

        return view;
    }

    public Museum getMuseum() {
        Museum museum = new Museum();
        museum.setTitle("Fogg Museum");
        museum.setDescription(
                "The Fogg Museum opened in 1895 on the northern edge of Harvard Yard in a modest Beaux-Arts building designed by Richard Morris Hunt, twenty-one years after the President and Fellows of Harvard College appointed Charles Eliot Norton the first professor of art history in America." + "\n\n" +
                "It was made possible when, in 1891, Mrs. Elizabeth Fogg gave a gift in memory of her husband to build “an Art Museum to be called and known as the William Hayes Fogg Museum of Harvard College." + "\n\n" +
                "In 1927, the Fogg Museum moved to its home at 32 Quincy Street." + "\n\n" +
                "Designed by architects Coolidge, Shepley, Bulfinch, and Abbott of Boston, the joint art museum and teaching facility was the first purpose-built structure for the specialized training of art scholars, conservators, and museum professionals in North America." + "\n\n" +
                "With an early collection that consisted largely of plaster casts and photographs, the Fogg Museum is now renowned for its holdings of Western paintings, sculpture, decorative arts, photographs, prints, and drawings dating from the Middle Ages to the present.");
        return museum;
    }

}