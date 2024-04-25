package instructions

import robot.MoonRobot

class MoveLeftInstruction : Instruction{
    override fun execute(robot: MoonRobot) {
        robot.move(-1,0)
    }
}