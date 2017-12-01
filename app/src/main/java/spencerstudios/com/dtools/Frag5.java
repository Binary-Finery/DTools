package spencerstudios.com.dtools;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.AppCompatSeekBar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.SeekBar;
import android.widget.TextView;

import java.util.Locale;

public class Frag5 extends Fragment {

    private TextView tv;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.frag5, container, false);

        AppCompatSeekBar seek = (AppCompatSeekBar) rootView.findViewById(R.id.seekbar);
        seek.setMax(100);
        int DEF_PROG = 35;
        seek.setProgress(DEF_PROG);

        tv = (TextView) rootView.findViewById(R.id.tv_percent);
        tv.setText(String.format(Locale.getDefault(), "%d%s", DEF_PROG, "%"));

        seek.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                tv.setText(String.format(Locale.getDefault(), "%d%s", progress, "%"));
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
            }
        });
        return rootView;
    }
}