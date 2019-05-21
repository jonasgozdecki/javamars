package com.mars.business;

import com.mars.model.Robot;

public interface RobotAction {

    public Robot action(String instructions);  

    public boolean isValidMovement(int newXCord, int newYCord);

    public boolean isMoveInstruction(char instruction);

    public boolean isValidInstructions(String instructions);
    
    public boolean isRotateInstruction(char instruction);
 
}
