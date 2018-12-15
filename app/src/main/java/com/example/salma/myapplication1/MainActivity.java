package com.example.salma.myapplication1;

import android.content.Intent;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    Button button_one;
    TextView textView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        
        setContentView(R.layout.activity_main);
         button_one = findViewById(R.id.buttonone);
         textView = findViewById(R.id.greeting);
         button_one.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               Intent intent =  new Intent(getApplicationContext(),ActivityTwo.class);
               startActivityForResult(intent,MyHelper.FUNCTIONALITY_ONE_CODE_REQUEST);
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {

        if(requestCode==MyHelper.FUNCTIONALITY_ONE_CODE_REQUEST){
            if(RESULT_OK==resultCode){
                textView.setText(data.getStringExtra(MyHelper.USERNAME));
            }
        }
        super.onActivityResult(requestCode, resultCode, data);
    }
}
