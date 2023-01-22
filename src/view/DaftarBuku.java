package view;

import controller.BukuController;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class DaftarBuku {

    protected static BukuController books = new BukuController();
    JFrame daftar = new JFrame();
    JTable tablebuku = new JTable();
    JLabel staffLabel;
    JButton back;
    JTextField textidbuku,textjudul;
    JScrollPane scrollstaff = new JScrollPane(tablebuku);

    public DaftarBuku(){
        daftar.setSize(700,650);
        daftar.setLayout(null);
        daftar.getContentPane().setBackground(Color.LIGHT_GRAY);
        staffLabel = new JLabel("Daftar Buku");
        staffLabel.setBounds(250, 30, 250, 60);
        staffLabel.setFont(new Font("Times New Roman", Font.BOLD,40));
        daftar.add(staffLabel);

        scrollstaff.setBounds(30, 100, 620, 200);
        tablebuku.setModel(books.inputBuku());
        daftar.add(scrollstaff);

        back = new JButton("back");
        back.setBounds(50,450,100,30);
        back.setBackground(Color.pink);
        daftar.add(back);

        daftar.setLocationRelativeTo(null);
        daftar.setVisible(true);
        daftar.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        back.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                daftar.dispose();
                StaffGUI staffGUI = new StaffGUI();
            }
        });

        tablebuku.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                int i = tablebuku.getSelectedRow();
                textidbuku.setText(ControllerView.buku.inputBuku().getValueAt(i,0).toString());
                textjudul.setText(ControllerView.buku.inputBuku().getValueAt(i,1).toString());

            }
        });
    }
}
