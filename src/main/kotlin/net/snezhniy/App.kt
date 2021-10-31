/*
 * This Source Code Form is subject to the terms of the Mozilla Public
 * License, v. 2.0. If a copy of the MPL was not distributed with this
 * file, You can obtain one at https://mozilla.org/MPL/2.0/.
 */

package net.snezhniy

import kotlin.reflect.full.createInstance
import kotlin.reflect.full.declaredFunctions
import kotlin.system.exitProcess

fun main(args: Array<String>) {
    val arg = if (args.isNotEmpty()) args[0] else "1"
    val solutionClassPath = "net.snezhniy.solutions.solution$arg.Main"

    val cls = try {
        Class.forName(solutionClassPath).kotlin
    } catch (e: ClassNotFoundException) {
        println("Вы указали номер задания, решение которого не найдено. Попробуйте снова.")
        exitProcess(1)
    }
    val obj = cls.createInstance()
    val method = cls.declaredFunctions.find { it.name == "run" }!!
    method.call(obj)
}