package com.problem2.factory;

import com.problem2.panels.*;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Supplier;

public class ControlPanelFactory {
    private static Map<String, Supplier<CharacterPanel>> characterPanelMap = new HashMap<>();
    private static Map<String, Supplier<WeaponPanel>> weaponPanelMap = new HashMap<>();

    static {
        characterPanelMap.put("Beginner", BeginnerCharacterPanel::new);
        weaponPanelMap.put("Beginner", BeginnerWeaponPanel::new);

        characterPanelMap.put("Intermediate", IntermediateCharacterPanel::new);
        weaponPanelMap.put("Intermediate", IntermediateWeaponPanel::new);

        characterPanelMap.put("Advanced", AdvancedCharacterPanel::new);
        weaponPanelMap.put("Advanced", AdvancedWeaponPanel::new);

        // ... Add more panels here
    }

    /**
     * Creates a character panel based on the given level. The level should be the
     * level name in lowercase (e.g. "beginner", "intermediate", "advanced").
     * If the level is not found, it defaults to the Beginner Character Panel.
     * 
     * @param level the level name
     * @return the character panel
     */
    public static CharacterPanel createCharacterPanel(String level) {
        Supplier<CharacterPanel> supplier = characterPanelMap.get(level.toLowerCase());

        if (supplier != null) {
            return supplier.get();
        }

        // Default to Beginner Character Panel, if client disagrees, we can return null
        // here as well
        return new BeginnerCharacterPanel();
    }

    /**
     * Creates a weapon panel based on the given level. The level should be the
     * level name in lowercase (e.g. "beginner", "intermediate", "advanced").
     * If the level is not found, it defaults to the Beginner Weapon Panel.
     * 
     * @param level the level name
     * @return the weapon panel
     */
    public static WeaponPanel createWeaponPanel(String level) {
        Supplier<WeaponPanel> supplier = weaponPanelMap.get(level.toLowerCase());

        if (supplier != null) {
            return supplier.get();
        }

        // Default to Beginner Weapon Panel, if client disagrees, we can return null
        // here as well
        return new BeginnerWeaponPanel();
    }

    /**
     * Registers a new character panel with the factory. The level should be the
     * level name in lowercase (e.g. "beginner", "intermediate", "advanced").
     * The supplier should be a lambda that when invoked returns an instance of
     * the panel. The panel is expected to be a subclass of CharacterPanel.
     * 
     * @param level    the level name
     * @param supplier the supplier of the panel
     */
    public static void registerCharacterPanel(String level, Supplier<CharacterPanel> supplier) {
        characterPanelMap.put(level.toLowerCase(), supplier);
    }

    /**
     * Registers a new weapon panel with the factory. The level should be the
     * level name in lowercase (e.g. "beginner", "intermediate", "advanced").
     * The supplier should be a lambda that when invoked returns an instance of
     * the panel. The panel is expected to be a subclass of WeaponPanel.
     * 
     * @param level    the level name
     * @param supplier the supplier of the panel
     */
    public static void registerWeaponPanel(String level, Supplier<WeaponPanel> supplier) {
        weaponPanelMap.put(level.toLowerCase(), supplier);
    }
}
