/*
 * Created by JFormDesigner on Thu Dec 02 22:52:33 CST 2021
 */

package ui.admin;

import bean.Dvd;
import dao.DvdDao;
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
public class Admin2 extends JFrame {
    public Admin2() {
        initComponents();
        fillTable(new Dvd());
    }

    private void button1ActionPerformed(ActionEvent e) {
        // TODO add your code here
        String name=textField1.getText();
        Dvd dvd=new Dvd();
        dvd.setdName(name);
        fillTable(dvd);

    }

    /**
     * fill the dvd table
     * @param dvd
     */
    public void fillTable(Dvd dvd){
        DbUtil dbUtil=new DbUtil();
        DvdDao dvdDao=new DvdDao();
        DefaultTableModel dtm= (DefaultTableModel) table1.getModel();
        dtm.setRowCount(0);  // set the form to 0
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


    // mouse click event
    private void table1MousePressed(MouseEvent e) {
        // TODO add your code here
        int row=table1.getSelectedRow();
        String idTxt= (String) table1.getValueAt(row,0);
        String dvdName= (String) table1.getValueAt(row,1);
        String dvdPrice= (String) table1.getValueAt(row,2);
        textField2.setText(idTxt);
        textField4.setText(dvdName);
        textField3.setText(dvdPrice);
    }

    private void scrollPane1MousePressed(MouseEvent e) {
        // TODO add your code here
    }

    private void button2ActionPerformed(ActionEvent e) {
        // TODO add your code here
        int a=JOptionPane.showConfirmDialog(null,"Confirm modification?");
        if (a==0){
            Dvd dvd=new Dvd();
            dvd.setdId(Integer.parseInt(textField2.getText()));
            dvd.setdName(textField4.getText());
            dvd.setdPrice(textField3.getText());
            DvdDao dvdDao=new DvdDao();
            Connection con=null;
            try {
               int s= dvdDao.changeDvd(con,dvd);
               if (s==1){
                   JOptionPane.showMessageDialog(null,"Modification successful!");
               }else {
                   JOptionPane.showMessageDialog(null,"Modification failed!");
               }
               dispose();
               new Admin2().setVisible(true);
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
    }

    private void button3ActionPerformed(ActionEvent e) {
        // TODO add your code here
        Connection con=null;
        Dvd dvd=new Dvd();
        DvdDao dvdDao=new DvdDao();
        dvd.setdId(Integer.parseInt(textField2.getText()));
        dvd.setdName(textField4.getText());
        dvd.setdPrice(textField3.getText());
        try {
            int a=JOptionPane.showConfirmDialog(null,"Delete?");
            if (a == 0) {
                int s=dvdDao.deleteDvd(con,dvd);
                if (s==1){
                    JOptionPane.showMessageDialog(null,"Delete successful!");
                }else{
                    JOptionPane.showMessageDialog(null,"Delete failed!");
                }
                dispose();
                new Admin2().setVisible(true);
            }


        } catch (Exception ex) {
            ex.printStackTrace();
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
        textField3 = new JTextField();
        label4 = new JLabel();
        label5 = new JLabel();
        textField4 = new JTextField();
        button2 = new JButton();
        button3 = new JButton();

        //======== this ========
        setTitle("Dvd Management");
        Container contentPane = getContentPane();

        //---- label1 ----
        label1.setText("'Please enter dvd name");

        //---- button1 ----
        button1.setText("Search");
        button1.addActionListener(e -> button1ActionPerformed(e));

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
                    "Dvd ID", "Dvd Title", "Price"
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
        label2.setText("Form Operation");

        //---- label3 ----
        label3.setText("Dvd ID");

        //---- textField2 ----
        textField2.setEditable(false);

        //---- label4 ----
        label4.setText("Price");

        //---- label5 ----
        label5.setText("Dvd Title");

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
                    .addContainerGap()
                    .addGroup(contentPaneLayout.createParallelGroup()
                        .addGroup(GroupLayout.Alignment.TRAILING, contentPaneLayout.createSequentialGroup()
                            .addComponent(label1)
                            .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(textField1, GroupLayout.DEFAULT_SIZE, 314, Short.MAX_VALUE)
                            .addGap(18, 18, 18)
                            .addComponent(button1))
                        .addGroup(contentPaneLayout.createSequentialGroup()
                            .addComponent(label2)
                            .addGap(0, 452, Short.MAX_VALUE)))
                    .addContainerGap())
                .addGroup(contentPaneLayout.createSequentialGroup()
                    .addGap(31, 31, 31)
                    .addGroup(contentPaneLayout.createParallelGroup()
                        .addGroup(contentPaneLayout.createSequentialGroup()
                            .addComponent(label5)
                            .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(textField4, GroupLayout.DEFAULT_SIZE, 380, Short.MAX_VALUE))
                        .addGroup(contentPaneLayout.createSequentialGroup()
                            .addComponent(label3)
                            .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(textField2, GroupLayout.PREFERRED_SIZE, 116, GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(label4)
                            .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(textField3, GroupLayout.PREFERRED_SIZE, 125, GroupLayout.PREFERRED_SIZE)))
                    .addGap(79, 79, 79))
                .addGroup(contentPaneLayout.createSequentialGroup()
                    .addGap(88, 88, 88)
                    .addComponent(button2)
                    .addGap(112, 112, 112)
                    .addComponent(button3)
                    .addContainerGap(132, Short.MAX_VALUE))
                .addGroup(GroupLayout.Alignment.TRAILING, contentPaneLayout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(scrollPane1, GroupLayout.DEFAULT_SIZE, 516, Short.MAX_VALUE)
                    .addContainerGap())
        );
        contentPaneLayout.setVerticalGroup(
            contentPaneLayout.createParallelGroup()
                .addGroup(contentPaneLayout.createSequentialGroup()
                    .addContainerGap()
                    .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(label1)
                        .addComponent(button1)
                        .addComponent(textField1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                    .addComponent(scrollPane1, GroupLayout.PREFERRED_SIZE, 77, GroupLayout.PREFERRED_SIZE)
                    .addGap(12, 12, 12)
                    .addComponent(label2)
                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                    .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(label3)
                        .addComponent(textField3, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                        .addComponent(label4)
                        .addComponent(textField2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                    .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(label5)
                        .addComponent(textField4, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                    .addGap(18, 18, 18)
                    .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(button2)
                        .addComponent(button3))
                    .addContainerGap(60, Short.MAX_VALUE))
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
    private JTextField textField3;
    private JLabel label4;
    private JLabel label5;
    private JTextField textField4;
    private JButton button2;
    private JButton button3;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
