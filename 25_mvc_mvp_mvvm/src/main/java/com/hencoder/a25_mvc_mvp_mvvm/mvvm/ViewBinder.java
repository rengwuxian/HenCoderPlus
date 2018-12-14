package com.hencoder.a25_mvc_mvp_mvvm.mvvm;

import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;

public class ViewBinder {
    void bind(final EditText editText, final ViewModel.TextAttr text) {
        editText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                if (!s.equals(text.getText())) {
                    text.setText(s.toString());
                }
            }
        });
        text.setOnChangeListener(new ViewModel.TextAttr.OnChangeListener() {
            @Override
            public void onChange(String newText) {
                if (!newText.equals(editText.getText().toString())) {
                    editText.setText(newText);
                }
                System.out.println("被动改变: " + newText);
            }
        });
    }
}
