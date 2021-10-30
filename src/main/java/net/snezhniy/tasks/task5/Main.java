/*
 * This Source Code Form is subject to the terms of the Mozilla Public
 * License, v. 2.0. If a copy of the MPL was not distributed with this
 * file, You can obtain one at https://mozilla.org/MPL/2.0/.
 */

package net.snezhniy.tasks.task5;

import net.snezhniy.Utils;
import net.snezhniy.tasks.TaskBase;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.Optional;
import java.util.Scanner;
import java.util.stream.Stream;

/*
№5. Текстовый файл содержит одну строку. Строка – это 5 целых чисел,
разделенные пробелами. Считать строку из файла, сформировать массив целых
чисел из считанных слов строки. Подсчитать сумму чисел и вывести результат
на консоль.
*/

public class Main implements TaskBase {
    @Override
    public void run() {
        Scanner scan = Utils.makeScanner();

        System.out.print("Укажите путь к текстовому файлу с числами: ");
        String input = scan.nextLine().trim();

        File f = new File(input);
        if (!f.exists()) {
            System.out.println("К сожалению, данный файл не найден.");
            System.exit(1);
        }

        try {
            Optional<String> line = Files.lines(Paths.get(f.getAbsolutePath())).findFirst();

            if (!line.isPresent()) {
                System.out.println("В указанном файле нет данных!");
                System.exit(1);
            }

            Stream<Integer> numbers = Arrays.stream(line.get().split("\\s+")).map(Integer::parseInt);
            int sum = numbers.reduce(0, Integer::sum);

            System.out.println("Числа в файле: " + line.get());
            System.out.println("Сумма чисел: " + sum);
        } catch (IOException e) {
            System.out.println("Oops, IOException happened...");
        }
    }
}
