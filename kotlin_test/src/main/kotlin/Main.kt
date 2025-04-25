package me.npanuhin.cu.kyrgyz_keyboard

import org.apertium.lttoolbox.LTProc

import java.io.StringReader

fun main() {
    val binaryKirData = "src/main/resources/kir.automorf.bin"
    val input = StringReader("боюнча\n")
    val output = StringBuilder()

    LTProc.doMain(arrayOf(binaryKirData), input, output)

    println(output)
}
