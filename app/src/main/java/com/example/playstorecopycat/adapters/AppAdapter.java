package com.example.playstorecopycat.adapters;

import android.content.Context;
import android.icu.util.Calendar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;

import com.example.playstorecopycat.R;
import com.example.playstorecopycat.datas.app;

import java.util.List;

public class AppAdapter extends ArrayAdapter<app> {

    List<app> appList;
    Context context;

    LayoutInflater inf;

    AppAdapter(Context context, List<app> appList){

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

//        row.findViewById("");

        return row;
    }
}
