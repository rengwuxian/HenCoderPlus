package com.hencoder.a26_pluginnable;

import androidx.appcompat.app.AppCompatActivity;
import dalvik.system.DexClassLoader;

import android.content.Intent;
import android.os.Bundle;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//        Utils utils = new Utils();
//        utils.shout();

        try {
            Class utilClass = Class.forName("com.hencoder.a26_pluginnable.hidden.Utils");
//            Object utils = utilClass.newInstance();
            Constructor utilsConstructor = utilClass.getDeclaredConstructors()[0];
            utilsConstructor.setAccessible(true);
            Object utils = utilsConstructor.newInstance();
            Method shoutMethod = utilClass.getDeclaredMethod("shout");
            shoutMethod.setAccessible(true);
            shoutMethod.invoke(utils);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        File apk = new File(getCacheDir() + "/26_pluginnable_plugin-debug.apk");
        if (!apk.exists()) {
            try {
                InputStream is = getAssets().open("apk/26_pluginnable_plugin-debug.apk");
                int size = is.available();
                byte[] buffer = new byte[size];
                is.read(buffer);
                is.close();

                FileOutputStream fos = new FileOutputStream(apk);
                fos.write(buffer);
                fos.close();
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }

        try {
            DexClassLoader classLoader = new DexClassLoader(apk.getPath(), getCacheDir().getPath(), null, null);
            Class pluginUtilsClass = classLoader.loadClass("com.hencoder.a26_pluginnable_plugin.Utils");
            Constructor utilsConstructor = pluginUtilsClass.getDeclaredConstructors()[0];
            Object utils = utilsConstructor.newInstance();
            Method shoutMethod = pluginUtilsClass.getDeclaredMethod("shout");
            shoutMethod.invoke(utils);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
    }
}
