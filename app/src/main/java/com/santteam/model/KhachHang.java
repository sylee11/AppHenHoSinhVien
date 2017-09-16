package com.santteam.model;

import java.io.Serializable;

/**
 * Created by Songtuyen on 9/15/2017.
 */

public class KhachHang implements Serializable {
    private int id;
    private String tenDangNhap;
    private String matkhau;
    private String truongHoc;
    private String namSinh;
    private String gioiTinh;
    private String soThich;
    private int anhDaiDien;

    public KhachHang(int id, String tenDangNhap, String matkhau, String truongHoc, String namSinh, String gioiTinh, String soThich, int anhDaiDien) {
        this.id = id;
        this.tenDangNhap = tenDangNhap;
        this.matkhau = matkhau;
        this.truongHoc = truongHoc;
        this.namSinh = namSinh;
        this.gioiTinh = gioiTinh;
        this.soThich = soThich;
        this.anhDaiDien = anhDaiDien;
    }


    public int getAnhDaiDien() {
        return anhDaiDien;
    }

    public void setAnhDaiDien(int anhDaiDien) {
        this.anhDaiDien = anhDaiDien;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTenDangNhap() {
        return tenDangNhap;
    }

    public void setTenDangNhap(String tenDangNhap) {
        this.tenDangNhap = tenDangNhap;
    }

    public String getMatkhau() {
        return matkhau;
    }

    public void setMatkhau(String matkhau) {
        this.matkhau = matkhau;
    }

    public String getTruongHoc() {
        return truongHoc;
    }

    public void setTruongHoc(String truongHoc) {
        this.truongHoc = truongHoc;
    }

    public String getNamSinh() {
        return namSinh;
    }

    public void setNamSinh(String namSinh) {
        this.namSinh = namSinh;
    }

    public String getGioiTinh() {
        return gioiTinh;
    }

    public void setGioiTinh(String gioiTinh) {
        this.gioiTinh = gioiTinh;
    }

    public String getSoThich() {
        return soThich;
    }

    public void setSoThich(String soThich) {
        this.soThich = soThich;
    }
}
