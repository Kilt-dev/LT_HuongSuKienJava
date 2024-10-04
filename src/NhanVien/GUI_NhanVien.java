package NhanVien;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GUI_NhanVien extends JFrame {
    private JTextField txtMaNV, txtHo, txtTen, txtTuoi, txtTienLuong, txtSearch;
    private JRadioButton rbNu;
    private JTable table;
    private DefaultTableModel tableModel;
    private dsNhanVien listNhanVien;
	private JFrame panelButtons;

    public GUI_NhanVien() {
        listNhanVien = new dsNhanVien();
        setTitle("THÔNG TIN NHÂN VIÊN");
        setSize(600, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        // Panel for Employee Information Input
        JPanel panelInput = new JPanel(new GridLayout(6, 2));
        panelInput.add(new JLabel("Mã nhân viên:"));
        txtMaNV = new JTextField();
        panelInput.add(txtMaNV);

        panelInput.add(new JLabel("Họ:"));
        txtHo = new JTextField();
        panelInput.add(txtHo);

        panelInput.add(new JLabel("Tên nhân viên:"));
        txtTen = new JTextField();
        panelInput.add(txtTen);

        panelInput.add(new JLabel("Tuổi:"));
        txtTuoi = new JTextField();
        panelInput.add(txtTuoi);

        panelInput.add(new JLabel("Tiền lương:"));
        txtTienLuong = new JTextField();
        panelInput.add(txtTienLuong);

        panelInput.add(new JLabel("Phái:"));
        JPanel panelGender = new JPanel();
        rbNu = new JRadioButton("Nữ");
        rbNu.setSelected(true);  // "Nữ" is preselected since it's the only option
        panelGender.add(rbNu);
        panelInput.add(panelGender);

        // Table for displaying employees
        String[] columnNames = {"Mã NV", "Họ", "Tên", "Phái", "Tuổi", "Tiền lương"};
        tableModel = new DefaultTableModel(columnNames, 0);
        table = new JTable(tableModel);

        JScrollPane scrollPane = new JScrollPane(table);

        // Panel for Search
        JPanel panelSearch = new JPanel();
        panelSearch.add(new JLabel("Nhập mã số cần tìm:"));
        txtSearch = new JTextField(10);
        JButton btnSearch = new JButton("Tìm");
        panelSearch.add(txtSearch);
        panelSearch.add(btnSearch);

        // Buttons for actions (added directly below the input fields)
        JButton btnAdd = new JButton("Thêm");
        JButton btnClear = new JButton("Xóa trắng");
        JButton btnDelete = new JButton("Xóa");
        JButton btnSave = new JButton("Lưu");

        // Add components to main frame
        setLayout(new BorderLayout());
        add(panelInput, BorderLayout.NORTH);
        add(scrollPane, BorderLayout.CENTER);
        
        // Create a panel to hold the buttons
       
        JPanel panelButtons = new JPanel();
        panelButtons.add(btnAdd);
        panelButtons.add(btnClear);
        panelButtons.add(btnDelete);
        panelButtons.add(btnSave);
        add(panelButtons, BorderLayout.SOUTH);

       	

        // Button actions
        btnAdd.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                NhanVien nv = new NhanVien(txtMaNV.getText(), txtHo.getText(), txtTen.getText(),
                        Integer.parseInt(txtTuoi.getText()), Double.parseDouble(txtTienLuong.getText()));
                listNhanVien.themNhanVien(nv);
                addNhanVienToTable(nv);
            }
        });

        btnClear.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                clearInputs();
            }
        });

        btnDelete.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int selectedRow = table.getSelectedRow();
                if (selectedRow != -1) {
                    listNhanVien.xoaNhanVien(selectedRow);
                    tableModel.removeRow(selectedRow);
                }
            }
        });

        btnSave.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Implement save logic (e.g., saving to a file or database)
                JOptionPane.showMessageDialog(null, "Lưu thông tin thành công!");
            }
        });

        btnSearch.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String searchId = txtSearch.getText();
                int index = listNhanVien.timKiemTheoMaNV(searchId);
                if (index != -1) {
                    table.setRowSelectionInterval(index, index);
                }
            }
        });
    }

    private void addNhanVienToTable(NhanVien nv) {
        String[] data = {nv.getMaNV(), nv.getHo(), nv.getTen(), nv.getPhai(), String.valueOf(nv.getTuoi()), String.valueOf(nv.getTienLuong())};
        tableModel.addRow(data);
    }

    private void clearInputs() {
        txtMaNV.setText("");
        txtHo.setText("");
        txtTen.setText("");
        txtTuoi.setText("");
        txtTienLuong.setText("");
        rbNu.setSelected(true);  // Since "Nữ" is the only option, keep it selected
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new GUI_NhanVien().setVisible(true);
            }
        });
    }
}
