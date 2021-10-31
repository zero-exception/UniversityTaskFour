/*
 * This Source Code Form is subject to the terms of the Mozilla Public
 * License, v. 2.0. If a copy of the MPL was not distributed with this
 * file, You can obtain one at https://mozilla.org/MPL/2.0/.
 */

package net.snezhniy.tasks.task6

import net.snezhniy.tasks.SolutionBase
import java.io.File
import kotlin.system.exitProcess

/*
№6. Текстовый файл содержит 3 строки. Каждая строка – это 5 вещественных
чисел (с дробной частью), разделенные пробелами. Считать строки из файла,
сформировать матрицу вещественных чисел, вывести сформированную
матрицу на консоль.
*/

class Main : SolutionBase {
    override fun run() {
        print("Введите путь до текстового файла: ")
        val input = readLine().orEmpty().trim()

        val file = File(input)
        if (!file.exists()) {
            println("Ой-ой, кажется вы указали некорректный путь...")
            exitProcess(1)
        }

        val matrix = arrayListOf<ArrayList<Double?>>()
        File(input).forEachLine { line ->
            val numbers = line
                .split("\\s+".toRegex())
                .map { el -> el.toDoubleOrNull() }
                .toCollection(ArrayList())

            matrix.add(numbers)
        }

        println(matrix.joinToString(",\n"))
    }
}