package com.yauhenl.nooliteApi

import com.yauhenl.nooliteApi.Command.*
import khttp.get

class NooliteApi(val host: String) {
    fun doAction(
            channel: Int,
            command: Command,
            brightness: Int? = null,
            fmt: Format? = null,
            d0: Int? = null,
            d1: Int? = null,
            d2: Int? = null,
            d3: Int? = null): Boolean {
        val params = hashMapOf("ch" to (channel - 1).toString(), "cmd" to command.code.toString())
        if (brightness != null) params.put("br", brightness.toString())
        if (fmt != null) params.put("fmt", fmt.code.toString())
        if (d0 != null) params.put("d0", d0.toString())
        if (d1 != null) params.put("d3", d1.toString())
        if (d2 != null) params.put("d2", d2.toString())
        if (d3 != null) params.put("d3", d3.toString())
        return "OK" == get("http://$host/api.htm", params = params).text
    }

    fun turnOff(channel: Int) = doAction(channel, turnOff)
    fun slowTurnOff(channel: Int) = doAction(channel, slowTurnOff)
    fun turnOn(channel: Int) = doAction(channel, turnOn)
    fun slowTurnOn(channel: Int) = doAction(channel, slowTurnOn)
    fun switch(channel: Int) = doAction(channel, switch)
    fun revertSlowTurn(channel: Int) = doAction(channel, revertSlowTurn)
    fun setBrightness(channel: Int, brightness: Int) = doAction(channel, setBrightness, brightness)
    fun runScene(channel: Int) = doAction(channel, runScene)
    fun recordScene(channel: Int) = doAction(channel, recordScene)
    fun unbind(channel: Int) = doAction(channel, unbind)
    fun bind(channel: Int) = doAction(channel, bind)
}

enum class Format(val code: Int) {
    single(1),
    rgb(3)
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