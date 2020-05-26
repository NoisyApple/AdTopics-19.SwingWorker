package com.milkyblue;

import java.util.concurrent.ExecutionException;

import javax.swing.JLabel;
import javax.swing.SwingWorker;

// FibonacciBackground class. Extends from SwingWorker, calculates 
// the nth fibonacci number and updates a JLabel object.
public class FibonacciBackground extends SwingWorker<String, Object> {

  private final int n;
  private final JLabel lblResult;

  // Class constructor, takes the desired nth fibonacci number and a reference to
  // the target
  // JLabel.
  public FibonacciBackground(int n, JLabel lblResult) {
    this.n = n;
    this.lblResult = lblResult;
  }

  // Generates the desired nth fibonacci number in background.
  protected String doInBackground() throws Exception {
    long nFib = fibonacci(n);
    return String.valueOf(nFib);
  }

  // When doInBackground is done, lblResult is updated to nth fibonacci number's
  // value.
  protected void done() {
    try {
      lblResult.setText(get());
    } catch (InterruptedException e) {
      lblResult.setText("Interrupted while waiting for results.");
    } catch (ExecutionException e) {
      lblResult.setText("An error was found.");
    }
  }

  // Fibonacci recursive method.
  public long fibonacci(long n) {
    if (n == 0 || n == 1)
      return n;
    else
      return fibonacci(n - 1) + fibonacci(n - 2);
  }

}