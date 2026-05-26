// Copyright (C) 2013 The Android Open Source Project
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
package com.google.gerrit.extensions.restapi;

/**
 * Resource identifier split out from a URL.
 *
 * <p>Identifiers are URL encoded and usually need to be decoded.
 */
public class IdString {

    /**
     * Construct an identifier from an already encoded string.
     */
    public static IdString fromUrl(String id) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * Construct an identifier from an already decoded string.
     */
    public static IdString fromDecoded(String id) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    private final String urlEncoded;

    private IdString(String s) {
        urlEncoded = s;
    }

    /**
     * @return the decoded value of the string.
     */
    public String get() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * @return true if the string is the empty string.
     */
    public boolean isEmpty() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * @return the original URL encoding supplied by the client.
     */
    public String encoded() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public int hashCode() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public boolean equals(Object other) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public String toString() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }
}
