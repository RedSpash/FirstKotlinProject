import command.CommandManager
import map.MoonMap
import robot.MoonRobot

fun main(){
    val map = MoonMap(10,10)
    val robot = MoonRobot(map)

    val commandManager = CommandManager(map,robot)
    commandManager.startListening()
}