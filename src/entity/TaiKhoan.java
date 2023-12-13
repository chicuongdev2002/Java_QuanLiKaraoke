/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entity;
import entity.NhanVien;
/**
 *
 * @author HieuPCW
 */
public class TaiKhoan {
     
    private int maTK;
    private String tenDN;
    private String matKhau;
    private NhanVien nhanVien;
    private boolean trangThai;

    public TaiKhoan(int maTK, String tenDN, String matKhau, NhanVien nhanVien, boolean trangThai) {
        this.maTK = maTK;
        this.tenDN = tenDN;
        this.matKhau = matKhau;
        this.nhanVien = nhanVien;
        this.trangThai = trangThai;
    }

    public TaiKhoan(int maTK) {
        this.maTK = maTK;
    }

    
    
    
    public int getMaTK() {
        return maTK;
    }

    public void setMaTK(int maTK) {
        this.maTK = maTK;
    }

    public String getTenDN() {
        return tenDN;
    }

    public void setTenDN(String tenDN) {
        this.tenDN = tenDN;
    }

    public String getMatKhau() {
        return matKhau;
    }

    public void setMatKhau(String matKhau) {
        this.matKhau = matKhau;
    }

    public NhanVien getNhanVien() {
        return nhanVien;
    }

    public void setNhanVien(NhanVien nhanVien) {
        this.nhanVien = nhanVien;
    }

    public boolean getTrangThai() {
        return trangThai;
    }

    public void setTrangThai(boolean trangThai) {
        this.trangThai = trangThai;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 53 * hash + this.maTK;
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
        final TaiKhoan other = (TaiKhoan) obj;
        return this.maTK == other.maTK;
    }

    @Override
    public String toString() {
        return "TaiKhoan{" + "maTK=" + maTK + ", tenDN=" + tenDN + ", matKhau=" + matKhau + ", nhanVien=" + nhanVien + ", trangThai=" + trangThai + '}';
    }
    
    
    
    
    
    
}
