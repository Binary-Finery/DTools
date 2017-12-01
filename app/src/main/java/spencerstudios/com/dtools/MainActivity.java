package spencerstudios.com.dtools;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageButton;

import com.pixelcan.inkpageindicator.InkPageIndicator;

import java.lang.reflect.Field;

public class MainActivity extends AppCompatActivity {

    private ImageButton next, prev;
    private ViewPager viewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        if (getSupportActionBar() != null) getSupportActionBar().hide();

        prev = (ImageButton) findViewById(R.id.prev);
        next = (ImageButton) findViewById(R.id.next);

        prev.setVisibility(View.INVISIBLE);

        SectionsPagerAdapter mSectionsPagerAdapter = new SectionsPagerAdapter(getSupportFragmentManager());

        viewPager = (ViewPager) findViewById(R.id.container);
        viewPager.setAdapter(mSectionsPagerAdapter);
        viewPager.setPageTransformer(true, new PageAnimator());

        try {
            Field mScroller = ViewPager.class.getDeclaredField("mScroller");
            mScroller.setAccessible(true);
            mScroller.set(viewPager, new CustomScroller(MainActivity.this));
        } catch (NoSuchFieldException | IllegalAccessException e) {
            e.printStackTrace();
        }

        InkPageIndicator inkPageIndicator = (InkPageIndicator) findViewById(R.id.indicator);
        inkPageIndicator.setViewPager(viewPager);

        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
            }

            @Override
            public void onPageSelected(int position) {
                switch (position) {
                    case 0:
                        prev.setVisibility(View.INVISIBLE);
                        break;
                    case 1:
                        prev.setVisibility(View.VISIBLE);
                        break;
                    case 5:
                        next.setVisibility(View.INVISIBLE);
                        break;
                    case 4:
                        next.setVisibility(View.VISIBLE);
                        break;
                }
            }

            @Override
            public void onPageScrollStateChanged(int state) {
            }
        });
    }

    private class SectionsPagerAdapter extends FragmentPagerAdapter {
        SectionsPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            switch (position) {
                case 0:
                    return new Frag1();
                case 1:
                    return new Frag2();
                case 2:
                    return new Frag3();
                case 3:
                    return new Frag4();
                case 4:
                    return new Frag5();
                case 5:
                    return new Frag6();
                default:
                    return null;
            }
        }

        @Override
        public int getCount() {
            return 6;
        }
    }

    public void clickEvent(View v) {
        viewPager.setCurrentItem(v.getId() == R.id.next ?
                viewPager.getCurrentItem() + 1 : viewPager.getCurrentItem() - 1);
    }
}
