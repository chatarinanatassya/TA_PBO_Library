package view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GUI {
    JFrame log = new JFrame();
    JLabel login, daftar,top;
    JRadioButton radiostaff;
    JTextField textidlogin, textnamalogin, textpasswordlogin, textnotelp, texttgllahir;
    JLabel labelnamalogin, labelpasswordlogin, labelnotelp,labeltgllahi;
    JButton check;
    JPasswordField passwordlogin;
    private boolean ceklogin = false;

    public GUI(){
        log.setSize(700, 630);
        log.setLayout(null);
        log.getContentPane().setBackground(Color.LIGHT_GRAY);

        top = new JLabel("Audrey Hepburn Library");
        top.setBounds(120, 30, 600, 50);
        top.setFont(new Font("Times New Roman",Font.BOLD,40));
        log.add(top);

        login = new JLabel("login");
        login.setBounds(320, 90, 100, 100);
        login.setFont(new Font("Times New Roman", Font.BOLD, 30));
        log.add(login);

        radiostaff = new JRadioButton("Staff Library");
        radiostaff.setBounds(200, 188, 100, 30);
        radiostaff.setBackground(Color.pink);
        log.add(radiostaff);

        labelnamalogin = new JLabel("Nama");
        labelnamalogin.setBounds(200, 230, 100, 30);
        log.add(labelnamalogin);

        textnamalogin = new JTextField();
        textnamalogin.setBounds(200, 270, 280, 30);
        log.add(textnamalogin);

        labelpasswordlogin = new JLabel("Password");
        labelpasswordlogin.setBounds(200, 310, 100, 30);
        log.add(labelpasswordlogin);

        passwordlogin = new JPasswordField();
        passwordlogin.setBounds(200, 350, 280, 36);
        log.add(passwordlogin);

        check = new JButton("check");
        check.setBounds(240, 430, 180, 40);
        log.add(check);

        log.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        log.setVisible(true);
        log.setLocationRelativeTo(null);

        radiostaff.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                radiostaff.isSelected();
                ceklogin = true;
            }
        });

        check.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ceklogin = true;
                try {
                    ControllerView.staff.dataStaff();
                    ControllerView.staff.login(textnamalogin.getText(), passwordlogin.getText());
                    String nama = ControllerView.staff.staffEntity().getNama();
                    JOptionPane.showMessageDialog(null, "selamat datang " + nama, "information", JOptionPane.INFORMATION_MESSAGE);
                    StaffGUI staff = new StaffGUI();
                    log.dispose();
                }catch (Exception exception){
                    JOptionPane.showMessageDialog(null, "Nama atau password salah", "information", JOptionPane.INFORMATION_MESSAGE);
                    kosong();
                }
            }
        });
    }

    void kosong(){
        textidlogin.setText(null);
        textnamalogin.setText(null);
        textpasswordlogin.setText(null);
        passwordlogin.setText(null);

    }

}
