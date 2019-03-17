package com.example.jaskaran.firebasenotifications;

import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import android.widget.Toast;

import com.google.firebase.messaging.FirebaseMessagingService;
import com.google.firebase.messaging.RemoteMessage;


public class MyFirebaseMessagingService extends FirebaseMessagingService {

    private static final String TAG = "MyFirebaseMessagingSER";

    @Override
    public void onNewToken(String s) {
        super.onNewToken(s);

        Log.d(TAG, "onNewToken: " + s);
    }

    @Override
    public void onMessageReceived(final RemoteMessage remoteMessage) {
        super.onMessageReceived(remoteMessage);

        Log.d(TAG, "onMessageReceived: fired");

        final Handler handler = new Handler(Looper.getMainLooper());

        handler.post(new Runnable() {
            @Override
            public void run() {

                Toast.makeText(getApplicationContext(), "Firebase Notification arrived",
                        Toast.LENGTH_SHORT).show();
            }
        });

        if (remoteMessage.getNotification() != null) {

            handler.post(new Runnable() {
                @Override
                public void run() {

                    Toast.makeText(getApplicationContext(), "Notification Body: "
                            + remoteMessage.getNotification()
                            .getBody() , Toast.LENGTH_SHORT).show();

                }
            });
        }

    }
}
