package instructions

import robot.MoonRobot

class MoveRightInstruction : Instruction{
    override fun execute(robot: MoonRobot) {
        robot.move(1,0)
    }
}