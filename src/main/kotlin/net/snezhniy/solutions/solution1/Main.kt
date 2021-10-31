/*
 * This Source Code Form is subject to the terms of the Mozilla Public
 * License, v. 2.0. If a copy of the MPL was not distributed with this
 * file, You can obtain one at https://mozilla.org/MPL/2.0/.
 */

package net.snezhniy.solutions.solution1

import net.snezhniy.solutions.SolutionBase
import java.io.File

/*
№1. Ввести с консоли имя файла (полный путь, по правилам Java). Выдать
информацию об этом файле: существует он, или нет.
*/
class Main : SolutionBase {
    override fun run() {
        print("Укажите путь к файлу: ")
        val input = readLine().orEmpty().trim()

        val msg = if (File(input).exists()) "Этот файл существует, ура!" else "Кажется, такого файла нет..."
        println(msg)
    }
}