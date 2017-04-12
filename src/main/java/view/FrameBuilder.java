package view;

import controller.AppController;

import javax.swing.*;
import java.awt.*;

public class FrameBuilder {
    private AppController appController;
    private static final String newline = "\n";
    private static final Dimension textFieldSize = new Dimension(400, 30);
    private static final Dimension btnPanelSize = new Dimension(400, 30);
    private static final Dimension infoPanelSize = new Dimension(400, 150);

    public FrameBuilder(AppController appController) {
        this.appController = appController;
    }

    public void build() {
        JFrame frame = new JFrame();
        frame.setTitle("Test VPT-221");
        frame.setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);
        frame.setResizable(false);
        frame.setLayout(new BorderLayout());

        JTextField textField = new InputTextField(textFieldSize);

        JTextArea textArea = new InfoTextArea();
        JScrollPane scrollPane = new InfoScrollPane(textArea, infoPanelSize);

        JButton confirmBtn = new JButton("Confirm");
        JButton clearBtn = new JButton("Clear");
        JButton exitBtn = new JButton("Exit");

        JPanel btnPanel = new BtnPanel(btnPanelSize);
        btnPanel.add(confirmBtn);
        btnPanel.add(clearBtn);
        btnPanel.add(exitBtn);

        confirmBtn.addActionListener(e -> {
            if (!textField.getText().equals("")) {
                textArea.append(appController.confirm(textField.getText()));
                textArea.append(newline);
            }
        });
        clearBtn.addActionListener(e -> textField.setText(""));
        exitBtn.addActionListener(e -> appController.exit());

        frame.add(textField, BorderLayout.NORTH);
        frame.add(btnPanel, BorderLayout.CENTER);
        frame.add(scrollPane, BorderLayout.SOUTH);

        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

}
