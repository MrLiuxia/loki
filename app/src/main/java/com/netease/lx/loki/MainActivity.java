package com.netease.lx.loki;


import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.service.notification.StatusBarNotification;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private Button mPostBtn;
    private Button mTempBtn;
    private Button mNotifyBtn;
    private int mLastNotificationId;
    private Notification mLastNotification;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        PayloadBean payloadBean = PayloadBean.demoBean();
        NotificationManager notificationManager = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
        String channelId = "loki_channel_id";
        String channelName = "loki_channel_name";
        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.O) {
            notificationManager.deleteNotificationChannel(channelId);
            NotificationChannel notificationChannel = new NotificationChannel(channelId, channelName, NotificationManager.IMPORTANCE_HIGH);
            notificationChannel.enableLights(false);
            notificationChannel.enableVibration(false);
            notificationManager.createNotificationChannel(notificationChannel);
        }


        findViewById(R.id.btn_post).setOnClickListener(v -> {
            mLastNotificationId = (int) (Math.random() * 1000);
            mLastNotification = new NotificationCompat.Builder(this, channelId)
                    .setContentTitle(mLastNotificationId + ": " + payloadBean.getTitle())
                    .setContentText(payloadBean.getContent())
                    .setSmallIcon(R.drawable.ic_launcher_background)
                    .setPriority(NotificationCompat.PRIORITY_DEFAULT)
                    .build();
            notificationManager.notify(mLastNotificationId, mLastNotification);
        });


        final Handler handler = new Handler();

        final Notification tempNotification = new NotificationCompat.Builder(this, channelId)
                .setContentTitle("置顶中...")
                .setContentText(payloadBean.getContent())
                .setSmallIcon(R.drawable.ic_launcher_background)
                .setPriority(NotificationCompat.PRIORITY_MAX)
                .setVibrate(null)
                .setLights(0, 0, 0)
                .build();
        final int tempId = 10001;
        findViewById(R.id.btn_temp_post).setOnClickListener(v -> {
//            notificationManager.notify(tempId, tempNotification);
//            notificationManager.cancel(tempId);
            handler.postDelayed(() -> notificationManager.notify(tempId, tempNotification), 1000);
            handler.postDelayed(() -> notificationManager.cancel(tempId), 2000);
//            handler.postDelayed(() -> notificationManager.notify(tempId, tempNotification), 15000);
//            handler.postDelayed(() -> notificationManager.cancel(tempId), 16000);

        });


        findViewById(R.id.btn_notify).setOnClickListener(v -> {
            if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.M) {
                StatusBarNotification[] activeNotifications = notificationManager.getActiveNotifications();
                List<StatusBarNotification> notificationList = Arrays.asList(activeNotifications);
                Collections.sort(notificationList, new Comparator<StatusBarNotification>() {
                    @Override
                    public int compare(StatusBarNotification o1, StatusBarNotification o2) {
                        return (int)(o1.getPostTime() - o2.getPostTime());
                    }
                });
                for (StatusBarNotification statusBarNotification : notificationList) {
//                    notificationManager.cancel(statusBarNotification.getId());
//                    notificationManager.notify(statusBarNotification.getId() + 1, statusBarNotification.getNotification());
                    Notification notification = statusBarNotification.getNotification();
                    notification.when = System.currentTimeMillis();
                    notificationManager.notify(statusBarNotification.getId(), notification);
                }
            } else {
                mLastNotification.priority = NotificationCompat.PRIORITY_MAX;
                notificationManager.notify(mLastNotificationId, mLastNotification);
            }
        });


    }
}
