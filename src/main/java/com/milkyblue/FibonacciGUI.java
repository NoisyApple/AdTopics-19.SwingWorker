package com.milkyblue;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;

// FibonacciGUI class. Models the GUI.
public class FibonacciGUI {

  private int n1, n2, count;
  private JFrame mainFrame;
  private JPanel workerPanel, threadEventsPanel;
  private JTextField txtN;
  private JButton btnStart, btnNextN;
  private JLabel lblFibonacci, lblN, lblNFibonacci;

  // Class constructor.
  public FibonacciGUI() {
    n1 = 0;
    n2 = 1;
    count = 1;
    mainFrame = new JFrame("Fibonacci Swing Worker");
    workerPanel = new JPanel(new GridLayout(2, 2, 5, 5));
    threadEventsPanel = new JPanel(new GridLayout(2, 2, 5, 5));
    txtN = new JTextField();
    btnStart = new JButton("Start");
    btnNextN = new JButton("Next number");
    lblFibonacci = new JLabel();
    lblN = new JLabel("Fibonacci of 1: ");
    lblNFibonacci = new JLabel(String.valueOf(n2));

    // Main methods are called.
    addAttributes();
    addListeners();
    build();
    launch();

  }

  // Adds attributes to elements in the class.
  private void addAttributes() {
    mainFrame.setLayout(new GridLayout(2, 1, 10, 10));
    mainFrame.setSize(275, 200);

    // Sets a border with a title on each panel.
    workerPanel.setBorder(new TitledBorder(new LineBorder(Color.BLACK), "With SwingWorker"));
    threadEventsPanel.setBorder(new TitledBorder(new LineBorder(Color.BLACK), "Without SwingWorker"));

    mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    mainFrame.setResizable(false);
  }

  // Adds listeners to elements in GUI.
  private void addListeners() {

    // Calculates the desired nth fibonacci number with a FibonacciBackground
    // instance based in a SwingWorker, when its done, lblFibonacci is updated.
    btnStart.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        int n;

        try {
          n = Integer.parseInt(txtN.getText());
        } catch (NumberFormatException error) {
          lblFibonacci.setText("Input an Integer number.");
          return;
        }

        lblFibonacci.setText("Processing...");

        FibonacciBackground task = new FibonacciBackground(n, lblFibonacci);
        task.execute();

      }
    });

    // Calculates the next fibonacci number based on the previous.
    btnNextN.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {

        int temp = n1 + n2;
        n1 = n2;
        n2 = temp;
        ++count;

        lblN.setText("Fibonacci of " + count + ": ");
        lblNFibonacci.setText(String.valueOf(n2));

      }
    });
  }

  // Builds the GUI.
  private void build() {
    workerPanel.add(new JLabel("Get fibonacci of: "));
    workerPanel.add(txtN);
    workerPanel.add(btnStart);
    workerPanel.add(lblFibonacci);

    threadEventsPanel.add(lblN);
    threadEventsPanel.add(lblNFibonacci);
    threadEventsPanel.add(btnNextN);

    mainFrame.add(workerPanel);
    mainFrame.add(threadEventsPanel);
  }

  // Launches mainFrame by setting its visible value to true.
  private void launch() {
    mainFrame.setVisible(true);
    mainFrame.pack();
    mainFrame.setLocationRelativeTo(null);
  }

}