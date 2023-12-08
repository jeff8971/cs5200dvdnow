/*
 * Created by JFormDesigner on Thu Dec 02 14:42:10 CST 2021
 */

package ui.user;

import bean.ReturnDvd;
import dao.ReturnDvdDao;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.Vector;

/**
 * @author 1
 */
public class User4 extends JFrame {
    public User4() {
        initComponents();
        fillTable();
    }

    //填充表格方法
    public void fillTable(){
        Connection connection=null;
        ReturnDvd returnDvd =new ReturnDvd();
        ReturnDvdDao returnDvdDao=new ReturnDvdDao();
        DefaultTableModel dtm= (DefaultTableModel) table1.getModel();
        dtm.setRowCount(0);
        try {
            ResultSet rs=returnDvdDao.listReturnDvd(connection);
            while (rs.next()){
                Vector vector=new Vector();
                vector.add(rs.getInt("dvd_id"));
                vector.add(rs.getInt("admin_id"));
                vector.add(rs.getString("borrow_time"));
                vector.add(rs.getString("time"));
                vector.add(rs.getString("back_time"));
                vector.add(rs.getString("ddl"));
                dtm.addRow(vector);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        label1 = new JLabel();
        scrollPane1 = new JScrollPane();
        table1 = new JTable();

        //======== this ========
        setTitle("Borrowing History");
        Container contentPane = getContentPane();

        //---- label1 ----
        label1.setText("Borrowing History");
        label1.setHorizontalAlignment(SwingConstants.CENTER);

        //======== scrollPane1 ========
        {

            //---- table1 ----
            table1.setModel(new DefaultTableModel(
                new Object[][] {
                },
                new String[] {
                        "Dvd ID", "Admin ID", "Borrowing Time", "Borrowing Days", "Return Time", "Return Deadline"
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
            scrollPane1.setViewportView(table1);
        }

        GroupLayout contentPaneLayout = new GroupLayout(contentPane);
        contentPane.setLayout(contentPaneLayout);
        contentPaneLayout.setHorizontalGroup(
            contentPaneLayout.createParallelGroup()
                .addGroup(contentPaneLayout.createSequentialGroup()
                    .addContainerGap()
                    .addGroup(contentPaneLayout.createParallelGroup()
                        .addComponent(label1, GroupLayout.DEFAULT_SIZE, 741, Short.MAX_VALUE)
                        .addComponent(scrollPane1, GroupLayout.DEFAULT_SIZE, 741, Short.MAX_VALUE))
                    .addContainerGap())
        );
        contentPaneLayout.setVerticalGroup(
            contentPaneLayout.createParallelGroup()
                .addGroup(contentPaneLayout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(label1)
                    .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                    .addComponent(scrollPane1, GroupLayout.PREFERRED_SIZE, 144, GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(171, Short.MAX_VALUE))
        );
        pack();
        setLocationRelativeTo(getOwner());
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    private JLabel label1;
    private JScrollPane scrollPane1;
    private JTable table1;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
