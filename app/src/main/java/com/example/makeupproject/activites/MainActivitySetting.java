package com.example.makeupproject.activites;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.example.makeupproject.R;

import fragments.settingFragment;

public class MainActivitySetting extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main_setting);
        FrameLayout fm = findViewById(R.id.fm);
        settingFragment newSettingFragment = new settingFragment();
        FragmentManager myFragmentManager= getSupportFragmentManager();
        FragmentTransaction fragmentTransaction=myFragmentManager.beginTransaction();
        fragmentTransaction.add(R.id.fm,newSettingFragment);
        fragmentTransaction.commit();

    }
}