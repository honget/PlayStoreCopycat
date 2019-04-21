package com.example.playstorecopycat;

import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Toast;

import com.example.playstorecopycat.adapters.AppAdapter;
import com.example.playstorecopycat.databinding.ActivityMainBinding;
import com.example.playstorecopycat.datas.Appli;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class MainActivity extends AppCompatActivity {

    List<Appli> appList = new ArrayList<>();

    ActivityMainBinding binding;

    AppAdapter appAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = DataBindingUtil.setContentView(this, R.layout.activity_main);

        //확인 버튼이 눌리면 "확인 버튼을 눌렀습니다." 라는 포스트를 띄워 봅시다.

        binding.btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, "확인 버튼을 눌렀습니다.", Toast.LENGTH_SHORT).show();
            }
        });

        fillApps();

        appAdapter = new AppAdapter(MainActivity.this, appList);

        binding.appListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                //Toast.makeText(MainActivity.this, String.format("%d 번째 줄이 눌렸습니다.", position), Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(MainActivity.this, AppDetailActivity.class);

//                intent.putExtra("APP_DATA", appList.get(position));
                Appli appData = appList.get(position);

//                intent.putExtra("title", appData.getTitle());
//                intent.putExtra("comName", appData.getCompanyName());
//                intent.putExtra("userRating", appData.getUserRating());
//                intent.putExtra("isMine", appData.isMine());
//                intent.putExtra("price", appData.getPrice());

                Map<String, Object> aa = new HashMap<>();
                intent.putExtra("APP_DATA", appData);


                startActivity(intent);
            }
        });

        binding.appListView.setAdapter(appAdapter);


        binding.appListView.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {

                Toast.makeText(MainActivity.this, String.format("%d 번째 줄을 오래  눌름", position), Toast.LENGTH_SHORT).show();

                return false;
            }
        });
    }

    public void fillApps(){
        appList.add(new Appli(1, "아스팔트 8: 에어본", "GameLoft", 5, 6000, true));
        appList.add(new Appli(2, "MineCraft - Pocket Edition", "Mojang", 4, 5000, true));
        appList.add(new Appli(3, "아스팔트 7: 하트", "GameLoft", 2, 1000, false));
        appList.add(new Appli(4, "팔라독(Paladog)", "FazeCat", 3, 1087, false));
        appList.add(new Appli(5, "Plants Vs. Zombies", "EA Swiss Sarl", 1, 2000, false));
        appList.add(new Appli(6, "스왐피(Swampy)", "Disney", 4, 3000, false));
    }
}
