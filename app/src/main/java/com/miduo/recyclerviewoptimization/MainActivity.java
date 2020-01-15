package com.miduo.recyclerviewoptimization;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class MainActivity extends AppCompatActivity {

    RecyclerView recycler;
    List<Desc> datas;
    ReAdapter reAdapter;

    Button button;
    int id=101;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        datas=new ArrayList<>();

        reAdapter=new ReAdapter(this,datas);
        reAdapter.setCallBackListener(new ReAdapter.CallBackListener() {
            @Override
            public void onClick(int position) {
                Toast.makeText(MainActivity.this,"点击"+position,Toast.LENGTH_SHORT).show();
            }
        });
        initData();
        recycler=findViewById(R.id.recycler);
        button=findViewById(R.id.button);
        LinearLayoutManager linearLayoutManager=new LinearLayoutManager(this);
        linearLayoutManager.setItemPrefetchEnabled(true);
        recycler.setLayoutManager(linearLayoutManager);
        recycler.setAdapter(reAdapter);

        button.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
//                Desc desc=new Desc();
//                desc.setPic("https://img.iplaysoft.com/wp-content/uploads/2019/free-images/free_stock_photo.jpg");
//                desc.setText("图片描述信息:"+id);
//                desc.setId(id++);
//                datas.add(desc);
                reAdapter.notifyDataSetChanged();
            }
        });

    }

    private List<String> pics=new ArrayList<>();

    public void initData()
    {
        pics.add("https://i.keaitupian.net/up/97/19/61/c1dc018dddbddf3c4d7a9cf27d611997.jpg");
        pics.add("https://www.canva.cn/learn/wp-content/uploads/sites/17/2019/09/Snipaste_2019-09-24_15-21-59.png");
        pics.add("https://uploadfile.huiyi8.com/up/a2/e3/83/a2e3832e52216b846c80313049591938.jpg");
        pics.add("https://img0.sc115.com/uploads3/sc/jpgs/1909/zzpic19910_sc115.com.jpg");
        Random random=new Random();
        for (int i=0;i<10;i++)
        {
            Desc desc=new Desc();
            desc.setPic(pics.get(random.nextInt(3)+1));
            desc.setText("图片描述信息:"+id);
            desc.setId(id++);
            datas.add(desc);
        }
    }


}
