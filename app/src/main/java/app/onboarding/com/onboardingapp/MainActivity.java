package app.onboarding.com.onboardingapp;

import android.os.Bundle;
import android.text.Html;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

public class MainActivity extends AppCompatActivity {

    private ViewPager sliderViewPager;
    private LinearLayout dotLayout;

    private TextView[] dots;
    private SliderAdapter sliderAdapter;

    private Button nextButton;
    private Button backButton;

    private int currentPage;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        sliderViewPager = (ViewPager) findViewById(R.id.slideViewPager);
        dotLayout = (LinearLayout) findViewById(R.id.dotsLayout);

        nextButton = (Button) findViewById(R.id.nextBtn);
        backButton = (Button) findViewById(R.id.prevBtn);


        sliderAdapter = new SliderAdapter(this);

        sliderViewPager.setAdapter(sliderAdapter);

        addDotsIndiicatior(0);

        sliderViewPager.addOnPageChangeListener(viewListener);

        nextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                sliderViewPager.setCurrentItem(currentPage + 1);
            }
        });

        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                sliderViewPager.setCurrentItem(currentPage - 1);
            }
        });

    }

    public void addDotsIndiicatior(int position) {

        dots = new TextView[3];
        dotLayout.removeAllViews();

        for (int i = 0; i < dots.length; i++) {

            dots[i] = new TextView(this);
            dots[i].setText(Html.fromHtml("&#8226"));
            dots[i].setTextSize(35);
            dots[i].setTextColor(getResources().getColor(R.color.colorTransparentWhite));

            dotLayout.addView(dots[i]);
        }

        if (dots.length > 0) {
            dots[position].setTextColor(getResources().getColor(R.color.colorWhite));
        }
    }

    ViewPager.OnPageChangeListener viewListener = new ViewPager.OnPageChangeListener() {
        @Override
        public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

        }

        @Override
        public void onPageSelected(int position) {
            addDotsIndiicatior(position);

            currentPage = position;

            if (position == 0) {
                backButton.setEnabled(false);
                nextButton.setEnabled(true);
                backButton.setVisibility(View.INVISIBLE);

                nextButton.setText("Next");
                backButton.setText("");
            } else if (position == dots.length - 1) {

                backButton.setEnabled(true);
                backButton.setVisibility(View.VISIBLE);
                nextButton.setEnabled(true);

                nextButton.setText("Finish");
                backButton.setText("Back");
            } else {

                backButton.setEnabled(true);
                nextButton.setEnabled(true);
                backButton.setVisibility(View.VISIBLE);

                nextButton.setText("Next");
                backButton.setText("Back");
            }
        }

        @Override
        public void onPageScrollStateChanged(int state) {

        }
    };
}
