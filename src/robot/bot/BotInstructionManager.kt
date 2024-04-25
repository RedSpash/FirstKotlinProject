package robot.bot

import command.*
import map.MoonMap
import map.Position
import `object`.Object
import robot.MoonRobot
import kotlin.math.max

class BotInstructionManager(private val moonRobot: MoonRobot,private val  map: MoonMap) {
    fun getInstruction(): String? {
        for(i in 1..<max(map.sizeX,map.sizeY)){
            for(x in -i..i){
                for(y in -i..i){
                    val relatedPosition = Position(
                        moonRobot.position.x+x,
                        moonRobot.position.y+y,
                    )
                    val obstacle: Object? = this.map.getElementAt(
                        relatedPosition
                    )
                    if(obstacle != null){
                        if(obstacle.isBreakable()){
                            return this.moveToObstacle(Position(
                                relatedPosition.x - moonRobot.position.x,
                                relatedPosition.y - moonRobot.position.y,
                                )
                            ) + EXPLODE_KEY
                        }
                    }
                }
            }
        }
        return null
    }

    private fun moveToObstacle(relatedPosition: Position): String {
        println("To: $relatedPosition")
        var pattern = ""
        while (relatedPosition.x > 0){
            relatedPosition.x -= 1
            pattern += RIGHT_KEY
        }
        while (relatedPosition.x < 0){
            println("Added to x "+relatedPosition.x)
            relatedPosition.x += 1
            pattern += LEFT_KEY
        }

        while (relatedPosition.y > 0){
            println("Removed to y "+relatedPosition.y)
            relatedPosition.y -= 1
            pattern += DOWN_KEY
        }
        while (relatedPosition.y < 0){
            println("Added to y "+relatedPosition.y)
            relatedPosition.y += 1
            pattern += UP_KEY
        }
        return pattern
    }

}
