/*
 * This Source Code Form is subject to the terms of the Mozilla Public
 * License, v. 2.0. If a copy of the MPL was not distributed with this
 * file, You can obtain one at https://mozilla.org/MPL/2.0/.
 */

package net.snezhniy;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class App {
    public static void main(String[] args) throws NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
        String selectedSolution = (args.length >= 1) ? args[0] : "1";
        String classPath = "net.snezhniy.tasks.task" + selectedSolution + ".Main";

        Class<?> cls;
        try {
            cls = Class.forName(classPath);
        } catch (ClassNotFoundException e) {
            System.out.printf("Вы указали некорректный номер задания, класс %s не найден.\n", classPath);
            return;
        }

        Object obj = cls.getDeclaredConstructor().newInstance();
        Method run = cls.getDeclaredMethod("run");
        run.invoke(obj);
    }
}
