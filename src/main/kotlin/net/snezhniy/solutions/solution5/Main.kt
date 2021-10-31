/*
 * This Source Code Form is subject to the terms of the Mozilla Public
 * License, v. 2.0. If a copy of the MPL was not distributed with this
 * file, You can obtain one at https://mozilla.org/MPL/2.0/.
 */

package net.snezhniy.solutions.solution5

import net.snezhniy.solutions.SolutionBase
import java.io.File
import kotlin.system.exitProcess

class Main :SolutionBase {
    override fun run() {
        print("Укажите путь к текстовому файлу с числами: ")
        val input = readLine().orEmpty().trim()

        val f = File(input)
        if (!f.exists()) {
            println("К сожалению, данный файл не найден.")
            exitProcess(1)
        }

        if (!f.isFile) {
            println("Вы указали путь не к файлу, попробуйте ещё раз.")
            exitProcess(1)
        }

        val line = try {
            f.readLines().first()
        } catch (e: NoSuchElementException) {
            println("Указанный текстовый файл пуст!")
            exitProcess(1)
        }

        val numbers = line.split("\\s+".toRegex()).map { it.toInt() }
        val sum = numbers.sum()

        println("Числа в файле: $numbers")
        println("Сумма чисел: $sum")
    }
}