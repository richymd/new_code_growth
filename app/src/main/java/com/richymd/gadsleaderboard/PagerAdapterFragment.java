package com.richymd.gadsleaderboard;

import android.content.Context;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import org.jetbrains.annotations.NotNull;

public class PagerAdapterFragment extends FragmentPagerAdapter {

    private Context mContext;

    public PagerAdapterFragment(Context context, FragmentManager fragmentManager) {
        super(fragmentManager);
        mContext = context;
    }

    @NotNull
    @Override
    public Fragment getItem(int position) {
        if (position == 0) {
            return new LearningFragment();
        } else
            return new SkillFragment();
    }

    @Override
    public int getCount() {
        return 2;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        if (position == 0) {
            return mContext.getString(R.string.learning_fragment_text);
        } else
            return mContext.getString(R.string.skill_fragment_text);
    }

}
