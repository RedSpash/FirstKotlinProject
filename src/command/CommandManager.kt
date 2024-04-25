package command

import instructions.*
import map.MoonMap
import robot.MoonRobot

class CommandManager(private val map: MoonMap,private val moonRobot: MoonRobot) {

    private final val instructions = mapOf(
        "4" to MoveLeftInstruction(),
        "8" to MoveUpInstruction(),
        "6" to MoveRightInstruction(),
        "2" to MoveDownInstruction(),
        "5" to ExplodeObstacleInstruction()
    )

    private var listening = false

    fun startListening(){
        this.listening = true
        while(this.listening){
            val stringInput = readln()
            for(letter : Char in stringInput){
                if(instructions.containsKey(letter.toString())){
                    instructions[letter.toString()]?.execute(moonRobot)
                    map.showMap(arrayOf(moonRobot))
                    Thread.sleep(500)
                }
            }
        }
    }

    fun stopListening(){
        this.listening = false;
    }

}