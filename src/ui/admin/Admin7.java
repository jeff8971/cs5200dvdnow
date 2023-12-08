/*
 * Created by JFormDesigner on Thu Dec 02 23:47:22 CST 2021
 */

package ui.admin;

import bean.ALog;
import bean.Admin;
import dao.ALogDao;
import dao.AdminDao;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.sql.Connection;

/**
 * @author 1
 */
public class Admin7 extends JFrame {
    public Admin7() {
        initComponents();
        fillAdmin7(new Admin());
    }

    public void fillAdmin7(Admin admin){
        Connection connection=null;
        ALogDao aLogDao=new ALogDao();
        AdminDao adminDao=new AdminDao();
        ALog aLog=new ALog();
        try {
            aLog=aLogDao.readAdmin(connection);
            admin.setaId(aLog.getaId());
            admin=adminDao.selectAdmin(connection,admin);
            textField1.setText(String.valueOf(admin.getaId()));
            textField2.setText(admin.getaUsername());
            textField3.setText(admin.getaPassword());
            textField4.setText(admin.getaNmae());
            comboBox1.setSelectedItem(admin.getaSex());
            comboBox2.setSelectedItem(admin.getaAge());
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    //修改按钮
    private void button1ActionPerformed(ActionEvent e) {
        // TODO add your code here
        Connection connection=null;
        Admin admin=new Admin();
        admin.setaId(Integer.parseInt(textField1.getText()));
        admin.setaUsername(textField2.getText());
        admin.setaPassword(textField3.getText());
        admin.setaNmae(textField4.getText());
        admin.setaSex((String) comboBox1.getSelectedItem());
        admin.setaAge((String) comboBox2.getSelectedItem());
        AdminDao adminDao=new AdminDao();
        try {
            int a=adminDao.updateAdmin(connection,admin);
            if (a==1){
                JOptionPane.showMessageDialog(null,"Modify successfully！");
            }else {
                JOptionPane.showMessageDialog(null,"Modify failed！");
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        dispose();
        new Admin7().setVisible(true);
    }
    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        label1 = new JLabel();
        textField1 = new JTextField();
        label2 = new JLabel();
        textField2 = new JTextField();
        textField3 = new JTextField();
        label4 = new JLabel();
        textField4 = new JTextField();
        label5 = new JLabel();
        label6 = new JLabel();
        comboBox1 = new JComboBox<>();
        comboBox2 = new JComboBox<>();
        label7 = new JLabel();
        label8 = new JLabel();
        button1 = new JButton();

        //======== this ========
        setTitle("Personal Information");
        Container contentPane = getContentPane();

        //---- label1 ----
        label1.setText("Admin ID");

        //---- textField1 ----
        textField1.setEditable(false);

        //---- label2 ----
        label2.setText("Username");

        //---- label4 ----
        label4.setText("Name");

        //---- label5 ----
        label5.setText("Gender");

        //---- label6 ----
        label6.setText("Age");

        //---- comboBox1 ----
        comboBox1.setModel(new DefaultComboBoxModel<>(new String[] {
                "Male",
                "Female"
        }));

        //---- comboBox2 ----
        comboBox2.setModel(new DefaultComboBoxModel<>(new String[] {
            "1",
            "2",
            "3",
            "4",
            "5",
            "6",
            "7",
            "8",
            "9",
            "10",
            "11",
            "12",
            "13",
            "14",
            "15",
            "16",
            "17",
            "18",
            "19",
            "20",
            "21",
            "22",
            "23",
            "24",
            "25",
            "26",
            "27",
            "28",
            "29",
            "30",
            "31",
            "32",
            "33",
            "34",
            "35",
            "36",
            "37",
            "38",
            "39",
            "40",
            "41",
            "42",
            "43",
            "44",
            "45",
            "46",
            "47",
            "48",
            "49",
            "50",
            "51",
            "52",
            "53",
            "54",
            "55",
            "56",
            "57",
            "58",
            "59",
            "60",
            "61",
            "62",
            "63",
            "64",
            "65",
            "66",
            "67",
            "68",
            "69",
            "70"
        }));

        //---- label7 ----
        label7.setText("Cannot modify!");
        label7.setForeground(Color.red);

        //---- label8 ----
        label8.setText("Password");

        //---- button1 ----
        button1.setText("Modify");
        button1.addActionListener(e -> button1ActionPerformed(e));

        GroupLayout contentPaneLayout = new GroupLayout(contentPane);
        contentPane.setLayout(contentPaneLayout);
        contentPaneLayout.setHorizontalGroup(
            contentPaneLayout.createParallelGroup()
                .addGroup(contentPaneLayout.createSequentialGroup()
                    .addContainerGap()
                    .addGroup(contentPaneLayout.createParallelGroup()
                        .addComponent(label1)
                        .addComponent(label8, GroupLayout.Alignment.TRAILING)
                        .addComponent(label5, GroupLayout.Alignment.TRAILING))
                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                    .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                        .addGroup(contentPaneLayout.createSequentialGroup()
                            .addComponent(comboBox1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 186, Short.MAX_VALUE)
                            .addComponent(label6))
                        .addGroup(contentPaneLayout.createSequentialGroup()
                            .addComponent(textField3, GroupLayout.PREFERRED_SIZE, 123, GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 161, Short.MAX_VALUE)
                            .addComponent(label4))
                        .addGroup(contentPaneLayout.createSequentialGroup()
                            .addComponent(textField1, GroupLayout.PREFERRED_SIZE, 123, GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(label7)
                            .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 59, Short.MAX_VALUE)
                            .addComponent(label2)))
                    .addGap(18, 18, 18)
                    .addGroup(contentPaneLayout.createParallelGroup()
                        .addComponent(textField2, GroupLayout.PREFERRED_SIZE, 123, GroupLayout.PREFERRED_SIZE)
                        .addComponent(textField4, GroupLayout.PREFERRED_SIZE, 123, GroupLayout.PREFERRED_SIZE)
                        .addComponent(comboBox2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                    .addGap(27, 27, 27))
                .addGroup(contentPaneLayout.createSequentialGroup()
                    .addGap(256, 256, 256)
                    .addComponent(button1)
                    .addContainerGap(204, Short.MAX_VALUE))
        );
        contentPaneLayout.setVerticalGroup(
            contentPaneLayout.createParallelGroup()
                .addGroup(contentPaneLayout.createSequentialGroup()
                    .addContainerGap()
                    .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(label1)
                        .addComponent(textField1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                        .addComponent(label7)
                        .addComponent(label2)
                        .addComponent(textField2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                    .addGroup(contentPaneLayout.createParallelGroup()
                        .addGroup(contentPaneLayout.createSequentialGroup()
                            .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                .addComponent(textField3, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                .addComponent(label8)
                                .addComponent(label4))
                            .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED))
                        .addGroup(GroupLayout.Alignment.TRAILING, contentPaneLayout.createSequentialGroup()
                            .addComponent(textField4, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                            .addGap(4, 4, 4)))
                    .addGroup(contentPaneLayout.createParallelGroup()
                        .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                            .addComponent(comboBox1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                            .addComponent(label5)
                            .addComponent(label6))
                        .addComponent(comboBox2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 22, Short.MAX_VALUE)
                    .addComponent(button1)
                    .addGap(41, 41, 41))
        );
        pack();
        setLocationRelativeTo(getOwner());
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    private JLabel label1;
    private JTextField textField1;
    private JLabel label2;
    private JTextField textField2;
    private JTextField textField3;
    private JLabel label4;
    private JTextField textField4;
    private JLabel label5;
    private JLabel label6;
    private JComboBox<String> comboBox1;
    private JComboBox<String> comboBox2;
    private JLabel label7;
    private JLabel label8;
    private JButton button1;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
