package com.example.home.component.school;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.example.home.R;

public class DetailInfoActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_info);
        Intent intent = getIntent();
        String info = intent.getStringExtra("info");

        TextView tv = (TextView) findViewById(R.id.detail_info_tv);

        tv.setText(info);


    }
}