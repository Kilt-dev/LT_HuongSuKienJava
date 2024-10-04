package CongTruNhanChia;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JRadioButton;
import javax.swing.JButton;
import javax.swing.ButtonGroup;
import javax.swing.BorderFactory;
import javax.swing.border.Border;
import java.awt.Font;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class congtrunhanchia extends JFrame {
    private JTextField txtNhapA;
    private JTextField txtNhapB;
    private JTextField txtKetQua;
    private JRadioButton rdbtnCong, rdbtnTru, rdbtnNhan, rdbtnChia;
    private JPanel panel4; 

    public congtrunhanchia() {
        super("Cộng Trừ Nhân Chia");

        // Cấu hình
        setSize(512, 500);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        getContentPane().setLayout(new FlowLayout());
        setVisible(true);

        // Tạo đường viền
        Border lineBorder = BorderFactory.createLineBorder(Color.BLACK, 2);

        // Panel tiêu đề
        JPanel panel1 = new JPanel();
        panel1.setBorder(lineBorder); // Thêm đường viền
        JLabel lblCongTruNhanChia = new JLabel("Cộng Trừ Nhân Chia");
        lblCongTruNhanChia.setForeground(new Color(0, 128, 255));
        lblCongTruNhanChia.setFont(new Font("Tahoma", Font.BOLD, 25));
        panel1.add(lblCongTruNhanChia);

        // Panel nhập dữ liệu
        JPanel panel2 = new JPanel(new GridLayout(5, 2, 10, 10)); // GridLayout cho bố cục hợp lý
        panel2.setBorder(lineBorder); // Thêm đường viền

        JLabel lblNhapA = new JLabel("Nhập a:");
        lblNhapA.setFont(new Font("Tahoma", Font.BOLD, 12));
        txtNhapA = new JTextField(10);
        panel2.add(lblNhapA);
        panel2.add(txtNhapA);

        JLabel lblNhapB = new JLabel("Nhập b:");
        lblNhapB.setFont(new Font("Tahoma", Font.BOLD, 12));
        txtNhapB = new JTextField(10);
        panel2.add(lblNhapB);
        panel2.add(txtNhapB);

        JLabel lblPhepToan = new JLabel("Phép Toán:");
        lblPhepToan.setFont(new Font("Tahoma", Font.BOLD, 12));
        panel2.add(lblPhepToan);

        // Panel phép toán
        JPanel panelPhepToan = new JPanel(new GridLayout(2, 2)); // GridLayout 2x2 cho các phép toán
        rdbtnCong = new JRadioButton("Cộng");
        rdbtnTru = new JRadioButton("Trừ");
        rdbtnNhan = new JRadioButton("Nhân");
        rdbtnChia = new JRadioButton("Chia");

        // Nhóm các radio buttons
        ButtonGroup group = new ButtonGroup();
        group.add(rdbtnCong);
        group.add(rdbtnTru);
        group.add(rdbtnNhan);
        group.add(rdbtnChia);

        panelPhepToan.add(rdbtnCong);
        panelPhepToan.add(rdbtnTru);
        panelPhepToan.add(rdbtnNhan);
        panelPhepToan.add(rdbtnChia);

        panel2.add(panelPhepToan); // Thêm panel phép toán vào panel chính

        JLabel lblKetQua = new JLabel("Kết Quả:");
        lblKetQua.setFont(new Font("Tahoma", Font.BOLD, 12));
        txtKetQua = new JTextField(10);
        txtKetQua.setEditable(false); // Không cho phép nhập kết quả
        panel2.add(lblKetQua);
        panel2.add(txtKetQua);

        // Panel chứa các nút tác vụ
        JPanel panel3 = new JPanel(new GridLayout(3, 1, 10, 10));
        panel3.setBorder(lineBorder); // Thêm đường viền
        JButton btnGiai = new JButton("Giải");
        btnGiai.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                giaiPhepToan();
            }
        });
        // Nút Xóa
        JButton btnXoa = new JButton("Xóa");
        btnXoa.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                xoaRong();
            }
        });
        // Nút Thoát
        JButton btnThoat = new JButton("Thoát");
        btnThoat.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });

        panel3.add(btnGiai);
        panel3.add(btnXoa);
        panel3.add(btnThoat);

        // Panel chứa các nút đổi màu
        panel4 = new JPanel(new FlowLayout());
        panel4.setBorder(lineBorder); // Thêm đường viền
        JButton btnColorBlue = new JButton("");
        btnColorBlue.setBackground(Color.BLUE); // Set màu xanh dương
        btnColorBlue.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                panel4.setBackground(Color.BLUE);
            }
        });

        JButton btnColorRed = new JButton("");
        btnColorRed.setBackground(Color.RED); // Set màu đỏ
        btnColorRed.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                panel4.setBackground(Color.RED);
            }
        });

        JButton btnColorYellow = new JButton("");
        btnColorYellow.setBackground(Color.YELLOW); // Set màu vàng
        btnColorYellow.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                panel4.setBackground(Color.YELLOW);
            }
        });

        panel4.add(btnColorBlue);
        panel4.add(btnColorRed);
        panel4.add(btnColorYellow);

        // Thêm các panel vào frame 
        getContentPane().add(panel1);
        getContentPane().add(panel2);
        getContentPane().add(panel3);
        getContentPane().add(panel4);

        
        
    }

    private void giaiPhepToan() {
        try {
            double a = Double.parseDouble(txtNhapA.getText());
            double b = Double.parseDouble(txtNhapB.getText());
            double ketQua = 0;

            if (rdbtnCong.isSelected()) {
                ketQua = a + b;
            } else if (rdbtnTru.isSelected()) {
                ketQua = a - b;
            } else if (rdbtnNhan.isSelected()) {
                ketQua = a * b;
            } else if (rdbtnChia.isSelected()) {
                ketQua = a / b;
            }

            txtKetQua.setText(String.valueOf(ketQua));
        } catch (NumberFormatException e) {
            txtKetQua.setText("Lỗi: Nhập số hợp lệ");
        }
    }

    private void xoaRong() {
        txtNhapA.setText("");
        txtNhapB.setText("");
        txtKetQua.setText("");
    }

    public static void main(String[] args) {
        new congtrunhanchia();
    }
}
