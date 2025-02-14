package com.problem2.factory;

import com.problem2.panels.*;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Supplier;

interface ControlPanelFactoryInterface {
    CharacterPanel createCharacterPanel();

    WeaponPanel createWeaponPanel();
}

// Concrete Factory Class that creates control panel instances
public class ControlPanelFactory implements ControlPanelFactoryInterface {
    private static Map<String, Supplier<CharacterPanel>> characterPanelMap = new HashMap<>();
    private static Map<String, Supplier<WeaponPanel>> weaponPanelMap = new HashMap<>();
    private String selectedLevel;

    static {
        characterPanelMap.put("beginner", BeginnerCharacterPanel::new);
        weaponPanelMap.put("beginner", BeginnerWeaponPanel::new);

        characterPanelMap.put("intermediate", IntermediateCharacterPanel::new);
        weaponPanelMap.put("intermediate", IntermediateWeaponPanel::new);

        characterPanelMap.put("advanced", AdvancedCharacterPanel::new);
        weaponPanelMap.put("advanced", AdvancedWeaponPanel::new);

        characterPanelMap.put("extreme", ExtremeCharacterPanel::new);
        weaponPanelMap.put("extreme", ExtremeWeaponPanel::new);

        characterPanelMap.put("super extreme", SuperExtremeCharacterPanel::new);
        weaponPanelMap.put("super extreme", SuperExtremeWeaponPanel::new);

        // ... Add more panels here
    }

    public ControlPanelFactory(String level) {
        this.selectedLevel = level.toLowerCase();
    }

    /**
     * Creates a character panel based on the selected level.
     * 
     * @return the character panel
     * @throws IllegalArgumentException if the selected level is invalid
     */
    public CharacterPanel createCharacterPanel() {
        Supplier<CharacterPanel> supplier = characterPanelMap.get(selectedLevel);

        if (supplier != null) {
            return supplier.get();
        }

        throw new IllegalArgumentException("Invalid level: " + selectedLevel);
    }

    /**
     * Creates a weapon panel based on the selected level.
     * 
     * @return the weapon panel
     * @throws IllegalArgumentException if the selected level is invalid
     */
    public WeaponPanel createWeaponPanel() {
        Supplier<WeaponPanel> supplier = weaponPanelMap.get(selectedLevel);

        if (supplier != null) {
            return supplier.get();
        }

        throw new IllegalArgumentException("Invalid level: " + selectedLevel);
    }
}
