package com.nibri.binproject;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.net.Uri;
import android.os.Bundle;
import android.view.View;

import com.google.android.exoplayer2.MediaItem;
import com.google.android.exoplayer2.SimpleExoPlayer;
import com.google.android.exoplayer2.ui.StyledPlayerView;
import com.nibri.binproject.databinding.ActivityVideoPlayerBinding;

public class VideoPlayerActivity extends AppCompatActivity {
    ActivityVideoPlayerBinding binding;
    SimpleExoPlayer player;
    String STREAM_URL = "http://clips.vorwaerts-gmbh.de/big_buck_bunny.mp4";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_video_player);



    }

    private void initializePlayer() {
        player = new SimpleExoPlayer.Builder(this).build();
        MediaItem mediaItem = MediaItem.fromUri(Uri.parse(STREAM_URL));
        player.setMediaItem(mediaItem);
        player.setPlayWhenReady(true);
        player.prepare();
        binding.videoView.setPlayer(player);
    }

    private void hideSystemUi() {
        binding.videoView.setSystemUiVisibility(View.SYSTEM_UI_FLAG_LOW_PROFILE
                | View.SYSTEM_UI_FLAG_FULLSCREEN
                | View.SYSTEM_UI_FLAG_LAYOUT_STABLE
                | View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY
                | View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
                | View.SYSTEM_UI_FLAG_HIDE_NAVIGATION);
    }

    @Override
    protected void onStart() {
        super.onStart();
        initializePlayer();
    }

    @Override
    protected void onStop() {
        super.onStop();
    }

    @Override
    protected void onResume() {
        super.onResume();
        hideSystemUi();

        initializePlayer();
    }

    @Override
    protected void onPause() {
        super.onPause();
    }
}