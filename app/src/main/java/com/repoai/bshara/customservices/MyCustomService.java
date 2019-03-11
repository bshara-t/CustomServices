package com.repoai.bshara.customservices;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.support.annotation.Nullable;
import android.view.View;

public class MyCustomService extends Service {
    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        MainActivity.lnrLoading.setVisibility(View.VISIBLE);
        return super.onStartCommand(intent, flags, startId);
    }

    @Override
    public void onDestroy() {
        MainActivity.lnrLoading.setVisibility(View.INVISIBLE);
        super.onDestroy();
    }
}
