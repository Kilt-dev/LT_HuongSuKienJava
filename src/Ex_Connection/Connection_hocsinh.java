package Ex_Connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Connection_hocsinh {

    // Hàm để kết nối với cơ sở dữ liệu
    public Connection connect() {
        Connection conn = null;
        try {
            // Đường dẫn kết nối tới MySQL Database
            String url = "jdbc:sqlserver://localhost:1433;database=hocsinh;trustServerCentificate=true;encrypt=true"; 
            String user = "sa"; 
            String password = "123123"; 
            // Kết nối với cơ sở dữ liệu
            conn = DriverManager.getConnection(url, user, password);
            System.out.println("Kết nối thành công!");
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Kết nối thất bại!");
        }
        return conn;
    }

    // Hàm để tải dữ liệu từ bảng hoc_sinh
    public void loadHocSinhData() {
        Connection conn = connect();
        if (conn != null) {
            String query = "SELECT Id, Ten, Ho FROM hocsinh";  // Truy vấn dữ liệu từ bảng hocsinh
            try (PreparedStatement stmt = conn.prepareStatement(query);
                 ResultSet rs = stmt.executeQuery()) {

                // Duyệt qua kết quả và in ra Id, Tên, Họ
                while (rs.next()) {
                    int id = rs.getInt("Id");
                    String ten = rs.getString("Ten");
                    String ho = rs.getString("Ho");
                    System.out.println("Id: " + id + ", Tên: " + ten + ", Họ: " + ho);
                }

            } catch (SQLException e) {
                e.printStackTrace();
            } finally {
                try {
                    conn.close();  // Đóng kết nối sau khi sử dụng
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static void main(String[] args) {
        Connection_hocsinh hocSinhDAO = new Connection_hocsinh();
        hocSinhDAO.loadHocSinhData();
    }
}

    