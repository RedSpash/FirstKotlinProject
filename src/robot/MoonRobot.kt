package robot

import map.MoonMap
import map.Position
import `object`.Object
import robot.direction.Direction

class MoonRobot(val map: MoonMap) {

    var direction = Direction.RIGHT
    val position = Position(0,0)

    fun move(x: Int, y: Int) {
        val mapObject : Object? = this.map.getElementAt(Position(this.position.x+x, this.position.y+y))
        if(mapObject != null && !mapObject.isSolid()){
            this.position.x += x
            this.position.y += y
        }
    }
}
