import javax.swing.*;
import java.awt.*;

class linklist {
    int data;
    linklist next;

    linklist(int data) {
        this.data = data;
        next = null;
    }
}

class Functions {
    linklist head = null;

    void insertAtHead(linklist node) {
        linklist temp = head;
        if (head == null) {
            head = node;
        } else {
            head = node;
            head.next = temp;
        }
    }

    void insertAtTail(linklist node) {
        if (head == null) {
            head = node;
        } else {
            linklist temp = head;
            while (temp.next != null) {
                temp = temp.next;
            }
            temp.next = node;
        }
    }

    void delHead() {
        if (head != null) {
            linklist temp = head;
            head = head.next;
            temp = null;
        }
    }

    void delTail() {
        if (head != null) {
            linklist temp = head;
            linklist pre = null;
            while (temp.next != null) {
                pre = temp;
                temp = temp.next;
            }

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
        linklist temp = head;
        while (temp != null) {
            result.append(temp.data).append('\u2192');
            temp = temp.next;
        }
        result.append("NULL");
        return result.toString();
    }
}

class GU {
    Functions obj;
    JTextArea textArea;

    GU() {
        obj = new Functions();

        JFrame frame = new JFrame("Singly Linked List");
        frame.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        frame.setLayout(new BorderLayout());
        frame.setSize(1200, 400);

        JButton button1 = new JButton("Insert at Head");
        JButton button2 = new JButton("Insert at Tail");
        JButton button3 = new JButton("Delete at Head");
        JButton button4 = new JButton("Delete at Tail");
        frame.setResizable(false);
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
        button4.setBackground(Color.decode("#FF0000"));
        JLabel label=new JLabel("   Value/Poiston :");
        JTextField textField = new JTextField(10);
        textArea = new JTextArea("Link List : ");
        textArea.setEditable(false);

        button1.addActionListener(e -> {

           if(textField.getText().isEmpty())
           {
               JOptionPane.showMessageDialog(null,"First enter the value");
           }
           else
           {
               int data = Integer.parseInt(textField.getText());
               linklist newNode = new linklist(data);
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
            else{
                int data = Integer.parseInt(textField.getText());
                linklist newNode = new linklist(data);
                obj.insertAtTail(newNode);
                textField.setText("");
                updateDisplay();
                JOptionPane.showMessageDialog(null, "Added to tail successfully");
            }
        });

        button3.addActionListener(e -> {
            obj.delHead();
            updateDisplay();
        });

        button4.addActionListener(e -> {
            obj.delTail();
            updateDisplay();
        });



        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new FlowLayout());
        buttonPanel.add(label);
        buttonPanel.add(textField);
        buttonPanel.add(button1);
        buttonPanel.add(button2);
        buttonPanel.add(button3);
        buttonPanel.add(button4);

         buttonPanel.setLayout(new GridLayout(6,1));
        frame.getContentPane().setBackground(Color.BLACK);
        frame.add(buttonPanel, BorderLayout.EAST);
        textArea.setBounds(10,10,800,400);
        textArea.setBackground(Color.black);
        textArea.setForeground(Color.white);
        textArea.setFont(new Font("Arial",Font.BOLD,22));
        textArea.setPreferredSize(new Dimension(800,400));
   buttonPanel.setBorder(BorderFactory.createLineBorder(Color.black,10));

        textArea.setAlignmentX(Component.CENTER_ALIGNMENT);
        frame.add(textArea,BorderLayout.WEST);
        frame.setLayout(new FlowLayout());


        frame.add(textArea, BorderLayout.SOUTH);

        frame.setVisible(true);

    }

    private void updateDisplay() {
        textArea.setText("Link List : "+obj.display());
    }
}



