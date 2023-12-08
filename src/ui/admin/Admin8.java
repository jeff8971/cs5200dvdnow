/*
 * Created by JFormDesigner on Thu Dec 02 23:53:08 CST 2021
 */

package ui.admin;

import bean.Borrowed;
import dao.BorrowedDao;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.Vector;

/**
 * @author 1
 */
public class Admin8 extends JFrame {
    public Admin8() {
        initComponents();
        fillTable( new Borrowed());
    }

    //填充表格
    public  void fillTable(Borrowed borrowed){
        DefaultTableModel defaultTableModel= (DefaultTableModel) table1.getModel();
        defaultTableModel.setRowCount(0);
        BorrowedDao borrowedDao=new BorrowedDao();
        Connection connection=null;
        try {
            ResultSet resultSet=borrowedDao.listBorrowed(connection,borrowed);
            while (resultSet.next()){
                Vector vector=new Vector();
                vector.add(String.valueOf(resultSet.getInt("user_id")));
                vector.add(String.valueOf(resultSet.getInt("dvd_id")));
                vector.add(resultSet.getString("now_time"));
                vector.add(resultSet.getString("time"));
                vector.add(resultSet.getString("return_time"));
                defaultTableModel.addRow(vector);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        scrollPane1 = new JScrollPane();
        table1 = new JTable();

        //======== this ========
        setTitle("Borrowed Dvds");
        Container contentPane = getContentPane();

        //======== scrollPane1 ========
        {

            //---- table1 ----
            table1.setModel(new DefaultTableModel(
                new Object[][] {
                },
                new String[] {
                        "User ID", "Borrowed Dvd ID", "Borrowing Time", "Borrowing Days", "Return Deadline"
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
            scrollPane1.setViewportView(table1);
        }

        GroupLayout contentPaneLayout = new GroupLayout(contentPane);
        contentPane.setLayout(contentPaneLayout);
        contentPaneLayout.setHorizontalGroup(
            contentPaneLayout.createParallelGroup()
                .addGroup(GroupLayout.Alignment.TRAILING, contentPaneLayout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(scrollPane1, GroupLayout.DEFAULT_SIZE, 932, Short.MAX_VALUE))
        );
        contentPaneLayout.setVerticalGroup(
            contentPaneLayout.createParallelGroup()
                .addGroup(GroupLayout.Alignment.TRAILING, contentPaneLayout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(scrollPane1, GroupLayout.DEFAULT_SIZE, 398, Short.MAX_VALUE)
                    .addContainerGap())
        );
        pack();
        setLocationRelativeTo(getOwner());
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    private JScrollPane scrollPane1;
    private JTable table1;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
