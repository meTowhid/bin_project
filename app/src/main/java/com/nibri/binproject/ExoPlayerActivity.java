package com.nibri.binproject;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.exoplayer2.MediaItem;
import com.google.android.exoplayer2.SimpleExoPlayer;
import com.google.android.exoplayer2.ui.PlayerView;

public class ExoPlayerActivity extends AppCompatActivity {

    private PlayerView playerView;
    private SimpleExoPlayer player;
    private String mp4Url = "https://html5demos.com/assets/dizzy.mp4";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exo_player);
        playerView = findViewById(R.id.video_view);
    }

    @Override
    protected void onStart() {
        super.onStart();
        initPlayer();
    }

    private void initPlayer() {
        player = new SimpleExoPlayer.Builder(this).build();
        playerView.setPlayer(player);

        MediaItem mediaItem = MediaItem.fromUri(mp4Url);
        player.setMediaItem(mediaItem);
    }
}
