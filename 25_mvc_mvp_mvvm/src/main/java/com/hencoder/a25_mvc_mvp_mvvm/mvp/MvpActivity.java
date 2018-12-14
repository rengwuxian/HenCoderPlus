package com.hencoder.a25_mvc_mvp_mvvm.mvp;

import android.os.Bundle;
import android.widget.EditText;

import com.hencoder.a25_mvc_mvp_mvvm.R;
import com.hencoder.a25_mvc_mvp_mvvm.data.DataCenter;

import androidx.appcompat.app.AppCompatActivity;

public class MvpActivity extends AppCompatActivity implements Presenter.IView {
    EditText data1View;
    EditText data2View;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        data1View = findViewById(R.id.data1View);
        data2View = findViewById(R.id.data2View);

        new Presenter(this).load();
    }

    @Override
    public void showData(String data1, String data2) {
        data1View.setText(data1);
        data2View.setText(data2);
    }
}
