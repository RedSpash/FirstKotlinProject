package map

import `object`.Object
import `object`.Obstacle
import `object`.Void
import robot.MoonRobot

private const val VERTICAL_LINE = "┃"

private const val HORIZONTAL_LINE = "━━━"

class MoonMap(private val sizeX: Int, private val sizeY: Int) {

    private var map : Array<Array<Object>> = arrayOf()

    init {
        for (y in 1..sizeY){
            var line : Array<Object> = arrayOf()
            for (x in 1..sizeX){
                if((0..3).random() <= 2){
                    line += Void()
                }else{
                    line += Obstacle()
                }
            }
            this.map += line
        }
    }

    fun getElementAt(position: Position): Object? {
        if(!this.isValidPosition(position)){
            return null
        }
        return this.map[position.y][position.x]
    }

    fun showMap(robots : Array<MoonRobot> = arrayOf()){
        var mapToShow = ""
        for(y in this.map.indices){
            val objectLine = this.map[y]
            mapToShow += "${VERTICAL_LINE}$HORIZONTAL_LINE".repeat(this.sizeX)+"$VERTICAL_LINE\n"
            var line = "";
            for(x in objectLine.indices){
                val element = objectLine[x]
                var elementToShow = element.symbolRepresentation()
                for(robot in robots){
                    if(robot.position.x == x && robot.position.y == y){
                        elementToShow = robot.direction.direction
                        break
                    }
                }
                line = "$line$VERTICAL_LINE $elementToShow "
            }
            mapToShow += "$line$VERTICAL_LINE\n"
        }
        mapToShow += "${VERTICAL_LINE}$HORIZONTAL_LINE".repeat(this.sizeX)+ VERTICAL_LINE
        println(mapToShow)
    }

    fun setElement(obstaclePosition: Position, obstacle: Object) {
        if(!this.isValidPosition(obstaclePosition)){
            return
        }
        this.map[obstaclePosition.y][obstaclePosition.x] = obstacle
    }

    private fun isValidPosition(position: Position): Boolean {
        return position.x < sizeX && position.y < sizeY
                && position.x >= 0 && position.y >= 0
    }

}
