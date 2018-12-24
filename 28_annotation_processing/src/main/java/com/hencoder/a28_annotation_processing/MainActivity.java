package com.hencoder.a28_annotation_processing;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.hencoder.a28_lib.Binding;
import com.hencoder.a28_lib_annotations.BindView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.textView) TextView textView;
    @BindView(R.id.parentLayout) View parentLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Binding.bind(this);

        textView.setText("哈哈哈");
        parentLayout.setBackgroundColor(Color.RED);
    }
}
