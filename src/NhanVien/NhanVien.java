package NhanVien;

public class NhanVien {
    private String maNV;
    private String ho;
    private String ten;
    private String phai; // Phái is now always "Nữ"
    private int tuoi;
    private double tienLuong;

    public NhanVien(String maNV, String ho, String ten, int tuoi, double tienLuong) {
        this.maNV = maNV;
        this.ho = ho;
        this.ten = ten;
        this.phai = "Nữ";  // Default value since the only option is "Nữ"
        this.tuoi = tuoi;
        this.tienLuong = tienLuong;
    }

    // Getters and Setters (phai is hardcoded to "Nữ")
    public String getMaNV() { return maNV; }
    public void setMaNV(String maNV) { this.maNV = maNV; }

    public String getHo() { return ho; }
    public void setHo(String ho) { this.ho = ho; }

    public String getTen() { return ten; }
    public void setTen(String ten) { this.ten = ten; }

    public int getTuoi() { return tuoi; }
    public void setTuoi(int tuoi) { this.tuoi = tuoi; }

    public double getTienLuong() { return tienLuong; }
    public void setTienLuong(double tienLuong) { this.tienLuong = tienLuong; }

    public String getPhai() { return phai; }
}
