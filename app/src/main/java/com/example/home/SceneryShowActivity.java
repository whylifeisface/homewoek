package com.example.home;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

public class SceneryShowActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scenery_show);
        ImageView iv = (ImageView) findViewById(R.id.show_scenery_iv);
        TextView tv = (TextView) findViewById(R.id.show_scenery_tv);
        Intent intent = getIntent();
        String url = intent.getStringExtra("image");
        String content = intent.getStringExtra("content");
        tv.setText(content);
        Glide.with(this).load(url).into(iv);


    }

}