package view;

import javax.swing.*;
import java.awt.*;

public class InfoScrollPane extends JScrollPane {
    public InfoScrollPane(JTextArea textArea, Dimension size) {
        setPreferredSize(size);
        setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
        setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        setWheelScrollingEnabled(true);
        setViewportView(textArea);
    }
}
