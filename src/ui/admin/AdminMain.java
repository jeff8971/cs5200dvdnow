package ui.admin;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
/*
 * Created by JFormDesigner on Wed Dec 01 23:44:06 CST 2021
 */



/**
 * @author 1
 */
public class AdminMain extends JFrame {
    public AdminMain() {
        initComponents();
    }

    private void menuItem7ActionPerformed(ActionEvent e) {
        // TODO add your code here
        int a=JOptionPane.showConfirmDialog(null,"Exit?");
        if (a==0){
            dispose();
        }
    }

    private void menuItem1ActionPerformed(ActionEvent e) {
        // TODO add your code here
        new Admin1().setVisible(true);
    }

    private void menuItem2ActionPerformed(ActionEvent e) {
        // TODO add your code here
        new Admin2().setVisible(true);
    }

    private void menuItem3ActionPerformed(ActionEvent e) {
        // TODO add your code here
        new Admin3().setVisible(true);
    }

    private void menuItem5ActionPerformed(ActionEvent e) {
        // TODO add your code here
        new Admin5().setVisible(true);
    }

    private void menuItem6ActionPerformed(ActionEvent e) {
        // TODO add your code here
        new Admin6().setVisible(true);
    }

    private void menuItem8ActionPerformed(ActionEvent e) {
        // TODO add your code here
        new Admin7().setVisible(true);
    }

    private void menuItem9ActionPerformed(ActionEvent e) {
        // TODO add your code here
        new Admin8().setVisible(true);
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        menuBar1 = new JMenuBar();
        menu1 = new JMenu();
        menuItem1 = new JMenuItem();
        menuItem2 = new JMenuItem();
        menu2 = new JMenu();
        menuItem3 = new JMenuItem();
        menu3 = new JMenu();
        menuItem5 = new JMenuItem();
        menuItem6 = new JMenuItem();
        menu4 = new JMenu();
        menuItem8 = new JMenuItem();
        menuItem9 = new JMenuItem();
        menu5 = new JMenu();
        menuItem7 = new JMenuItem();
        panel1 = new JPanel();

        //======== this ========
        Container contentPane = getContentPane();

        //======== menuBar1 ========
        {

            //======== menu1 ========
            {
                menu1.setText("Dvd Operations");

                //---- menuItem1 ----
                menuItem1.setText("Add Dvd");
                menuItem1.addActionListener(e -> menuItem1ActionPerformed(e));
                menu1.add(menuItem1);

                //---- menuItem2 ----
                menuItem2.setText("Manage Dvds");
                menuItem2.addActionListener(e -> menuItem2ActionPerformed(e));
                menu1.add(menuItem2);
            }
            menuBar1.add(menu1);

            //======== menu2 ========
            {
                menu2.setText("Borrowing Operations");

                //---- menuItem3 ----
                menuItem3.setText("Borrow Approval");
                menuItem3.addActionListener(e -> menuItem3ActionPerformed(e));
                menu2.add(menuItem3);
            }
            menuBar1.add(menu2);

            //======== menu3 ========
            {
                menu3.setText("User Operations");

                //---- menuItem5 ----
                menuItem5.setText("User Management");
                menuItem5.addActionListener(e -> menuItem5ActionPerformed(e));
                menu3.add(menuItem5);

                //---- menuItem6 ----
                menuItem6.setText("Add User");
                menuItem6.addActionListener(e -> menuItem6ActionPerformed(e));
                menu3.add(menuItem6);
            }
            menuBar1.add(menu3);

            //======== menu4 ========
            {
                menu4.setText("Profile");

                //---- menuItem8 ----
                menuItem8.setText("profile Information");
                menuItem8.addActionListener(e -> menuItem8ActionPerformed(e));
                menu4.add(menuItem8);

                //---- menuItem9 ----
                menuItem9.setText("Borrowed Dvds");
                menuItem9.addActionListener(e -> menuItem9ActionPerformed(e));
                menu4.add(menuItem9);
            }
            menuBar1.add(menu4);

            //======== menu5 ========
            {
                menu5.setText("Logout");

                //---- menuItem7 ----
                menuItem7.setText("Secure Logout");
                menuItem7.addActionListener(e -> menuItem7ActionPerformed(e));
                menu5.add(menuItem7);
            }
            menuBar1.add(menu5);
        }
        setJMenuBar(menuBar1);

        //======== panel1 ========
        {

            GroupLayout panel1Layout = new GroupLayout(panel1);
            panel1.setLayout(panel1Layout);
            panel1Layout.setHorizontalGroup(
                panel1Layout.createParallelGroup()
                    .addGap(0, 398, Short.MAX_VALUE)
            );
            panel1Layout.setVerticalGroup(
                panel1Layout.createParallelGroup()
                    .addGap(0, 230, Short.MAX_VALUE)
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
    private JMenuBar menuBar1;
    private JMenu menu1;
    private JMenuItem menuItem1;
    private JMenuItem menuItem2;
    private JMenu menu2;
    private JMenuItem menuItem3;
    private JMenu menu3;
    private JMenuItem menuItem5;
    private JMenuItem menuItem6;
    private JMenu menu4;
    private JMenuItem menuItem8;
    private JMenuItem menuItem9;
    private JMenu menu5;
    private JMenuItem menuItem7;
    private JPanel panel1;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
