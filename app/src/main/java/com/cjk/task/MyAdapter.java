package com.cjk.task;

import android.content.Context;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

public class MyAdapter extends FragmentPagerAdapter {

    private final Context myContext;
    int totalTabs;

    public MyAdapter(Context context, FragmentManager fm, int totalTabs){
        super(fm);
        myContext = context;
        this.totalTabs = totalTabs;
    }
    @NonNull
    @Override
    public Fragment getItem(int position) {
        switch(position){
            case 0:
                FeedsFragment feedsFragment = new FeedsFragment();
                return  feedsFragment;
            case 1:
                AcademicsFragment academicsFragment =new AcademicsFragment();
                return  academicsFragment;
            case 2:
                ActivityFragment activityFragment = new ActivityFragment();
                return  activityFragment;
        }
        return null;
    }

    @Override
    public int getCount() {
        return totalTabs;
    }
}
