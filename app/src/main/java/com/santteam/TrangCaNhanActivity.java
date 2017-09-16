package com.santteam;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.santteam.apphenhosinhvien.MainActivity;
import com.santteam.apphenhosinhvien.R;

public class TrangCaNhanActivity extends AppCompatActivity implements View.OnClickListener{
    TextView tvUsername;
    ImageView imgBack,imgAnhDaiDien;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_trang_ca_nhan);
        addcontrols();
        addEvents();
    }

    private void addEvents() {
        imgBack.setOnClickListener(this);
    }

    private void addcontrols() {
        tvUsername = (TextView) findViewById(R.id.tvUsername);
        imgAnhDaiDien = (ImageView) findViewById(R.id.imvAnhDaiDien);
        imgBack = (ImageView) findViewById(R.id.imgBack);
    }

    @Override
    public void onClick(View view) {
        if(view.getId() == R.id.imgBack)
        {
            Intent intent = new Intent(TrangCaNhanActivity.this, MainActivity.class);
            startActivity(intent);
        }
    }
}
