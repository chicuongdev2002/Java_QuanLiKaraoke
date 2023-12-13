/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entity;

/**
 *
 * @author HP
 */
public class DonViDichVu {
    private int maDonVi;
    private String tenDonVi;
    private LoaiDichVu maLoaiDV;

    public DonViDichVu() {
    }

    public DonViDichVu(int maDonVi, String tenDonVi, LoaiDichVu maLoaiDV) {
        this.maDonVi = maDonVi;
        this.tenDonVi = tenDonVi;
        this.maLoaiDV = maLoaiDV;
    }

    public DonViDichVu(String tenDonVi, LoaiDichVu maLoaiDV) {
        this.tenDonVi = tenDonVi;
        this.maLoaiDV = maLoaiDV;
    }

    public DonViDichVu(String tenDonVi) {
        this.tenDonVi = tenDonVi;
    }
    

    public DonViDichVu(int maDonVi) {
        this.maDonVi = maDonVi;
    }

    public LoaiDichVu getMaLoaiDV() {
        return maLoaiDV;
    }

    public int getMaDonVi() {
        return maDonVi;
    }

    public String getTenDonVi() {
        return tenDonVi;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 41 * hash + this.maDonVi;
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
        final DonViDichVu other = (DonViDichVu) obj;
        return this.maDonVi == other.maDonVi;
    }

    @Override
    public String toString() {
        return "DonViDichVu{" + "maDonVi=" + maDonVi + ", tenDonVi=" + tenDonVi + '}';
    }
    
}
