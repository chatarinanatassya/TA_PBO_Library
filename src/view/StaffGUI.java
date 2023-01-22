package view;

import controller.BukuController;
import controller.ModelController;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class StaffGUI {

    JFrame staff = new JFrame();
    JTable tablebuku = new JTable();
    JScrollPane scrollstaff = new JScrollPane(tablebuku);
    JButton verif, back, update, delete, inputbuku,verifbuku,daftarbuku;
    JLabel staffLabel;


    public StaffGUI(){
        staff.setSize(700,630);
        staff.setLayout(null);
        staff.getContentPane().setBackground(Color.LIGHT_GRAY);
        staffLabel = new JLabel("Staff Library");
        staffLabel.setBounds(230, 30, 250, 60);
        staffLabel.setFont(new Font("Times New Roman", Font.BOLD,40));
        staff.add(staffLabel);

        inputbuku = new JButton("Input Buku");
        inputbuku.setBounds(250,160,200,30);
        inputbuku.setBackground(Color.pink);
        staff.add(inputbuku);

        verifbuku = new JButton("Verifikasi Buku");
        verifbuku.setBounds(250,235,200,40);
        verifbuku.setBackground(Color.pink);
        staff.add(verifbuku);

        daftarbuku = new JButton("Daftar Buku");
        daftarbuku.setBounds(250,310,200,40);
        daftarbuku.setBackground(Color.pink);
        staff.add(daftarbuku);

        delete = new JButton("Delete");
        delete.setBounds(250,385,200,30);
        delete.setBackground(Color.pink);
        staff.add(delete);

        update = new JButton("Edit Buku");
        update.setBounds(250,460,200,30);
        update.setBackground(Color.pink);
        staff.add(update);

        back = new JButton("back");
        back.setBounds(50,520,100,30);
        back.setBackground(Color.pink);
        staff.add(back);

        staff.setLocationRelativeTo(null);
        staff.setVisible(true);
        staff.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        back.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                staff.dispose();
                GUI men = new GUI();
            }
        });


        inputbuku.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                staff.dispose();
                InputBuku inputBuku = new InputBuku();
            }
        });

        update.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                staff.dispose();
                EditBuku editBuku = new EditBuku();
            }
        });

        delete.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                staff.dispose();
                DeleteBuku deleteBuku = new DeleteBuku();
            }
        });

        verifbuku.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                staff.dispose();
                VerifBuku verifBuku = new VerifBuku();
            }
        });

        daftarbuku.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                staff.dispose();
                DaftarBuku daftarBuku = new DaftarBuku();
            }
        });

    }
}
