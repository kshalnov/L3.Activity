package ru.gb.course1.myapplication;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class SecondActivity extends AppCompatActivity {
    public static final String NUMBER_EXTRA_KEY = "number_extra_key";
    private static final String TAG = "@@@ Second";
    private TextView numberTextView;

    public static Intent getIntentForLaunch(Context context, int number) {
        Intent intent = new Intent(context, SecondActivity.class);
        intent.putExtra(SecondActivity.NUMBER_EXTRA_KEY, number);
        return intent;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        Log.d(TAG, "onCreate() called with: savedInstanceState = [" + savedInstanceState + "]");

        numberTextView = findViewById(R.id.number_text_view);

//        int number = getIntent().getExtras().getInt(NUMBER_EXTRA_KEY);
//        numberTextView.setText(String.valueOf(number));

        findViewById(R.id.web_button).setOnClickListener(v -> {
            // todo показать браузер
            String url = "https://gb.ru";
            Uri uri = Uri.parse(url);

            Intent webIntent = new Intent(Intent.ACTION_VIEW, uri);

            if (webIntent.resolveActivity(getPackageManager()) != null) {
                startActivity(webIntent);
            } else {
                Toast.makeText(this, "Нет вариантов", Toast.LENGTH_SHORT).show();
            }
        });
    }

}