package QuanLySach;

import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.Border;

public class GUI_QuanLySach extends JFrame {
    public GUI_QuanLySach() {
        setTitle("Quản Lý Sách");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
        setSize(400, 400);

        // Tạo 3 panel chính
        JPanel panRec = new JPanel();
        JPanel panBut = new JPanel();
        JPanel panTab = new JPanel();

        setLayout(new BorderLayout());
        add(panRec, BorderLayout.NORTH);
        add(panBut, BorderLayout.CENTER);
        add(panTab, BorderLayout.SOUTH);

        // panRec sử dụng BoxLayout để sắp xếp dọc
        panRec.setLayout(new BoxLayout(panRec, BoxLayout.Y_AXIS));
        Border lineBorder = BorderFactory.createLineBorder(Color.BLACK, 2);
        panRec.setBorder(lineBorder);

        // Hàm tiện lợi để thêm JLabel và JTextField theo hàng ngang
        panRec.add(createLabelTextFieldPanel("Mã Sách", 20));
        panRec.add(createLabelTextFieldPanel("Tựa Sách", 20));
        panRec.add(createLabelTextFieldPanel("Năm Sản Xuất", 20));
        panRec.add(createLabelTextFieldPanel("Số Trang", 20));
        panRec.add(createLabelTextFieldPanel("ISBN", 20));
        panRec.add(createLabelTextFieldPanel("Tác Giả", 20));
        panRec.add(createLabelTextFieldPanel("Nhà Xuất Bản", 20));
        panRec.add(createLabelTextFieldPanel("Đơn Giá", 20));
    }

    // Phương thức tạo một JPanel chứa một JLabel và JTextField theo hàng ngang
    private JPanel createLabelTextFieldPanel(String labelText, int textFieldSize) {
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.X_AXIS));
        JLabel label = new JLabel(labelText);
        JTextField textField = new JTextField(textFieldSize);

        // Đặt khoảng cách giữa label và textField
        panel.add(label);
        panel.add(Box.createHorizontalStrut(10));  // khoảng cách giữa label và textField
        panel.add(textField);
        return panel;
    }

    public static void main(String[] args) {
        new GUI_QuanLySach();
    }
}
