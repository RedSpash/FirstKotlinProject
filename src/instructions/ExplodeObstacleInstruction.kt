package instructions

import map.Position
import `object`.Void
import robot.MoonRobot
import robot.direction.Direction

class ExplodeObstacleInstruction : Instruction{
    override fun execute(robot: MoonRobot) {
        val obstaclePosition = Position(
            robot.position.x + robot.direction.x,
            robot.position.y + robot.direction.y
        )
        val obstacle = robot.map.getElementAt(obstaclePosition)
        if(obstacle != null && obstacle.isBreakable()){
            robot.map.setElement(obstaclePosition, Void())
        }
    }
}