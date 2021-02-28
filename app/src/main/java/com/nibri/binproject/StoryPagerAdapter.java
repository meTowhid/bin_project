package com.nibri.binproject;


import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;

import java.util.ArrayList;
import java.util.List;

public class StoryPagerAdapter extends FragmentStatePagerAdapter {
    private final List<StoryData> storyData;
    private final StoryPageFragment.Callback onTimerFinishCallback;
    private final List<StoryPageFragment> fragments;

    public StoryPagerAdapter(FragmentManager fm, List<StoryData> storyData, StoryPageFragment.Callback onTimerFinishCallback) {
        super(fm, FragmentStatePagerAdapter.BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT);
        this.storyData = storyData;
        this.onTimerFinishCallback = onTimerFinishCallback;

        fragments = new ArrayList<>();
        for (StoryData story : storyData) {
            fragments.add(new StoryPageFragment(story, onTimerFinishCallback));
        }
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        return fragments.get(position);
    }

    @Override
    public int getCount() {
        return storyData.size();
    }

    public void loadPage(int position) {
        System.out.println("starting timer for page: " + position);
        for (int i = 0; i < fragments.size(); i++) {
            if (i == position) fragments.get(i).startTimer();
            else fragments.get(i).resetAll();
        }
    }
}
