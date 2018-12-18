package com.hencoder.a25_mvc_mvp_mvvm.mvvm;

import android.widget.EditText;

import com.hencoder.a25_mvc_mvp_mvvm.data.DataCenter;

public class ViewModel {
    TextAttr data1 = new TextAttr();
    TextAttr data2 = new TextAttr();

    ViewModel(ViewBinder binder, EditText editText1, EditText editText2) {
        binder.bind(editText1, data1);
        binder.bind(editText2, data2);
    }

    void load() {
        String[] data = DataCenter.getData();
        data1.setText(data[0]);
        data2.setText(data[1]);
    }

    static class TextAttr {
        private String text;
        private OnChangeListener listener;

        public String getText() {
            return text;
        }

        public void setText(String text) {
            this.text = text;
            if (listener != null) {
                listener.onChange(text);
            }
        }

        void setOnChangeListener(OnChangeListener listener) {
            this.listener = listener;
        }

        interface OnChangeListener {
            void onChange(String newText);
        }
    }
}
