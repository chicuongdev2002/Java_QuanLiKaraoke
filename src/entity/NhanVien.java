/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entity;

import java.sql.Date;

/**
 *
 * @author HieuPCW
 */
public class NhanVien {
    
     private int maNV;
     private String hoTen;
     private String diaChi;
     private Date NgaySinh;
     private String SDT;
     private int  chucVu;
     private boolean gioiTinh;

//

    public NhanVien(int maNV, String hoTen, String diaChi, Date NgaySinh, String SDT, int chucVu, boolean gioiTinh) {
        this.maNV = maNV;
        this.hoTen = hoTen;
        this.diaChi = diaChi;
        this.NgaySinh = NgaySinh;
        this.SDT = SDT;
        this.chucVu = chucVu;
        this.gioiTinh = gioiTinh;
    }

    public NhanVien(String hoTen, String diaChi, Date NgaySinh, String SDT, int chucVu, boolean gioiTinh) {
        this.hoTen = hoTen;
        this.diaChi = diaChi;
        this.NgaySinh = NgaySinh;
        this.SDT = SDT;
        this.chucVu = chucVu;
        this.gioiTinh = gioiTinh;
    }
     
     
    public NhanVien(int maNV) {
        this.maNV = maNV;
    }

    public NhanVien() {
        
        
    }

     
     
     
     
    public void setMaNV(int maNV) {
        this.maNV = maNV;
    }

    public void setHoTen(String hoTen) {
        this.hoTen = hoTen;
    }

    public void setDiaChi(String diaChi) {
        this.diaChi = diaChi;
    }

    public void setNgaySinh(Date NgaySinh) {
        this.NgaySinh = NgaySinh;
    }

    public void setSDT(String SDT) {
        this.SDT = SDT;
    }

 

    public void setGioiTinh(boolean gioiTinh) {
        this.gioiTinh = gioiTinh;
    }

     
     
     
    public int getMaNV() {
        return maNV;
    }

    public String getHoTen() {
        return hoTen;
    }

    public String getDiaChi() {
        return diaChi;
    }

    public Date getNgaySinh() {
        return NgaySinh;
    }

    public String getSDT() {
        return SDT;
    }


    public boolean getGioiTinh() {
        return gioiTinh;
    }

    public int getChucVu() {
        return chucVu;
    }

    public void setChucVu(int chucVu) {
        this.chucVu = chucVu;
    }

    @Override
    public String toString() {
        return "NhanVien{" + "maNV=" + maNV + ", hoTen=" + hoTen + ", diaChi=" + diaChi + ", NgaySinh=" + NgaySinh + ", SDT=" + SDT + ", chucVu=" + chucVu + ", gioiTinh=" + gioiTinh + '}';
    }

    
    

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 43 * hash + this.maNV;
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
        final NhanVien other = (NhanVien) obj;
        return this.maNV == other.maNV;
    }
     
     
     
     
     
    
    
    
    
}
