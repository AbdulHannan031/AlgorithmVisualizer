import javax.swing.*;
import java.awt.*;

class dlinklist {
    int data;
    dlinklist next;
    dlinklist previous;

    dlinklist(int data) {
        this.data = data;
        next = null;
        previous = null;
    }
}

class dFunctions {
    dlinklist head = null;

    void insertAtHead(dlinklist node) {
        dlinklist temp = head;
        if (head == null) {
            head = node;
        } else {
            head = node;
            head.next = temp;
            temp.previous = head;
        }
    }

    void insertAtTail(dlinklist node) {
        if (head == null) {
            head = node;
        } else {
            dlinklist temp = head;
            while (temp.next != null) {
                temp = temp.next;
            }
            temp.next = node;
            node.previous = temp;
        }
    }

    void insertAtPosition(int position, dlinklist node) {
        if (position <= 0) {
            JOptionPane.showMessageDialog(null, "Invalid position");
            return;
        }

        if (position == 1) {
            insertAtHead(node);
            return;
        }

        dlinklist temp = head;
        for (int i = 1; i < position - 1 && temp != null; i++) {
            temp = temp.next;
        }

        if (temp == null) {
            JOptionPane.showMessageDialog(null, "Position out of bounds");
            return;
        }

        dlinklist nextNode = temp.next;
        temp.next = node;
        node.previous = temp;
        node.next = nextNode;

        if (nextNode != null) {
            nextNode.previous = node;
        }
    }

    void deleteAtPosition(int position) {
        if (position <= 0 || head == null) {
            JOptionPane.showMessageDialog(null, "Invalid position or empty list");
            return;
        }

        if (position == 1) {
            deleteHead();
            return;
        }

        dlinklist temp = head;
        for (int i = 1; i < position - 1 && temp != null; i++) {
            temp = temp.next;
        }

        if (temp == null || temp.next == null) {
            JOptionPane.showMessageDialog(null, "Position out of bounds");
            return;
        }

        dlinklist deletedNode = temp.next;
        temp.next = deletedNode.next;

        if (deletedNode.next != null) {
            deletedNode.next.previous = temp;
        }

        deletedNode = null;
    }

    void deleteTarget(int target) {
        dlinklist temp = head;

        while (temp != null && temp.data != target) {
            temp = temp.next;
        }

        if (temp == null) {
            JOptionPane.showMessageDialog(null, "Target not found");
            return;
        }

        if (temp.previous != null) {
            temp.previous.next = temp.next;
        } else {
            head = temp.next;
        }

        if (temp.next != null) {
            temp.next.previous = temp.previous;
        }

        temp = null;
    }

    void deleteHead() {
        if (head != null) {
            dlinklist temp = head;
            head = head.next;
            if (head != null) {
                head.previous = null;
            }
            temp = null;
        }
    }

    void deleteTail() {
        if (head != null) {
            dlinklist temp = head;
            while (temp.next != null) {
                temp = temp.next;
            }
            dlinklist pre = temp.previous;
            if (pre != null) {
                pre.next = null;
            } else {
                head = null;
            }

            temp = null;
        }
    }

    String display() {
        StringBuilder result = new StringBuilder();
        dlinklist temp = head;
        while (temp != null) {
            result.append(temp.data).append('\u2192').append('\u2190');
            temp = temp.next;
        }
        result.append("NULL");
        return result.toString();
    }
}

class GDoublyLinkedList {
    dFunctions obj;
    JTextArea textArea;

