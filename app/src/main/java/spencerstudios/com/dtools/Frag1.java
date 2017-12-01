package spencerstudios.com.dtools;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.CardView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class Frag1 extends Fragment {

    CardView cv;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.frag1, container, false);

        cv = (CardView)rootView.findViewById(R.id.cv);
        return rootView;
    }
}