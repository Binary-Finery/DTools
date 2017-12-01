package spencerstudios.com.dtools;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.CardView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

/**
 * Created by User on 28/11/2017.
 */

public class Frag6 extends Fragment {

    Spinner spinner, spinner2;
    ArrayAdapter<String> adapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.frag6, container, false);

        spinner = (Spinner) rootView.findViewById(R.id.spinner);
        spinner2 = (Spinner) rootView.findViewById(R.id.spinner2);

        final String [] items = {"one person", "two people", "three people", "four people"};
        final String [] times = {"1pm - 2pm", "2pm - 3pm", "3pm - 4pm", "4pm - 5pm"};
        //ArrayAdapter<String> aa = new ArrayAdapter<>(rootView.getContext(), android.R.layout.simple_spinner_dropdown_item, items);
        //ArrayAdapter<String> aa2 = new ArrayAdapter<>(rootView.getContext(), android.R.layout.simple_spinner_dropdown_item, times);

        spinner.setAdapter(new ArrayAdapter<>(rootView.getContext(), android.R.layout.simple_spinner_dropdown_item, items));
        spinner2.setAdapter(new ArrayAdapter<>(rootView.getContext(), android.R.layout.simple_spinner_dropdown_item, times));

        return rootView;
    }
}
