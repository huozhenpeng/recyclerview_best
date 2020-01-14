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

public class MainActivity extends AppCompatActivity {

    RecyclerView recycler;
    List<Desc> datas;
    ReAdapter reAdapter;

    Button button;
    int id=0;
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
        recycler=findViewById(R.id.recycler);
        button=findViewById(R.id.button);
        recycler.setLayoutManager(new LinearLayoutManager(this));
        recycler.setAdapter(reAdapter);

        button.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                Desc desc=new Desc();
                desc.setPic("https://img.iplaysoft.com/wp-content/uploads/2019/free-images/free_stock_photo.jpg");
                desc.setText("图片描述信息:"+id);
                desc.setId(id++);
                datas.add(desc);
                reAdapter.notifyDataSetChanged();
            }
        });

    }
}
