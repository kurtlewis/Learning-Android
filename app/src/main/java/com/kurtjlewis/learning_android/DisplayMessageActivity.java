package com.kurtjlewis.learning_android;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class DisplayMessageActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_message);

        // Get the Intent that started this activity and extract the string
        Intent intent = getIntent();
        String message = intent.getStringExtra(MainActivity.EXTRA_MESSAGE);

        // Capture the layout's TextVieew and set the string as its text
        TextView textView1 = (TextView) findViewById(R.id.textView1);
        textView1.setText(message);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();

        TextView textView1 = (TextView) findViewById(R.id.textView1);
        String message = (String)textView1.getText();

        SharedPreferences sharedPref = getPreferences(Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPref.edit();
        editor.putString(getString(R.string.saved_history_1), message);
        editor.commit();
    }
}
