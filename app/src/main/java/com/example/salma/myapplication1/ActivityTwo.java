package com.example.salma.myapplication1;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class ActivityTwo extends AppCompatActivity {
    EditText editText ;
    Button button_two;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_two);
        editText=findViewById(R.id.username);
        button_two = findViewById(R.id.buttontwo);
        button_two.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String username = editText.getText().toString();
                Intent intent = new Intent();
                intent.putExtra(MyHelper.USERNAME,username);
                setResult(RESULT_OK,intent);
                finish();
            }
        });
    }
}
