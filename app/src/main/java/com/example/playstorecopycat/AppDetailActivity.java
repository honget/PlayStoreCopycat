package com.example.playstorecopycat;

import android.databinding.DataBindingUtil;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.playstorecopycat.databinding.ActivityAppDetailBinding;

public class AppDetailActivity extends AppCompatActivity {

    ActivityAppDetailBinding api;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        api = DataBindingUtil.setContentView(this, R.layout.activity_app_detail);

    }
}
