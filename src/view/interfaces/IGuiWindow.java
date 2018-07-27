package view.interfaces;

import model.MouseHandler;
import model.persistence.ApplicationState;
import view.EventName;
import javax.swing.*;

public interface IGuiWindow {

    JButton getButton(EventName eventName);

    void addMouseHandler(ApplicationState appState);
}
