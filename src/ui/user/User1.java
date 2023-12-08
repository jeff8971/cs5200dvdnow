/*
 * Created by JFormDesigner on Tue Dec 21 16:34:15 CST 2021
 */

package ui.user;

import bean.Dvd;
import bean.Borrow;
import bean.ULog;
import dao.AdminDao;
import dao.DvdDao;
import dao.BorrowDao;
import dao.ULogDao;
import utils.DateUtil;
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
 * @author Yuan Zhao
 */
public class User1 extends JFrame {
    public User1() {
        initComponents();
        fillTable(new Dvd());
        fillComboBox();
        fillTF5();
    }

    public void fillTable(Dvd dvd){
        DbUtil dbUtil=new DbUtil();
        DvdDao dvdDao=new DvdDao();
        DefaultTableModel dtm= (DefaultTableModel) table1.getModel();
        dtm.setRowCount(0);  //清空表格，设置成0行
        Connection con=null;
        try {
            con=dbUtil.getCon();
            ResultSet rs=dvdDao.listDvd(con,dvd);
            while (rs.next()){
                Vector vector=new Vector();
                vector.add(String.valueOf(rs.getInt("dvd_id")));
                vector.add(rs.getString("dvd_name"));
                vector.add(rs.getString("dvd_price"));
                dtm.addRow(vector);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }


    }

    private void button1ActionPerformed(ActionEvent e) {
        // TODO add your code here
        String name=textField1.getText();
        Dvd dvd=new Dvd();
        dvd.setdName(name);
        fillTable(dvd);

    }

    private void table1MousePressed(MouseEvent e) {
        // TODO add your code here
        int row=table1.getSelectedRow();  // Get the selected row number
        String idTxt= (String) table1.getValueAt(row,0); // Get the value corresponding to the row number
        String dvdName= (String) table1.getValueAt(row,1);
        String dvdPrice= (String) table1.getValueAt(row,2);
        textField2.setText(idTxt);
        textField3.setText(dvdName);
        textField4.setText(dvdPrice);
    }

    public void fillComboBox(){
        AdminDao adminDao=new AdminDao();
        DefaultComboBoxModel dcm = (DefaultComboBoxModel) comboBox1.getModel();
        Connection connection=null;
        try {
            ResultSet resultSet=adminDao.listAdminId(connection);
            while (resultSet.next()){
                dcm.addElement(resultSet.getInt("admin_id"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
    // Borrowing application button Listener
    private void button2ActionPerformed(ActionEvent e) {
        // TODO add your code here
        DateUtil dateUtil=new DateUtil();
        Borrow borrow=new Borrow();
        BorrowDao borrowDao=new BorrowDao();
        ULog uLog=new ULog();
        ULogDao uLogDao=new ULogDao();
        Connection connection=null;
        try {
            uLog=uLogDao.readUser(connection);
            String dvdId=textField2.getText();
            String adminId= String.valueOf(comboBox1.getSelectedItem());
            String userId= String.valueOf(uLog.getuId());
            String time= (String) comboBox2.getSelectedItem();
            String date =textField5.getText();
            borrow.setaId(Integer.parseInt(adminId));
            borrow.setdId(Integer.parseInt(dvdId));
            borrow.setuId(Integer.parseInt(userId));
            borrow.setTime(time);
            borrow.setDate(date);
            int a=borrowDao.addBorrow(connection,borrow);
            if (a==1){
                JOptionPane.showMessageDialog(null,"Application successful, please wait for administrator approval.\n   Your return deadline is:\n"+dateUtil.addDate(date, Integer.parseInt(time))+" 00:00:00");
            }
            dispose();
            new User1();
        } catch (Exception ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(null,"Application failed!");
        }

    }
    private void fillTF5(){
        DateUtil dateUtil=new DateUtil();
        String nowDate=dateUtil.nowDate();
        textField5.setText(nowDate);
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
        button2 = new JButton();
        label6 = new JLabel();
        label7 = new JLabel();
        comboBox1 = new JComboBox();
        label8 = new JLabel();
        label9 = new JLabel();
        comboBox2 = new JComboBox<>();
        label10 = new JLabel();
        textField5 = new JTextField();

        //======== this ========
        setTitle("Dvd Request");
        Container contentPane = getContentPane();

        //---- label1 ----
        label1.setText("Please enter dvd name");

        //---- button1 ----
        button1.setText("Search");
        button1.addActionListener(e -> button1ActionPerformed(e));

        //======== scrollPane1 ========
        {

            //---- table1 ----
            table1.setModel(new DefaultTableModel(
                new Object[][] {
                    {null, null, null},
                },
                new String[] {
                        "Dvd ID", "Dvd Name", "Dvd Price"
                }
            ) {
                boolean[] columnEditable = new boolean[] {
                    false, false, false
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
        label2.setText("Details");

            //---- label3 ----
        label3.setText("Dvd ID");

            //---- textField2 ----
        textField2.setEditable(false);

            //---- label4 ----
        label4.setText("Dvd Name");

            //---- textField3 ----
        textField3.setEditable(false);

            //---- label5 ----
        label5.setText("Dvd Price");

            //---- textField4 ----
        textField4.setEditable(false);

            //---- button2 ----
        button2.setText("Apply for borrowing");
        button2.addActionListener(e -> button2ActionPerformed(e));

            //---- label6 ----
        label6.setText("Select administrator for borrowing");

            //---- label7 ----
        label7.setText("Admin ID");

            //---- label8 ----
        label8.setText("Please select borrowing days");

            //---- label9 ----
        label9.setText("Borrowing Days");

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
            "30"
        }));

        //---- label10 ----
        label10.setText("Borrowed Dvd Time");

        //---- textField5 ----
        textField5.setEditable(false);

        GroupLayout contentPaneLayout = new GroupLayout(contentPane);
        contentPane.setLayout(contentPaneLayout);
        contentPaneLayout.setHorizontalGroup(
            contentPaneLayout.createParallelGroup()
                .addGroup(contentPaneLayout.createSequentialGroup()
                    .addGroup(contentPaneLayout.createParallelGroup()
                        .addGroup(contentPaneLayout.createSequentialGroup()
                            .addContainerGap()
                            .addGroup(contentPaneLayout.createParallelGroup()
                                .addComponent(scrollPane1, GroupLayout.DEFAULT_SIZE, 571, Short.MAX_VALUE)
                                .addGroup(contentPaneLayout.createSequentialGroup()
                                    .addComponent(label1)
                                    .addGap(18, 18, 18)
                                    .addComponent(textField1, GroupLayout.DEFAULT_SIZE, 357, Short.MAX_VALUE)
                                    .addGap(18, 18, 18)
                                    .addComponent(button1))
                                .addGroup(contentPaneLayout.createSequentialGroup()
                                    .addComponent(label2)
                                    .addGap(0, 539, Short.MAX_VALUE))))
                        .addGroup(contentPaneLayout.createSequentialGroup()
                            .addGap(82, 82, 82)
                            .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                                .addComponent(label4)
                                .addComponent(label3))
                            .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                            .addGroup(contentPaneLayout.createParallelGroup()
                                .addGroup(contentPaneLayout.createSequentialGroup()
                                    .addComponent(textField2, GroupLayout.PREFERRED_SIZE, 128, GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 82, Short.MAX_VALUE)
                                    .addComponent(label5)
                                    .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addComponent(textField4, GroupLayout.PREFERRED_SIZE, 118, GroupLayout.PREFERRED_SIZE))
                                .addComponent(textField3, GroupLayout.DEFAULT_SIZE, 372, Short.MAX_VALUE))
                            .addGap(65, 65, 65))
                        .addGroup(contentPaneLayout.createSequentialGroup()
                            .addGroup(contentPaneLayout.createParallelGroup()
                                .addGroup(contentPaneLayout.createSequentialGroup()
                                    .addContainerGap()
                                    .addGroup(contentPaneLayout.createParallelGroup()
                                        .addComponent(label6)
                                        .addGroup(contentPaneLayout.createSequentialGroup()
                                            .addComponent(label7)
                                            .addGap(18, 18, 18)
                                            .addComponent(comboBox1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))))
                                .addGroup(contentPaneLayout.createSequentialGroup()
                                    .addGap(212, 212, 212)
                                    .addComponent(button2)))
                            .addGap(0, 257, Short.MAX_VALUE)))
                    .addContainerGap())
                .addGroup(GroupLayout.Alignment.TRAILING, contentPaneLayout.createSequentialGroup()
                    .addContainerGap()
                    .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                        .addGroup(contentPaneLayout.createSequentialGroup()
                            .addComponent(label10)
                            .addGap(18, 18, 18)
                            .addComponent(textField5, GroupLayout.DEFAULT_SIZE, 392, Short.MAX_VALUE))
                        .addGroup(contentPaneLayout.createSequentialGroup()
                            .addGap(0, 332, Short.MAX_VALUE)
                            .addGroup(contentPaneLayout.createParallelGroup()
                                .addComponent(label8)
                                .addGroup(contentPaneLayout.createSequentialGroup()
                                    .addComponent(label9)
                                    .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addComponent(comboBox2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))))
                    .addGap(71, 71, 71))
        );
        contentPaneLayout.setVerticalGroup(
            contentPaneLayout.createParallelGroup()
                .addGroup(contentPaneLayout.createSequentialGroup()
                    .addContainerGap()
                    .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(label1)
                        .addComponent(button1)
                        .addComponent(textField1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                    .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                    .addComponent(scrollPane1, GroupLayout.PREFERRED_SIZE, 125, GroupLayout.PREFERRED_SIZE)
                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                    .addComponent(label2)
                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                    .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(textField4, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                        .addComponent(label5)
                        .addComponent(textField2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                        .addComponent(label3))
                    .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                    .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(label4)
                        .addComponent(textField3, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                    .addGap(16, 16, 16)
                    .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(label6)
                        .addComponent(label8))
                    .addGap(18, 18, 18)
                    .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(label7)
                        .addComponent(comboBox1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                        .addComponent(comboBox2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                        .addComponent(label9))
                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 30, Short.MAX_VALUE)
                    .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(label10)
                        .addComponent(textField5, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                    .addGap(26, 26, 26)
                    .addComponent(button2)
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
    private JButton button2;
    private JLabel label6;
    private JLabel label7;
    private JComboBox comboBox1;
    private JLabel label8;
    private JLabel label9;
    private JComboBox<String> comboBox2;
    private JLabel label10;
    private JTextField textField5;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
