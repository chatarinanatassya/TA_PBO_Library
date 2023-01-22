package view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class InputBuku {
    JFrame staff = new JFrame();
    JLabel top;
    JButton back, reg;
    JLabel labelidbuku, labeljudulbuku, labelauthorbuku, labelgenrebuku;
    JTextField textidbuku, textjudulbuku, textauthorbuku, textgenrebuku;

    public InputBuku(){
        staff.setSize(700,630);
        staff.setLayout(null);
        staff.getContentPane().setBackground(Color.LIGHT_GRAY);

        top = new JLabel("Input Buku");
        top.setBounds(100,10,200,100);
        top.setFont(new Font("Times New Roman",Font.BOLD,40));
        staff.add(top);

        labelidbuku = new JLabel("Id Buku");
        labelidbuku.setBounds(230,120,200,30);
        staff.add(labelidbuku);

        textidbuku = new JTextField();
        textidbuku.setBounds(230,160,200,30);
        staff.add(textidbuku);

        labeljudulbuku = new JLabel("Judul Buku");
        labeljudulbuku.setBounds(230,200,200,30);
        staff.add(labeljudulbuku);

        textjudulbuku = new JTextField();
        textjudulbuku.setBounds(230,235,200,40);
        staff.add(textjudulbuku);

        labelauthorbuku = new JLabel("Nama Author");
        labelauthorbuku.setBounds(230,280,200,30);
        staff.add(labelauthorbuku);

        textauthorbuku = new JTextField();
        textauthorbuku.setBounds(230,310,200,40);
        staff.add(textauthorbuku);

        labelgenrebuku = new JLabel("Genre Buku");
        labelgenrebuku.setBounds(230,360,200,30);
        staff.add(labelgenrebuku);

        textgenrebuku = new JTextField();
        textgenrebuku.setBounds(230,400,200,30);
        staff.add(textgenrebuku);

        reg = new JButton("Input");
        reg.setBounds(240,475,100,40);
        reg.setBackground(Color.pink);
        staff.add(reg);

        back = new JButton("back");
        back.setBounds(30,475,100,40);
        back.setBackground(Color.pink);
        staff.add(back);

        staff.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        staff.setVisible(true);
        staff.setLocationRelativeTo(null);

       reg.addActionListener(new ActionListener() {
           @Override
           public void actionPerformed(ActionEvent ae) {
                   try {
                       String idbuku = textidbuku.getText();
                       String judul = textjudulbuku.getText();
                       String author = textauthorbuku.getText();
                       String genre = textgenrebuku.getText();
                       ControllerView.buku.insert(idbuku,judul,author,genre);
                       JOptionPane.showMessageDialog(null, "Input Buku Sukses", "information", JOptionPane.INFORMATION_MESSAGE);
                       kosong();
                   }catch (Exception exception){
                   JOptionPane.showMessageDialog(null, "Format Penulisan Salah", "Input Buku Gagal", JOptionPane.INFORMATION_MESSAGE);
               }
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

    void kosong(){
        textidbuku.setText(null);
        textjudulbuku.setText(null);
        textauthorbuku.setText(null);
        textgenrebuku.setText(null);
    }
}
