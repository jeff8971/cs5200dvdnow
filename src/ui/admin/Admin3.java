/*
 * Created by JFormDesigner on Thu Dec 02 23:00:07 CST 2021
 */

package ui.admin;

import bean.ALog;
import bean.Admin;
import bean.Borrow;
import bean.Borrowed;
import dao.ALogDao;
import dao.BorrowDao;
import dao.BorrowedDao;
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
public class Admin3 extends JFrame {
    public Admin3() {
        initComponents();
        fillTable(new Borrow());
    }

    public void fillTable(Borrow borrow){
        BorrowDao borrowDao=new BorrowDao();
        Connection con=null;
        DefaultTableModel dtm= (DefaultTableModel) table1.getModel();
        dtm.setRowCount(0);
        ALogDao aLogDao=new ALogDao();
        Admin admin=new Admin();
        try {
            ALog aLog=aLogDao.readAdmin(con);
            admin.setaId(aLog.getaId());
            ResultSet rs=borrowDao.listBorrow(con,borrow,admin);
            while (rs.next()){
                Vector vector=new Vector();
                vector.add(String.valueOf(rs.getInt("user_id")));
                vector.add(String.valueOf(rs.getInt("dvd_id")));
                vector.add(rs.getString("now_time"));
                vector.add(rs.getString("time"));
                dtm.addRow(vector);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Click the table to display the information in the text box
     * @param e
     */
    private void table1MousePressed(MouseEvent e) {
        // TODO add your code here
        int row=table1.getSelectedRow();
        String userId= (String) table1.getValueAt(row,0);
        String dvdId= (String) table1.getValueAt(row,1);
        String date=(String) table1.getValueAt(row,2);
        String days= (String) table1.getValueAt(row,3);
        textField1.setText(userId);
        textField2.setText(dvdId);
        textField3.setText(date);
        textField4.setText(days);
    }

    // button1 is the approve button
    private void button1ActionPerformed(ActionEvent e) {
        // TODO add your code here
        int i=JOptionPane.showConfirmDialog(null,"Approve this borrowing request?");
        if (i==0){
            Borrowed borrowed = new Borrowed();
            BorrowedDao borrowedDao = new BorrowedDao();
            Borrow borrow=new Borrow();
            Connection con = null;
            borrowed.setuId(Integer.parseInt(textField1.getText()));
            borrowed.setdId(Integer.parseInt(textField2.getText()));
            borrowed.setnTime(textField3.getText());
            borrowed.setTime(textField4.getText());
            ALogDao aLogDao = new ALogDao();
            ALog aLog = new ALog();
            try {
                aLog = aLogDao.readAdmin(con);
                borrowed.setaId(aLog.getaId());
                String backdate=new DateUtil().addDate(borrowed.getnTime(), Integer.parseInt(borrowed.getTime()));
                borrowed.setdTime(backdate);
                borrowedDao.add(con, borrowed);
                borrow.setaId(borrowed.getaId());
                borrow.setuId(borrowed.getuId());
                borrow.setdId(borrowed.getdId());
                borrow.setDate(borrowed.getnTime());
                borrow.setTime(borrowed.getTime());
                new BorrowDao().deleteBorrow(con,borrow);
                JOptionPane.showMessageDialog(null,"Approve!");
            } catch (Exception ex) {
                ex.printStackTrace();
                JOptionPane.showMessageDialog(null,"Decline!");
            }
            dispose();
            new Admin3().setVisible(true);
        }
    }

    // button2 is the decline button
    private void button2ActionPerformed(ActionEvent e) {
        // TODO add your code here
        int a=JOptionPane.showConfirmDialog(null,"Decline this borrowing request?");
        if (a==0){
            Connection connection=null;
            Borrow borrow=new Borrow();
            ALog aLog=new ALog();
            ALogDao aLogDao=new ALogDao();
            borrow.setuId(Integer.parseInt(textField1.getText()));
            borrow.setdId(Integer.parseInt(textField2.getText()));
            borrow.setDate(textField3.getText());
            borrow.setTime(textField4.getText());
            try {
                aLog=aLogDao.readAdmin(connection);
                borrow.setaId(aLog.getaId());
                int b=new BorrowDao().deleteBorrow(connection,borrow);
                if (b==1) {
                    JOptionPane.showMessageDialog(null,"Decline!");
                }else {
                    JOptionPane.showMessageDialog(null,"No Decline!");
                }
            } catch (Exception ex) {
                ex.printStackTrace();
            }
            dispose();
            new Admin3().setVisible(true);
        }
    }

    private void scrollPane1MousePressed(MouseEvent e) {
        // TODO add your code here
    }

    

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        label1 = new JLabel();
        scrollPane1 = new JScrollPane();
        table1 = new JTable();
        button1 = new JButton();
        button2 = new JButton();
        label2 = new JLabel();
        label3 = new JLabel();
        label4 = new JLabel();
        label5 = new JLabel();
        label6 = new JLabel();
        textField1 = new JTextField();
        textField2 = new JTextField();
        textField3 = new JTextField();
        textField4 = new JTextField();

        //======== this ========
        setTitle("Borrowing Approval");
        Container contentPane = getContentPane();

        //---- label1 ----
        label1.setText("Borrowing List");
        label1.setHorizontalAlignment(SwingConstants.CENTER);

        //======== scrollPane1 ========
        {
            scrollPane1.addMouseListener(new MouseAdapter() {
                @Override
                public void mousePressed(MouseEvent e) {
                    scrollPane1MousePressed(e);
                }
            });

            //---- table1 ----
            table1.setModel(new DefaultTableModel(
                new Object[][] {
                },
                new String[] {
                    "User ID", "Borrowed Dvd ID", "Borrowing Time", "Borrowing Days"
                }
            ) {
                boolean[] columnEditable = new boolean[] {
                    false, false, false, false
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

        //---- button1 ----
        button1.setText("Approve");
        button1.addActionListener(e -> button1ActionPerformed(e));

        //---- button2 ----
        button2.setText("Decline");
        button2.addActionListener(e -> button2ActionPerformed(e));

        //---- label2 ----
        label2.setText("Approval Operation");

        //---- label3 ----
        label3.setText("User ID");

        //---- label4 ----
        label4.setText("Borrowed Dvd ID");

        //---- label5 ----
        label5.setText("Borrowing Time");

        //---- label6 ----
        label6.setText("Borrowing Days");

        //---- textField1 ----
        textField1.setEditable(false);

        //---- textField2 ----
        textField2.setEditable(false);

        //---- textField3 ----
        textField3.setEditable(false);

        //---- textField4 ----
        textField4.setEditable(false);

        GroupLayout contentPaneLayout = new GroupLayout(contentPane);
        contentPane.setLayout(contentPaneLayout);
        contentPaneLayout.setHorizontalGroup(
            contentPaneLayout.createParallelGroup()
                .addGroup(contentPaneLayout.createSequentialGroup()
                    .addContainerGap()
                    .addGroup(contentPaneLayout.createParallelGroup()
                        .addComponent(label1, GroupLayout.DEFAULT_SIZE, 561, Short.MAX_VALUE)
                        .addComponent(scrollPane1, GroupLayout.DEFAULT_SIZE, 561, Short.MAX_VALUE))
                    .addContainerGap())
                .addGroup(contentPaneLayout.createSequentialGroup()
                    .addGap(90, 90, 90)
                    .addComponent(button1)
                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 188, Short.MAX_VALUE)
                    .addComponent(button2)
                    .addGap(99, 99, 99))
                .addGroup(contentPaneLayout.createSequentialGroup()
                    .addGap(30, 30, 30)
                    .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                        .addGroup(contentPaneLayout.createSequentialGroup()
                            .addComponent(label3)
                            .addGap(18, 18, 18)
                            .addComponent(textField1, GroupLayout.PREFERRED_SIZE, 163, GroupLayout.PREFERRED_SIZE))
                        .addGroup(contentPaneLayout.createSequentialGroup()
                            .addComponent(label5)
                            .addGap(18, 18, 18)
                            .addComponent(textField3, GroupLayout.PREFERRED_SIZE, 162, GroupLayout.PREFERRED_SIZE)))
                    .addGap(18, 18, 18)
                    .addGroup(contentPaneLayout.createParallelGroup()
                        .addComponent(label4)
                        .addComponent(label6))
                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 28, Short.MAX_VALUE)
                    .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                        .addComponent(textField2, GroupLayout.DEFAULT_SIZE, 169, Short.MAX_VALUE)
                        .addComponent(textField4, GroupLayout.DEFAULT_SIZE, 169, Short.MAX_VALUE))
                    .addContainerGap())
                .addGroup(contentPaneLayout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(label2)
                    .addGap(189, 503, Short.MAX_VALUE))
        );
        contentPaneLayout.setVerticalGroup(
            contentPaneLayout.createParallelGroup()
                .addGroup(contentPaneLayout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(label1)
                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                    .addComponent(scrollPane1, GroupLayout.PREFERRED_SIZE, 75, GroupLayout.PREFERRED_SIZE)
                    .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                    .addComponent(label2)
                    .addGap(18, 18, 18)
                    .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(label3)
                        .addComponent(textField1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                        .addComponent(label4)
                        .addComponent(textField2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(label5)
                        .addComponent(textField3, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                        .addComponent(label6)
                        .addComponent(textField4, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                    .addGap(44, 44, 44)
                    .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(button1)
                        .addComponent(button2))
                    .addGap(26, 26, 26))
        );
        pack();
        setLocationRelativeTo(getOwner());
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    private JLabel label1;
    private JScrollPane scrollPane1;
    private JTable table1;
    private JButton button1;
    private JButton button2;
    private JLabel label2;
    private JLabel label3;
    private JLabel label4;
    private JLabel label5;
    private JLabel label6;
    private JTextField textField1;
    private JTextField textField2;
    private JTextField textField3;
    private JTextField textField4;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
