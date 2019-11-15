import android.content.Context;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewpager.widget.PagerAdapter;

import java.util.List;

/**
 * Creating a viewPager by extending the  PagerAdapter instead of
 * creating fragments... create custom views and pass  it to the pager class
 * That makes the views to independent of  lifecycle callbacks.
 */

public class PagerClass extends PagerAdapter {

    List<View> views;
    Context currentContext;

    public PagerClass(List<View> views, Context currentContext) {
        this.views = views;
        this.currentContext = currentContext;
    }

    public View getView(int position) {
        return views.get(position);
    }

    @Override
    public int getCount() {
        return views.size();
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return view == object;
    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        container.removeView(views.get(position));
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {

        View view = views.get(position);
        container.addView(view);
        return view;
    }

    @Override
    public int getItemPosition(@NonNull Object object) {
        for (int index = 0; index < getCount(); index++) {
            if ((View) object == views.get(index)) {
                return index;
            }
        }

        return POSITION_NONE;
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        return "View" +(position+1);
    }
}

