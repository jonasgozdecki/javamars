package com.mars.model.enums;

import java.util.HashMap;
import java.util.Map;


public enum RotationEnum { 
	RIGHT('R', 90), LEFT('L', -90);

	private final int intValue;
    private final char rotatioValue;
    

    private static final Map<Character, RotationEnum> rotationMap = new HashMap<>();

    static {
        for (RotationEnum rotationEnum : RotationEnum.values()) {
            rotationMap.put(rotationEnum.getRotationValue(), rotationEnum);
        }
    }

    RotationEnum(char rotationValue, int value) {
        this.intValue = value;
        this.rotatioValue = rotationValue;
    }

    public int getIntValue() {
        return this.intValue;
    }

    public char getRotationValue() {
        return this.rotatioValue;
    }

    public static RotationEnum getByValue(char rotation) {
        return rotationMap.get(rotation);
    }
}
