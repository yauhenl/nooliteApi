package com.yauhenl.nooliteApi

fun main(args: Array<String>) {
    val host = args[0]
    val channel:Int = args[1].toInt()
    val command = Command.valueOf(args[2])
    NooliteApi(host).doAction(channel, command)
}