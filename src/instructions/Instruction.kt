package instructions

import robot.MoonRobot

interface Instruction {

    fun execute(robot: MoonRobot)

}