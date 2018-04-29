package com.example.imransk.notificationpratice;

import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.support.v4.app.NotificationCompat;
import android.support.v4.app.TaskStackBuilder;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.util.PriorityQueue;

public class MainActivity extends AppCompatActivity {

    private NotificationManager notificationManager;
    private int noticationID = 100;
    private int NumberMessage = 0;

    NotificationCompat.Builder builder;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        builder = new NotificationCompat.Builder(this);

        Button startBtn = (Button) findViewById(R.id.start);
        startBtn.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                displayNotification();
            }

        });

        Button bigNotification = findViewById(R.id.startBigNotification);
        bigNotification.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getApplicationContext(),"click",Toast.LENGTH_LONG).show();
                BigNotificationShow();
            }

        });

        Button cancelBtn = (Button) findViewById(R.id.cancel);
        cancelBtn.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                cancelNotification();
            }
        });
        Button updateBtn = (Button) findViewById(R.id.update);
        updateBtn.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                updateNotification();
            }
        });
        builder.setAutoCancel(true);
    }

    private void BigNotificationShow() {


        builder.setContentTitle("New Message");
        builder.setSmallIcon(R.drawable.boy);
        builder.setContentText("hello this is notification");
        builder.setTicker("message alert");

 /* Increase notification number every time a new notification arrives */
        builder.setNumber(++NumberMessage);


         /* Add Big View Specific Configuration */
        NotificationCompat.InboxStyle inboxStyle = new NotificationCompat.InboxStyle();
        String[] events = new String[6];
        events[0] = new String("This is first line....");
        events[1] = new String("This is second line...");
        events[2] = new String("This is third line...");
        events[3] = new String("This is 4th line...");
        events[4] = new String("This is 5th line...");
        events[5] = new String("This is 6th line...");
        // Sets a title for the Inbox style big view
        inboxStyle.setBigContentTitle("Big Title Details:");
        // Moves events into the big view
        for (int i=0; i < events.length; i++) {
            inboxStyle.addLine(events[i]);
        }
        builder.setStyle(inboxStyle);


 /* Creates an explicit intent for an Activity in your app */
        Intent resultInten = new Intent(this, NotificationResultActivity.class);

 /* Adds the Intent that starts the Activity to the top of the stack */
        TaskStackBuilder taskStackBuilder = TaskStackBuilder.create(this);
        taskStackBuilder.addParentStack(NotificationResultActivity.class);
        taskStackBuilder.addNextIntent(resultInten);

        PendingIntent pendingIntent = taskStackBuilder.getPendingIntent(0, PendingIntent.FLAG_UPDATE_CURRENT);

        builder.setContentIntent(pendingIntent);

        notificationManager = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
        notificationManager.notify(noticationID, builder.build());
}

    private void displayNotification() {

        builder.setContentTitle("New Message");
        builder.setSmallIcon(R.drawable.boy);
        builder.setContentText("hello this is notification");
        builder.setTicker("message alert");

 /* Increase notification number every time a new notification arrives */
        builder.setNumber(++NumberMessage);

 /* Creates an explicit intent for an Activity in your app */
        Intent resultInten = new Intent(this, NotificationResultActivity.class);

 /* Adds the Intent that starts the Activity to the top of the stack */
        TaskStackBuilder taskStackBuilder = TaskStackBuilder.create(this);
        taskStackBuilder.addParentStack(NotificationResultActivity.class);
        taskStackBuilder.addNextIntent(resultInten);

        PendingIntent pendingIntent = taskStackBuilder.getPendingIntent(0, PendingIntent.FLAG_UPDATE_CURRENT);

        builder.setContentIntent(pendingIntent);

        notificationManager = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
        notificationManager.notify(noticationID, builder.build());
    }

    private void cancelNotification() {

    }

    private void updateNotification() {

    }


}
