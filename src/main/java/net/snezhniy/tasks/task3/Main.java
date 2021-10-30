/*
 * This Source Code Form is subject to the terms of the Mozilla Public
 * License, v. 2.0. If a copy of the MPL was not distributed with this
 * file, You can obtain one at https://mozilla.org/MPL/2.0/.
 */

package net.snezhniy.tasks.task3;

import net.snezhniy.Utils;
import net.snezhniy.tasks.TaskBase;

import java.io.File;
import java.util.Objects;
import java.util.Scanner;

/*
№3. Ввести с консоли имя каталога (полный путь, по правилам Java). Выдать
список файлов и вложенных каталогов, которые в нем содержатся
*/
public class Main implements TaskBase {
    @Override
    public void run() {
        Scanner scan = Utils.makeScanner();

        System.out.print("Укажите путь до диретории: ");
        String input = scan.nextLine().trim();

        File f = new File(input);
        if (!f.exists()) {
            System.out.println("Ой, кажется вы указали некорректный путь...");
            return;
        }

        if (!f.isDirectory()) {
            System.out.println("Указанный путь ведёт не к директории! Попробуйте снова.");
            return;
        }

        File[] objects = Objects.requireNonNull(f.listFiles());

        System.out.println("Содержимое директории:");
        for (File obj : objects) {
            System.out.println("* " + obj.getAbsolutePath());
        }
    }
}
