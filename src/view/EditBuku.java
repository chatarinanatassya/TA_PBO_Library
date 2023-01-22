package view;

import controller.ModelController;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Scanner;

public class EditBuku extends javax.swing.JFrame{
    JFrame staff = new JFrame();
    JTable tabelbuku = new JTable();
    JScrollPane scrollstaff = new JScrollPane(tabelbuku);
    JLabel staffLabel, idbukulabel, judullabel,judulbarulabel;
    JTextField textidbuku,textjudul,textjudulbaru;
    JButton back, updt;
    private static Scanner input = new Scanner(System.in);

    public EditBuku(){
        staff.setSize(700, 630);
        staff.setLayout(null);
        staff.getContentPane().setBackground(Color.lightGray);

        staffLabel = new JLabel("Update data buku");
        staffLabel.setBounds(150, 20, 400, 40);
        staffLabel.setFont(new Font("Times New Roman", Font.BOLD, 40));
        staff.add(staffLabel);

        scrollstaff.setBounds(30, 100, 570, 200);
        tabelbuku.setModel(ControllerView.buku.inputBuku());
        staff.add(scrollstaff);

        idbukulabel = new JLabel("Id buku");
        idbukulabel.setBounds(50, 320, 100, 30);
        staff.add(idbukulabel);

        textidbuku = new JTextField();
        textidbuku.setBounds(50, 350, 100, 30);
        staff.add(textidbuku);

        judullabel = new JLabel("Judul Buku Lama");
        judullabel.setBounds(200, 320, 100, 30);
        staff.add(judullabel);

        textjudul = new JTextField();
        textjudul.setBounds(200, 350, 200, 30);
        staff.add(textjudul);

        judulbarulabel = new JLabel("Judul baru");
        judulbarulabel.setBounds(200, 380, 100, 30);
        staff.add(judulbarulabel);

        textjudulbaru = new JTextField();
        textjudulbaru.setBounds(200, 410, 200, 30);
        staff.add(textjudulbaru);

        updt = new JButton("Ganti Judul");
        updt.setBounds(450, 350, 100, 30);
        updt.setBackground(Color.pink);
        staff.add(updt);

        back = new JButton("back");
        back.setBounds(50, 430, 100, 30);
        back.setBackground(Color.pink);
        staff.add(back);

        staff.setLocationRelativeTo(null);
        staff.setVisible(true);
        staff.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        tabelbuku.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                int i = tabelbuku.getSelectedRow();
                textidbuku.setText(ControllerView.buku.inputBuku().getValueAt(i,0).toString());
                textjudul.setText(ControllerView.buku.inputBuku().getValueAt(i,1).toString());

            }
        });

        updt.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                btnConfirmDialogActionPerformed(e);
            }
        });

        back.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                staff.dispose();
                StaffGUI men = new StaffGUI();
            }
        });
    }

    public void btnConfirmDialogActionPerformed(java.awt.event.ActionEvent evt) {
        int jawab = JOptionPane.showConfirmDialog(this, "Silahkan Konfirmasi");
        String newjudul = textjudulbaru.getText();
        String idbuku = textidbuku.getText();
        String judul = textjudul.getText();
        // 0 : yes
        // 1 : no
        // 2 : cancel
        switch (jawab) {
            case JOptionPane.YES_OPTION:
                try {
                    int index = ModelController.bukuModel.cekData(idbuku,judul);
                    ControllerView.buku.setBukuEntity(index).setJudul(newjudul);
                    JOptionPane.showMessageDialog(null, "Ganti judul Sukses", "information", JOptionPane.INFORMATION_MESSAGE);
                    kosong();
                } catch (Exception exception) {
                    JOptionPane.showMessageDialog(null, "Penulisan salah", "information", JOptionPane.INFORMATION_MESSAGE);
                    kosong();
                }
                break;
            case JOptionPane.NO_OPTION:
                JOptionPane.showMessageDialog(this, "Ganti judul dibatalkan");
                break;
        }
    }

    void kosong(){
        textidbuku.setText(null);
        textjudul.setText(null);
        textjudulbaru.setText(null);
    }
}
