package com.hencoder.a25_mvc_mvp_mvvm.mvp;

import com.hencoder.a25_mvc_mvp_mvvm.data.DataCenter;

public class Presenter {
    IView iView;

    Presenter(IView mvpActivity) {
        this.iView = mvpActivity;
    }

    void load() {
        String[] data = DataCenter.getData();
        iView.showData(data[0], data[1]);
    }

    interface IView {
        void showData(String data1, String data2);
    }
}
