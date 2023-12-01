import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.LinkedList;
import java.util.Queue;

public class QueueVisualizationGUI extends JFrame {
    private Queue<String> queue;
    private JPanel queuePanel;

    public QueueVisualizationGUI() {
        initializeUI();
    }

    private void initializeUI() {
        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Queue Visualization");
        setLayout(new BorderLayout());
        setSize(500, 300);

        queue = new LinkedList<>();
        queuePanel = new JPanel();
        queuePanel.setLayout(new FlowLayout());
        add(queuePanel, BorderLayout.CENTER);

        JButton enqueueButton = new JButton("Enqueue");
        enqueueButton.setFont(new Font("Arial", Font.BOLD, 18));;
        enqueueButton.setFocusPainted(false);
        enqueueButton.setBackground(Color.decode("#355E3B"));
        enqueueButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                enqueue();
            }
        });

        JButton dequeueButton = new JButton("Dequeue");
       dequeueButton.setFont(new Font("Arial", Font.BOLD, 18));;
        dequeueButton.setFocusPainted(false);
        dequeueButton.setBackground(Color.decode("#FF0000"));
        dequeueButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dequeue();
            }
        });

        JButton peekButton = new JButton("Peek");
        peekButton.setFont(new Font("Arial", Font.BOLD, 18));;
        peekButton.setFocusPainted(false);
        peekButton.setBackground(Color.decode("#355E3B"));
        peekButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                peek();
            }
        });

        JButton clearButton = new JButton("Clear");
        clearButton.setFont(new Font("Arial", Font.BOLD, 18));;
        clearButton.setFocusPainted(false);
        clearButton.setBackground(Color.decode("#FF0000"));
        clearButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                clear();
            }
        });

        JButton addButton = new JButton("Add");
        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                addButton();
            }
        });

        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new FlowLayout());
        buttonPanel.add(enqueueButton);
        buttonPanel.add(dequeueButton);
        buttonPanel.add(peekButton);
        buttonPanel.add(clearButton);
buttonPanel.setBackground(Color.black);
        add(buttonPanel, BorderLayout.NORTH);

        setVisible(true);
    }

    private void enqueue() {
        String element = JOptionPane.showInputDialog(this, "Enter element to enqueue:");
        if (element != null) {
            queue.add(element);
            updateQueueVisualization();
        }
    }

    private void dequeue() {
        if (!queue.isEmpty()) {
            queue.poll();
            updateQueueVisualization();
        } else {
            JOptionPane.showMessageDialog(this, "Queue is empty. Nothing to dequeue.");
        }
    }

    private void peek() {
        if (!queue.isEmpty()) {
            String frontElement = queue.peek();
            JOptionPane.showMessageDialog(this, "Front element: " + frontElement);
        } else {
            JOptionPane.showMessageDialog(this, "Queue is empty. Nothing to peek.");
        }
    }

    private void clear() {
        queue.clear();
        updateQueueVisualization();
    }

    private void addButton() {
        JButton newButton = new JButton("Button");
        newButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(QueueVisualizationGUI.this, "Button clicked");
            }
        });
        queuePanel.add(newButton);

        updateQueueVisualization();
    }

    private void updateQueueVisualization() {
        queuePanel.removeAll();

        for (String element : queue) {
            JButton button = new JButton(element);
            button.setEnabled(false);
            button.setBounds(12,12,50,50);
            button.setPreferredSize(new Dimension(50,50));
            button.setBorder(BorderFactory.createLineBorder(Color.white,3));
            queuePanel.add(button);
        }
    queuePanel.setBackground(Color.black);
        revalidate();
        repaint();
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(QueueVisualizationGUI::new);
    }
}
