package com.problem2;

import java.util.Arrays;

import com.problem2.factory.ControlPanelFactory;

public class Utility {
    // ... Add more difficulty levels here
    private static String[] difficulties = new String[] { "beginner", "intermediate", "advanced", "extreme",
            "super extreme" };

    public static ControlPanelFactory createControlPanelFactory(String level) {
        if (!Arrays.asList(difficulties).contains(level.toLowerCase())) {
            throw new IllegalArgumentException("Invalid level: " + level);
        }
        return new ControlPanelFactory(level);
    }

    /**
     * Returns the list of available difficulty levels.
     * The list is unmodifiable.
     * 
     * @return the list of available difficulty levels
     */
    public static String[] getDifficultyOptions() {
        return difficulties;
    }
}
