package com.problem2;

import com.problem2.factory.ControlPanelFactory;
import com.problem2.panels.CharacterPanel;
import com.problem2.panels.WeaponPanel;

import javax.swing.*;

interface GameInterface {
    void SetupGame(String level);
    String GetOptionFromUser();
    void Play();
}

// Concrete class that implements GameInterface
public class Game implements GameInterface {
    private CharacterPanel characterPanel;
    private WeaponPanel weaponPanel;

    /**
     * Sets up the game with the given level. The level should be the name of the
     * level in lowercase (e.g. "beginner", "intermediate", "advanced").
     * 
     * @param level the level name
     */
    public void SetupGame(String level) {
        System.out.println("Selected level: " + level);
        ControlPanelFactory factory = Utility.createControlPanelFactory(level);
        characterPanel = factory.createCharacterPanel();
        weaponPanel = factory.createWeaponPanel();
    }

    /**
     * Displays a level selection dialog box and returns the selected level
     * name. The dialog box should be a dropdown list of all the available
     * difficulty levels.
     * 
     * @return the selected difficulty level name
     */
    public String GetOptionFromUser() {
        String[] options = Utility.getDifficultyOptions();
        String selectedOption = (String) JOptionPane.showInputDialog(null, "Select a level:", "Level Selection",
                JOptionPane.QUESTION_MESSAGE, null, options, options[0]);
        return selectedOption;
    }

    /**
     * Starts the game by displaying the character panel and then the weapon
     * panel. The order of display should be character panel first, then weapon
     * panel.
     */
    public void Play() {
        characterPanel.display();
        weaponPanel.display();
    }
}
