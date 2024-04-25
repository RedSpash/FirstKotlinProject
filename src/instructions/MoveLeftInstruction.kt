package instructions

import robot.MoonRobot
import robot.direction.Direction

class MoveLeftInstruction : Instruction{
    override fun execute(robot: MoonRobot) {
        robot.move(-1,0)
        robot.direction = Direction.LEFT
    }
}