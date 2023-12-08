/*
 * Created by JFormDesigner on Thu Dec 02 23:43:02 CST 2021
 */

package ui.admin;

import bean.User;
import dao.UserDao;
import utils.DbUtil;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.Vector;

/**
 * @author 1
 */
public class Admin5 extends JFrame {
    public Admin5() {
        initComponents();
        fillTable(new User());
    }

    public void fillTable(User user){
        UserDao userDao=new UserDao();
        DbUtil dbUtil=new DbUtil();
        Connection connection=null;
        DefaultTableModel dtm= (DefaultTableModel) table1.getModel();
        dtm.setRowCount(0);
        try {
            connection=dbUtil.getCon();
            ResultSet resultSet=userDao.listUser(connection,user);
            while (resultSet.next()){
                Vector vector=new Vector();  // loop add data
                vector.add(String.valueOf(resultSet.getInt("user_id")));
                vector.add(resultSet.getString("user_username"));
                vector.add(resultSet.getString("user_password"));
                vector.add(resultSet.getString("user_name"));
                vector.add(resultSet.getString("user_sex"));
                vector.add(resultSet.getString("user_age"));
                dtm.addRow(vector);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void button1ActionPerformed(ActionEvent e) {
        // TODO add your code here
        User user=new User();
        user.setuName(textField1.getText());
        fillTable(user);
    }

    // JFormDesigner - End of listeners declaration  //GEN-END:listUser
    private void table1MousePressed(MouseEvent e) {
        // TODO add your code here
        int row=table1.getSelectedRow();
        String uId= (String) table1.getValueAt(row,0);
        String uUsername= (String) table1.getValueAt(row,1);
        String uPassword= (String) table1.getValueAt(row,2);
        String uName= (String) table1.getValueAt(row,3);
        String uSex= (String) table1.getValueAt(row,4);
        String uAge= (String) table1.getValueAt(row,5);
        textField2.setText(uId);
        textField3.setText(uUsername);
        textField4.setText(uPassword);
        textField5.setText(uName);
        comboBox1.setSelectedItem(uSex);
        comboBox2.setSelectedItem(uAge);
    }

    private void button3ActionPerformed(ActionEvent e) {
        // TODO add your code here
        int i=JOptionPane.showConfirmDialog(null,"Delete this user?");
        if (i==0){
            User user=new User();
            UserDao userDao=new UserDao();
            Connection connection=null;
            user.setuId(Integer.parseInt(textField2.getText()));
            user.setuUsername(textField3.getText());
            user.setuPassword(textField4.getText());
            user.setuName(textField5.getText());
            user.setuSex((String) comboBox1.getSelectedItem());
            user.setuAge((String) comboBox2.getSelectedItem());
            try {
                int a=userDao.deleteUser(connection,user);
                if (a==1){
                    JOptionPane.showMessageDialog(null,"Delete successfully!");
                }else {
                    JOptionPane.showMessageDialog(null,"Delete failed!");
                }
            } catch (Exception ex) {
                ex.printStackTrace();
            }
            dispose();
            new Admin5().setVisible(true);
        }
    }

    private void button2ActionPerformed(ActionEvent e) {
        // TODO add your code here
        int a=JOptionPane.showConfirmDialog(null,"Modify this user?");
        if (a==0){
            Connection connection=null;
            User user=new User();
            UserDao userDao=new UserDao();
            user.setuId(Integer.parseInt(textField2.getText()));
            user.setuUsername(textField3.getText());
            user.setuPassword(textField4.getText());
            user.setuName(textField5.getText());
            user.setuSex((String) comboBox1.getSelectedItem());
            user.setuAge((String) comboBox2.getSelectedItem());
            try {
                int b=userDao.changeUser(connection,user);
                if (b==1){
                    JOptionPane.showMessageDialog(null,"Modify successfully!");
                }else{
                    JOptionPane.showMessageDialog(null,"Modify failed!");
                }
            } catch (Exception ex) {
                ex.printStackTrace();
            }
            dispose();
            new Admin5().setVisible(true);
        }

    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        label1 = new JLabel();
        textField1 = new JTextField();
        button1 = new JButton();
        scrollPane1 = new JScrollPane();
        table1 = new JTable();
        label2 = new JLabel();
        label3 = new JLabel();
        textField2 = new JTextField();
        label4 = new JLabel();
        textField3 = new JTextField();
        label5 = new JLabel();
        textField4 = new JTextField();
        label6 = new JLabel();
        textField5 = new JTextField();
        label7 = new JLabel();
        comboBox1 = new JComboBox<>();
        label8 = new JLabel();
        comboBox2 = new JComboBox<>();
        button2 = new JButton();
        button3 = new JButton();

        //======== this ========
        setTitle("Search User");
        Container contentPane = getContentPane();

        //---- label1 ----
        label1.setText("Please enter user name");

        //---- button1 ----
        button1.setText("Search");
        button1.addActionListener(e -> button1ActionPerformed(e));

        //======== scrollPane1 ========
        {

            //---- table1 ----
            table1.setModel(new DefaultTableModel(
                new Object[][] {
                },
                new String[] {
                        "User ID", "Username", "Password", "Name", "Gender", "Age"
                }
            ) {
                boolean[] columnEditable = new boolean[] {
                    false, false, false, false, false, false
                };
                @Override
                public boolean isCellEditable(int rowIndex, int columnIndex) {
                    return columnEditable[columnIndex];
                }
            });
            table1.addMouseListener(new MouseAdapter() {
                @Override
                public void mousePressed(MouseEvent e) {
                    table1MousePressed(e);
                }
            });
            scrollPane1.setViewportView(table1);
        }

        //---- label2 ----
        label2.setText("User Actions");

        //---- label3 ----
        label3.setText("User ID");

        //---- textField2 ----
        textField2.setEditable(false);

        //---- label4 ----
        label4.setText("Username");

        //---- label5 ----
        label5.setText("Password");

        //---- label6 ----
        label6.setText("Name");

        //---- label7 ----
        label7.setText("Gender");

        //---- comboBox1 ----
        comboBox1.setModel(new DefaultComboBoxModel<>(new String[] {
            "Male",
            "Female"
        }));

        //---- label8 ----
        label8.setText("Age");

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

        //---- button2 ----
        button2.setText("Modify");
        button2.addActionListener(e -> button2ActionPerformed(e));

        //---- button3 ----
        button3.setText("Delete");
        button3.addActionListener(e -> button3ActionPerformed(e));

        GroupLayout contentPaneLayout = new GroupLayout(contentPane);
        contentPane.setLayout(contentPaneLayout);
        contentPaneLayout.setHorizontalGroup(
            contentPaneLayout.createParallelGroup()
                .addGroup(contentPaneLayout.createSequentialGroup()
                    .addGroup(contentPaneLayout.createParallelGroup()
                        .addGroup(contentPaneLayout.createSequentialGroup()
                            .addContainerGap()
                            .addGroup(contentPaneLayout.createParallelGroup()
                                .addComponent(scrollPane1, GroupLayout.Alignment.TRAILING)
                                .addGroup(GroupLayout.Alignment.TRAILING, contentPaneLayout.createSequentialGroup()
                                    .addGap(0, 16, Short.MAX_VALUE)
                                    .addComponent(label1)
                                    .addGap(18, 18, 18)
                                    .addComponent(textField1, GroupLayout.PREFERRED_SIZE, 364, GroupLayout.PREFERRED_SIZE)
                                    .addGap(18, 18, 18)
                                    .addComponent(button1))
                                .addGroup(contentPaneLayout.createSequentialGroup()
                                    .addComponent(label2)
                                    .addGap(0, 0, Short.MAX_VALUE))))
                        .addGroup(contentPaneLayout.createSequentialGroup()
                            .addGap(66, 66, 66)
                            .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                                .addComponent(label3)
                                .addComponent(label5)
                                .addComponent(label7))
                            .addGap(18, 18, 18)
                            .addGroup(contentPaneLayout.createParallelGroup()
                                .addGroup(contentPaneLayout.createSequentialGroup()
                                    .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                                        .addComponent(textField2, GroupLayout.DEFAULT_SIZE, 137, Short.MAX_VALUE)
                                        .addComponent(textField4, GroupLayout.DEFAULT_SIZE, 137, Short.MAX_VALUE))
                                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addGroup(contentPaneLayout.createParallelGroup()
                                        .addComponent(label6, GroupLayout.Alignment.TRAILING)
                                        .addComponent(label4, GroupLayout.Alignment.TRAILING)))
                                .addGroup(contentPaneLayout.createSequentialGroup()
                                    .addComponent(comboBox1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(label8)))
                            .addGap(18, 18, 18)
                            .addGroup(contentPaneLayout.createParallelGroup()
                                .addComponent(textField5, GroupLayout.PREFERRED_SIZE, 154, GroupLayout.PREFERRED_SIZE)
                                .addComponent(comboBox2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                .addComponent(textField3))
                            .addGap(47, 47, 47))
                        .addGroup(contentPaneLayout.createSequentialGroup()
                            .addGap(163, 163, 163)
                            .addComponent(button2)
                            .addGap(85, 85, 85)
                            .addComponent(button3)
                            .addGap(0, 188, Short.MAX_VALUE)))
                    .addContainerGap())
        );
        contentPaneLayout.setVerticalGroup(
            contentPaneLayout.createParallelGroup()
                .addGroup(contentPaneLayout.createSequentialGroup()
                    .addContainerGap()
                    .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(button1)
                        .addComponent(textField1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                        .addComponent(label1, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                    .addComponent(scrollPane1, GroupLayout.PREFERRED_SIZE, 104, GroupLayout.PREFERRED_SIZE)
                    .addGap(18, 18, 18)
                    .addComponent(label2)
                    .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                    .addGroup(contentPaneLayout.createParallelGroup()
                        .addGroup(contentPaneLayout.createSequentialGroup()
                            .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                .addComponent(label3)
                                .addComponent(textField2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                            .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                            .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                .addComponent(label5, GroupLayout.PREFERRED_SIZE, 38, GroupLayout.PREFERRED_SIZE)
                                .addComponent(textField4, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                .addComponent(label6)
                                .addComponent(textField5, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                            .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                            .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                .addComponent(label7)
                                .addComponent(comboBox1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                .addComponent(label8)
                                .addComponent(comboBox2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                            .addGap(18, 18, 18)
                            .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                .addComponent(button2)
                                .addComponent(button3)))
                        .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                            .addComponent(label4)
                            .addComponent(textField3, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
                    .addGap(16, 16, 16))
        );
        pack();
        setLocationRelativeTo(getOwner());
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    private JLabel label1;
    private JTextField textField1;
    private JButton button1;
    private JScrollPane scrollPane1;
    private JTable table1;
    private JLabel label2;
    private JLabel label3;
    private JTextField textField2;
    private JLabel label4;
    private JTextField textField3;
    private JLabel label5;
    private JTextField textField4;
    private JLabel label6;
    private JTextField textField5;
    private JLabel label7;
    private JComboBox<String> comboBox1;
    private JLabel label8;
    private JComboBox<String> comboBox2;
    private JButton button2;
    private JButton button3;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
