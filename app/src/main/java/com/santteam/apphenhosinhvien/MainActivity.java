package com.santteam.apphenhosinhvien;

import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.PersistableBundle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.santteam.Adapter.CustomAdapterList;
import com.santteam.ChatActivity;
import com.santteam.TrangCaNhanActivity;
import com.santteam.model.ContactList;
import com.santteam.model.KhachHang;

import com.santteam.ListActivity;
import com.santteam.TimKiemActivity;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    ListView lv_chat;
    ImageButton imgBtnKetBan, imgBtnYeuThich, imgBtnDanhSach, imgBtnTinNhan, imgBtnTimKiem;
    ImageView imvAnhDaiDien;
    TextView tvTen;
    private static KhachHang kh;
    SharedPreferences sharedPreferences;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        addControls();
        sharedPreferences = getSharedPreferences("data",MODE_PRIVATE);
        Intent intent = getIntent();
        kh = (KhachHang) intent.getSerializableExtra("KhachHang");
        if (kh != null) {
            imvAnhDaiDien.setImageResource(kh.getAnhDaiDien());
            tvTen.setText(kh.getTenDangNhap());
            SharedPreferences.Editor editor = sharedPreferences.edit();
            editor.putString("username",kh.getTenDangNhap());
            editor.putInt("anhdaidien",kh.getAnhDaiDien());
            editor.commit();
        }
        else {
            //Lấy giá trị
            imvAnhDaiDien.setImageResource(sharedPreferences.getInt("anhdaidien", R.drawable.add_01));
            tvTen.setText(sharedPreferences.getString("username", ""));
        }

        addEvens();
        Log.d("AAA", " onCreate main");


        //creat list chat
        lv_chat = (ListView)findViewById(R.id.lv_list);
        ArrayList<ContactList> arrContact = new ArrayList<>();

        ContactList contactList = new ContactList(Color.BLUE, "Nguyễn Thị Nam", "Hello boy !!!");
        ContactList contactList1 = new ContactList(Color.RED, "Nguyễn Thị An", "Hello boy !!!");
        ContactList contactList2 = new ContactList(Color.BLACK, "Nguyễn Thị Song Tuyển", "Hello boy !!!");
        ContactList contactList3 = new ContactList(Color.BLUE, "Nguyễn Thị Nam An", "Hello boy !!!");
        ContactList contactList4 = new ContactList(Color.BLUE, "Nguyễn Thị Nam", "Hello boy !!!");
        ContactList contactList5 = new ContactList(Color.YELLOW, "Nguyễn Thị Tuyển An", "Hello boy !!!");

        arrContact.add(contactList);
        arrContact.add(contactList1);
        arrContact.add(contactList2);
        arrContact.add(contactList3);
        arrContact.add(contactList4);
        arrContact.add(contactList5);

        CustomAdapterList customAdapterList = new CustomAdapterList(this,R.layout.show_listchat,arrContact);
        lv_chat.setAdapter(customAdapterList);

    }


    private void addEvens() {

        imgBtnTinNhan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, ListActivity.class);
                startActivity(intent);
            }
        });
        imgBtnTimKiem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, TimKiemActivity.class);
                startActivity(intent);
            }
        });
        imvAnhDaiDien.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, TrangCaNhanActivity.class);
                startActivity(intent);
            }
        });
        lv_chat.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent mh_chat = new Intent(MainActivity.this, ChatActivity.class);
                startActivity(mh_chat);
            }
        });
    }

    private void addControls() {
        imgBtnKetBan = (ImageButton) findViewById(R.id.imgBtnKetBan);
        imgBtnYeuThich = (ImageButton) findViewById(R.id.imgBtnYeuThich);
        imgBtnDanhSach = (ImageButton) findViewById(R.id.imgBtnDanhSach);
        imgBtnTinNhan = (ImageButton) findViewById(R.id.imgBtnTinNhan);
        imgBtnTimKiem = (ImageButton) findViewById(R.id.imgBtnTimKiem);
        imvAnhDaiDien = (ImageView) findViewById(R.id.imvAnhDaiDien);
        tvTen = (TextView) findViewById(R.id.tvTen);
    }
}
