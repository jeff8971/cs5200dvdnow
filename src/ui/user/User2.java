/*
 * Created by JFormDesigner on Thu Dec 02 14:06:01 CST 2021
 */

package ui.user;

import bean.Borrowed;
import bean.ReturnDvd;
import bean.ULog;
import dao.BorrowedDao;
import dao.ReturnDvdDao;
import dao.ULogDao;
import utils.DateUtil;

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
public class User2 extends JFrame {
    public User2() {
        initComponents();
        fillTable(new Borrowed());
    }

    public void fillTable(Borrowed borrowed){
        BorrowedDao borrowedDao=new BorrowedDao();
        Connection connection=null;
        DefaultTableModel dtm= (DefaultTableModel) table1.getModel();
        dtm.setRowCount(0);
        try {
            ResultSet resultSet=borrowedDao.listBorrowedUser(connection,borrowed);
            while (resultSet.next()){
                Vector vector=new Vector();
                vector.add(String.valueOf(resultSet.getInt("dvd_id")));
                vector.add(resultSet.getInt("admin_id"));
                vector.add(resultSet.getString("time"));
                vector.add(resultSet.getString("now_time"));
                vector.add(resultSet.getString("back_time"));
                dtm.addRow(vector);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void table1MousePressed(MouseEvent e) {
        // TODO add your code here
        int row=table1.getSelectedRow();
        String dvdId= String.valueOf( table1.getValueAt(row,0));
        String adminId= String.valueOf(table1.getValueAt(row,1));
        String time = (String) table1.getValueAt(row,2);
        String nowTime= (String) table1.getValueAt(row,3);
        String backTime= (String) table1.getValueAt(row,4);
        textField2.setText(dvdId);
        textField3.setText(adminId);
        textField4.setText(time);
        textField5.setText(nowTime);
        textField6.setText(backTime);
        DateUtil dateUtil=new DateUtil();
        textField1.setText(dateUtil.nowDate());
    }

    //归还按钮监听事件
    private void button1ActionPerformed(ActionEvent e) {
        // TODO add your code here
        Connection connection=null;
        ReturnDvd returnDvd=new ReturnDvd();
        ReturnDvdDao returnDvdDao=new ReturnDvdDao();
        Borrowed borrowed=new Borrowed();
        BorrowedDao borrowedDao=new BorrowedDao();
        ULog uLog=new ULog();
        ULogDao uLogDao=new ULogDao();
        try {
            uLog=uLogDao.readUser(connection);

        } catch (Exception ex) {
            ex.printStackTrace();
        }
        DateUtil dateUtil=new DateUtil();
//        当前系统时间早于ddl，执行操作
        if (dateUtil.compareDate(textField1.getText(),textField6.getText())){
            returnDvd.setaId(Integer.parseInt(textField3.getText()));
            returnDvd.setdId(Integer.parseInt(textField2.getText()));
            returnDvd.setuId(uLog.getuId());
            returnDvd.setBackTime(textField1.getText());
            returnDvd.setTime(textField4.getText());
            returnDvd.setDdl(textField6.getText());
            returnDvd.setBorrowTime(textField5.getText());
            borrowed.setaId(returnDvd.getaId());
            borrowed.setuId(returnDvd.getuId());
            borrowed.setdId(returnDvd.getdId());
            borrowed.setTime(returnDvd.getTime());
            borrowed.setnTime(returnDvd.getBorrowTime());
            borrowed.setdTime(returnDvd.getDdl());
            try {
                int a=returnDvdDao.addRenturnDvd(connection,returnDvd);
                int b=borrowedDao.deleteBorrowed(connection,borrowed);
                if (a==1&&b==1){
                    JOptionPane.showMessageDialog(null,"Return successfully!");
                }
            } catch (Exception ex) {
                ex.printStackTrace();
                JOptionPane.showMessageDialog(null,"Return failed!");
            }
        }else {
            JOptionPane.showMessageDialog(null,"The return deadline has passed, please contact the admin.");
        }
        dispose();
        new User2().setVisible(true);
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        panel1 = new JPanel();
        label1 = new JLabel();
        scrollPane1 = new JScrollPane();
        table1 = new JTable();
        label2 = new JLabel();
        textField1 = new JTextField();
        label3 = new JLabel();
        label4 = new JLabel();
        textField2 = new JTextField();
        label5 = new JLabel();
        textField3 = new JTextField();
        label6 = new JLabel();
        textField4 = new JTextField();
        label7 = new JLabel();
        textField5 = new JTextField();
        label8 = new JLabel();
        textField6 = new JTextField();
        button1 = new JButton();

        //======== this ========
        setTitle("Dvd need to be returned");
        Container contentPane = getContentPane();

        //======== panel1 ========
        {

            //---- label1 ----
            label1.setText("List of the dvds need to be returned");
            label1.setHorizontalAlignment(SwingConstants.CENTER);

            //======== scrollPane1 ========
            {

                //---- table1 ----
                table1.setModel(new DefaultTableModel(
                    new Object[][] {
                    },
                    new String[] {
                            "Dvd ID", "Admin ID", "Borrowing Days", "Borrowing Time", "Return Deadline"
                    }
                ) {
                    boolean[] columnEditable = new boolean[] {
                        false, false, false, false, false
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
            label2.setText("Current System Time");

            //---- textField1 ----
            textField1.setEditable(false);

            //---- label3 ----
            label3.setText("Details");

            //---- label4 ----
            label4.setText("Dvd ID");

            //---- textField2 ----
            textField2.setEditable(false);

            //---- label5 ----
            label5.setText("Admin ID");

            //---- textField3 ----
            textField3.setEditable(false);

            //---- label6 ----
            label6.setText("Borrowing Days");

            //---- textField4 ----
            textField4.setEditable(false);

            //---- label7 ----
            label7.setText("Borrowing Time");

            //---- textField5 ----
            textField5.setEditable(false);

            //---- label8 ----
            label8.setText("Return Deadline");

            //---- textField6 ----
            textField6.setEditable(false);

            //---- button1 ----
            button1.setText("Return");
            button1.addActionListener(e -> button1ActionPerformed(e));

            GroupLayout panel1Layout = new GroupLayout(panel1);
            panel1.setLayout(panel1Layout);
            panel1Layout.setHorizontalGroup(
                panel1Layout.createParallelGroup()
                    .addGroup(panel1Layout.createSequentialGroup()
                        .addGap(263, 263, 263)
                        .addComponent(button1)
                        .addContainerGap(287, Short.MAX_VALUE))
                    .addGroup(GroupLayout.Alignment.TRAILING, panel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(panel1Layout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                            .addComponent(scrollPane1, GroupLayout.DEFAULT_SIZE, 636, Short.MAX_VALUE)
                            .addComponent(label1, GroupLayout.Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(GroupLayout.Alignment.LEADING, panel1Layout.createSequentialGroup()
                                .addComponent(label3)
                                .addGap(0, 604, Short.MAX_VALUE))
                            .addGroup(GroupLayout.Alignment.LEADING, panel1Layout.createSequentialGroup()
                                .addComponent(label7)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(textField5, GroupLayout.PREFERRED_SIZE, 202, GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 42, Short.MAX_VALUE)
                                .addComponent(label8)
                                .addGap(18, 18, 18)
                                .addComponent(textField6, GroupLayout.PREFERRED_SIZE, 202, GroupLayout.PREFERRED_SIZE))
                            .addGroup(panel1Layout.createSequentialGroup()
                                .addGap(0, 24, Short.MAX_VALUE)
                                .addComponent(label4)
                                .addGap(18, 18, 18)
                                .addComponent(textField2, GroupLayout.PREFERRED_SIZE, 89, GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(label5)
                                .addGap(18, 18, 18)
                                .addComponent(textField3, GroupLayout.PREFERRED_SIZE, 89, GroupLayout.PREFERRED_SIZE)
                                .addGap(33, 33, 33)
                                .addComponent(label6)
                                .addGap(18, 18, 18)
                                .addComponent(textField4, GroupLayout.PREFERRED_SIZE, 89, GroupLayout.PREFERRED_SIZE)
                                .addGap(32, 32, 32))
                            .addGroup(GroupLayout.Alignment.LEADING, panel1Layout.createSequentialGroup()
                                .addComponent(label2)
                                .addGap(18, 18, 18)
                                .addComponent(textField1, GroupLayout.DEFAULT_SIZE, 522, Short.MAX_VALUE)))
                        .addContainerGap())
            );
            panel1Layout.setVerticalGroup(
                panel1Layout.createParallelGroup()
                    .addGroup(panel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(label1)
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(scrollPane1, GroupLayout.PREFERRED_SIZE, 126, GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(label3)
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(panel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                            .addComponent(textField4, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                            .addComponent(label6)
                            .addComponent(textField3, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                            .addComponent(label5)
                            .addComponent(textField2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                            .addComponent(label4))
                        .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(panel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                            .addComponent(label7)
                            .addComponent(textField5, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                            .addComponent(textField6, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                            .addComponent(label8))
                        .addGap(18, 18, 18)
                        .addGroup(panel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                            .addComponent(textField1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                            .addComponent(label2))
                        .addGap(18, 18, 18)
                        .addComponent(button1)
                        .addContainerGap(31, Short.MAX_VALUE))
            );
        }

        GroupLayout contentPaneLayout = new GroupLayout(contentPane);
        contentPane.setLayout(contentPaneLayout);
        contentPaneLayout.setHorizontalGroup(
            contentPaneLayout.createParallelGroup()
                .addComponent(panel1, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        contentPaneLayout.setVerticalGroup(
            contentPaneLayout.createParallelGroup()
                .addComponent(panel1, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        pack();
        setLocationRelativeTo(getOwner());
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    private JPanel panel1;
    private JLabel label1;
    private JScrollPane scrollPane1;
    private JTable table1;
    private JLabel label2;
    private JTextField textField1;
    private JLabel label3;
    private JLabel label4;
    private JTextField textField2;
    private JLabel label5;
    private JTextField textField3;
    private JLabel label6;
    private JTextField textField4;
    private JLabel label7;
    private JTextField textField5;
    private JLabel label8;
    private JTextField textField6;
    private JButton button1;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
