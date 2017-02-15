package com.yauhenl.nooliteApi

import com.yauhenl.nooliteApi.Command.*

class NooliteApi(val host:String) {
    private fun doAction(channel:Byte, command:Command) = "OK" == khttp.get("http://$host/api.htm", params = hashMapOf("ch" to channel.toString(), "cmd" to command.code.toString())).text

    fun turnOff(channel: Byte) = doAction(channel, turnOff)
    fun slowTurnOff(channel: Byte) = doAction(channel, slowTurnOff)
    fun turnOn(channel: Byte) = doAction(channel, turnOn)
    fun slowTurnOn(channel: Byte) = doAction(channel, slowTurnOn)
    fun switch(channel: Byte) = doAction(channel, switch)
    fun revertSlowTurn(channel: Byte) = doAction(channel, revertSlowTurn)
    fun runScene(channel: Byte) = doAction(channel, runScene)
    fun recordScene(channel: Byte) = doAction(channel, recordScene)
    fun unbind(channel: Byte) = doAction(channel, unbind)
    fun bind(channel: Byte) = doAction(channel, bind)
}

enum class Command(val code: Int) {
    turnOff(0),
    slowTurnOff(1),
    turnOn(2),
    slowTurnOn(3),
    switch(4),
    revertSlowTurn(5),
    runScene(7),
    recordScene(8),
    unbind(9),
    bind(15)
}

fun main(args: Array<String>) {
    val api = NooliteApi(args[0])
    println(api.turnOff(0))
    println(api.slowTurnOff(0))
    println(api.turnOn(0))
    println(api.slowTurnOn(0))
    println(api.switch(0))
    println(api.revertSlowTurn(0))
    println(api.runScene(0))
    println(api.recordScene(0))
    println(api.unbind(0))
    println(api.bind(0))
}