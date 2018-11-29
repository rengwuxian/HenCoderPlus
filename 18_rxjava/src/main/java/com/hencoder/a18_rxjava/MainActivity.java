package com.hencoder.a18_rxjava;

import android.os.Bundle;
import android.widget.TextView;

import com.hencoder.a18_rxjava.model.Repo;
import com.hencoder.a18_rxjava.model.User;
import com.hencoder.a18_rxjava.network.Api;

import java.util.List;
import java.util.concurrent.TimeUnit;

import androidx.appcompat.app.AppCompatActivity;
import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.Scheduler;
import io.reactivex.Single;
import io.reactivex.SingleObserver;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.BiFunction;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;
import io.reactivex.plugins.RxJavaPlugins;
import io.reactivex.schedulers.Schedulers;
import okhttp3.ResponseBody;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {
    TextView textView;
    Disposable diposable;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView = findViewById(R.id.textView);

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://api.github.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build();
        Api api = retrofit.create(Api.class);

        /*api.getRepos("rengwuxian")
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new SingleObserver<List<Repo>>() {
                    @Override
                    public void onSubscribe(Disposable d) {
                        diposable = d;
                        textView.setText("正在请求");
                    }

                    @Override
                    public void onSuccess(List<Repo> repos) {
                        textView.setText(repos.get(0).name);
                    }

                    @Override
                    public void onError(Throwable e) {
                        String errorDesc = e.getMessage();
                        if (errorDesc == null) {
                            errorDesc = e.getClass().getName();
                        }
                        textView.setText(errorDesc);
                    }
                });*/
        Single.just(1)
                .map(new Function<Integer, String>() {
                    @Override
                    public String apply(Integer integer) {
                        return String.valueOf(integer);
                    }
                })
                .delay(2, TimeUnit.SECONDS)
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new SingleObserver<String>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onSuccess(String s) {
                        textView.setText(s);
                    }

                    @Override
                    public void onError(Throwable e) {

                    }
                });
        Observable.interval(2, TimeUnit.SECONDS)
                .subscribe(new Observer<Long>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(Long aLong) {

                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        diposable.dispose();
    }
}
