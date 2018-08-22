package com.yauhenl.nooliteApi

fun main(args: Array<String>) {
    val host = args[0]
    val channel:Int = args[1].toInt()
    val command = Command.valueOf(args[2])
    if (command.code == 6) {
        val br = args[3]
        val format = Format.valueOf(args[4])
        val d0 = args[5].toInt()
        if (format == Format.rgb) {
            val d1 = args[6].toInt()
            val d2 = args[7].toInt()
            val d3 = args[8].toInt()
        }
    }
    NooliteApi(host).doAction(channel, command)
}