package view.interfaces;

import controller.IJPaintController;
import view.EventName;

import javax.swing.*;

public interface IGuiWindow {
    JButton getButton(EventName eventName);
    
}
