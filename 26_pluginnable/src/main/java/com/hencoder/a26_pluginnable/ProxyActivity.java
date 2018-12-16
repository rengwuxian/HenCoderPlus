package com.hencoder.a26_pluginnable;

import android.app.Activity;
import android.content.res.AssetManager;
import android.content.res.Resources;
import android.os.Bundle;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import androidx.annotation.Nullable;

public class ProxyActivity extends Activity {
    Object realActivity;

//    realActivity = ???;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        realActivity.onCreate(savedInstanceState);

    }

    @Override
    public AssetManager getAssets() {
        try {
            Class assetManagerClass = AssetManager.class;
            AssetManager assetManager = (AssetManager) assetManagerClass.newInstance();
            Method addAssetPath = assetManagerClass.getDeclaredMethod("adAssetPath", String.class);
            addAssetPath.invoke(assetManager, "apkPath");
            return assetManager;
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
        return super.getAssets();
    }

    @Override
    public Resources getResources() {
        return new Resources(getAssets(), getResources().getDisplayMetrics(), getResources().getConfiguration());
    }
}
