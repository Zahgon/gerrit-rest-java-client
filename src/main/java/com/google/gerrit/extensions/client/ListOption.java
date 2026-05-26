// Copyright (C) 2019 The Android Open Source Project
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
package com.google.gerrit.extensions.client;

import java.lang.reflect.InvocationTargetException;
import java.util.EnumSet;
import java.util.Set;

/**
 * Enum that can be expressed as a bitset in query parameters.
 */
public interface ListOption {

    int getValue();

    static <T extends Enum<T> & ListOption> EnumSet<T> fromBits(Class<T> clazz, int v) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    static <T extends Enum<T> & ListOption> String toHex(Set<T> options) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }
}
