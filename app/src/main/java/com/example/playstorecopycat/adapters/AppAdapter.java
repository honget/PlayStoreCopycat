package com.example.playstorecopycat.adapters;

import android.content.Context;
import android.databinding.DataBindingUtil;
import android.icu.util.Calendar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.playstorecopycat.R;
import com.example.playstorecopycat.datas.Appli;

import java.util.ArrayList;
import java.util.List;

public class AppAdapter extends ArrayAdapter<Appli> {

    List<Appli> appList;
    Context context;

    LayoutInflater inf;

    public AppAdapter(Context context, List<Appli> appList){

        super(context, R.layout.app_item_list, appList);

        this.appList = appList;
        this.context = context;

        //어느 화면에서 그릴지 적용
        inf = LayoutInflater.from(context);
    }

    @Override
    public View getView(int position, View row, ViewGroup parent) {

        if(row == null){
            row = inf.inflate(R.layout.app_item_list, null);
        }

        //실질적으로 상황에 맞게 머리를 써야 하는 부분

        //앱 리스트에서 해당 줄의 데이터 뽑음
        Appli appData = appList.get(position);

        //아이디 찾기
        TextView rankAndTitleTxtV = row.findViewById(R.id.rankAndTitleTxtV);
        TextView companyNameTxtV = row.findViewById(R.id.companyNameTxtV);
        TextView priceOrInstalledTxtV = row.findViewById(R.id.priceOrInstalledTxtV);
        ImageView start1 = row.findViewById(R.id.starImgV1);
        ImageView start2 = row.findViewById(R.id.starImgV2);
        ImageView start3 = row.findViewById(R.id.starImgV3);
        ImageView start4 = row.findViewById(R.id.starImgV4);
        ImageView start5 = row.findViewById(R.id.starImgV5);
        //등스와 제목 세팅
        rankAndTitleTxtV.setText(String.format("%d, %s", appData.getRank(), appData.getTitle()));

        //회사 이름은 그대로
        companyNameTxtV.setText(appData.getCompanyName());

//        List<ImageView> startList = new ArrayList<>();
//
//        startList.add(start1);
//        startList.add(start2);
//        startList.add(start3);
//        startList.add(start4);
//        startList.add(start5);


        //리스트는 재사용때문에 초기화 작업 필요

//        for (ImageView star : startList) {
//            star.setImageResource(R.drawable.star_empty);
//        }
//        for(int i = 0 ; i < appData.getUserRating(); i++) {
//            startList.get(i).setImageResource(R.drawable.star_fill);
//        }

        ImageView[] starts = {start1, start2, start3, start4, start5};

        for(ImageView start : starts) {
            start.setImageResource(R.drawable.star_empty);
        }

        for(int i = 0 ; i < appData.getUserRating(); i++) {
            starts[i].setImageResource(R.drawable.star_fill);

            //반달 표시
            if( appData.getUserRating() < i && appData.getUserRating() > i + 1 ){
                starts[i].setImageResource(R.drawable.ic_launcher_background);
            }
        }

        //설치 여부 따라 안내
        if(!appData.isMine()){
            //미설치
            //Stirng.format의 %,d 를 이용해 세자리 마다 콤파 적용
            priceOrInstalledTxtV.setText( String.format("%,d 원", appData.getPrice()) );
        }
        else {
            priceOrInstalledTxtV.setText( "설치된 항목" );
        }

        return row;
    }
}
