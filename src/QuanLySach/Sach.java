package QuanLySach;

import java.util.Objects;

public class Sach {
	private String maSach;
	private String tuaSach;
	private String tacGia;
	private String namSanXuat;
	private String nhaSanXuat;
	private int soTrang;
	private double donGia;
	private String iSBN;
	public Sach(String maSach, String tuaSach, String tacGia, String namSanXuat, String nhaSanXuat, int soTrang,
			double donGia, String iSBN) {
		super();
		this.maSach = maSach;
		this.tuaSach = tuaSach;
		this.tacGia = tacGia;
		this.namSanXuat = namSanXuat;
		this.nhaSanXuat = nhaSanXuat;
		this.soTrang = soTrang;
		this.donGia = donGia;
		this.iSBN = iSBN;
	}
	
	public String getMaSach() {
		return maSach;
	}
	public void setMaSach(String maSach) {
		this.maSach = maSach;
	}
	public String getTuaSach() {
		return tuaSach;
	}
	public void setTuaSach(String tuaSach) {
		this.tuaSach = tuaSach;
	}
	public String getTacGia() {
		return tacGia;
	}
	public void setTacGia(String tacGia) {
		this.tacGia = tacGia;
	}
	public String getNamSanXuat() {
		return namSanXuat;
	}
	public void setNamSanXuat(String namSanXuat) {
		this.namSanXuat = namSanXuat;
	}
	public String getNhaSanXuat() {
		return nhaSanXuat;
	}
	public void setNhaSanXuat(String nhaSanXuat) {
		this.nhaSanXuat = nhaSanXuat;
	}
	public int getSoTrang() {
		return soTrang;
	}
	public void setSoTrang(int soTrang) {
		this.soTrang = soTrang;
	}
	public double getDonGia() {
		return donGia;
	}
	public void setDonGia(double donGia) {
		this.donGia = donGia;
	}
	public String getiSBN() {
		return iSBN;
	}
	public void setiSBN(String iSBN) {
		this.iSBN = iSBN;
	}
	public Sach() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "listSach [maSach=" + maSach + ", tuaSach=" + tuaSach + ", tacGia=" + tacGia + ", namSanXuat="
				+ namSanXuat + ", nhaSanXuat=" + nhaSanXuat + ", soTrang=" + soTrang + ", donGia=" + donGia + ", iSBN="
				+ iSBN + "]";
	}
	@Override
	public int hashCode() {
		return Objects.hash(donGia, iSBN, maSach, namSanXuat, nhaSanXuat, soTrang, tacGia, tuaSach);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Sach other = (Sach) obj;
		return Double.doubleToLongBits(donGia) == Double.doubleToLongBits(other.donGia)
				&& Objects.equals(iSBN, other.iSBN) && Objects.equals(maSach, other.maSach)
				&& Objects.equals(namSanXuat, other.namSanXuat) && Objects.equals(nhaSanXuat, other.nhaSanXuat)
				&& soTrang == other.soTrang && Objects.equals(tacGia, other.tacGia)
				&& Objects.equals(tuaSach, other.tuaSach);
	}
}
//MaSach;TuaSach;TacGia;NamXuatBan;NhaXuatBan;SoTrang;DonGia;ISBN
