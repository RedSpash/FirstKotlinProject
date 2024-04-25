import command.CommandManager
import map.MoonMap
import robot.MoonRobot

fun main(){
    val map = MoonMap(10,10)
    val robot = MoonRobot(map)
    map.showMap(arrayOf(robot))
    val commandManager = CommandManager(true,map,robot)
    commandManager.startListening()
}