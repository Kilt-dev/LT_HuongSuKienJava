package NhanVien;

import java.util.ArrayList;

public class dsNhanVien {
    private ArrayList<NhanVien> danhSachNhanVien;

    public dsNhanVien() {
        danhSachNhanVien = new ArrayList<>();
    }

    // Add an employee
    public void themNhanVien(NhanVien nv) {
        danhSachNhanVien.add(nv);
    }

    // Remove an employee
    public void xoaNhanVien(int index) {
        if (index >= 0 && index < danhSachNhanVien.size()) {
            danhSachNhanVien.remove(index);
        }
    }

    // Get employee by index
    public NhanVien getNhanVien(int index) {
        if (index >= 0 && index < danhSachNhanVien.size()) {
            return danhSachNhanVien.get(index);
        }
        return null;
    }

    // Search employee by ID
    public int timKiemTheoMaNV(String maNV) {
        for (int i = 0; i < danhSachNhanVien.size(); i++) {
            if (danhSachNhanVien.get(i).getMaNV().equals(maNV)) {
                return i;
            }
        }
        return -1; // Not found
    }

    // Get list size
    public int getSize() {
        return danhSachNhanVien.size();
    }
}