    GDoublyLinkedList() {
        obj = new dFunctions();

        JFrame frame = new JFrame("Doubly Linked List");
        frame.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        frame.setLayout(new BorderLayout());
        frame.setSize(1200, 400);

        JButton button1 = new JButton("Insert at Head");
        JButton button2 = new JButton("Insert at Tail");
        JButton button3 = new JButton("Delete at Head");
        JButton button4 = new JButton("Delete at Tail");
        JButton button5 = new JButton("Display");
        JButton button6 = new JButton("Insert at Position");
        JButton button7 = new JButton("Delete at Position");
        JButton button8 = new JButton("Delete Target");
   JLabel label=new JLabel("  Value / Position :");
        JTextField textField = new JTextField(10);
        textArea = new JTextArea("Link List : ");
        textArea.setEditable(false);

        button1.addActionListener(e -> {
            if(textField.getText().isEmpty())
            {
                JOptionPane.showMessageDialog(null,"First enter the value");

            }
            else {
                int data = Integer.parseInt(textField.getText());
                dlinklist newNode = new dlinklist(data);
                obj.insertAtHead(newNode);
                textField.setText("");
                updateDisplay();
                JOptionPane.showMessageDialog(null, "Added to head successfully");
            }
        });

        button2.addActionListener(e -> {
            if(textField.getText().isEmpty())
            {
                JOptionPane.showMessageDialog(null,"First enter the value");

            }
            else {
                int data = Integer.parseInt(textField.getText());
                dlinklist newNode = new dlinklist(data);
                obj.insertAtTail(newNode);
                textField.setText("");
                updateDisplay();
                JOptionPane.showMessageDialog(null, "Added to tail successfully");
            }
        });

        button3.addActionListener(e -> {
            obj.deleteHead();
            updateDisplay();
        });

        button4.addActionListener(e -> {
            obj.deleteTail();
            updateDisplay();
        });



        button6.addActionListener(e -> {
            if(textField.getText().isEmpty())
            {
                JOptionPane.showMessageDialog(null,"Please enter the position in the field");

            }
            else {
                int position = Integer.parseInt(textField.getText());
                int data = Integer.parseInt(JOptionPane.showInputDialog("Enter data:"));
                dlinklist newNode = new dlinklist(data);
                obj.insertAtPosition(position, newNode);
                textField.setText("");
                updateDisplay();
                JOptionPane.showMessageDialog(null, "Node inserted at position " + position);
            }
        });

        button7.addActionListener(e -> {
            if(textField.getText().isEmpty())
            {
                JOptionPane.showMessageDialog(null,"Please enter the position in the field");

            }
            else {


                int position = Integer.parseInt(textField.getText());
                obj.deleteAtPosition(position);
                updateDisplay();
            }
        });

        button8.addActionListener(e -> {
            int target = Integer.parseInt(JOptionPane.showInputDialog("Enter target data:"));
            obj.deleteTarget(target);
            updateDisplay();
        });
        button1.setFont(new Font("Arial", Font.BOLD, 18));;
        button1.setFocusPainted(false);
        button1.setBackground(Color.decode("#355E3B"));
        button2.setFont(new Font("Arial", Font.BOLD, 18));;
        button2.setFocusPainted(false);
        button2.setBackground(Color.decode("#355E3B"));
        button3.setFont(new Font("Arial", Font.BOLD, 18));;
        button3.setFocusPainted(false);
        button3.setBackground(Color.decode("#FF0000"));
        button4.setFont(new Font("Arial", Font.BOLD, 18));;
        button4.setFocusPainted(false);
        frame.setResizable(false);
        button4.setBackground(Color.decode("#FF0000"));
        button5.setFont(new Font("Arial", Font.BOLD, 18));;
        button5.setFocusPainted(false);
        button5.setBackground(Color.decode("#355E3B"));
        button6.setFont(new Font("Arial", Font.BOLD, 18));;
        button6.setFocusPainted(false);
        button6.setBackground(Color.decode("#355E3B"));
        button7.setFont(new Font("Arial", Font.BOLD, 18));;
        button7.setFocusPainted(false);
        button7.setBackground(Color.decode("#FF0000"));
        button8.setFont(new Font("Arial", Font.BOLD, 18));;
        button8.setFocusPainted(false);
        button8.setBackground(Color.decode("#FF0000"));
        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new FlowLayout());
        buttonPanel.add(label);
        buttonPanel.add(textField);
        buttonPanel.add(button1);
        buttonPanel.add(button2);
        buttonPanel.add(button3);
        buttonPanel.add(button4);

        buttonPanel.add(button6);
        buttonPanel.add(button7);
        buttonPanel.add(button8);
        buttonPanel.setLayout(new GridLayout(9, 1));
        frame.add(buttonPanel, BorderLayout.EAST);
        frame.getContentPane().setBackground(Color.BLACK);
        textArea.setBounds(10,10,800,400);
        textArea.setBackground(Color.black);
        textArea.setForeground(Color.white);
        textArea.setFont(new Font("Arial",Font.BOLD,22));
        textArea.setPreferredSize(new Dimension(800,400));
        buttonPanel.setBorder(BorderFactory.createLineBorder(Color.black,10));

        textArea.setAlignmentX(Component.CENTER_ALIGNMENT);
        frame.add(textArea,BorderLayout.WEST);
        frame.setLayout(new FlowLayout());

        frame.setVisible(true);
    }

    private void updateDisplay() {
        textArea.setText("Link List : "+obj.display());
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(GDoublyLinkedList::new);
    }
}
