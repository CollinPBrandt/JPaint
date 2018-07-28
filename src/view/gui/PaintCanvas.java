package view.gui;

import javax.swing.*;
import java.awt.*;

public class PaintCanvas extends Component {

    public Graphics2D getGraphics2D() {
        return (Graphics2D)getGraphics();
    }
}
