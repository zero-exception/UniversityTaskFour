/*
 * This Source Code Form is subject to the terms of the Mozilla Public
 * License, v. 2.0. If a copy of the MPL was not distributed with this
 * file, You can obtain one at https://mozilla.org/MPL/2.0/.
 */

package net.snezhniy.solutions.solution10

import net.snezhniy.solutions.SolutionBase
import java.io.File
import kotlin.system.exitProcess

/*
№10. Текстовый файл содержит произвольное количество строк. Ввести с
консоли номер строки. Ввести с консоли произвольную текстовую строку.
Заменить в файле строку с указанным номером на введенную с консоли строку.
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

        print("Укажите номер строки, которую хотите изменить: ")
        val lineNumber = readLine().orEmpty().trim().toInt()
        if (lineNumber > lines.size || lineNumber < 1) {
            println("Вы указали некорректный номер строки.")
            exitProcess(1)
        }

        print("Введите строку, на которую хотите изменить оригинальную: ")
        val replacement = readLine().orEmpty()
        lines[lineNumber - 1] = replacement

        f.writeText(lines.joinToString("\n"))
    }
}