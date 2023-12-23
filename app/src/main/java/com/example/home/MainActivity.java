package com.example.home;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.ImageView;

import com.bumptech.glide.Glide;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ImageView imageView = (ImageView) findViewById(R.id.imageView);

        Glide.with(this)
                .load("https://img2.baidu.com/it/u=2095782499,3271309958&fm=253&fmt=auto&app=138&f=JPEG?w=693&h=500")
                .into(imageView);
    }

    @Override
    public boolean onCreatePanelMenu(int featureId, @NonNull Menu menu) {
        return super.onCreatePanelMenu(featureId, menu);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.sample_menu, menu);

        return super.onCreateOptionsMenu(menu);
    }

    public void outerDoor(View view){
        Intent intent = new Intent(this, SceneryActivity.class);
        startActivity(intent);
    }
    public void phoneKown(View view){
        Intent intent = new Intent(this, CampusLifeActivity.class);
        startActivity(intent);
    }
    public void schoolLife(View view){
        Intent intent = new Intent(this, CampusLifeActivity.class);
        startActivity(intent);
    }
}