package ru.gb.course1.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = "@@@";
    private static final String NUMBER_KEY = "number_key";

    private EditText numberEditText;
    private TextView resultTextView;

    private int number = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Log.d(TAG, "onCreate() called with: savedInstanceState = [" + savedInstanceState + "]");

        numberEditText = findViewById(R.id.number_input_edit_text);
        resultTextView = findViewById(R.id.result_text_view);

        if (savedInstanceState != null && savedInstanceState.containsKey(NUMBER_KEY)) {
            number = savedInstanceState.getInt(NUMBER_KEY);
        }

        showResult();

        numberEditText.setText("OLOLO");

        findViewById(R.id.process_button).setOnClickListener(v -> {
            number = Integer.parseInt(numberEditText.getText().toString());
            number = number * number;
            showResult();
        });

        findViewById(R.id.show_second_button).setOnClickListener(v -> {
            Intent intent = SecondActivity.getIntentForLaunch(this, number);
            startActivity(intent);
        });
    }

    @Nullable
    @Override
    public Object onRetainCustomNonConfigurationInstance() {
        return super.onRetainCustomNonConfigurationInstance();
    }

    @Nullable
    @Override
    public Object getLastCustomNonConfigurationInstance() {
        return super.getLastCustomNonConfigurationInstance();
    }

    @Override
    protected void onRestoreInstanceState(@NonNull Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
    }

    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putInt(NUMBER_KEY, number);
    }

    private void showResult() {
        resultTextView.setText(String.valueOf(number));
    }

}