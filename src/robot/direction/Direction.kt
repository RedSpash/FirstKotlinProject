package robot.direction

enum class Direction(var direction: String, val x: Int, val y: Int) {
    RIGHT(">",1,0),
    LEFT("<",-1,0),
    UP("^",0,-1),
    DOWN("v",0,1)
}
