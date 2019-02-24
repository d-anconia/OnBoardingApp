package app.onboarding.com.onboardingapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.viewpager.widget.PagerAdapter;

public class SliderAdapter extends PagerAdapter {

    Context context;
    LayoutInflater layoutInflater;

    public SliderAdapter(Context context) {
        this.context = context;
    }

    public int[] slideImages = {

            R.drawable.eat_icon,
            R.drawable.sleep_icon,
            R.drawable.code_icon
    };

    public String[] slideHeadings = {
            "EAT",
            "SLEEP",
            "CODE"
    };

    public String[] slideDescs = {
            "Lorem ipsum dolor sit amet, consectetur adipiscing elit. In tristique magna et iaculis gravida. Duis bibendum lorem ante, et cursus.",
            "Lorem ipsum dolor sit amet, consectetur adipiscing elit. In tristique magna et iaculis gravida. Duis bibendum lorem ante, et cursus.",
            "Lorem ipsum dolor sit amet, consectetur adipiscing elit. In tristique magna et iaculis gravida. Duis bibendum lorem ante, et cursus."
    };

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {

        layoutInflater = (LayoutInflater) context.getSystemService(context.LAYOUT_INFLATER_SERVICE);
        View view = layoutInflater.inflate(R.layout.slide_layout, container, false);

        ImageView slideImageView =(ImageView) view.findViewById(R.id.slideImage);
        TextView slideHeadingView = (TextView) view.findViewById(R.id.heading);
        TextView slideDescView = (TextView) view.findViewById(R.id.description);

        slideImageView.setImageResource(slideImages[position]);
        slideHeadingView.setText(slideHeadings[position]);
        slideDescView.setText(slideDescs[position]);

        container.addView(view);

        return view;

    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {

        container.removeView((RelativeLayout) object);

    }

    @Override
    public int getCount() {
        return slideHeadings.length;
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return view == (RelativeLayout) object;
    }
}
