/*
 * This Source Code Form is subject to the terms of the Mozilla Public
 * License, v. 2.0. If a copy of the MPL was not distributed with this
 * file, You can obtain one at https://mozilla.org/MPL/2.0/.
 */

package net.snezhniy.solutions.solution3

import net.snezhniy.solutions.SolutionBase
import java.io.File
import java.util.*
import kotlin.system.exitProcess

class Main : SolutionBase {
    override fun run() {
        print("Укажите путь до диретории: ")
        val input = readLine().orEmpty().trim()

        val f = File(input)
        if (!f.exists()) {
            println("Ой, кажется вы указали некорректный путь...")
            exitProcess(1)
        }

        if (!f.isDirectory) {
            println("Указанный путь ведёт не к директории! Попробуйте снова.")
            exitProcess(1)
        }

        val objects = Objects.requireNonNull(f.listFiles())

        println("Содержимое директории:")
        for (obj in objects) {
            println("* " + obj.absolutePath)
        }
    }
}