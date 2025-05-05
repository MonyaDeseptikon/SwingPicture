package Windows;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Exceptional extends JFrame implements ActionListener, Thread.UncaughtExceptionHandler {

    public Exceptional() {
        Thread.setDefaultUncaughtExceptionHandler(this);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setBounds(1100, 200, 500, 300);
        add(new JPanel() {
            @Override
            public void setBackground(Color bg) {
                super.setBackground(Color.black);
            }
        });

        JButton button = new JButton("PUSH");
        button.addActionListener(this);
        add(button, BorderLayout.SOUTH);
        setVisible(true);

    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new Exceptional();
            }
        });

    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }

    @Override
    public void uncaughtException(Thread t, Throwable e) {
        this.setVisible(false);
        JOptionPane.showMessageDialog(null, e.getMessage(), "Exception", JOptionPane.ERROR_MESSAGE);

    }
}
