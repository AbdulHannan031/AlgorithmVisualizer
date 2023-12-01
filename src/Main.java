import javax.swing.*;
import java.awt.*;

public class Main {

    public static void main(String[] args) {
         createAndShowGUI();
    }

    private static void createAndShowGUI() {
        ImageIcon ic=new ImageIcon("C:\\Users\\Toshiba\\Desktop\\kkk\\src\\connection.png");
        Image im=ic.getImage();

        JFrame frame = new JFrame("DSA Algorithm Visualizer");
        frame.setIconImage(im);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800, 600);

         JPanel panel1=new JPanel();
        JPanel panel = new JPanel();



        panel.setLayout(new GridLayout(2, 3, 20, 20));
        panel.setBorder(BorderFactory.createEmptyBorder(40, 40, 40, 40));
        panel.setBackground(Color.decode("#F4F4F4")); // Light gray background color

        JButton bubbleSortButton = createMenuButton("Bubble Sort", "bubble.png");
        bubbleSortButton.addActionListener(e -> new bubblesort());

        JButton selectionSortButton = createMenuButton("Selection Sort", "selection.png");
        selectionSortButton.addActionListener(e -> new selectionsort());

        JButton singlyLinkedListButton = createMenuButton("Singly Linked List", "linkedlist.png");
        singlyLinkedListButton.addActionListener(e -> new GU());

        JButton doublyLinkedListButton = createMenuButton("Doubly Linked List", "doublylinkedlist.png");
        doublyLinkedListButton.addActionListener(e -> new GDoublyLinkedList());

        JButton stackButton = createMenuButton("Stack", "stack.png");
        stackButton.addActionListener(e -> new stack());

        JButton queueButton = createMenuButton("Queue", "queue.png");
        queueButton.addActionListener(e -> new QueueVisualizationGUI());

        panel.add(bubbleSortButton);
        panel.add(selectionSortButton);
        panel.add(singlyLinkedListButton);
        panel.add(doublyLinkedListButton);
        panel.add(stackButton);
        panel.add(queueButton);

     panel.setBackground(Color.black);
        frame.add(panel, BorderLayout.CENTER);
        frame.setVisible(true);
    }

    private static JButton createMenuButton(String label, String iconFileName) {
        JButton button = new JButton(label);
        button.setFont(new Font("Arial", Font.BOLD, 18));
        button.setFocusPainted(false);
        button.setBackground(Color.decode("#3498db"));
        button.setForeground(Color.white);
        button.setIcon(new ImageIcon(iconFileName));
        button.setHorizontalTextPosition(SwingConstants.CENTER);
        button.setVerticalTextPosition(SwingConstants.BOTTOM);
        button.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        return button;
    }
}
