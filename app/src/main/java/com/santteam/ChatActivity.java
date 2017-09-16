package com.santteam;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.santteam.apphenhosinhvien.MainActivity;
import com.santteam.apphenhosinhvien.R;

public class ChatActivity extends AppCompatActivity {
    Button btn_backchat;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chat);

        btn_backchat = (Button)findViewById(R.id.btn_backchat);
        btn_backchat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent mh_list = new Intent(ChatActivity.this, MainActivity.class);
                startActivity(mh_list);
            }
        });
    }

}
