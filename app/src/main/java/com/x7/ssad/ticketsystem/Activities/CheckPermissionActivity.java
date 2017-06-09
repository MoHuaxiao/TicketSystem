package com.x7.ssad.ticketsystem.Activities;

import android.Manifest;
import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

import com.nostra13.universalimageloader.cache.disc.naming.Md5FileNameGenerator;
import com.nostra13.universalimageloader.core.DisplayImageOptions;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.ImageLoaderConfiguration;
import com.nostra13.universalimageloader.core.assist.QueueProcessingType;
import com.tbruyelle.rxpermissions2.RxPermissions;
import com.x7.ssad.ticketsystem.R;

import io.reactivex.annotations.NonNull;
import io.reactivex.functions.Consumer;

public class CheckPermissionActivity extends AppCompatActivity {

    Handler mHandler = new Handler();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_check_permission);

        //Configuring Universal Image Loader
//        ImageLoaderConfiguration config = ImageLoaderConfiguration.createDefault(getApplicationContext());
        DisplayImageOptions displayImageOptions = new DisplayImageOptions.Builder()
                .cacheInMemory(true)
                .cacheOnDisk(true)
                .build();

        ImageLoaderConfiguration config = new ImageLoaderConfiguration.Builder(getApplicationContext())
                .defaultDisplayImageOptions(displayImageOptions)
                .threadPriority(Thread.NORM_PRIORITY - 2)
                .denyCacheImageMultipleSizesInMemory()
                .diskCacheFileNameGenerator(new Md5FileNameGenerator())
                .diskCacheSize(80 * 1024 * 1024)  //80MB for cache
                .tasksProcessingOrder(QueueProcessingType.LIFO)
                .writeDebugLogs()
                .build();

        ImageLoader.getInstance().init(config);

        RxPermissions rxPermissions = new RxPermissions(this);
        rxPermissions
                .request(Manifest.permission.ACCESS_COARSE_LOCATION,
                        Manifest.permission.INTERNET,
                        Manifest.permission.WRITE_EXTERNAL_STORAGE)
                .subscribe(new Consumer<Boolean>() {
                    @Override
                    public void accept(@NonNull Boolean granted) throws Exception {

                            if (granted) {
                                Toast.makeText(CheckPermissionActivity.this, "Granted", Toast.LENGTH_SHORT).show();
                                Intent i = new Intent(CheckPermissionActivity.this, LoginActivity.class);
                                startActivity(i);
                            } else {
                                Toast.makeText(CheckPermissionActivity.this, "App will close in 3 secs.", Toast.LENGTH_SHORT).show();
                                mHandler.postDelayed(new Runnable() {
                                    @Override
                                    public void run() {
                                        finish();
                                    }
                                }, 3000);
                            }

                        }
                });

    }
}
