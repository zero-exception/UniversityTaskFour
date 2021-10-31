/*
 * This Source Code Form is subject to the terms of the Mozilla Public
 * License, v. 2.0. If a copy of the MPL was not distributed with this
 * file, You can obtain one at https://mozilla.org/MPL/2.0/.
 */

package net.snezhniy.solutions.solution4

import net.snezhniy.solutions.SolutionBase
import java.io.File

class Main : SolutionBase {
    override fun run() {
        print("Введите путь к файлу: ")
        val input = readLine().orEmpty().trim()

        val f = File(input)

        val msg = if (f.exists()) "Этот файл существует, ура!" else "Кажется, такого файла нет..."
        println(msg)
    }
}