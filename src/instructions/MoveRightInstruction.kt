package instructions

import robot.MoonRobot
import robot.direction.Direction

class MoveRightInstruction : Instruction{
    override fun execute(robot: MoonRobot) {
        robot.move(1,0)
        robot.direction = Direction.RIGHT
    }
}