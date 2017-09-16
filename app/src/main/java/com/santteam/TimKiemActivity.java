package com.santteam;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.ImageButton;

import com.santteam.apphenhosinhvien.MainActivity;
import com.santteam.apphenhosinhvien.R;
import com.santteam.model.KhachHang;

import java.util.ArrayList;


public class TimKiemActivity extends AppCompatActivity {
    GridView gvUser;
    ImageButton imgBtnBack;
    ArrayList<AnhDaiDienUser> anhDaiDienUsers;
    AnhDaiDienUserAdapter anhDaiDienUserAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tim_kiem);
        addControls();
        fakeData();
        anhDaiDienUserAdapter = new AnhDaiDienUserAdapter(TimKiemActivity.this,R.layout.item_list_anh_dai_dien_user,anhDaiDienUsers);
        gvUser.setAdapter(anhDaiDienUserAdapter);
        addEvens();
    }

    private void fakeData() {
        anhDaiDienUsers = new ArrayList<>();
        anhDaiDienUsers.add(new AnhDaiDienUser("username1",R.drawable.add_02));
        anhDaiDienUsers.add(new AnhDaiDienUser("username2",R.drawable.add_03));
        anhDaiDienUsers.add(new AnhDaiDienUser("username3",R.drawable.add_04));
        anhDaiDienUsers.add(new AnhDaiDienUser("username4",R.drawable.add_02));
        anhDaiDienUsers.add(new AnhDaiDienUser("username5",R.drawable.add_03));
        anhDaiDienUsers.add(new AnhDaiDienUser("username6",R.drawable.add_04));
        anhDaiDienUsers.add(new AnhDaiDienUser("username7",R.drawable.add_02));
        anhDaiDienUsers.add(new AnhDaiDienUser("username8",R.drawable.add_03));
        anhDaiDienUsers.add(new AnhDaiDienUser("username9",R.drawable.add_04));
        anhDaiDienUsers.add(new AnhDaiDienUser("username10",R.drawable.add_02));
        anhDaiDienUsers.add(new AnhDaiDienUser("username11",R.drawable.add_03));
        anhDaiDienUsers.add(new AnhDaiDienUser("username12",R.drawable.add_04));
        anhDaiDienUsers.add(new AnhDaiDienUser("username13",R.drawable.add_02));
        anhDaiDienUsers.add(new AnhDaiDienUser("username14",R.drawable.add_03));
        anhDaiDienUsers.add(new AnhDaiDienUser("username15",R.drawable.add_04));
        anhDaiDienUsers.add(new AnhDaiDienUser("username16",R.drawable.add_02));
        anhDaiDienUsers.add(new AnhDaiDienUser("username17",R.drawable.add_03));
        anhDaiDienUsers.add(new AnhDaiDienUser("username18",R.drawable.add_04));
        anhDaiDienUsers.add(new AnhDaiDienUser("username19",R.drawable.add_02));
        anhDaiDienUsers.add(new AnhDaiDienUser("username20",R.drawable.add_03));
        anhDaiDienUsers.add(new AnhDaiDienUser("username21",R.drawable.add_04));
        anhDaiDienUsers.add(new AnhDaiDienUser("username22",R.drawable.add_02));
        anhDaiDienUsers.add(new AnhDaiDienUser("username23",R.drawable.add_03));
        anhDaiDienUsers.add(new AnhDaiDienUser("username24",R.drawable.add_04));
        anhDaiDienUsers.add(new AnhDaiDienUser("username25",R.drawable.add_02));
        anhDaiDienUsers.add(new AnhDaiDienUser("username26",R.drawable.add_03));
        anhDaiDienUsers.add(new AnhDaiDienUser("username27",R.drawable.add_04));
        anhDaiDienUsers.add(new AnhDaiDienUser("username28",R.drawable.add_02));
        anhDaiDienUsers.add(new AnhDaiDienUser("username29",R.drawable.add_03));
        anhDaiDienUsers.add(new AnhDaiDienUser("username30",R.drawable.add_04));
        anhDaiDienUsers.add(new AnhDaiDienUser("username31",R.drawable.add_02));
        anhDaiDienUsers.add(new AnhDaiDienUser("username32",R.drawable.add_03));
        anhDaiDienUsers.add(new AnhDaiDienUser("username33",R.drawable.add_04));
    }


    private void addEvens() {
        imgBtnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(TimKiemActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });
        gvUser.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intent = new Intent(TimKiemActivity.this,TrangCaNhanActivity.class);
                intent.putExtra("KhachHang",anhDaiDienUsers.get(i).getUsername());
                startActivity(intent);
            }
        });
    }

    private void addControls() {
        imgBtnBack= (ImageButton) findViewById(R.id.imgBtnBack);
        gvUser = (GridView) findViewById(R.id.gvUser);
    }
}
