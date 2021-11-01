/*
 * This Source Code Form is subject to the terms of the Mozilla Public
 * License, v. 2.0. If a copy of the MPL was not distributed with this
 * file, You can obtain one at https://mozilla.org/MPL/2.0/.
 */

package net.snezhniy.solutions.solution4

import net.snezhniy.solutions.SolutionBase
import java.io.File

/*
4. Ввести с консоли имя файла (полный путь, по правилам Windows). Выдать информацию об этом файле:
существует или нет. Если существует, то определить: доступен он для чтения или нет, доступен он для
записи или нет.
*/
class Main : SolutionBase {
    override fun run() {
        print("Введите путь к файлу: ")
        val input = readLine().orEmpty().trim()

        val f = File(input)

        if (f.exists()) {
            println("Этот файл существует, ура!")
            println(if (f.canRead()) "Его возможно прочесть..." else "Его невозможно прочесть...")
            println(if (f.canWrite()) "Он доступен для записи." else "Он недоступен для записи.")
        } else {
            println("Кажется, такого файла нет...")
        }
    }
}