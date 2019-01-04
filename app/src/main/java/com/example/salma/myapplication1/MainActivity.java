package com.example.salma.myapplication1;

import android.content.Intent;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.util.List;

public class MainActivity extends AppCompatActivity implements NameItemListener
{
    Button button_one;
    private RecyclerView recyclerView;
    ListNameAdapter listNameAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
         button_one = findViewById(R.id.buttonone);
        listNameAdapter = new ListNameAdapter(this);
        recyclerView = findViewById(R.id.activity_main_recyclerview);
         button_one.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               Intent intent =  new Intent(getApplicationContext(),ActivityTwo.class);
                startActivity(intent);
            }// ajouter un switch by id
        });
         initList();
    }

    @Override
    protected void onResume() {
        super.onResume();
        super.onResume();
        List nameList = DataManager.getInstance().getNameList();
        listNameAdapter.updateData(nameList);
    }

    private void initList(){
        final LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setAdapter(listNameAdapter);
    }

    @Override
    public void clickOnItem(String name) {
        Toast.makeText(this, name, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void clickOnCross(String name) {
        Toast.makeText(this, "Click on the star of "+name , Toast.LENGTH_SHORT).show();
    }
}