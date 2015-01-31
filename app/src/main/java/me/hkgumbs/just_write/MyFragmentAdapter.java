package me.hkgumbs.just_write;

import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

/**
 * Created by hkgumbs on 1/30/15.
 */
public class MyFragmentAdapter extends FragmentStatePagerAdapter {

    private int size;

    public MyFragmentAdapter(FragmentManager fm, int size) {
        super(fm);
        this.size = size;
    }

    @Override
    public ContentFragment getItem(int position) {
        ContentFragment fragment = new ContentFragment();
        Bundle arg = new Bundle();
        String value;
        if (position == 0)
            // first element gets empty argument for legacy reasons
            value = "";
        else
            value = Integer.toString(position);
        arg.putString("position", value);
        fragment.setArguments(arg);
        return fragment;
    }

    @Override
    public int getCount() {
        return size;
    }

    @Override
    public int getItemPosition(Object object) {
        if (object instanceof ContentFragment)
            ((ContentFragment) object).update();
        return super.getItemPosition(object);
    }
}