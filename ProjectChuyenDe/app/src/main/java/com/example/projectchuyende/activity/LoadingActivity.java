package com.example.projectchuyende.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.projectchuyende.MainActivity;
import com.example.projectchuyende.R;

public class LoadingActivity extends AppCompatActivity {
    private ImageView imageView;
    private Thread mThread;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.load_activity);
        imageView = findViewById(R.id.load);
        startAnimation();
    }
    private  void startAnimation()
    {
        Animation bg = AnimationUtils.loadAnimation(this, R.anim.bg_circle_rotate);
        imageView.setAnimation(bg);
        // ham chay animation
        mThread = new Thread() {
            @Override
            public void run() {
                super.run();
                int waited = 0;
                //thoi gian load
                while (waited < 2000) {
                    try {
                        sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    waited += 100;
                }
                LoadingActivity.this.finish();
                Intent intent = new Intent(LoadingActivity.this, MainActivity.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
                startActivity(intent);
            }
        };
        mThread.start();
    }
}
