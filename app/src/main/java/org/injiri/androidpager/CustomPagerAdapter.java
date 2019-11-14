package org.injiri.androidpager;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewpager.widget.PagerAdapter;

class CustomPagerAdapter extends PagerAdapter {

    Context currentContext;


    public CustomPagerAdapter(Context context) {

        this.currentContext = context;
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {

        PagerEnum pagerEnum = PagerEnum.values()[position];
        LayoutInflater inflater = LayoutInflater.from(currentContext);
        ViewGroup layout = (ViewGroup) inflater.inflate(pagerEnum.getLayoutResId(), container, false);
        container.addView(layout);
        return layout;

    }

    @Override
    public int getCount() {
        return PagerEnum.values().length;
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return false;
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        PagerEnum pagerEnum = PagerEnum.values()[position];
        return currentContext.getString(pagerEnum.getTitleResId());
    }

    ;
}
