package com.example.playstorecopycat;

import android.databinding.DataBindingUtil;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.playstorecopycat.databinding.ActivityMainBinding;
import com.example.playstorecopycat.datas.app;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    List<app> appList;

    ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = DataBindingUtil.setContentView(this, R.layout.activity_main);

        fillApps();
    }

    public void fillApps(){
        appList.add(new app(1, "아스팔트 8","gameLoft", 4.5, 8000, true));
        appList.add(new app(2, "마인크래프트","Mojang", 3.5, 800, false));
        appList.add(new app(3, "아스팔트 7 하트","회사", 2, 8020, false));
        appList.add(new app(4, "팔라독","팔라독 회사", 1, 1000, false));
        appList.add(new app(5, "식물 대 좀비","EA 스포트", 3, 123600, false));
        appList.add(new app(6, "스왐피","gameLoft", 2, 19000, false));
        appList.add(new app(7, "앵그리 버트","gameLoft", 5, 3000, false));
    }
}
