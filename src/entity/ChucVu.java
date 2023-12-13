/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entity;

/**
 *
 * @author HP
 */
public class ChucVu {

    private int maChucVu;
    private String tenChucVu;

    public ChucVu(int maChucVu) {
        this.maChucVu = maChucVu;
    }

    public ChucVu() {
    }

    public ChucVu(String tenChucVu) {
        this.tenChucVu = tenChucVu;
    }

    public ChucVu(int maChucVu, String tenChucVu) {
        this.maChucVu = maChucVu;
        this.tenChucVu = tenChucVu;
    }

    public int getMaChucVu() {
        return maChucVu;
    }

    public void setMaChucVu(int maChucVu) {
        this.maChucVu = maChucVu;
    }

    public String getTenChucVu() {
        return tenChucVu;
    }

    public void setTenChucVu(String tenChucVu) {
        this.tenChucVu = tenChucVu;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 67 * hash + this.maChucVu;
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
        final ChucVu other = (ChucVu) obj;
        return this.maChucVu == other.maChucVu;
    }

    @Override
    public String toString() {
        return "ChucVu{" + "maChucVu=" + maChucVu + ", tenChucVu=" + tenChucVu + '}';
    }

}
