// Copyright (C) 2014 The Android Open Source Project
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

import java.sql.Timestamp;
import java.util.Comparator;
import java.util.Objects;

public abstract class Comment {

    /**
     * Patch set number containing this commit.
     *
     * <p>Only set in contexts where comments may come from multiple patch sets.
     */
    public Integer patchSet;

    public String id;

    public String path;

    public Side side;

    public Integer parent;

    /**
     * Value 0 or null indicates a file comment, normal lines start at 1.
     */
    public Integer line;

    public Range range;

    public String inReplyTo;

    public Timestamp updated;

    public String message;

    public Boolean unresolved;

    /**
     * Hex commit SHA1 (as 40 characters hex string) of the commit of the patchset to which this
     * comment applies.
     */
    public String commitId;

    public static class Range implements Comparable<Range> {

        private static final Comparator<Range> RANGE_COMPARATOR = Comparator.<Range>comparingInt(range -> range.startLine).thenComparingInt(range -> range.startCharacter).thenComparingInt(range -> range.endLine).thenComparingInt(range -> range.endCharacter);

        // Start position is inclusive; end position is exclusive.
        // 1-based
        public int startLine;

        // 0-based
        public int startCharacter;

        // 1-based
        public int endLine;

        // 0-based
        public int endCharacter;

        public boolean isValid() {
            throw new UnsupportedOperationException("STUB: not implemented");
        }

        @Override
        public boolean equals(Object o) {
            throw new UnsupportedOperationException("STUB: not implemented");
        }

        @Override
        public int hashCode() {
            throw new UnsupportedOperationException("STUB: not implemented");
        }

        @Override
        public String toString() {
            throw new UnsupportedOperationException("STUB: not implemented");
        }

        @Override
        public int compareTo(Range otherRange) {
            throw new UnsupportedOperationException("STUB: not implemented");
        }
    }

    public short side() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public boolean equals(Object o) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public int hashCode() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }
}
