import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class stack extends JFrame {
    static String[] array = new String[5];
    static int top = -1;
    static int size = array.length;

    private JTextArea stackTextArea;
    private JTextField inputField;

    public stack() {
        initializeUI();
    }

    private void initializeUI() {
        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Stack Visualization");
        setLayout(new BorderLayout());
        setSize(400, 300);

        stackTextArea = new JTextArea();
        stackTextArea.setEditable(false);
        add(new JScrollPane(stackTextArea), BorderLayout.CENTER);
        JLabel label=new JLabel("   Value :");
        JPanel inputPanel = new JPanel();
        inputPanel.setLayout(new FlowLayout());
   inputPanel.add(label);
       inputField = new JTextField(10);
        inputPanel.add(inputField);

        JButton pushButton = new JButton("Push");
        pushButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
               if(inputField.getText().isEmpty())
               {
                        JOptionPane.showMessageDialog(null,"Please enter a value");
               }
               else {
                   String input = inputField.getText();
                   push(input);
                   updateStackText();
                   inputField.setText("");
               }
            }
        });
        inputPanel.add(pushButton);

        JButton popButton = new JButton("Pop");
        popButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                pop();
                updateStackText();
            }
        });
        inputPanel.add(popButton);

        JButton peekButton = new JButton("Peek");
        peekButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                peek();
                updateStackText();
            }
        });
        inputPanel.add(peekButton);

        add(inputPanel, BorderLayout.SOUTH);

        updateStackText();
        setVisible(true);
    }

    private void push(String c) {
        if (top >= size - 1) {
            JOptionPane.showMessageDialog(this, "Stack overflow");
        } else {
            array[++top] = c;
        }
    }

    private void pop() {
        if (top < 0) {
            JOptionPane.showMessageDialog(this, "Stack empty");
        } else {
            array[top--] = null;
        }
    }

    private void peek() {
        if (top >= 0) {
            JOptionPane.showMessageDialog(this, "Top element: " + array[top]);
        } else {
            JOptionPane.showMessageDialog(this, "Stack empty");
        }
    }

    private void updateStackText() {
        StringBuilder stackContent = new StringBuilder();
        stackContent.append("Stack Contents:\n");

        for (int i = top; i >= 0; i--) {
            stackContent.append(array[i]).append("\n");
        }

        stackTextArea.setText(stackContent.toString());
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(stack::new);
    }
}
