package ui.login;

import bean.ALog;
import bean.Admin;
import bean.ULog;
import bean.User;
import dao.ALogDao;
import dao.AdminDao;
import dao.ULogDao;
import dao.UserDao;
import ui.admin.AdminMain;
import ui.user.UserMain;
import utils.DbUtil;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.sql.Connection;
/*
 * Created by JFormDesigner on Wed Dec 01 23:05:59 CST 2021
 */



/**
 * @author 1
 */
public class Log extends JFrame {
    public Log() {
        initComponents();
    }

    private void button1ActionPerformed(ActionEvent e) {
        // TODO add your code here
        DbUtil dbUtil=new DbUtil();
        String username=textField1.getText();
        String password= String.valueOf(passwordField1.getPassword());
        if (comboBox1.getSelectedItem() =="Admin"){
            Admin admin=new Admin();
            admin.setaUsername(username);
            admin.setaPassword(password);
            Connection con=null;
            try {
                con=dbUtil.getCon();
                AdminDao adminDao=new AdminDao();
                Admin trueAdmin=adminDao.login(con,admin);

                if (trueAdmin!=null){
                    dispose();

                    ALog aLog=new ALog();
                    aLog.setaId(trueAdmin.getaId());
                    aLog.setaUsername(trueAdmin.getaUsername());
                    aLog.setaPassword(trueAdmin.getaPassword());
                    aLog.setaNmae(trueAdmin.getaNmae());
                    aLog.setaSex(trueAdmin.getaSex());
                    aLog.setaAge(trueAdmin.getaAge());
                    ALogDao aLogDao=new ALogDao();
                    aLogDao.addAdmin(con,aLog); // write into log

                    new AdminMain().setVisible(true);
                }else {
                    JOptionPane.showMessageDialog(null,"Username or password is incorrect!");
                }
            } catch (Exception ex) {
                ex.printStackTrace();
            }


        }if (comboBox1.getSelectedItem()=="User"){
            User user=new User();
            user.setuUsername(username);
            user.setuPassword(password);
            Connection con=null;
            UserDao userDao =new UserDao();
            try {
                con=dbUtil.getCon();
                User trueUser=userDao.login(con,user);
                if (trueUser!=null){
                    dispose();

                    ULog uLog=new ULog();
                    uLog.setuId(trueUser.getuId());
                    uLog.setuUsername(trueUser.getuUsername());
                    uLog.setuPassword(trueUser.getuPassword());
                    uLog.setuName(trueUser.getuName());
                    uLog.setuSex(trueUser.getuSex());
                    uLog.setuAge(trueUser.getuAge());
                    ULogDao uLogDao=new ULogDao();
                    uLogDao.addUser(con,uLog); //写入日志
                    System.out.println();
                    new UserMain().setVisible(true);

                }else {
                    JOptionPane.showMessageDialog(null,"Username or password is incorrect!");
                }
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        label1 = new JLabel();
        label2 = new JLabel();
        label3 = new JLabel();
        textField1 = new JTextField();
        passwordField1 = new JPasswordField();
        button1 = new JButton();
        comboBox1 = new JComboBox<>();

        //======== this ========
        Container contentPane = getContentPane();

        //---- label1 ----
        label1.setText("User Login");
        label1.setHorizontalAlignment(SwingConstants.CENTER);

        //---- label2 ----
        label2.setText("Username");

        //---- label3 ----
        label3.setText("Password");

        //---- button1 ----
        button1.setText("Login");
        button1.addActionListener(e -> button1ActionPerformed(e));

        //---- comboBox1 ----
        comboBox1.setMaximumRowCount(2);
        comboBox1.setModel(new DefaultComboBoxModel<>(new String[] {
                "Admin",
                "User"
        }));

        GroupLayout contentPaneLayout = new GroupLayout(contentPane);
        contentPane.setLayout(contentPaneLayout);
        contentPaneLayout.setHorizontalGroup(
            contentPaneLayout.createParallelGroup()
                .addGroup(contentPaneLayout.createSequentialGroup()
                    .addGroup(contentPaneLayout.createParallelGroup()
                        .addGroup(contentPaneLayout.createSequentialGroup()
                            .addGap(118, 118, 118)
                            .addComponent(label1, GroupLayout.PREFERRED_SIZE, 157, GroupLayout.PREFERRED_SIZE))
                        .addGroup(contentPaneLayout.createSequentialGroup()
                            .addGap(34, 34, 34)
                            .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                                .addComponent(label3)
                                .addComponent(label2))
                            .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                            .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                                .addComponent(textField1, GroupLayout.DEFAULT_SIZE, 228, Short.MAX_VALUE)
                                .addComponent(passwordField1, GroupLayout.DEFAULT_SIZE, 228, Short.MAX_VALUE)))
                        .addGroup(contentPaneLayout.createSequentialGroup()
                            .addGap(138, 138, 138)
                            .addGroup(contentPaneLayout.createParallelGroup()
                                .addComponent(button1)
                                .addComponent(comboBox1, GroupLayout.PREFERRED_SIZE, 91, GroupLayout.PREFERRED_SIZE))))
                    .addGap(76, 76, 76))
        );
        contentPaneLayout.setVerticalGroup(
            contentPaneLayout.createParallelGroup()
                .addGroup(contentPaneLayout.createSequentialGroup()
                    .addGap(20, 20, 20)
                    .addComponent(label1)
                    .addGap(18, 18, 18)
                    .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(label2)
                        .addComponent(textField1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                    .addGap(18, 18, 18)
                    .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(label3)
                        .addComponent(passwordField1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                    .addComponent(comboBox1, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                    .addComponent(button1)
                    .addContainerGap(17, Short.MAX_VALUE))
        );
        pack();
        setLocationRelativeTo(getOwner());
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    private JLabel label1;
    private JLabel label2;
    private JLabel label3;
    private JTextField textField1;
    private JPasswordField passwordField1;
    private JButton button1;
    private JComboBox<String> comboBox1;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
