/*
 * This Source Code Form is subject to the terms of the Mozilla Public
 * License, v. 2.0. If a copy of the MPL was not distributed with this
 * file, You can obtain one at https://mozilla.org/MPL/2.0/.
 */

package net.snezhniy.tasks.task2;

import net.snezhniy.Utils;
import net.snezhniy.tasks.TaskBase;

import java.io.File;
import java.util.Scanner;

/*
№2. Ввести с консоли имя файла (полный путь, по правилам Java). Выдать
информацию об этом файле: доступен он для чтения или нет, доступен он для
записи или нет.
*/

public class Main implements TaskBase {
    @Override
    public void run() {
        Scanner scan = Utils.makeScanner();

        System.out.print("Укажите путь к файлу: ");
        String input = scan.nextLine().trim();

        File f = new File(input);
        if (!f.exists()) {
            System.out.println("Похоже, что этого файла не существует! :(");
            return;
        }

        if (f.canRead())
            System.out.println("Этот файл возможно прочесть...");
        else
            System.out.println("Этот файл невозможно прочесть...");


        if (f.canWrite())
            System.out.println("Ещё он доступен для записи!");
        else
            System.out.println("Ещё он недоступен для записи.");
    }
}
