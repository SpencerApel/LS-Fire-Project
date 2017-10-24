package lsfire;

import javax.swing.*;

public class FireDepartmentDriver extends JFrame
{       
    public static void main(String[] args) 
    {
        BaseClass tabbedPane = new BaseClass();
        tabbedPane.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        tabbedPane.setSize(1000,900);
        tabbedPane.setVisible(true);
    }
}