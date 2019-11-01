package com.example.mzy;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    ImageView iv;
    boolean isChanged = false;
    EditText ed_get;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button btn_send=findViewById(R.id.button);
        iv= findViewById(R.id.imageView);
        ed_get=findViewById(R.id.editText);
        btn_send.setOnClickListener(this);
    }
    public void onClick(View v) {
        String text = ed_get.getText().toString();
        Log.i("mzy", text);
        if (text.equals("mzy")) {
            iv.setImageDrawable(getResources().getDrawable(R.drawable.m));
            Toast.makeText(this, "马芝洋的头像已切换", Toast.LENGTH_LONG).show();
            time();
        }
        else {
            ed_get.setText(null);
            Toast.makeText(this, "密码错误！\n"+"请重新输入密码", Toast.LENGTH_LONG).show();

        }
            isChanged = !isChanged;

    }

    public void time(){
        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                ed_get.setText(null);
                iv.setImageResource(R.drawable.dragon);
            }
        }, 1800);//ms后执行Runnable中的run方法
    }
}
