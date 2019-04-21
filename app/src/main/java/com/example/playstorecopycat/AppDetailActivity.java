package com.example.playstorecopycat;

import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.example.playstorecopycat.databinding.ActivityAppDetailBinding;
import com.example.playstorecopycat.datas.Appli;

public class AppDetailActivity extends AppCompatActivity {

    Appli appData;

    ActivityAppDetailBinding act;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        act = DataBindingUtil.setContentView(this, R.layout.activity_app_detail);

        appData = (Appli) getIntent().getSerializableExtra("APP_DATA");

//        String appTitle = getIntent().getStringExtra("title");
//        String comName = getIntent().getStringExtra("comName");
//        double userRating = getIntent().getDoubleExtra("userRating", 1);
//        boolean isMine = getIntent().getBooleanExtra("isMine", false);
//        int price = getIntent().getIntExtra("price", 0);
//
//        act.appTitleTxtV.setText(appTitle);
//        act.comNameTxt.setText(comName);
//        act.userRating.setText(String.valueOf(userRating));

        act.appTitleTxtV.setText(appData.getTitle());
        act.comNameTxt.setText(appData.getCompanyName());
        act.userRating.setText(String.format("%1f 점", appData.getUserRating()));

        // 구매 여부에 따라 버튼 보이기
        if(appData.isMine()){
            act.removeBtn.setVisibility(View.VISIBLE);
            act.launchBtn.setVisibility(View.VISIBLE);
            act.buyBtn.setVisibility(View.GONE);
        }else{
            act.removeBtn.setVisibility(View.GONE);
            act.launchBtn.setVisibility(View.GONE);
            act.buyBtn.setVisibility(View.VISIBLE);

            act.buyBtn.setText(String.format("구매하기(%,d원)", appData.getPrice()));
        }


        //버튼 기능 추가
        act.dialBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Uri phoneUri =  Uri.parse("tel:010-1234-5678");

                Intent intent = new Intent(Intent.ACTION_DIAL, phoneUri);

                startActivity(intent);

            }
        });

        act.smsBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        act.goWebBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
    }
}
