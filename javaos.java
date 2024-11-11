import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SimpleOS {
    private JFrame desktopFrame;
    private JDesktopPane desktopPane;
    private JPanel taskBar;

    public SimpleOS() {
        createDesktop();
    }

    private void createDesktop() {
        // Create the main desktop frame
        desktopFrame = new JFrame("Simple Java OS");
        desktopFrame.setSize(800, 600);
        desktopFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        desktopFrame.setLayout(new BorderLayout());

        // Create the desktop pane (which will contain internal windows)
        desktopPane = new JDesktopPane();
        desktopPane.setBackground(Color.LIGHT_GRAY);

        // Create the taskbar
        taskBar = new JPanel();
        taskBar.setLayout(new FlowLayout(FlowLayout.LEFT));

        // Add buttons to the taskbar for opening apps
        JButton fileExplorerButton = new JButton("File Explorer");
        JButton textEditorButton = new JButton("Text Editor");
        JButton calculatorButton = new JButton("Calculator");

        taskBar.add(fileExplorerButton);
        taskBar.add(textEditorButton);
        taskBar.add(calculatorButton);

        // Add action listeners for buttons
        fileExplorerButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                openFileExplorer();
            }
        });

        textEditorButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                openTextEditor();
            }
        });

        calculatorButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                openCalculator();
            }
        });

        // Add components to the frame
        desktopFrame.add(desktopPane, BorderLayout.CENTER);
        desktopFrame.add(taskBar, BorderLayout.SOUTH);

        // Show the desktop frame
        desktopFrame.setVisible(true);
    }

    private void openFileExplorer() {
        JInternalFrame fileExplorer = new JInternalFrame("File Explorer", true, true, true, true);
        fileExplorer.setSize(300, 200);
        fileExplorer.setVisible(true);

        JLabel label = new JLabel("This is a mock File Explorer.");
        fileExplorer.add(label);

        desktopPane.add(fileExplorer);
        try {
            fileExplorer.setSelected(true);
        } catch (java.beans.PropertyVetoException e) {
            e.printStackTrace();
        }
    }

    private void openTextEditor() {
        JInternalFrame textEditor = new JInternalFrame("Text Editor", true, true, true, true);
        textEditor.setSize(400, 300);
        textEditor.setVisible(true);

        JTextArea textArea = new JTextArea();
        textEditor.add(new JScrollPane(textArea));

        desktopPane.add(textEditor);
        try {
            textEditor.setSelected(true);
        } catch (java.beans.PropertyVetoException e) {
            e.printStackTrace();
        }
    }

    private void openCalculator() {
        JInternalFrame calculator = new JInternalFrame("Calculator", true, true, true, true);
        calculator.setSize(200, 250);
        calculator.setVisible(true);

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(4, 4));
        String[] buttons = { "7", "8", "9", "/", "4", "5", "6", "*", "1", "2", "3", "-", "0", ".", "=", "+" };
        for (String text : buttons) {
            panel.add(new JButton(text));
        }

        calculator.add(panel);
        desktopPane.add(calculator);

        try {
            calculator.setSelected(true);
        } catch (java.beans.PropertyVetoException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        new SimpleOS();
    }
}