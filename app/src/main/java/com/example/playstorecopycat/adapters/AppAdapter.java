package com.example.playstorecopycat.adapters;

import android.content.Context;
import android.databinding.DataBindingUtil;
import android.icu.util.Calendar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.example.playstorecopycat.R;
import com.example.playstorecopycat.databinding.AppItemListBinding;
import com.example.playstorecopycat.datas.app;

import java.util.List;

public class AppAdapter extends ArrayAdapter<app> {

    List<app> appList;
    Context context;

    LayoutInflater inf;

    public AppAdapter(Context context, List<app> appList){

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
        app appData = appList.get(position);

        //아이디 찾기
        TextView rankAndTitleTxtV = row.findViewById(R.id.rankAndTitleTxtV);
        TextView companyNameTxtV = row.findViewById(R.id.companyNameTxtV);
        TextView priceOrInstalledTxtV = row.findViewById(R.id.priceOrInstalledTxtV);

        //등스와 제목 세팅
        rankAndTitleTxtV.setText(String.format("%d, %s", appData.getRank(), appData.getTitle()));

        //회사 이름은 그대로
        companyNameTxtV.setText(appData.getCompanyName());

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
