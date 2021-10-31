/*
 * This Source Code Form is subject to the terms of the Mozilla Public
 * License, v. 2.0. If a copy of the MPL was not distributed with this
 * file, You can obtain one at https://mozilla.org/MPL/2.0/.
 */

package net.snezhniy.solutions.solution11

import net.snezhniy.solutions.SolutionBase
import java.io.File
import kotlin.system.exitProcess

/*
№11. Текстовый файл содержит произвольное количество строк. Каждая строка
– это слова, разделенные пробелами. Ввести номер строки. В указанной строке
отсортировать слова по возрастанию, записать результат в файл. Вывести на
консоль исходный и преобразованный файлы.
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

        val lines = f.readLines().toCollection(ArrayList())

        print("Укажите номер строки, которую хотите отсортировать: ")
        val lineNumber = readLine().orEmpty().trim().toInt()
        if (lineNumber > lines.size || lineNumber < 1) {
            println("Вы указали некорректный номер строки.")
            exitProcess(1)
        }

        val sortedLine = lines[lineNumber - 1].split("\\s+".toRegex()).sorted().joinToString(" ")
        lines[lineNumber - 1] = sortedLine

        f.writeText(lines.joinToString("\n"))
    }
}