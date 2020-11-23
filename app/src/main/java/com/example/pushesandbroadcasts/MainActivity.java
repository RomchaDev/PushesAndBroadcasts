package com.example.pushesandbroadcasts;

import androidx.appcompat.app.AppCompatActivity;

import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.os.Build;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {
    private final NetworkStateReceiver networkReceiver = new NetworkStateReceiver();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initNotificationManager();
    }

    @Override
    protected void onResume() {
        super.onResume();

        registerReceiver(networkReceiver, new IntentFilter(ConnectivityManager.CONNECTIVITY_ACTION));
    }

    @Override
    protected void onPause() {
        super.onPause();

        unregisterReceiver(networkReceiver);
    }

    private void initNotificationManager() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            NotificationManager manager = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
            NotificationChannel channelNetwork = new NotificationChannel("1", "Broadcast", NotificationManager.IMPORTANCE_LOW);
            NotificationChannel channelFirebase = new NotificationChannel("2", "Firebase", NotificationManager.IMPORTANCE_LOW);
            manager.createNotificationChannel(channelNetwork);
            manager.createNotificationChannel(channelFirebase);
        }
    }
}