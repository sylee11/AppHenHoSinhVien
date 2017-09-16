package com.santteam;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.santteam.apphenhosinhvien.MainActivity;
import com.santteam.apphenhosinhvien.R;

public class ListActivity extends AppCompatActivity {

    Button btnBack;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);
        addControls();
        addEvens();
    }

    private void addEvens() {
        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(ListActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });
    }

    private void addControls() {
        btnBack= (Button) findViewById(R.id.btnBack);
    }
}
