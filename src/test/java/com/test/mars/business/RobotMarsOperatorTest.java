package com.test.mars.business;

import com.mars.business.RobotMarsAction;
import com.mars.model.Robot;
import com.mars.model.enums.OrientationEnum;
import com.mars.model.enums.RotationEnum;
import com.mars.web.RobotBadRequestException;

import static org.junit.Assert.assertEquals;
import org.junit.Test;


public class RobotMarsOperatorTest {

    private RobotMarsAction operac = new RobotMarsAction(new Robot());

    @Test
    public void operateShouldNotReturnError() {
    	operac.action("MMMM");
    	operac = new RobotMarsAction(new Robot());
    	operac.action("MMRMMRMM");
    	operac = new RobotMarsAction(new Robot());
    	operac.action("MML");
    }

    @Test(expected = RobotBadRequestException.class)
    public void operateInvalidMoveShouldReturnError() { 
    	operac.action("MMMMMMMMMMMMMMMMMMMMMMMM");
    }
    
    @Test(expected = RobotBadRequestException.class)
    public void operateInvalidInstructionShouldReturnError() {
    	operac.action("AA123MLR");
    }


    @Test
    public void isValidInstructionsShouldNotReturnError() {
        assertEquals(operac.isValidInstructions("MMMM"), true);
        assertEquals(operac.isValidInstructions("MMRMMRMM"), true);
        assertEquals(operac.isValidInstructions("MML"), true);
        assertEquals(operac.isValidInstructions("AAA"), false);
        assertEquals(operac.isValidInstructions("MMMMMMMMMMMMMMMMMMMMMMMM"), false);
    }

    @Test
    public void isMoveInstructionShouldNotReturnError() {
        assertEquals(operac.isMoveInstruction('M'), true);
        assertEquals(operac.isMoveInstruction('L'), false);
    }

    @Test
    public void isRotateInstructionShouldNotReturnError() {
        assertEquals(operac.isRotateInstruction('R'), true);
        assertEquals(operac.isRotateInstruction('L'), true);
        assertEquals(operac.isRotateInstruction('M'), false);
    }

    @Test
    public void isValidMoveShouldNotReturnError() {
        assertEquals(operac.isValidMovement(0, 0), true);
        assertEquals(operac.isValidMovement(-1, -1), false);

    }

    @Test
    public void operateRotateToNorthShouldNotReturnError() {
        OrientationEnum orientationEnum = OrientationEnum.getOrientationRotating(OrientationEnum.LESTE, RotationEnum.LEFT);
        assertEquals(orientationEnum, OrientationEnum.NORTE);
        orientationEnum = OrientationEnum.getOrientationRotating(OrientationEnum.OESTE, RotationEnum.RIGHT);
        assertEquals(orientationEnum, OrientationEnum.NORTE);
    }

    @Test
    public void operateRotateToSouthShouldNotReturnError() {
        OrientationEnum orientationEnum = OrientationEnum.getOrientationRotating(OrientationEnum.OESTE, RotationEnum.LEFT);
        assertEquals(orientationEnum, OrientationEnum.SUL);
        orientationEnum = OrientationEnum.getOrientationRotating(OrientationEnum.LESTE, RotationEnum.RIGHT);
        assertEquals(orientationEnum, OrientationEnum.SUL);
    }

    @Test
    public void operateRotateToEastShouldNotReturnError() {
        OrientationEnum orientationEnum = OrientationEnum.getOrientationRotating(OrientationEnum.SUL, RotationEnum.LEFT);
        assertEquals(orientationEnum, OrientationEnum.LESTE);
        orientationEnum = OrientationEnum.getOrientationRotating(OrientationEnum.NORTE, RotationEnum.RIGHT);
        assertEquals(orientationEnum, OrientationEnum.LESTE);
    }
    
    @Test
    public void operateRotateToWestShouldNotReturnError() {
        OrientationEnum orientationEnum = OrientationEnum.getOrientationRotating(OrientationEnum.NORTE, RotationEnum.LEFT);
        assertEquals(orientationEnum, OrientationEnum.OESTE);
        orientationEnum = OrientationEnum.getOrientationRotating(OrientationEnum.SUL, RotationEnum.RIGHT);
        assertEquals(orientationEnum, OrientationEnum.OESTE);
    }

}
