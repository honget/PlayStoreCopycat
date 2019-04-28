package com.example.playstorecopycat;

import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.example.playstorecopycat.databinding.ActivityAppDetailBinding;
import com.example.playstorecopycat.databinding.ActivityFillterBinding;

public class FillterActivity extends AppCompatActivity {

    ActivityFillterBinding act;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        act = DataBindingUtil.setContentView(this, R.layout.activity_fillter);


        act.okBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //값 가져오기
                double minRation = Double.parseDouble(act.minRation.getSelectedItem().toString());

                //기존
//              Intent intent = new Intent(FillterActivity.this, MainActivity.class);

                //메인으로 돌아가기
                Intent resultIntent = new Intent();

                //결과 전달
                resultIntent.putExtra("MIN_RATION", minRation);

                /** finish 하니 전 결과를 설정
                 *  완료값
                 *  전달값
                 */
                setResult(RESULT_OK, resultIntent);

                //모든 설정 끝났으니 화면 닫음
                finish();

            }
        });

    }
}
