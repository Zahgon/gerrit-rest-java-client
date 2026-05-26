// Copyright 2008 Google Inc.
//
// Licensed under the Apache License, Version 2.0 (the "License");
// you may not use this file except in compliance with the License.
// You may obtain a copy of the License at
//
// http://www.apache.org/licenses/LICENSE-2.0
//
// Unless required by applicable law or agreed to in writing, software
// distributed under the License is distributed on an "AS IS" BASIS,
// WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
// See the License for the specific language governing permissions and
// limitations under the License.
package com.google.gwtorm.server;

import java.io.UnsupportedEncodingException;
import java.util.Arrays;

public class StandardKeyEncoder {

    private static final char[] hexc = { '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F' };

    private static final char[] safe;

    private static final byte[] hexb;

    static {
        safe = new char[256];
        safe['-'] = '-';
        safe['_'] = '_';
        safe['.'] = '.';
        safe['!'] = '!';
        safe['~'] = '~';
        safe['*'] = '*';
        safe['\''] = '\'';
        safe['('] = '(';
        safe[')'] = ')';
        safe['/'] = '/';
        safe[' '] = '+';
        for (char c = '0'; c <= '9'; c++) safe[c] = c;
        for (char c = 'A'; c <= 'Z'; c++) safe[c] = c;
        for (char c = 'a'; c <= 'z'; c++) safe[c] = c;
        hexb = new byte['f' + 1];
        Arrays.fill(hexb, (byte) -1);
        for (char i = '0'; i <= '9'; i++) hexb[i] = (byte) (i - '0');
        for (char i = 'A'; i <= 'F'; i++) hexb[i] = (byte) ((i - 'A') + 10);
        for (char i = 'a'; i <= 'f'; i++) hexb[i] = (byte) ((i - 'a') + 10);
    }

    public static String encode(final String e) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public static String decode(final String e) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }
}
