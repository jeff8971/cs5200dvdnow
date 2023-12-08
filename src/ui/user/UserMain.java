package ui.user;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
/*
 * Created by JFormDesigner on Wed Dec 01 23:33:58 CST 2021
 */



/**
 * @author Yuan Zhao
 */
public class UserMain extends JFrame {
    public UserMain() {
        initComponents();
    }

    private void menuItem6ActionPerformed(ActionEvent e) {
        // TODO add your code here
        int a=JOptionPane.showConfirmDialog(null,"Exit?");
        if (a==0){
            dispose();
        }
    }

    private void menuItem1ActionPerformed(ActionEvent e) {
        // TODO add your code here
        new User1().setVisible(true);
    }

    private void menuItem2ActionPerformed(ActionEvent e) {
        // TODO add your code here
        new User2().setVisible(true);
    }

    private void menuItem3ActionPerformed(ActionEvent e) {
        // TODO add your code here
        new User3().setVisible(true);
    }

    private void menuItem4ActionPerformed(ActionEvent e) {
        // TODO add your code here
        new User4().setVisible(true);
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        menuBar1 = new JMenuBar();
        menu1 = new JMenu();
        menuItem1 = new JMenuItem();
        menuItem2 = new JMenuItem();
        menu2 = new JMenu();
        menuItem3 = new JMenuItem();
        menuItem4 = new JMenuItem();
        menu4 = new JMenu();
        menuItem6 = new JMenuItem();
        panel1 = new JPanel();

        //======== this ========
        Container contentPane = getContentPane();

        //======== menuBar1 ========
        {

            //======== menu1 ========
            {
                menu1.setText("Dvd Operations");

                //---- menuItem1 ----
                menuItem1.setText("Borrow Dvd");
                menuItem1.addActionListener(e -> menuItem1ActionPerformed(e));
                menu1.add(menuItem1);

                //---- menuItem2 ----
                menuItem2.setText("Pending Returns");
                menuItem2.addActionListener(e -> menuItem2ActionPerformed(e));
                menu1.add(menuItem2);
            }
            menuBar1.add(menu1);

            //======== menu2 ========
            {
                menu2.setText("Profile");

                //---- menuItem3 ----
                menuItem3.setText("User Information");
                menuItem3.addActionListener(e -> menuItem3ActionPerformed(e));
                menu2.add(menuItem3);

                //---- menuItem4 ----
                menuItem4.setText("Borrowing History");
                menuItem4.addActionListener(e -> menuItem4ActionPerformed(e));
                menu2.add(menuItem4);
            }
            menuBar1.add(menu2);

            //======== menu4 ========
            {
                menu4.setText("Logout");

                //---- menuItem6 ----
                menuItem6.setText("Secure Logout");
                menuItem6.addActionListener(e -> menuItem6ActionPerformed(e));
                menu4.add(menuItem6);
            }
            menuBar1.add(menu4);
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
                .addComponent(panel1, GroupLayout.Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        contentPaneLayout.setVerticalGroup(
            contentPaneLayout.createParallelGroup()
                .addComponent(panel1, GroupLayout.Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
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
    private JMenuItem menuItem4;
    private JMenu menu4;
    private JMenuItem menuItem6;
    private JPanel panel1;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
