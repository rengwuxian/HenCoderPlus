package com.hencoder.a25_mvc_mvp_mvvm.mvc;

import android.os.Bundle;
import android.widget.EditText;

import com.hencoder.a25_mvc_mvp_mvvm.R;
import com.hencoder.a25_mvc_mvp_mvvm.data.DataCenter;

import androidx.appcompat.app.AppCompatActivity;

public class MvcActivity extends AppCompatActivity {
    IView dataView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mvc);

        dataView = findViewById(R.id.dataView);

        String[] data = DataCenter.getData();
        dataView.showData(data[0], data[1]);
    }

    interface IView {
        void showData(String data1, String data2);
    }
}
