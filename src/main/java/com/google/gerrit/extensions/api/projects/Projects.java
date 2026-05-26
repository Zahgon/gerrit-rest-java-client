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
package com.google.gerrit.extensions.api.projects;

import com.google.gerrit.extensions.client.ProjectState;
import com.google.gerrit.extensions.common.ProjectInfo;
import com.google.gerrit.extensions.restapi.NotImplementedException;
import com.google.gerrit.extensions.restapi.RestApiException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.SortedMap;

public interface Projects {

    /**
     * Look up a project by name.
     *
     * <p><strong>Note:</strong> This method eagerly reads the project. Methods that mutate the
     * project do not necessarily re-read the project. Therefore, calling a getter method on an
     * instance after calling a mutation method on that same instance is not guaranteed to reflect the
     * mutation. It is not recommended to store references to {@code ProjectApi} instances.
     *
     * @param name project name.
     * @return API for accessing the project.
     * @throws RestApiException if an error occurred.
     */
    ProjectApi name(String name) throws RestApiException;

    /**
     * Create a project using the default configuration.
     *
     * @param name project name.
     * @return API for accessing the newly-created project.
     * @throws RestApiException if an error occurred.
     */
    ProjectApi create(String name) throws RestApiException;

    /**
     * Create a project.
     *
     * @param in project creation input; name must be set.
     * @return API for accessing the newly-created project.
     * @throws RestApiException if an error occurred.
     */
    ProjectApi create(ProjectInput in) throws RestApiException;

    ListRequest list();

    /**
     * Query projects.
     *
     * <p>Example code: {@code query().withQuery("name:project").get()}
     *
     * @return API for setting parameters and getting result.
     */
    QueryRequest query();

    /**
     * Query projects.
     *
     * <p>Shortcut API for {@code query().withQuery(String)}.
     *
     * @see #query()
     */
    QueryRequest query(String query);

    abstract class ListRequest {

        public enum FilterType {

            CODE, PERMISSIONS, ALL
        }

        private final List<String> branches = new ArrayList<>();

        private boolean description;

        private String prefix;

        private String substring;

        private String regex;

        private int limit;

        private int start;

        private boolean showTree;

        private boolean all;

        private FilterType type = FilterType.ALL;

        private ProjectState state = null;

        public List<ProjectInfo> get() throws RestApiException {
            throw new UnsupportedOperationException("STUB: not implemented");
        }

        public abstract SortedMap<String, ProjectInfo> getAsMap() throws RestApiException;

        public ListRequest withDescription(boolean description) {
            throw new UnsupportedOperationException("STUB: not implemented");
        }

        public ListRequest withPrefix(String prefix) {
            throw new UnsupportedOperationException("STUB: not implemented");
        }

        public ListRequest withSubstring(String substring) {
            throw new UnsupportedOperationException("STUB: not implemented");
        }

        public ListRequest withRegex(String regex) {
            throw new UnsupportedOperationException("STUB: not implemented");
        }

        public ListRequest withLimit(int limit) {
            throw new UnsupportedOperationException("STUB: not implemented");
        }

        public ListRequest withStart(int start) {
            throw new UnsupportedOperationException("STUB: not implemented");
        }

        public ListRequest addShowBranch(String branch) {
            throw new UnsupportedOperationException("STUB: not implemented");
        }

        public ListRequest withTree(boolean show) {
            throw new UnsupportedOperationException("STUB: not implemented");
        }

        public ListRequest withType(FilterType type) {
            throw new UnsupportedOperationException("STUB: not implemented");
        }

        public ListRequest withAll(boolean all) {
            throw new UnsupportedOperationException("STUB: not implemented");
        }

        public ListRequest withState(ProjectState state) {
            throw new UnsupportedOperationException("STUB: not implemented");
        }

        public boolean getDescription() {
            throw new UnsupportedOperationException("STUB: not implemented");
        }

        public String getPrefix() {
            throw new UnsupportedOperationException("STUB: not implemented");
        }

        public String getSubstring() {
            throw new UnsupportedOperationException("STUB: not implemented");
        }

        public String getRegex() {
            throw new UnsupportedOperationException("STUB: not implemented");
        }

        public int getLimit() {
            throw new UnsupportedOperationException("STUB: not implemented");
        }

        public int getStart() {
            throw new UnsupportedOperationException("STUB: not implemented");
        }

        public List<String> getBranches() {
            throw new UnsupportedOperationException("STUB: not implemented");
        }

        public boolean getShowTree() {
            throw new UnsupportedOperationException("STUB: not implemented");
        }

        public FilterType getFilterType() {
            throw new UnsupportedOperationException("STUB: not implemented");
        }

        public boolean isAll() {
            throw new UnsupportedOperationException("STUB: not implemented");
        }

        public ProjectState getState() {
            throw new UnsupportedOperationException("STUB: not implemented");
        }
    }

    /**
     * API for setting parameters and getting result. Used for {@code query()}.
     *
     * @see #query()
     */
    abstract class QueryRequest {

        private String query;

        private int limit;

        private int start;

        /**
         * Execute query and returns the matched projects as list.
         */
        public abstract List<ProjectInfo> get() throws RestApiException;

        /**
         * Set query.
         *
         * @param query needs to be in human-readable form.
         */
        public QueryRequest withQuery(String query) {
            throw new UnsupportedOperationException("STUB: not implemented");
        }

        /**
         * Set limit for returned list of projects. Optional; server-default is used when not provided.
         */
        public QueryRequest withLimit(int limit) {
            throw new UnsupportedOperationException("STUB: not implemented");
        }

        /**
         * Set number of projects to skip. Optional; no projects are skipped when not provided.
         */
        public QueryRequest withStart(int start) {
            throw new UnsupportedOperationException("STUB: not implemented");
        }

        public String getQuery() {
            throw new UnsupportedOperationException("STUB: not implemented");
        }

        public int getLimit() {
            throw new UnsupportedOperationException("STUB: not implemented");
        }

        public int getStart() {
            throw new UnsupportedOperationException("STUB: not implemented");
        }
    }

    /**
     * A default implementation which allows source compatibility when adding new methods to the
     * interface.
     */
    class NotImplemented implements Projects {

        @Override
        public ProjectApi name(String name) throws RestApiException {
            throw new UnsupportedOperationException("STUB: not implemented");
        }

        @Override
        public ProjectApi create(ProjectInput in) throws RestApiException {
            throw new UnsupportedOperationException("STUB: not implemented");
        }

        @Override
        public ProjectApi create(String name) throws RestApiException {
            throw new UnsupportedOperationException("STUB: not implemented");
        }

        @Override
        public ListRequest list() {
            throw new UnsupportedOperationException("STUB: not implemented");
        }

        @Override
        public QueryRequest query() {
            throw new UnsupportedOperationException("STUB: not implemented");
        }

        @Override
        public QueryRequest query(String query) {
            throw new UnsupportedOperationException("STUB: not implemented");
        }
    }
}
