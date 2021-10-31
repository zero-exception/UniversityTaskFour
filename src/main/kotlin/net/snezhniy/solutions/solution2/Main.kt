/*
 * This Source Code Form is subject to the terms of the Mozilla Public
 * License, v. 2.0. If a copy of the MPL was not distributed with this
 * file, You can obtain one at https://mozilla.org/MPL/2.0/.
 */

package net.snezhniy.solutions.solution2

import net.snezhniy.solutions.SolutionBase
import java.io.File
import kotlin.system.exitProcess

/*
№2. Ввести с консоли имя файла (полный путь, по правилам Java). Выдать
информацию об этом файле: доступен он для чтения или нет, доступен он для
записи или нет.
*/
class Main : SolutionBase {
    override fun run() {
        print("Укажите путь к файлу: ")
        val input = readLine().orEmpty().trim()

        val file = File(input)
        if (!file.exists()) {
            println("Похоже, что этого файла не существует! :(")
            exitProcess(1)
        }

        if (file.canRead()) {
            println("Этот файл возможно прочесть...")
        } else {
            println("Этот файл невозможно прочесть...")
        }

        if (file.canWrite()) {
            println("Ещё он доступен для записи!")
        } else {
            println("Ещё он недоступен для записи.")
        }
    }
}