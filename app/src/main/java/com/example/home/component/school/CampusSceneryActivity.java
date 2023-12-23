package com.example.home.component.school;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager2.adapter.FragmentStateAdapter;
import androidx.viewpager2.widget.ViewPager2;

import android.content.Context;
import android.media.Image;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.example.home.R;

public class CampusSceneryActivity extends AppCompatActivity {
    public static final String[] imageUrl =
            new String[]{
                    "https://ts1.cn.mm.bing.net/th/id/R-C.66f5d2d12dcd20261773eb82f59a6d8a?rik=qMNVmaig1XPkqA&riu=http%3a%2f%2fwx.qlogo.cn%2fmmopen%2fJjzCUOOx7W6QudAiaJpPWpKPwUegdR8n8K3j3rGyOD4iciccbdZmyKs3V7qqq3ibCyAgiaBNgeGicKGHHlr8Ipevj202B6tlXk8Fcy%2f0&ehk=Z%2fyVGyZZUMJlVL5aXWOeiXWjMdM94J3fgwKS1e0YHqs%3d&risl=&pid=ImgRaw&r=0",
                    "https://ts1.cn.mm.bing.net/th/id/R-C.d51a447d0a328ac2ed15683ed581f73b?rik=hV1yt33X3wLQzQ&riu=http%3a%2f%2fwww.ahtcm.edu.cn%2f__local%2fD%2f51%2fA4%2f47D0A328AC2ED15683ED581F73B_E43E99B7_13E206.png&ehk=fqzk%2bNmOsjvHiSV5ni%2f81xqzZFo4NqVzJQtUmcVlQhI%3d&risl=&pid=ImgRaw&r=0",
                    "https://tse3-mm.cn.bing.net/th/id/OIP-C.bwMjqn6DKqNB_xdWhs916QHaEw?w=286&h=184&c=7&r=0&o=5&dpr=1.1&pid=1.7"
            };
//    private static String url = imageUrl[0];
    public ImageView iv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_campus_scenery2);
         iv = (ImageView) findViewById(R.id.iv);


        Glide.with(this).load(imageUrl[0]).into(iv);
        RecyclerView rc = (RecyclerView) findViewById(R.id.rv);

        rc.setAdapter(new CampusSceneryAdapter(this));
        rc.setLayoutManager(new GridLayoutManager(this, 3));
    }

    class CampusSceneryAdapter extends RecyclerView.Adapter<CampusSceneryAdapter.MyViewHolder> {
        private Context context;
        public CampusSceneryAdapter(Context context) {
            this.context = context;
        }

        @NonNull
        @Override
        public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            LayoutInflater layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            View inflate = layoutInflater.inflate(R.layout.activity_campus_scenery2_item, parent, false);
            return new MyViewHolder(inflate);
        }

        @Override
        public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {

            ImageView imageView = holder.itemView.findViewById(R.id.item_image_view);
            System.out.println("我是111");
            System.out.println(position);
            Glide.with(CampusSceneryActivity.this)
                    .load(imageUrl[position])
                    .thumbnail(0.1f)
                    .into(imageView);
            imageView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    iv.post(new Runnable() {
                        @Override
                        public void run() {
                            Glide.with(CampusSceneryActivity.this).load(imageUrl[position]).into(iv);
                        }
                    });
                }
            });
        }

        @Override
        public int getItemCount() {
            return imageUrl.length;
        }


        class MyViewHolder extends RecyclerView.ViewHolder {
            public MyViewHolder(@NonNull View itemView) {
                super(itemView);
            }
        }
    }
}