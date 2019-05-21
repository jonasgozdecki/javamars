package com.mars.model;

import com.mars.model.enums.OrientationEnum;

public class Robot {

    @SuppressWarnings("unused")
	private static final long serialVersionUID = -340875071855645838L;

    private int xCoordenada;
    private int yCoordenada;
    private OrientationEnum oriEnum; 

    public Robot() {
        xCoordenada = 0;
        yCoordenada = 0;
        oriEnum = OrientationEnum.NORTE;
    }

    public int getxCoordenada() {
        return xCoordenada;
    }

    public void setxCoordenada(int xCoordenada) {
        this.xCoordenada = xCoordenada;
    }

    public int getyCoordenada() {
        return yCoordenada;
    }

    public void setyCoordenada(int yCoordenada) {
        this.yCoordenada = yCoordenada;
    }

    public OrientationEnum getOrientationEnum() {
        return oriEnum;
    }

    public void setOrientationEnum(OrientationEnum orientationEnum) {
        this.oriEnum = orientationEnum;
    }

    @Override
    public String toString() {
        return "[" + xCoordenada + "," + yCoordenada +"," + oriEnum.getOrientationValue() + "]";
    }
    
    

}
