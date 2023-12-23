package com.example.home.phone;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ExpandableListView;
import android.widget.SimpleExpandableListAdapter;

import com.example.home.R;
import com.example.home.db.MyDatabaseHelper;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PhoneListActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_phone_list);


        ExpandableListView expandableListView = (ExpandableListView) findViewById(R.id.my_expand_list_view);
        MyDatabaseHelper myDatabaseHelper = new MyDatabaseHelper(this);
        String sql = "select distinct type from phone_tb";
        ArrayList<String> type = myDatabaseHelper.getType(myDatabaseHelper.getWritableDatabase(), sql);


        ArrayList<Map<String, String>> groupData = new ArrayList<Map<String, String>>();
        ArrayList<List<Map<String, String>>> children = new ArrayList<List<Map<String, String>>>();
        for (String str : type) {
            Map<String, String> item = new HashMap<String, String>();
            item.put("group", str);
            groupData.add(item);
            ArrayList<Map<String, String>> child = myDatabaseHelper.getData(myDatabaseHelper.getWritableDatabase(),
                    "select name,phone from phone_tb where type=?", new String[]{str});
            System.out.println(child);
            children.add(child);
        }


        SimpleExpandableListAdapter simpleExpandableListAdapter = new SimpleExpandableListAdapter(
                this,
                groupData,
                R.layout.group, new String[]{"group"},
                new int[]{R.id.group},
                children,
                R.layout.child,
                new String[]{"name", "phone"},
                new int[]{R.id.name, R.id.phone});
        expandableListView.setAdapter(simpleExpandableListAdapter);

    }
}