package com.example.pushesandbroadcasts;

import android.app.NotificationManager;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import androidx.core.app.NotificationCompat;

public class NetworkStateReceiver extends BroadcastReceiver {
    private int messageId = 100;

    @Override
    public void onReceive(Context context, Intent intent) {
        NotificationCompat.Builder builder =
                new NotificationCompat.Builder(context, "1")
                        .setContentTitle("Network")
                        .setContentText("Network")
                        .setSmallIcon(R.drawable.ic_launcher_background);

        NotificationManager manager = (NotificationManager) context.getSystemService(Context.NOTIFICATION_SERVICE);
        manager.notify(messageId ++, builder.build());
    }
}
