package com.yauhenl.nooliteApi

import com.yauhenl.nooliteApi.Command.*

class NooliteApi(val host: String) {
    private fun doAction(channel: Byte, command: Command, brightness: Int? = null): Boolean {
        val params = hashMapOf("ch" to channel.toString(), "cmd" to command.code.toString())
        if (brightness != null) params.put("br", brightness.toString())
        return "OK" == khttp.get("http://$host/api.htm", params = params).text
    }

    fun turnOff(channel: Byte) = doAction(channel, turnOff)
    fun slowTurnOff(channel: Byte) = doAction(channel, slowTurnOff)
    fun turnOn(channel: Byte) = doAction(channel, turnOn)
    fun slowTurnOn(channel: Byte) = doAction(channel, slowTurnOn)
    fun switch(channel: Byte) = doAction(channel, switch)
    fun revertSlowTurn(channel: Byte) = doAction(channel, revertSlowTurn)
    fun setBrightness(channel: Byte, brightness: Int) = doAction(channel, setBrightness, brightness)
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
    setBrightness(6),
    runScene(7),
    recordScene(8),
    unbind(9),
    bind(15)
}