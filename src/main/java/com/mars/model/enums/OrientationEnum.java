package com.mars.model.enums;

import java.util.HashMap;
import java.util.Map;


public enum OrientationEnum { 

    NORTE("N", 0), SUL("S", 180), LESTE("E", 90), OESTE("W", 270);

    private final String orientationValue;
    private final int intValue;
    private static final Map<Integer, OrientationEnum> automap = new HashMap<>();

    static {
        for (OrientationEnum direction : OrientationEnum.values()) {
        	automap.put(direction.getIntValue(), direction);
        }
    }

    OrientationEnum(final String position, final int value) {
        this.orientationValue = position;
        this.intValue = value;
    }

    public String getOrientationValue() {
        return this.orientationValue;
    }

    public int getIntValue() {
        return this.intValue;
    }

    public static OrientationEnum getOrientationRotating(OrientationEnum orientationEnum, RotationEnum rotationEnum) {
        OrientationEnum newOriEnum;
        int value = orientationEnum.getIntValue() + rotationEnum.getIntValue();
        if (value < NORTE.getIntValue()) {
        	newOriEnum = OESTE;
        } else if (value > OESTE.getIntValue()) {
        	newOriEnum = NORTE;
        } else {
        	newOriEnum = automap.get(value);
        }
        return newOriEnum;
    }    

}
