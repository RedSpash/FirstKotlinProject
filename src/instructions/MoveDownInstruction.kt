package instructions

import robot.MoonRobot

class MoveUpInstruction : Instruction{
    override fun execute(robot: MoonRobot) {
        robot.move(0,1)
    }
}