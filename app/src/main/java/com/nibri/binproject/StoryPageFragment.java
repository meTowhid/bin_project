package com.nibri.binproject;

import android.os.Bundle;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.bumptech.glide.Glide;
import com.nibri.binproject.model.StoryData;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Timer;
import java.util.TimerTask;

public class StoryPageFragment extends Fragment {

    private final StoryData story;
    private final Callback callback;

    private final LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(
            LinearLayout.LayoutParams.MATCH_PARENT,
            LinearLayout.LayoutParams.MATCH_PARENT,
            1.0f);

    ImageView ivSlide, ivProfile;
    TextView tvTitle, tvSubTitle;

    List<ProgressBar> progressIndicators;
    private final int perImageDelayInMileSeconds = 5000;
    private int currentImageIndex = 0;
    private long startTime;

    private Timer playTimer;
    private final Handler mTimerHandler = new Handler();

    public StoryPageFragment(StoryData story, Callback callback) {
        this.story = story;
        this.callback = callback;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_story_page, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initView(view);
    }

    public void initView(View view) {
        ivSlide = view.findViewById(R.id.iv_slide);
        ivProfile = view.findViewById(R.id.iv_profile);
        tvTitle = view.findViewById(R.id.tv_title);
        tvSubTitle = view.findViewById(R.id.tv_subtitle);

        view.findViewById(R.id.viewNext).setOnClickListener((v) -> {
            if (currentImageIndex == story.images.size() - 1) {
                callback.onTimerFinishCallback(true);
                resetAll();
            } else {
                currentImageIndex++;
                startTime = System.currentTimeMillis() - currentImageIndex * perImageDelayInMileSeconds;
                loadImage();
                startTimer();
            }
        });

        view.findViewById(R.id.viewPrev).setOnClickListener((v) -> {
            if (currentImageIndex == 0) {
                callback.onTimerFinishCallback(false);
                resetAll();
            } else {
                currentImageIndex--;
                startTime = System.currentTimeMillis() - currentImageIndex * perImageDelayInMileSeconds;
                loadImage();
                startTimer();
            }
        });

        String profile = "https://www.pinclipart.com/picdir/middle/221-2214756_lim-green-screen-circle-png-clipart.png";
        Glide.with(Objects.requireNonNull(getContext())).load(profile).into(ivProfile);
        buildProgressIndicators(view);
        tvTitle.setText(story.title);
        loadImage();
    }

    private void loadImage() {
        String url = story.images.get(currentImageIndex);
        Glide.with(Objects.requireNonNull(getContext())).load(url).into(ivSlide);
    }

    private void updateIndicators() {
        long elapsedTime = System.currentTimeMillis() - startTime;
//        System.out.println("elapsed time: " + elapsedTime + ", currentImage: " + (currentImageIndex + 1) + "/" + story.images.size());


        if (elapsedTime >= perImageDelayInMileSeconds * story.images.size()) {
            resetAll();
            callback.onTimerFinishCallback(true);
            System.out.println("timer finished");
            return;
        } else if (elapsedTime > (currentImageIndex + 1) * perImageDelayInMileSeconds) {
            currentImageIndex++;
            loadImage();
            System.out.println("changing image to: " + currentImageIndex);
        }

        if (progressIndicators == null) {
            System.out.println("Null progress indicators");
            return;
        }

        for (int i = 0; i < progressIndicators.size(); i++) {
            if (currentImageIndex == i) {
                double elapsedTimeForImage = elapsedTime - perImageDelayInMileSeconds * currentImageIndex;
                int progress = (int) ((elapsedTimeForImage / perImageDelayInMileSeconds) * 100.0);
                progressIndicators.get(i).setProgress(progress);
//                System.out.println("progress: " + progress + ", elapsedTimeForImage: " + elapsedTimeForImage);
            } else
                progressIndicators.get(i).setProgress(currentImageIndex > i ? 100 : 0);
        }
    }


    public void buildProgressIndicators(View view) {
        LinearLayout progressViewHolder = view.findViewById(R.id.ll_progress);
        progressIndicators = new ArrayList<>();
        if (story.images.size() == 0) progressViewHolder.setVisibility(View.INVISIBLE);
        else for (int i = 0; i < story.images.size(); i++) {
            View pbView = LayoutInflater.from(view.getContext()).inflate(R.layout.view_story_progress, null, false);
            pbView.setLayoutParams(params);
            progressViewHolder.addView(pbView);
            progressIndicators.add(pbView.findViewById(R.id.pb));
        }
    }

    public void startTimer() {
        System.out.println("starting timer");
        if (playTimer != null) return; // timer is already running
        System.out.println("timer already started!");

        startTime = System.currentTimeMillis();

        playTimer = new Timer();
        TimerTask timerTask = new TimerTask() {
            public void run() {
                mTimerHandler.post(() -> updateIndicators());
            }
        };

        playTimer.schedule(timerTask, 1, 25);
    }

    private void stopTimer() {
        if (playTimer != null) {
            playTimer.cancel();
            playTimer.purge();
            playTimer = null;
        }
    }

    @Override
    public void onPause() {
        super.onPause();
        resetAll();
    }

    public void resetAll() {
        stopTimer();
        currentImageIndex = 0;
    }

    public interface Callback {
        void onTimerFinishCallback(boolean isForeword);
    }
}

