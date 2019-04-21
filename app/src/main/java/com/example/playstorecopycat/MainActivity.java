package com.example.playstorecopycat;

import android.databinding.DataBindingUtil;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.example.playstorecopycat.adapters.AppAdapter;
import com.example.playstorecopycat.databinding.ActivityMainBinding;
import com.example.playstorecopycat.datas.app;

import java.util.List;


public class MainActivity extends AppCompatActivity {

    List<app> appList;

    ActivityMainBinding binding;

    AppAdapter appAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = DataBindingUtil.setContentView(this, R.layout.activity_main);

        fillApps();

        appAdapter = new AppAdapter(MainActivity.this, appList);
        binding.appListView.setAdapter(appAdapter);

        //확인 버튼이 눌리면 "확인 버튼을 눌렀습니다." 라는 포스트를 띄워 봅시다.

        binding.btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, "확인 버튼을 눌렀습니다.", Toast.LENGTH_SHORT).show();
            }
        });
    }

    public void fillApps(){
//        appList.add(new app(1, "아스팔트 8: 에어본", "GameLoft", 5, 6000, true));
//        appList.add(new app(2, "MineCraft - Pocket Edition", "Mojang", 4, 5000, true));
//        appList.add(new app(3, "아스팔트 7: 하트", "GameLoft", 2, 1000, false));
//        appList.add(new app(4, "팔라독(Paladog)", "FazeCat", 3, 1087, false));
//        appList.add(new app(5, "Plants Vs. Zombies", "EA Swiss Sarl", 1, 2000, false));
//        appList.add(new app(6, "스왐피(Swampy)", "Disney", 4, 3000, false));
        appList.add(new app(1, "아스팔트 8: 에어본", "GameLoft", 5, 6000));
        appList.add(new app(2, "MineCraft - Pocket Edition", "Mojang", 4, 5000));
        appList.add(new app(3, "아스팔트 7: 하트", "GameLoft", 2, 1000));
        appList.add(new app(4, "팔라독(Paladog)", "FazeCat", 3, 1087));
        appList.add(new app(5, "Plants Vs. Zombies", "EA Swiss Sarl", 1, 2000));
        appList.add(new app(6, "스왐피(Swampy)", "Disney", 4, 3000));


    }
}
