/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entity;

/**
 *
 * @author HP
 */
public class DichVu {

    private int maDichVu;
    private String tenDichVu;
    private double donGia;
    private int soLuongTon;
    private DonViDichVu donVi;

    public DichVu() {
    }

    public DichVu(String tenDichVu) {
        this.tenDichVu = tenDichVu;
    }

    public DichVu(int maDichVu) {
        this.maDichVu = maDichVu;
    }

    public DichVu(String tenDichVu, double donGia, int soLuongTon) {
        this.tenDichVu = tenDichVu;
        this.donGia = donGia;
        this.soLuongTon = soLuongTon;
    }

    public DichVu(int maDichVu, int soLuongTon) {
        this.maDichVu = maDichVu;
        this.soLuongTon = soLuongTon;
    }

    public DichVu(int maDichVu, String tenDichVu, double donGia, int soLuongTon) {
        this.maDichVu = maDichVu;
        this.tenDichVu = tenDichVu;
        this.donGia = donGia;
        this.soLuongTon = soLuongTon;
    }

    public DichVu(int maDichVu, String tenDichVu, int soLuongTon, DonViDichVu donVi) {
        this.maDichVu = maDichVu;
        this.tenDichVu = tenDichVu;
        this.soLuongTon = soLuongTon;
        this.donVi = donVi;
    }

    public DichVu(int maDichVu, String tenDichVu,int soLuongTon, double donGia,DonViDichVu donVi) {
        this.maDichVu = maDichVu;
        this.tenDichVu = tenDichVu;
        this.donGia = donGia;
        this.soLuongTon = soLuongTon;
        this.donVi = donVi;
    }

    public DichVu(String tenDichVu, double donGia, int soLuongTon, DonViDichVu donVi) {
        this.tenDichVu = tenDichVu;
        this.donGia = donGia;
        this.soLuongTon = soLuongTon;
        this.donVi = donVi;
    }
    

    public int getMaDichVu() {
        return maDichVu;
    }

    public String getTenDichVu() {
        return tenDichVu;
    }


    public double getDonGia() {
        return donGia;
    }

    public int getSoLuongTon() {
        return soLuongTon;
    }

    public DonViDichVu getDonVi() {
        return donVi;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 97 * hash + this.maDichVu;
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
        final DichVu other = (DichVu) obj;
        return this.maDichVu == other.maDichVu;
    }

    @Override
    public String toString() {
        return "DichVu{" + "maDichVu=" + maDichVu + ", tenDichVu=" + tenDichVu + ", loai=" + ", donGia=" + donGia + ", soLuongTon=" + soLuongTon + ", donVi=" + donVi + '}';
    }

}
