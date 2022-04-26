package com.example.samplelifecycle;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ComponentName;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toast.makeText(this, "onCreate 호출", Toast.LENGTH_LONG).show();

        Button button = findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent();
                ComponentName name = new ComponentName("com.example.samplelifecycle",
                        "com.example.samplelifecycle.MenuActivity");
                intent.setComponent(name);
                startActivityForResult(intent, 101);
            }
        });
    }

    @Override
    protected void onStart() {
        super.onStart();
        println("onStart 호출");
    }

    @Override
    protected void onStop() {
        super.onStop();
        println("onStop 호출");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        println("onDestroy 호출");
    }

    @Override
    protected void onPause() {
        super.onPause();
        println("onPause 호출");
    }

    @Override
    protected void onResume() {
        super.onResume();
        println("onResume 호출");
    }

    public void println(String data) {
        Toast.makeText(this, data, Toast.LENGTH_LONG).show();
        Log.d("Main", data);
    }
}