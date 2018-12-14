package com.hencoder.a25_mvc_mvp_mvvm.mvvm;

import android.os.Bundle;
import android.widget.EditText;

import com.hencoder.a25_mvc_mvp_mvvm.R;
import com.hencoder.a25_mvc_mvp_mvvm.mvp.Presenter;

import androidx.appcompat.app.AppCompatActivity;

public class MvvmActivity extends AppCompatActivity {
    EditText data1View;
    EditText data2View;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        data1View = findViewById(R.id.data1View);
        data2View = findViewById(R.id.data2View);

        new ViewModel(new ViewBinder(), data1View, data2View).load();
    }
}
