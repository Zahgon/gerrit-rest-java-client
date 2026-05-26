// Copyright (C) 2017 The Android Open Source Project
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
package com.google.gerrit.extensions.api.plugins;

import com.google.gerrit.extensions.common.PluginInfo;
import com.google.gerrit.extensions.restapi.NotImplementedException;
import com.google.gerrit.extensions.restapi.RestApiException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.SortedMap;

public interface Plugins {

    ListRequest list() throws RestApiException;

    PluginApi name(String name) throws RestApiException;

    @Deprecated
    PluginApi install(String name, com.google.gerrit.extensions.common.InstallPluginInput input) throws RestApiException;

    PluginApi install(String name, InstallPluginInput input) throws RestApiException;

    abstract class ListRequest {

        private boolean all;

        private int limit;

        private int start;

        private String substring;

        private String prefix;

        private String regex;

        public List<PluginInfo> get() throws RestApiException {
            throw new UnsupportedOperationException("STUB: not implemented");
        }

        public abstract SortedMap<String, PluginInfo> getAsMap() throws RestApiException;

        public ListRequest all() {
            throw new UnsupportedOperationException("STUB: not implemented");
        }

        public boolean getAll() {
            throw new UnsupportedOperationException("STUB: not implemented");
        }

        public ListRequest limit(int limit) {
            throw new UnsupportedOperationException("STUB: not implemented");
        }

        public int getLimit() {
            throw new UnsupportedOperationException("STUB: not implemented");
        }

        public ListRequest start(int start) {
            throw new UnsupportedOperationException("STUB: not implemented");
        }

        public int getStart() {
            throw new UnsupportedOperationException("STUB: not implemented");
        }

        public ListRequest substring(String substring) {
            throw new UnsupportedOperationException("STUB: not implemented");
        }

        public String getSubstring() {
            throw new UnsupportedOperationException("STUB: not implemented");
        }

        public ListRequest prefix(String prefix) {
            throw new UnsupportedOperationException("STUB: not implemented");
        }

        public String getPrefix() {
            throw new UnsupportedOperationException("STUB: not implemented");
        }

        public ListRequest regex(String regex) {
            throw new UnsupportedOperationException("STUB: not implemented");
        }

        public String getRegex() {
            throw new UnsupportedOperationException("STUB: not implemented");
        }
    }

    /**
     * A default implementation which allows source compatibility when adding new methods to the
     * interface.
     */
    class NotImplemented implements Plugins {

        @Override
        public ListRequest list() {
            throw new UnsupportedOperationException("STUB: not implemented");
        }

        @Override
        public PluginApi name(String name) {
            throw new UnsupportedOperationException("STUB: not implemented");
        }

        @Override
        @Deprecated
        public PluginApi install(String name, com.google.gerrit.extensions.common.InstallPluginInput input) throws RestApiException {
            throw new NotImplementedException();
        }

        @Override
        public PluginApi install(String name, InstallPluginInput input) {
            throw new UnsupportedOperationException("STUB: not implemented");
        }
    }
}
