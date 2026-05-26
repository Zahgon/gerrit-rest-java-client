// Copyright (C) 2015 The Android Open Source Project
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
package com.google.gerrit.extensions.api.groups;

import com.google.gerrit.extensions.client.ListGroupsOption;
import com.google.gerrit.extensions.common.GroupInfo;
import com.google.gerrit.extensions.restapi.NotImplementedException;
import com.google.gerrit.extensions.restapi.RestApiException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.EnumSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public interface Groups {

    /**
     * Look up a group by ID.
     *
     * <p><strong>Note:</strong> This method eagerly reads the group. Methods that mutate the group do
     * not necessarily re-read the group. Therefore, calling a getter method on an instance after
     * calling a mutation method on that same instance is not guaranteed to reflect the mutation. It
     * is not recommended to store references to {@code groupApi} instances.
     *
     * @param id any identifier supported by the REST API, including group name or UUID.
     * @return API for accessing the group.
     * @throws RestApiException if an error occurred.
     */
    GroupApi id(String id) throws RestApiException;

    /**
     * Create a new group with the given name and default options.
     */
    GroupApi create(String name) throws RestApiException;

    /**
     * Create a new group.
     */
    GroupApi create(GroupInput input) throws RestApiException;

    /**
     * @return new request for listing groups.
     */
    ListRequest list();

    /**
     * Query groups.
     *
     * <p>Example code: {@code query().withQuery("inname:test").withLimit(10).get()}
     *
     * @return API for setting parameters and getting result.
     */
    QueryRequest query();

    /**
     * Query groups.
     *
     * <p>Shortcut API for {@code query().withQuery(String)}.
     *
     * @see #query()
     */
    QueryRequest query(String query);

    abstract class ListRequest {

        private final EnumSet<ListGroupsOption> options = EnumSet.noneOf(ListGroupsOption.class);

        private final List<String> projects = new ArrayList<>();

        private final List<String> groups = new ArrayList<>();

        private boolean visibleToAll;

        private String user;

        private boolean owned;

        private int limit;

        private int start;

        private String substring;

        private String suggest;

        private String regex;

        private String ownedBy;

        public List<GroupInfo> get() throws RestApiException {
            throw new UnsupportedOperationException("STUB: not implemented");
        }

        public abstract Map<String, GroupInfo> getAsMap() throws RestApiException;

        public ListRequest addOption(ListGroupsOption option) {
            throw new UnsupportedOperationException("STUB: not implemented");
        }

        public ListRequest addOptions(ListGroupsOption... options) {
            throw new UnsupportedOperationException("STUB: not implemented");
        }

        public ListRequest addOptions(Iterable<ListGroupsOption> options) {
            throw new UnsupportedOperationException("STUB: not implemented");
        }

        public ListRequest withProject(String project) {
            throw new UnsupportedOperationException("STUB: not implemented");
        }

        public ListRequest addGroup(String uuid) {
            throw new UnsupportedOperationException("STUB: not implemented");
        }

        public ListRequest withVisibleToAll(boolean visible) {
            throw new UnsupportedOperationException("STUB: not implemented");
        }

        public ListRequest withUser(String user) {
            throw new UnsupportedOperationException("STUB: not implemented");
        }

        public ListRequest withOwned(boolean owned) {
            throw new UnsupportedOperationException("STUB: not implemented");
        }

        public ListRequest withLimit(int limit) {
            throw new UnsupportedOperationException("STUB: not implemented");
        }

        public ListRequest withStart(int start) {
            throw new UnsupportedOperationException("STUB: not implemented");
        }

        public ListRequest withSubstring(String substring) {
            throw new UnsupportedOperationException("STUB: not implemented");
        }

        public ListRequest withRegex(String regex) {
            throw new UnsupportedOperationException("STUB: not implemented");
        }

        public ListRequest withSuggest(String suggest) {
            throw new UnsupportedOperationException("STUB: not implemented");
        }

        public ListRequest withOwnedBy(String ownedBy) {
            throw new UnsupportedOperationException("STUB: not implemented");
        }

        public Set<ListGroupsOption> getOptions() {
            throw new UnsupportedOperationException("STUB: not implemented");
        }

        public List<String> getProjects() {
            throw new UnsupportedOperationException("STUB: not implemented");
        }

        public List<String> getGroups() {
            throw new UnsupportedOperationException("STUB: not implemented");
        }

        public boolean getVisibleToAll() {
            throw new UnsupportedOperationException("STUB: not implemented");
        }

        public String getUser() {
            throw new UnsupportedOperationException("STUB: not implemented");
        }

        public boolean getOwned() {
            throw new UnsupportedOperationException("STUB: not implemented");
        }

        public int getLimit() {
            throw new UnsupportedOperationException("STUB: not implemented");
        }

        public int getStart() {
            throw new UnsupportedOperationException("STUB: not implemented");
        }

        public String getSubstring() {
            throw new UnsupportedOperationException("STUB: not implemented");
        }

        public String getRegex() {
            throw new UnsupportedOperationException("STUB: not implemented");
        }

        public String getSuggest() {
            throw new UnsupportedOperationException("STUB: not implemented");
        }

        public String getOwnedBy() {
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

        private Set<ListGroupsOption> options = EnumSet.noneOf(ListGroupsOption.class);

        /**
         * Execute query and returns the matched groups as list.
         */
        public abstract List<GroupInfo> get() throws RestApiException;

        /**
         * Set query.
         *
         * @param query needs to be in human-readable form.
         */
        public QueryRequest withQuery(String query) {
            throw new UnsupportedOperationException("STUB: not implemented");
        }

        /**
         * Set limit for returned list of groups. Optional; server-default is used when not provided.
         */
        public QueryRequest withLimit(int limit) {
            throw new UnsupportedOperationException("STUB: not implemented");
        }

        /**
         * Set number of groups to skip. Optional; no groups are skipped when not provided.
         */
        public QueryRequest withStart(int start) {
            throw new UnsupportedOperationException("STUB: not implemented");
        }

        /**
         * Set an option on the request, appending to existing options.
         */
        public QueryRequest withOption(ListGroupsOption options) {
            throw new UnsupportedOperationException("STUB: not implemented");
        }

        /**
         * Set options on the request, appending to existing options.
         */
        public QueryRequest withOptions(ListGroupsOption... options) {
            throw new UnsupportedOperationException("STUB: not implemented");
        }

        /**
         * Set options on the request, replacing existing options.
         */
        public QueryRequest withOptions(Set<ListGroupsOption> options) {
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

        public Set<ListGroupsOption> getOptions() {
            throw new UnsupportedOperationException("STUB: not implemented");
        }
    }

    /**
     * A default implementation which allows source compatibility when adding new methods to the
     * interface.
     */
    class NotImplemented implements Groups {

        @Override
        public GroupApi id(String id) throws RestApiException {
            throw new UnsupportedOperationException("STUB: not implemented");
        }

        @Override
        public GroupApi create(String name) throws RestApiException {
            throw new UnsupportedOperationException("STUB: not implemented");
        }

        @Override
        public GroupApi create(GroupInput input) throws RestApiException {
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
