package com.repoai.bshara.customservices;

import android.app.ActivityManager;
import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;

public class MainActivity extends AppCompatActivity {
    private Button btnStart, btnStop;
    public static LinearLayout lnrLoading;
    Intent myService;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setPointer();
    }

    private void setPointer() {
        myService = new Intent(this,MyCustomService.class);
        btnStart=findViewById(R.id.btnStart);
        btnStart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!isMyServiceRunning(MyCustomService.class)) {

                    startService(myService);
                }
            }
        });

        btnStop=findViewById(R.id.btnStop);
        btnStop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (isMyServiceRunning(MyCustomService.class)) {
                    stopService(myService);
                }
            }
        });
        lnrLoading=findViewById(R.id.lnrLoading);
    }

    private boolean isMyServiceRunning(Class<?> serviceClass)
    {
        //create activity manager to get all process that are running in the system
        ActivityManager manger = (ActivityManager)getSystemService(Context.ACTIVITY_SERVICE);
        //go on entire collection and check if there is a matching name to the serviceClass name
        //that we gave in the args.
        for (ActivityManager.RunningServiceInfo service:manger.getRunningServices(Integer.MAX_VALUE))
        {
            //if we found, return true
            if (serviceClass.getName().equals(service.service.getClassName()))
            {
                Log.e("onStop", "onClick: start" );
                return true;
            }
        }
        //if we didn't found , return false as a default
        return false;
    }



}
