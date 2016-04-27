package com.smsintent.ahurwitz.smsintent;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
private final String LOG_TAG = MainActivity.class.getSimpleName();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button smsIntentBtn = (Button) findViewById(R.id.sms_btn_id);

        smsIntentBtn.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v){
                Uri uri = null;
                composeMmsMessage("SMS Works!", uri);
                Log.v(LOG_TAG, "smsIntentBtn_called");
            }
        });
    }

    public void composeMmsMessage(String message, Uri attachment) {
        // ACTION_VIEW to choose between SMS/MMS apps
        // Intent intent = new Intent(Intent.ACTION_VIEW, Uri.fromParts("sms", "", null));

        // ACTION_SENDTO to open default SMS/MMS apps
        Intent intent = new Intent(Intent.ACTION_SENDTO, Uri.fromParts("sms", "", null));
        // Intent intent = new Intent(Intent.ACTION_SENDTO);
        // intent.setType(HTTP.PLAIN_TEXT_TYPE);
        intent.putExtra("sms_body", message);
        // intent.putExtra(Intent.EXTRA_STREAM, attachment);
        if (intent.resolveActivity(getPackageManager()) != null) {
            startActivity(intent);
        }
    }
}
