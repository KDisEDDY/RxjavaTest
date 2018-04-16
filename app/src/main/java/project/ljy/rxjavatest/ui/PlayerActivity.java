package project.ljy.rxjavatest.ui;

import android.os.Bundle;
import android.support.annotation.Nullable;

import project.ljy.rxjavatest.R;
import project.ljy.rxjavatest.VideoPlayerListener;
import project.ljy.rxjavatest.base.BaseActivity;
import project.ljy.rxjavatest.base.BaseConstant;
import project.ljy.rxjavatest.widget.IJKVideoPlayer;
import tv.danmaku.ijk.media.player.IMediaPlayer;

/**
 * Title: PlayerActivity
 * Description: 播放器activity
 * Copyright: Copyright (c) 2014-2016 gjfax.com
 * Company: 广金所
 * Author: 刘加彦
 * Date: 2018/4/16
 * Version: 1.0
 */

public class PlayerActivity extends BaseActivity{

    private IJKVideoPlayer mPlayer;


    @Override
    public int setSubContentView() {
        return R.layout.activity_player;
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initTitle("登录", BaseConstant.STYLE_RETURN_BACK);
        mPlayer = (IJKVideoPlayer) findViewById(R.id.view_ijk_player);
        mPlayer.setListener(new VideoPlayerListener() {
            @Override
            public void onBufferingUpdate(IMediaPlayer iMediaPlayer, int i) {

            }

            @Override
            public void onCompletion(IMediaPlayer iMediaPlayer) {

            }

            @Override
            public boolean onError(IMediaPlayer iMediaPlayer, int i, int i1) {
                return false;
            }

            @Override
            public boolean onInfo(IMediaPlayer iMediaPlayer, int i, int i1) {
                return false;
            }

            @Override
            public void onPrepared(IMediaPlayer iMediaPlayer) {
                mPlayer.start();
            }

            @Override
            public void onSeekComplete(IMediaPlayer iMediaPlayer) {

            }

            @Override
            public void onVideoSizeChanged(IMediaPlayer iMediaPlayer, int i, int i1, int i2, int i3) {

            }
        });
    }
}
