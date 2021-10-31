/*
 * This Source Code Form is subject to the terms of the Mozilla Public
 * License, v. 2.0. If a copy of the MPL was not distributed with this
 * file, You can obtain one at https://mozilla.org/MPL/2.0/.
 */

package net.snezhniy.solutions.solution9

import net.snezhniy.solutions.SolutionBase
import java.io.File
import kotlin.system.exitProcess

/*
№9. Текстовый файл содержит произвольное количество строк. Каждая строка
– это слова, разделенные пробелами. Подсчитать количество символов в
текстовом файле (включая пробелы).
*/
class Main : SolutionBase {
    override fun run() {
        print("Укажите путь к текстовому файлу: ")
        val input = readLine().orEmpty().trim()

        val f = File(input)
        if (!f.exists()) {
            println("Указанный файл не существует!")
            exitProcess(1)
        }

        val count = f.readText().length
        println("Количество символов: $count")
    }
}