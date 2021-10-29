/*
 * This Source Code Form is subject to the terms of the Mozilla Public
 * License, v. 2.0. If a copy of the MPL was not distributed with this
 * file, You can obtain one at https://mozilla.org/MPL/2.0/.
 */

package net.snezhniy.tasks.task1;

import net.snezhniy.Utils;
import net.snezhniy.tasks.TaskBase;

import java.io.File;
import java.util.Scanner;

/*
№1. Ввести с консоли имя файла (полный путь, по правилам Java). Выдать
информацию об этом файле: существует он, или нет.
*/
public class Main implements TaskBase {
    @Override
    public void run() {
        Scanner scan = Utils.makeScanner();

        System.out.print("Введите путь к файлу: ");
        String input = scan.nextLine().trim();

        File f = new File(input);

        String msg = f.exists() ? "Этот файл существует, ура!" : "Кажется, такого файла нет...";
        System.out.println(msg);
    }
}
