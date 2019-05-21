package com.mars.business;

import com.mars.model.enums.OrientationEnum;
import com.mars.model.enums.RotationEnum;
import com.mars.web.RobotBadRequestException;
import com.mars.model.Robot;
import javax.inject.Inject;
import javax.inject.Named;
import java.util.logging.Logger; 

@Named
public class RobotMarsAction implements RobotAction {

    private static final int TER_MIN_POS = 0;
    private static final int TER_MAX_POS = 4;
    private static final char MOV_INSTRUC= 'M';
    
    private static final Logger logger = Logger.getLogger(RobotMarsAction.class.getCanonicalName());
    private final Robot robot;

    @Inject
    public RobotMarsAction(Robot robot) {
        this.robot = robot;
    }

    @Override
    public Robot action(String instructions) {
        if (!isValidInstructions(instructions)) {
            throw new RobotBadRequestException();
        }

        for (char instruction : instructions.toCharArray()) {
            if (isMoveInstruction(instruction)) {
                operateMove();
            } else if (isRotateInstruction(instruction)) {
                RotationEnum rotationEnum = RotationEnum.getByValue(instruction);
                operateRotateTo(rotationEnum);
            }
        }
        return robot;
    }
    
    @Override
    public boolean isValidInstructions(String instructions) {
        boolean isValid = false;

        String moveLimits = new String(new char[TER_MAX_POS + 1]).replace("\0", String.valueOf(MOV_INSTRUC));
        if (!instructions.contains(moveLimits) && instructions.matches("^[LRM]*")) {
            isValid = true;
        }
        return isValid;
    }
    
    @Override
    public boolean isValidMovement(int newXCoord, int newYCoord) {
        return newXCoord <= TER_MAX_POS && newYCoord >= TER_MIN_POS && newXCoord >= TER_MIN_POS && newYCoord <= TER_MAX_POS;
    }
    
    @Override
    public boolean isMoveInstruction(char instruction) {
        return MOV_INSTRUC == instruction;
    }

    @Override
    public boolean isRotateInstruction(char instruction) {
        return RotationEnum.getByValue(instruction) != null;
    }
    

    private void operateMove() {
        int newXCoord = robot.getxCoordenada();
        int newYCoord = robot.getyCoordenada();

        OrientationEnum orientationEnum = robot.getOrientationEnum();
        switch (orientationEnum) {
            case NORTE:
                newYCoord++;
                break;
            case SUL:
                newYCoord--;
                break;
            case LESTE:
                newXCoord++;
                break;
            case OESTE:
                newXCoord--;
                break;
        }

        if (isValidMovement(newXCoord, newYCoord)) {
            robot.setxCoordenada(newXCoord);
            robot.setyCoordenada(newYCoord);
            logger.info("Mover: [" + robot.getxCoordenada() + "," + robot.getyCoordenada() + "," + robot.getOrientationEnum().getOrientationValue() + "]");
        } else {
            logger.info("Mover: ERRO [" + newXCoord + "," + newYCoord + "," + robot.getOrientationEnum().getOrientationValue() + "]");
            throw new RobotBadRequestException();
        }
    }


    private void operateRotateTo(RotationEnum toRotationEnum) {
        OrientationEnum oriEnum = robot.getOrientationEnum();
        OrientationEnum newOriEnum = OrientationEnum.getOrientationRotating(oriEnum, toRotationEnum);
        robot.setOrientationEnum(newOriEnum);
        logger.info("Rotacionar: [" + robot.getxCoordenada() + "," + robot.getyCoordenada() + "," + robot.getOrientationEnum().getOrientationValue() + "]");
    }
}
