/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entity;

import java.util.Objects;

/**
 *
 * @author HP
 */
// kieeur z a'
//h đang làm nè,đang sửa lại
//cho t muon 
// dich vu nao la s
//à là bên m kiểu k dùng hình ảnh
//tại bên t sơ sài quá nên làm cho nó có chút ảnh,ben t  ko dung,z thoi a
//z thoi t làm đại z mệt vs team vc ,z làm đi h t cũng đang làm ok
public class Phong {

    private String maPhong;
    private int sucChua;
    private String viTri;
    private LoaiPhong loaiPhong; 
    private Boolean tinhTrang;

    public Phong() {
    }

    public Phong(String maPhong, int sucChua, String viTri, LoaiPhong loaiPhong, Boolean tinhTrang) {
        this.maPhong = maPhong;
        this.sucChua = sucChua;
        this.viTri = viTri;
        this.loaiPhong = loaiPhong;
        this.tinhTrang = tinhTrang;
    }

    public Phong(String maPhong, int sucChua, String viTri, LoaiPhong loaiPhong) {
        this.maPhong = maPhong;
        this.sucChua = sucChua;
        this.viTri = viTri;
        this.loaiPhong = loaiPhong;
    }

    public Phong(String maPhong) {
        this.maPhong = maPhong;
    }

    public String getMaPhong() {
        return maPhong;
    }

    public void setMaPhong(String maPhong) {
        this.maPhong = maPhong;
    }

    public int getSucChua() {
        return sucChua;
    }

    public void setSucChua(int sucChua) {
        this.sucChua = sucChua;
    }

    public String getViTri() {
        return viTri;
    }

    public void setViTri(String viTri) {
        this.viTri = viTri;
    }

    public LoaiPhong getLoaiPhong() {
        return loaiPhong;
    }

    public void setLoaiPhong(LoaiPhong loaiPhong) {
        this.loaiPhong = loaiPhong;
    }

    public Boolean getTinhTrang() {
        return tinhTrang;
    }

    public void setTinhTrang(Boolean tinhTrang) {
        this.tinhTrang = tinhTrang;
    }

    @Override
    public String toString() {
        return "Phong{" + "maPhong=" + maPhong + ", sucChua=" + sucChua + ", viTri=" + viTri + ", loaiPhong=" + loaiPhong + ", tinhTrang=" + tinhTrang + '}';
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 61 * hash + Objects.hashCode(this.maPhong);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Phong other = (Phong) obj;
        return Objects.equals(this.maPhong, other.maPhong);
    }
    

}