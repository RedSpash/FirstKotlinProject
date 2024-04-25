package instructions

import robot.MoonRobot
import robot.direction.Direction

class MoveUpInstruction : Instruction{
    override fun execute(robot: MoonRobot) {
        robot.move(0,-1)
        robot.direction = Direction.UP
    }
}