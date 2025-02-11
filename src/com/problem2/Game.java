package com.problem2;

import com.problem2.factory.ControlPanelFactory;
import com.problem2.panels.CharacterPanel;
import com.problem2.panels.WeaponPanel;

import javax.swing.*;

public class Game {
    private CharacterPanel characterPanel;
    private WeaponPanel weaponPanel;

    public void SetupGame(String level) {
        characterPanel = ControlPanelFactory.createCharacterPanel(level);
        weaponPanel = ControlPanelFactory.createWeaponPanel(level);
    }

    public void DisplayOptions() {
        String[] options = { "Beginner", "Intermediate", "Advanced" };
        String selectedOption = (String) JOptionPane.showInputDialog(null, "Select a level:", "Level Selection",
                JOptionPane.QUESTION_MESSAGE, null, options, options[0]);
        SetupGame(selectedOption);
    }

    public void Play() {
        characterPanel.display();
        weaponPanel.display();
    }
}
