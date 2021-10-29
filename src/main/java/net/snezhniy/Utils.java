/*
 * This Source Code Form is subject to the terms of the Mozilla Public
 * License, v. 2.0. If a copy of the MPL was not distributed with this
 * file, You can obtain one at https://mozilla.org/MPL/2.0/.
 */

package net.snezhniy;

import java.io.Reader;
import java.util.Scanner;

public class Utils {
    public static Scanner makeScanner() {
        Reader reader = System.console().reader();
        return new Scanner(reader);
    }
}
