import javax.swing.*;
import java.awt.*;
import java.util.Random;



public class bubblesort extends Thread {
        private static JButton[] buttons;

        bubblesort() {

            JFrame frame = new JFrame("Bubble Sort");
            buttons = new JButton[5];
            JPanel code=new JPanel();

            JPanel mainPanel = new JPanel(); // Main panel to center content
            JPanel panel = new JPanel();
            JPanel panel1 = new JPanel();
            JButton start = new JButton("Start");
            JButton close = new JButton("Close");
            JPanel panel2 = new JPanel();
            start.setFont(new Font("Arial", Font.BOLD, 18));;
            start.setFocusPainted(false);
            start.setBackground(Color.decode("#3498db"));
            close.setFont(new Font("Arial", Font.BOLD, 18));;
            close.setFocusPainted(false);
            close.setBackground(Color.decode("#FF0000"));

            frame.setResizable(false);
            for (int i = 4; i >= 0; i--) {
                String str = String.valueOf(i);
                buttons[4 - i] = new JButton(str);
                buttons[4 - i].setEnabled(false);
                buttons[4 - i].setBackground(Color.black);
                buttons[4-i].setForeground(Color.white);
                panel.add(buttons[4 - i]);
            }

            start.addActionListener(e -> {
                start.setEnabled(false);
                new BubbleSortThread().start();
            });

            close.addActionListener(e -> {
                    frame.dispose();

            });

            panel.setLayout(new GridLayout(1, 5));
            panel1.setLayout(new FlowLayout(FlowLayout.CENTER));
            panel1.add(panel);
            panel2.add(start);
            panel2.add(close);

            mainPanel.setLayout(new BorderLayout());
            mainPanel.add(panel1, BorderLayout.CENTER);
            mainPanel.add(panel2, BorderLayout.SOUTH);


            frame.setContentPane(mainPanel);

            frame.setSize(400, 300);
            frame.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);


            frame.setLocationRelativeTo(null);

            frame.setVisible(true);
        }



        static class BubbleSortThread extends Thread {
            @Override
            public void run() {
                int[] array = new int[5];
                for (int i = 0; i < 5; i++) {
                    array[i] = Integer.parseInt(buttons[i].getText());
                }

                // Visualize the unsorted array
                updateButtons(array, -1, -1);

                Random random = new Random();

                for (int i = 0; i < 5; i++) {
                    for (int j = 0; j < 4 - i; j++) {
                        buttons[j+1].setBackground(Color.cyan);
                        buttons[j + 1].setBackground(Color.cyan);
                        if (array[j] > array[j + 1]) {
                            int temp = array[j];
                            array[j] = array[j + 1];
                            array[j + 1] = temp;
                            updateButtons(array, j, j + 1);
                            try {
                                sleep(3000);
                            } catch (InterruptedException ex) {
                                throw new RuntimeException(ex);
                            }
                        }
                        resetButtonColors();
                    }

                    resetButtonColors();
                }
                JOptionPane.showMessageDialog(null, "Sorting completed!");
            }

            private void updateButtons(int[] array, int index1, int index2) {
                for (int i = 0; i < 5; i++) {
                    buttons[i].setText(String.valueOf(array[i]));
                }

                if (index1 != -1 && index2 != -1) {
                    if (array[index1] == array[index2]) {
                        // Change the color to indicate matching indices
                        buttons[index1].setBackground(Color.yellow);
                        buttons[index2].setBackground(Color.yellow);
                    } else {
                        buttons[index1].setBackground(Color.green);
                        buttons[index2].setBackground(Color.red);
                    }
                }
            }

            private void resetButtonColors() {
                for (int i = 0; i < 5; i++) {
                    buttons[i].setBackground(Color.black);
                    buttons[i].setForeground(Color.white);
                }
            }
        }
    }


