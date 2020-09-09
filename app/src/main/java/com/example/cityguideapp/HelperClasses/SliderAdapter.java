package com.example.cityguideapp.HelperClasses;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewpager.widget.PagerAdapter;

import com.example.cityguideapp.R;

public class SliderAdapter extends PagerAdapter {

    Context context;
    LayoutInflater inflater;

    public SliderAdapter(Context context) {
        this.context = context;
    }

    int images[] = {
            R.drawable.search,
            R.drawable.phone_call,
            R.drawable.relax,
            R.drawable.add_location
    };

    int headings[] = {
            R.string.slider_one_title,
            R.string.slider_two_title,
            R.string.slider_three_title,
            R.string.slider_four_title
    };

    int descriptions[] = {
            R.string.slider_one_desc,
            R.string.slider_two_desc,
            R.string.slider_third_desc,
            R.string.slider_four_desc
    };

    @Override
    public int getCount() {
        return headings.length;
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return view == (ConstraintLayout) object;
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {
        ImageView slider_image;
        TextView slider_title;
        TextView slider_desc;

        inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view = inflater.inflate(R.layout.slides_layout, container, false);

        slider_image = view.findViewById(R.id.slider_image);
        slider_title = view.findViewById(R.id.slider_title);
        slider_desc = view.findViewById(R.id.slider_desc);

        slider_image.setImageResource(images[position]);
        slider_title.setText(headings[position]);
        slider_desc.setText(descriptions[position]);

        container.addView(view);

        return view;
    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        container.removeView((ConstraintLayout) object);
    }
}
