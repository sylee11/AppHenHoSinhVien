package com.santteam;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.santteam.apphenhosinhvien.MainActivity;
import com.santteam.apphenhosinhvien.R;
import com.santteam.model.KhachHang;

import java.util.ArrayList;

public class DangNhapActivity extends AppCompatActivity {

    EditText edtMatKhau,edtTenDN;
    TextView tvDangKy;
    static ArrayList<KhachHang>arrKhachhang;
    Button btnDangNhap;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dang_nhap);
        addControls();
        addEvens();
        fakeData();

    }

    private void fakeData() {
        arrKhachhang=new ArrayList<KhachHang>();
        arrKhachhang.add(new KhachHang(00,"santteam","santteam","BKDN","1/1/1997","Nam","Gai",R.drawable.add_01));
        arrKhachhang.add(new KhachHang(01,"admin","admin","BKDN","1/1/1997","Nam","Gai",R.drawable.add_03));
        arrKhachhang.add(new KhachHang(02,"santteam1","santteam1","BKDN","1/1/1997","Nam","Gai",R.drawable.add_04));
        arrKhachhang.add(new KhachHang(03,"santteam2","santteam2","BKDN","1/1/1997","Nam","Gai",R.drawable.add_03));
        arrKhachhang.add(new KhachHang(04,"santteam3","santteam3","BKDN","1/1/1997","Nam","Gai",R.drawable.add_02));
        //themVaoTuManHinhDangKy();

    }

    private void themVaoTuManHinhDangKy() {
        Intent intent=getIntent();
        KhachHang kh= (KhachHang) intent.getSerializableExtra("KhachHang");
        arrKhachhang.add(kh);
    }

    private void addEvens() {
        //------------Intent Tu man hinh dang Ky---------
        Intent intent=getIntent();
        String taiKhoan=intent.getStringExtra("Ten Dang Nhap");
        String matKhau=intent.getStringExtra("Mat Khau");

        edtTenDN.setText(taiKhoan);
        edtMatKhau.setText(matKhau);
        //----------Inten Sang Man Hinh Dang Ky---------
        tvDangKy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(DangNhapActivity.this,DangKyActivity.class);
                startActivity(intent);
            }
        });
        btnDangNhap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int dem=0;
                if(edtTenDN.length()==0 || edtMatKhau.length()==0)
                    Toast.makeText(DangNhapActivity.this,"Nhập Thiếu Kìa !!",Toast.LENGTH_LONG);
                else{
                    String tenDangNhap=edtTenDN.getText().toString();
                    String matKhau=edtMatKhau.getText().toString();

                    for(KhachHang kh:arrKhachhang){
                        if(kh.getTenDangNhap().compareTo(tenDangNhap)==0 &&
                                kh.getMatkhau().compareTo(matKhau)==0)
                        {
                            Toast.makeText(DangNhapActivity.this,"Đăng Nhập Thành Công !!",Toast.LENGTH_LONG).show();
                            Intent intent=new Intent(DangNhapActivity.this, MainActivity.class);
                            intent.putExtra("KhachHang",kh);
                            startActivity(intent);
                        }
                        else dem++;
                    }
                    if(dem==(arrKhachhang.size())) Toast.makeText(DangNhapActivity.this,
                            "Sai Mật Khẩu Hoặc Tên Đăng Nhập !!",Toast.LENGTH_LONG).show();
                }
            }
        });

    }

    private void addControls() {
        edtMatKhau= (EditText) findViewById(R.id.edtMatKhau);
        edtTenDN= (EditText) findViewById(R.id.edtTenDN);
        tvDangKy= (TextView) findViewById(R.id.tvDangKy);
        btnDangNhap= (Button) findViewById(R.id.btnDangNhap);

    }
}
