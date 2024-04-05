import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.io.File;

public class View {
    private JTextArea textArea;
    private JButton loadButton;
    private JButton saveButton;
    private JButton traverseButton;

    public View() {
        JFrame frame = new JFrame("Text Editor");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(500, 500);

        JPanel panel = new JPanel();
        panel.setLayout(new BorderLayout());

        textArea = new JTextArea();
        panel.add(new JScrollPane(textArea), BorderLayout.CENTER);

        JPanel buttonPanel = new JPanel();
        loadButton = new JButton("Load");
        saveButton = new JButton("Save");
        traverseButton = new JButton("Traverse Folder");
        buttonPanel.add(loadButton);
        buttonPanel.add(saveButton);
        buttonPanel.add(traverseButton);

        panel.add(buttonPanel, BorderLayout.SOUTH);

        frame.getContentPane().add(panel);
        frame.setVisible(true);
    }

    public void addLoadListener(ActionListener listener) {
        loadButton.addActionListener(listener);
    }

    public void addSaveListener(ActionListener listener) {
        saveButton.addActionListener(listener);
    }

    public void addTraverseListener(ActionListener listener) {
        traverseButton.addActionListener(listener);
    }

    public String getText() {
        return textArea.getText();
    }

    public void setText(String text) {
        textArea.setText(text);
    }

    public void showMessage(String message) {
        JOptionPane.showMessageDialog(null, message);
    }
}