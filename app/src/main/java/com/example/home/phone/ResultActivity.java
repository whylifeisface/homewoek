package com.example.home.phone;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import com.example.home.R;

import java.util.ArrayList;
import java.util.Map;

public class ResultActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);
        ListView lv = (ListView) findViewById(R.id.result_lv);

        Bundle bundle = getIntent().getExtras();
        ArrayList<Map<String, String>> data = (ArrayList<Map<String, String>>) bundle.getSerializable("data");
        SimpleAdapter adapter = new SimpleAdapter(this, data, R.layout.result_item,
                new String[]{"name", "phone"},
                new int[]{R.id.result_name, R.id.result_phone});
        lv.setAdapter(adapter);
    }
}