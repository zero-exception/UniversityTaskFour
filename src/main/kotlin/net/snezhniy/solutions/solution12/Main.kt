/*
 * This Source Code Form is subject to the terms of the Mozilla Public
 * License, v. 2.0. If a copy of the MPL was not distributed with this
 * file, You can obtain one at https://mozilla.org/MPL/2.0/.
 */

package net.snezhniy.solutions.solution12

import net.snezhniy.solutions.SolutionBase
import java.io.File
import kotlin.system.exitProcess

/*
№12. Текстовый файл содержит произвольное количество строк. Каждая строка
– это слова, разделенные пробелами. В файле отсортировать слова в строках по
убыванию, записать результат в файл. Вывести на консоль исходный и
преобразованный файлы.f
*/
class Main : SolutionBase {
    override fun run() {
        print("Укажите путь к текстовому файлу: ")
        val pathname = readLine().orEmpty().trim()

        val f = File(pathname)
        if (!f.exists()) {
            println("Указанный файл не существует!")
            exitProcess(1)
        }

        if (!f.canWrite()) {
            println("Указанный файл невозможно изменить.")
            exitProcess(1)
        }

        var lines = f.readLines()
        println("Исходный файл: $lines")

        lines = lines.map { line ->
            line.split("\\s+".toRegex())
                .sortedDescending()
                .joinToString(" ")
        }

        f.writeText(lines.joinToString("\n"))
        println("Обработанный файл: $lines")
    }
}