package GiaiPhuongTrinhBac2;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JOptionPane;

public class giaiphuongtrinhbac2 extends JFrame {

    public giaiphuongtrinhbac2() {
        super("Giai Phuong Trinh Bac 2");

        // Khởi tạo các panel
        JPanel pan1 = new JPanel();
        pan1.setBackground(Color.cyan);
        JLabel lblPTB2 = new JLabel("Giải Phương Trình Bậc 2");
        lblPTB2.setFont(new Font("Tahoma", Font.BOLD, 14));
        pan1.add(lblPTB2);  

        JPanel pan2 = new JPanel(new GridLayout(4, 2, 10, 10));  
        // Các thành phần trong pan2
        JLabel lblnhapa = new JLabel("Nhập a:");
        lblnhapa.setFont(new Font("Tahoma", Font.BOLD, 12));
        JTextField txtnhapa = new JTextField(10);

        JLabel lblnhapb = new JLabel("Nhập b:");
        lblnhapb.setFont(new Font("Tahoma", Font.BOLD, 12));
        JTextField txtnhapb = new JTextField(10);

        JLabel lblnhapc = new JLabel("Nhập c:");
        lblnhapc.setFont(new Font("Tahoma", Font.BOLD, 12));
        JTextField txtnhapc = new JTextField(10);

        JLabel lblkq = new JLabel("Kết quả:");
        JTextField txtkq = new JTextField(10);
        txtkq.setEditable(false);  // không cho phép nhập kết quả

        // Thêm các thành phần vào pan2 
        pan2.add(lblnhapa);
        pan2.add(txtnhapa);
        pan2.add(lblnhapb);
        pan2.add(txtnhapb);
        pan2.add(lblnhapc);
        pan2.add(txtnhapc);
        pan2.add(lblkq);
        pan2.add(txtkq);

        JPanel pan3 = new JPanel(new FlowLayout());  // Sử dụng FlowLayout cho pan3
        JButton btnGiai = new JButton("Giải");
        JButton btnXoaRong = new JButton("Xóa Rỗng");
        JButton btnThoat = new JButton("Thoát");

        // Thêm Action Listener cho nút Giải
        btnGiai.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    double a = Double.parseDouble(txtnhapa.getText());
                    double b = Double.parseDouble(txtnhapb.getText());
                    double c = Double.parseDouble(txtnhapc.getText());

                    // Kiểm tra phương trình có phải bậc 2 không
                    if (a == 0) {
                        txtkq.setText("Không phải phương trình bậc 2");
                    } else {
                        // Tính delta
                        double delta = b * b - 4 * a * c;
                        if (delta < 0) {
                            txtkq.setText("Phương trình vô nghiệm");
                        } else if (delta == 0) {
                            double x = -b / (2 * a);
                            txtkq.setText("Phương trình có nghiệm kép: x = " + x);
                        } else {
                            double x1 = (-b + Math.sqrt(delta)) / (2 * a);
                            double x2 = (-b - Math.sqrt(delta)) / (2 * a);
                            txtkq.setText("x1 = " + x1 + ", x2 = " + x2);
                        }
                    }
                } catch (NumberFormatException ex) {
                    // Hiển thị thông báo lỗi nếu người dùng nhập sai định dạng
                    JOptionPane.showMessageDialog(null, "Vui lòng nhập các giá trị hợp lệ!", "Lỗi", JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        // Nút Xóa Rỗng
        btnXoaRong.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                txtnhapa.setText("");
                txtnhapb.setText("");
                txtnhapc.setText("");
                txtkq.setText("");
            }
        });

        // Nút thoát
        btnThoat.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });

        // Thêm các nút vào pan3
        pan3.add(btnGiai);
        pan3.add(btnXoaRong);
        pan3.add(btnThoat);

        // Thêm các panel vào frame
        getContentPane().add(pan1, BorderLayout.NORTH);
        getContentPane().add(pan2, BorderLayout.CENTER);
        getContentPane().add(pan3, BorderLayout.SOUTH);

        // Thiết lập kích thước và hiển thị cửa sổ
        setSize(400, 250);
        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    public static void main(String[] args) {
        new giaiphuongtrinhbac2();
    }
}
