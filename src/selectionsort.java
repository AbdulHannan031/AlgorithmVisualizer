import javax.swing.*;
import java.awt.*;
import java.util.Random;

public class selectionsort extends Thread {
    private static JButton[] buttons;

    public selectionsort() {

        JFrame frame = new JFrame("Selection Sort");
        frame.setResizable(false);
        buttons = new JButton[5];
        JPanel mainPanel = new JPanel();

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
        setupButtonPanel(panel);

        start.addActionListener(e -> {
            start.setEnabled(false);
            new SelectionSortThread().start();

        });

        close.addActionListener(e -> frame.dispose());

        setupLayout(frame, mainPanel, panel, panel1, panel2, start, close);

        frame.setSize(400, 300);
        frame.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        frame.setLocationRelativeTo(null);

        frame.setVisible(true);
    }

    private void setupButtonPanel(JPanel panel) {

        for (int i = 4; i >= 0; i--) {
            buttons[4 - i] = new JButton(String.valueOf(i));
            buttons[4 - i].setEnabled(false);
            buttons[4 - i].setBackground(Color.black);
            panel.add(buttons[4 - i]);

        }
    }

    private void setupLayout(JFrame frame, JPanel mainPanel, JPanel panel, JPanel panel1, JPanel panel2, JButton start, JButton close) {
        panel.setLayout(new GridLayout(1, 5));
        panel1.setLayout(new FlowLayout(FlowLayout.CENTER));
        panel1.add(panel);
        panel2.add(start);
        panel2.add(close);

        mainPanel.setLayout(new BorderLayout());
        mainPanel.add(panel1, BorderLayout.CENTER);
        mainPanel.add(panel2, BorderLayout.SOUTH);

        frame.setContentPane(mainPanel);
    }

    private static class SelectionSortThread extends Thread {
        @Override
        public void run() {
            int[] array = new int[5];
            for (int i = 0; i < 5; i++) {
                array[i] = Integer.parseInt(buttons[i].getText());
            }

            updateButtons(array, -1, -1);

            Random random = new Random();

            for (int i = 0; i < 5 - 1; i++) {
                for (int j = i + 1; j < 5; j++) {
                    if (array[i] > array[j]) {
                        int temp = array[j];
                        array[j] = array[i];
                        array[i] = temp;
                        updateButtons(array, i, j);
                        try {
                            sleep(1000);
                        } catch (InterruptedException ex) {
                            throw new RuntimeException(ex);
                        }
                    }
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
            }
        }
    }
}
