package view;

import javax.swing.*;
import java.awt.*;

public class BtnPanel extends JPanel {
    public BtnPanel(Dimension size) {
        setLayout(new GridLayout(1, 3, 2, 0));
        setPreferredSize(size);
    }
}
