package view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class VerifBuku {
    JFrame buku = new JFrame();
    JButton back,inputbtn;
    JTextArea area = new JTextArea();
    JLabel databuku;

    int cek = ControllerView.buku.cekDataBuku(ControllerView.buku.bukuEntity().getJudul());

    public VerifBuku(){
        buku.setSize(720, 600);
        buku.setLayout(null);
        buku.getContentPane().setBackground(Color.LIGHT_GRAY);

        databuku = new JLabel("Data Buku ");
        databuku.setFont(new Font("Times New Roman", Font.BOLD,20));
        databuku.setBounds(90, 30, 200, 30);
        buku.add(databuku);
        area.setBounds(30, 90, 400, 300);
        buku.add(area);

        inputbtn = new JButton("Input");
        inputbtn.setBounds(500, 200, 100, 30);
        inputbtn.setBackground(Color.pink);
        buku.add(inputbtn);

        back = new JButton("back");
        back.setBounds(30, 500, 100, 30);
        back.setBackground(Color.pink);
        buku.add(back);
        buku.setVisible(true);
        buku.setLocationRelativeTo(null);
        buku.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        if (cek == -1) {
            JOptionPane.showMessageDialog(null,"Buku Belum di Verifikasi","information", JOptionPane.INFORMATION_MESSAGE);
        } else if (cek == -2) {
            JOptionPane.showMessageDialog(null,"Buku Belum di Verifikasi","information", JOptionPane.INFORMATION_MESSAGE);
        }else {
            area.setText(databuku());
        }

        inputbtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ControllerView.buku.inputdatabuku(ControllerView.buku.bukuEntity(),true);
                area.setText((databuku()));
            }
        });

        back.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                buku.dispose();
                StaffGUI men = new StaffGUI();
            }
        });

    }

    public String databuku(){
        int cek = ControllerView.buku.cekDataBuku(ControllerView.buku.bukuEntity().getJudul());
        String cekverif;
        if (ControllerView.buku.showDataBuku(cek).isAccStaff()==false){
            cekverif = "belum di verifikasi";
        }else {
            cekverif = "sudah di verifikasi ";
        }
        String text = "Id buku  = " + ControllerView.buku.showDataBuku(cek).getBukuEntity().getIdbuku() + "\n"
                + "Judul Buku   = " + ControllerView.buku.showDataBuku(cek).getBukuEntity().getJudul() + "\n"
                + "Nama Author  = " + ControllerView.buku.showDataBuku(cek).getBukuEntity().getAuthor() + "\n"
                + "Genre BUku   = " + ControllerView.buku.showDataBuku(cek).getBukuEntity().getGenre() + "\n"
                + "Verifikasi   = " + cekverif + "\n";
        return text;
    }
}
