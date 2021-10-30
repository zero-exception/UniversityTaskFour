/*
 * This Source Code Form is subject to the terms of the Mozilla Public
 * License, v. 2.0. If a copy of the MPL was not distributed with this
 * file, You can obtain one at https://mozilla.org/MPL/2.0/.
 */

package net.snezhniy.tasks.task4;

import net.snezhniy.Utils;
import net.snezhniy.tasks.TaskBase;

import java.io.File;
import java.util.Scanner;

/*
№4. Ввести с консоли имя файла (полный путь, по правилам Windows). Выдать
информацию об этом файле: существует или нет. Если существует, то
определить: доступен он для чтения или нет, доступен он для записи или нет.
*/

public class Main implements TaskBase {
    @Override
    public void run() {
        Scanner scan = Utils.makeScanner();

        System.out.print("Укажите путь до файла: ");
        String input = scan.nextLine().trim();

        File f = new File(input);
        if (!f.exists()) {
            System.out.println("Очень жаль, но указанный файл не существует...");
            return;
        }

        System.out.println("Файл обнаружен, немного информации о нём: ");
        System.out.println("* Доступен для чтения: " + (f.canRead() ? "да" : "нет"));
        System.out.println("* Доступен для записи: " + (f.canWrite() ? "да" : "нет"));
    }
}
