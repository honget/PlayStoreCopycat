package com.example.playstorecopycat;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.DatePicker;
import android.widget.TimePicker;
import android.widget.Toast;

import com.example.playstorecopycat.databinding.ActivityAppDetailBinding;
import com.example.playstorecopycat.datas.Appli;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;

public class AppDetailActivity extends AppCompatActivity {

    Appli appData;

    ActivityAppDetailBinding act;

    int hour = 3;
    int min = 15;
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
        act.userRating.setText(String.format("%.1f 점", appData.getUserRating()));

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

        act.dateTxt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d("텍스트 뷰 클릭!", "동작 확인용!!!!!");

                //날짜
                DatePickerDialog dpd = new DatePickerDialog(AppDetailActivity.this, new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {

                        //Toast.makeText(AppDetailActivity.this, String.format("%d년 %월 %일 ", year, month + 1, dayOfMonth), Toast.LENGTH_SHORT);

                        //new Calendar 라고 만들지 않는다. 싱글턴 패턴의 일종
                        Calendar cal = Calendar.getInstance();

                        /**
                         * 같은 메소드인데 값에 따라 행동 다름 => overloading 의 예시
                         */
                        //1. 항목별  세팅
                        cal.set(Calendar.YEAR, year);
                        cal.set(Calendar.MONTH, month);
                        cal.set(Calendar.DAY_OF_MONTH, dayOfMonth);

                        //2. 일괄 세팅
                        cal.set(year, month, dayOfMonth);

                        //cal 에 저장된 정보를 출력
                        //날짜를 양식으로 바꾸고 싶을때  SimpleDateFormat 사용

                        //어떤 양식으로 문자를 출력할지 양식 지정
                        SimpleDateFormat sdf = new SimpleDateFormat("YYYY년 M월 d일");

                        //양식으로 String 출력
                        String dataSrt = sdf.format(cal.getTimeInMillis());

                        //화면에 출력
                        act.dateTxt.setText(dataSrt);
                    }
                    //초기 출력 값
                }, 2019, 4 - 1, 27);

                dpd.show();
            }
        });

        act.timeTxt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TimePickerDialog tpd = new TimePickerDialog(AppDetailActivity.this, new TimePickerDialog.OnTimeSetListener() {
                    @Override
                    public void onTimeSet(TimePicker view, int hourOfDay, int minute) {

                        hour = hourOfDay;
                        min = minute;

                        Calendar cal = Calendar.getInstance();

                        cal.set(Calendar.HOUR_OF_DAY, hourOfDay);
                        cal.set(Calendar.MINUTE, minute);

                        SimpleDateFormat sdf = new SimpleDateFormat("a h시 m분", Locale.KOREA);

                        String timeStr = sdf.format(cal.getTimeInMillis());

                        act.timeTxt.setText(timeStr);


                    }
                }, hour, min, true);

                tpd.show();
            }
        });

    }
}
