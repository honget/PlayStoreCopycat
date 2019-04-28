package com.example.playstorecopycat;

import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.playstorecopycat.databinding.ActivityAppDetailBinding;

public class FillterActivity extends AppCompatActivity {

    ActivityAppDetailBinding act;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        act = DataBindingUtil.setContentView(this, R.layout.activity_fillter);

        act.launchBtn.getText();

        double minRation = Double.parseDouble("1.5");
//        act.
//        Intent intent = new Intent(FillterActivity.this, MainActivity.class);
//        intent

        //메인으로 돌아가기
        Intent resultIntent = new Intent();

        //결과 전달
        resultIntent.putExtra("최소 평점", minRation);

        /** finish 하니 전 결과를 설정
         *  완료값
         *  전달값
         */
        setResult(RESULT_OK, resultIntent);

        //모든 설정 끝났으니 화면 닫음
        finish();

    }
}
