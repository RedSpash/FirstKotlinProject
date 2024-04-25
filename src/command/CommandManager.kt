package command

import instructions.*
import map.MoonMap
import robot.MoonRobot
import robot.bot.BotInstructionManager

const val LEFT_KEY = "4"

const val UP_KEY = "8"

const val RIGHT_KEY = "6"

const val DOWN_KEY = "2"

const val EXPLODE_KEY = "5"

class CommandManager(private val bot: Boolean, private val map: MoonMap, private val moonRobot: MoonRobot) {

    private val instructions = mapOf(
        LEFT_KEY to MoveLeftInstruction(),
        UP_KEY to MoveUpInstruction(),
        RIGHT_KEY to MoveRightInstruction(),
        DOWN_KEY to MoveDownInstruction(),
        EXPLODE_KEY to ExplodeObstacleInstruction()
    )

    private var listening = false

    fun startListening(){
        var botInstruction : BotInstructionManager? = null
        if(this.bot){
            botInstruction = BotInstructionManager(moonRobot,map)
        }
        this.listening = true
        while(this.listening){
            val stringInput = if(botInstruction != null){
                botInstruction.getInstruction()
            }else{
                readln()
            }

            println(stringInput)

            if(stringInput == null){
                this.stopListening()
            }else{
                for(letter : Char in stringInput){
                    if(instructions.containsKey(letter.toString())){
                        println(letter)
                        instructions[letter.toString()]?.execute(moonRobot)
                        map.showMap(arrayOf(moonRobot))
                    }
                    readln()
                }
            }
        }
    }

    fun stopListening(){
        println("Arrêt de l'écoute")
        this.listening = false;
    }

}