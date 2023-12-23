package com.example.home;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

public class SceneryActivity extends AppCompatActivity {

    String[] images = new String[]{"https://img2.baidu.com/it/u=3632765100,3260754934&fm=253&fmt=auto&app=120&f=JPEG?w=665&h=397",

            "https://img2.baidu.com/it/u=1834260737,3703696454&fm=253&fmt=auto&app=138&f=JPEG?w=667&h=500",

            "https://img1.baidu.com/it/u=2763288611,2598315854&fm=253&fmt=auto&app=138&f=JPEG?w=667&h=500",
            "https://img1.baidu.com/it/u=4293655378,618480992&fm=253&fmt=auto&app=138&f=JPEG?w=751&h=500",
            "https://ns-strategy.cdn.bcebos.com/ns-strategy/upload/fc_big_pic/part-00162-3385.jpg",

            "https://img0.baidu.com/it/u=295683608,801414253&fm=253&fmt=auto&app=138&f=JPEG?w=500&h=666"
    };
    String[] names = new String[]{"三河古镇", "巢湖国家风景名胜区", "安徽省博物馆", "包公园", "大蜀山国家森林公园",
            "合肥植物园"};
    String[] briefs = new String[]{"三河古镇是一座典型的水乡古镇，位于肥西县南端，地处肥西", "巢湖国家风景名胜区位于皖中，包括巢湖及其附属岛屿",
            "安徽博物院是一家集自然、历史、社教于一体的省级综合类博物馆", "公园以包公“忠、孝、清、廉”的人格魅力吸引着众多游客。", "是合肥近郊唯一的一座大山，也是国家级森林公园",
            "拥有一千多种植物，四季如画，四季有花，四季有果"};
    String[] contents = new String[]{
            "\t\t三河古镇是一座典型的水乡古镇，位于肥西县南端，地处肥西、庐江、舒城交界处。古镇内荟萃了丰富的人文景观，具有典型的“小桥流水人家,水乡古镇特色”。" +
                    "\n\t\t古镇内保存了许多古迹和历史遗存，如城墙、天王府四合院等，让人仿佛穿越回了古代。这里的古镇氛围浓厚，充满了古迹、传统文化和民俗风情，是合肥著名的旅游景点之一。",
            "\t\t巢湖国家风景名胜区位于皖中，包括巢湖及其附属岛屿，总面积约760平方公里。作为中国五大淡水湖之一，巢湖拥有广阔的淡水湖水域。景区内有巢湖博物馆、巢湖风景名胜区、姥山岛等景点，这些景点都展示了巢湖丰富的生态资源。\n\t\t" +
                    "此外，还有姥山岛和姥山湖等水上景点，以及众多的水上娱乐项目，如水上摩托、帆船等。巢湖风景名胜区是合肥周边地区的重要旅游景点之一",
            "\t\t安徽博物院是一家集自然、历史、社教于一体的省级综合类博物馆。成立于1956年，于2010年更名为安徽博物院。" +
                    "馆内陈列了21.8万余件文物，分为15个展厅，实行一院两馆的管理模式。假日期间,安徽博物院迎客无数,前来参观体验的大小朋友络绎不绝",
            "\t\t包公园是包拯的出生地，是为了纪念他的忠诚和清廉而建的。包公祠、包公墓、清风阁和浮庄等景点展示了包公的一生。包公园以包公“忠、孝、清、廉”的人格魅力吸引着众多游客",
            "\t\t大蜀山国家森林公园位于合肥市西部蜀山区内，是合肥近郊唯一的一座大山，也是国家级森林公园、省级风景名胜区、省级地质公园。公园以大蜀山为主体，秋季满山桂花盛开吸引了无数游人。公园内的石梯陡峭，攀爬时要注意安全。" +
                    "\t\t\n大蜀山是合肥近郊难得一见的大山，由火山喷发而成，古火山的火山遗迹至今保存完整。公园内的自然景观优美，还有丰富的户外活动，如漫步高架桥、散养猛兽等",
            "\t\t合肥植物园是合肥的一大景点，拥有一千多种植物。园内环境优美，有绿树成荫、花草芬芳，特别是园内的珍稀植物让人流连忘返。" +
                    "这里的空气清新，适合休闲、亲子旅游、观景娱乐等。作为安徽省唯一的植物园，合肥植物园是合肥市民喜爱的景点之一。"};


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scenery);
        ListView lv = findViewById(R.id.outdoor_lv);

        lv.setAdapter(new SceneryActivity.MyBaseAdapter(SceneryActivity.this));
        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(SceneryActivity.this, SceneryShowActivity.class);
                intent.putExtra("image", images[position]);
                intent.putExtra("content", contents[position]);
                startActivity(intent);
            }
        });
    }

    class MyBaseAdapter extends BaseAdapter {
        private Context context;

        public MyBaseAdapter(SceneryActivity sceneryActivity) {
            context = sceneryActivity;
        }

        @Override
        public int getCount() {
            return images.length;
        }

        @Override
        public Object getItem(int position) {
            return images;
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            View inflate = getLayoutInflater().inflate(R.layout.outdoor_item, parent, false);
            ImageView iv = (ImageView) inflate.findViewById(R.id.outdoor_iv);
            TextView tv1 = (TextView) inflate.findViewById(R.id.outdoor_tv1);
            TextView tv2 = (TextView) inflate.findViewById(R.id.outdoor_tv2);
            tv1.setText(names[position]);
            tv2.setText(briefs[position]);
            Glide.with(context).load(images[position]).into(iv);
            return inflate;
        }
    }
}