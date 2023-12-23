package com.example.home;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.example.home.component.school.CampusSceneryActivity;
import com.example.home.component.school.FreshAssistActivity;

public class CampusLifeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_campus_life);
        ImageView imageView = (ImageView) findViewById(R.id.imv);
        Glide.with(this)
                .load("https://pic4.zhimg.com/v2-77d62f6305569bc9a28ca2f37f9bbdb5_r.jpg")
                .into(imageView);

    }

    public void school_view(View view) {
        startActivity(new Intent(this, CampusSceneryActivity.class));
    }

    public void new_of_school(View view) {
        //TODO
        startActivity(new Intent(this, FreshAssistActivity.class));

    }

}