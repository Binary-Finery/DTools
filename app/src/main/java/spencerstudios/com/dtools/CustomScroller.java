package spencerstudios.com.dtools;

import android.content.Context;
import android.widget.Scroller;


class CustomScroller extends Scroller {

    CustomScroller(Context context) {
        super(context);
    }

    @Override
    public void startScroll(int startX, int startY, int dx, int dy, int duration) {
        int mDuration = 750;
        super.startScroll(startX, startY, dx, dy, mDuration);
    }
}
