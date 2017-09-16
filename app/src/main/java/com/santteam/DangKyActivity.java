package com.santteam;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

import com.santteam.apphenhosinhvien.R;

import java.util.Calendar;

public class DangKyActivity extends AppCompatActivity {

    Button btnDangKy,btnChonNgay;
    TextView tvNamSinh;
    EditText edtHocTruong,edtTenDN,edtMatKhau,edtNhapLaiMK,edtKhac;
    RadioButton radNam,radNu;
    CheckBox chkNgheNhac,chkTheThao,chkMiThuat,chkToanHoc,chkThienVanHoc,chkDuLich;
    ImageButton imgBtnBack;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dang_ky);

        addControls();
        addEvens();
    }

    private void addEvens() {
        btnChonNgay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Calendar calendar=Calendar.getInstance();
                int year=calendar.get(Calendar.YEAR);
                int month=calendar.get(Calendar.MONTH);
                int day=calendar.get(Calendar.DAY_OF_MONTH);

                DatePickerDialog.OnDateSetListener onDateSetListener= new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker datePicker, int i, int i1, int i2) {
                        tvNamSinh.setText(i2+"/"+i1+"/"+i);
                    }
                };
                DatePickerDialog dialog=new DatePickerDialog(DangKyActivity.this,onDateSetListener,year,month,day);
                dialog.show();
            }
        });
        btnDangKy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(edtTenDN.getText().toString().compareTo("")==0 ||
                        edtMatKhau.getText().toString().compareTo("")==0 ||
                        edtNhapLaiMK.getText().toString().compareTo("")==0 ||
                        edtHocTruong.getText().toString().compareTo("")==0 ||
                     (radNam.isSelected()==true && radNu.isSelected()==true))
                    Toast.makeText(DangKyActivity.this,"Thong Tin Nhap Chua day Du!!",Toast.LENGTH_LONG).show();
                else if(edtMatKhau.getText().toString().compareTo(edtNhapLaiMK.getText().toString())!=0) {
                    Toast.makeText(DangKyActivity.this,"Mat Khau Nhap Lai Khong Chinh Xac!!",Toast.LENGTH_LONG).show();
                }
                else{
                    Intent intent=new Intent(DangKyActivity.this,DangNhapActivity.class);
                    String gioiTinh;
                    if(radNu.isSelected()==true) gioiTinh="Nu";
                    else gioiTinh="Nam";
                    intent.putExtra("Gioi Tinh",gioiTinh);
                    String sothich="";
                    switch (1){
                        case 1:if(chkDuLich.isSelected()==true) sothich+=chkDuLich.getText().toString();
                        case 2:if(chkMiThuat.isSelected()==true) sothich+=chkMiThuat.getText().toString();
                        case 3:if(chkToanHoc.isSelected()==true) sothich+=chkToanHoc.getText().toString();
                        case 4:if(chkThienVanHoc.isSelected()==true) sothich+=chkThienVanHoc.getText().toString();
                        case 5:if(chkTheThao.isSelected()==true) sothich+=chkTheThao.getText().toString();
                        case 6:if(chkNgheNhac.isSelected()==true) sothich+=chkNgheNhac.getText().toString();
                    }
                    String tenDangNhap=edtTenDN.getText().toString();
                    String matKhau=edtMatKhau.getText().toString();
                    String hocTruong=edtHocTruong.getText().toString();
                    String ngaySinh=tvNamSinh.getText().toString();
//                    KhachHang kh=new KhachHang(01,tenDangNhap,matKhau,hocTruong,ngaySinh,gioiTinh,sothich);
//                    intent.putExtra("khachHang",kh);
//                    startActivity(intent);
                    //------------tao doi tuong moi va dua doi tuong vao arraylist----------------

                }
            }
        });
        imgBtnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(DangKyActivity.this,DangNhapActivity.class);
                startActivity(intent);
            }
        });
    }

    private void addControls() {
        tvNamSinh= (TextView) findViewById(R.id.tvNamSinh);
        btnChonNgay= (Button) findViewById(R.id.btnChonNgay);
        btnDangKy= (Button) findViewById(R.id.btnDangKy);
        edtTenDN= (EditText) findViewById(R.id.edtTenDN);
        edtMatKhau= (EditText) findViewById(R.id.edtMatKhau);
        edtNhapLaiMK= (EditText) findViewById(R.id.edtNhapLaiMK);
        edtHocTruong= (EditText) findViewById(R.id.edtHocTruong);
        radNam= (RadioButton) findViewById(R.id.radNam);
        radNu= (RadioButton) findViewById(R.id.radNu);
        edtKhac= (EditText) findViewById(R.id.edtKhac);
        chkDuLich= (CheckBox) findViewById(R.id.chkDuLich);
        chkMiThuat= (CheckBox) findViewById(R.id.chkMiThuat);
        chkNgheNhac= (CheckBox) findViewById(R.id.chkNgheNhac);
        chkTheThao= (CheckBox) findViewById(R.id.chkTheThao);
        chkThienVanHoc= (CheckBox) findViewById(R.id.chkThienVanHoc);
        chkToanHoc= (CheckBox) findViewById(R.id.chkToanHoc);
        imgBtnBack= (ImageButton) findViewById(R.id.imgBtnBack);

    }
}
