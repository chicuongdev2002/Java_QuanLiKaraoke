/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entity;

/**
 *
 * @author HP
 */
public class LoaiDichVu {

    private int maLoaiDichVu;
    private String tenLoaiDichVu;

    public LoaiDichVu() {
    }

    public LoaiDichVu(int maLoaiDichVu, String tenLoaiDichVu) {
        this.maLoaiDichVu = maLoaiDichVu;
        this.tenLoaiDichVu = tenLoaiDichVu;
    }

    public LoaiDichVu(String tenLoaiDichVu) {
        this.tenLoaiDichVu = tenLoaiDichVu;
    }

    public LoaiDichVu(int maLoaiDichVu) {
        this.maLoaiDichVu = maLoaiDichVu;
    }

    public int getMaLoaiDichVu() {
        return maLoaiDichVu;
    }

    public String getTenLoaiDichVu() {
        return tenLoaiDichVu;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 13 * hash + this.maLoaiDichVu;
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
        final LoaiDichVu other = (LoaiDichVu) obj;
        return this.maLoaiDichVu == other.maLoaiDichVu;
    }

    @Override
    public String toString() {
        return "LoaiDichVu{" + "maLoaiDichVu=" + maLoaiDichVu + ", tenLoaiDichVu=" + tenLoaiDichVu + '}';
    }

}
