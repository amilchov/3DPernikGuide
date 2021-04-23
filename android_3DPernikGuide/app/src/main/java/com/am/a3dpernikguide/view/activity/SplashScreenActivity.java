package com.am.a3dpernikguide.view.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;

import androidx.appcompat.app.AppCompatActivity;

import com.am.a3dpernikguide.PernikGuideApplication;
import com.am.a3dpernikguide.R;
import com.am.a3dpernikguide.databinding.ActivitySplashScreenBinding;
import com.am.a3dpernikguide.db.PernikGuideDatabase;
import com.am.a3dpernikguide.model.db.ModelEntry;
import com.am.a3dpernikguide.util.manager.DataManager;
import com.am.a3dpernikguide.util.manager.SharedPreferencesManager;

import java.util.List;

/**
 * @author Created by Aleks Vasilev Milchov
 */

public class SplashScreenActivity extends AppCompatActivity {

    private ActivitySplashScreenBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);
        binding = ActivitySplashScreenBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        //set animation
        Animation animation = AnimationUtils.loadAnimation(this, R.anim.fade);
        binding.ivLogo.startAnimation(animation);

        //instance for the local database
        PernikGuideDatabase database = PernikGuideDatabase.getDatabase(PernikGuideApplication.getContext());

        //Create a local database if it does not exist
        if (database.modelDao().loadModel() == null) {
            DataManager.addModelsToDatabase();
        }

        //Create new thread for splash screen
        Thread timer = new Thread(){
            public void run(){
                try {
                    sleep(3000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    if(SharedPreferencesManager.isUserLogged(getApplicationContext()))
                    {
                        startActivity(new Intent(SplashScreenActivity.this, MainActivity.class));
                        finish();
                    }else {
                        startActivity(new Intent(SplashScreenActivity.this, LoginActivity.class));
                        finish();
                    }
                }
            }
        };
        timer.start();

    }
}
