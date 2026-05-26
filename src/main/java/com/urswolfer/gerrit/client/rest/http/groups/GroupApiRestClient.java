/*
 * Copyright 2013-2016 Urs Wolfer
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.urswolfer.gerrit.client.rest.http.groups;

import com.google.gerrit.extensions.api.groups.GroupApi;
import com.google.gerrit.extensions.common.AccountInfo;
import com.google.gerrit.extensions.common.GroupInfo;
import com.google.gerrit.extensions.restapi.RestApiException;
import com.google.gerrit.extensions.restapi.Url;
import com.google.gson.JsonElement;
import com.urswolfer.gerrit.client.rest.http.GerritRestClient;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Map;

/**
 * @author Shawn Stafford
 */
public class GroupApiRestClient extends GroupApi.NotImplemented implements GroupApi {

    /**
     * Base REST URL for managing Group data
     */
    private static final String BASE_URL = "/groups";

    private final GroupsParser groupsParser;

    private final GerritRestClient gerritRestClient;

    private final String groupId;

    public GroupApiRestClient(GerritRestClient gerritRestClient, GroupsParser groupsParser, String id) {
        this.gerritRestClient = gerritRestClient;
        this.groupsParser = groupsParser;
        this.groupId = id;
    }

    public static String getBaseRequestPath() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public static String getRequestPath(String id) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    protected String getRequestPath() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public GroupInfo get() throws RestApiException {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public GroupInfo detail() throws RestApiException {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public String name() throws RestApiException {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public void name(String name) throws RestApiException {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public GroupInfo owner() throws RestApiException {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public void owner(String owner) throws RestApiException {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public String description() throws RestApiException {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public void description(String description) throws RestApiException {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public List<AccountInfo> members() throws RestApiException {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public List<AccountInfo> members(boolean recursive) throws RestApiException {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public void addMembers(String... members) throws RestApiException {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public List<GroupInfo> includedGroups() throws RestApiException {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public void addGroups(String... groups) throws RestApiException {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public void removeGroups(String... groups) throws RestApiException {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public void removeMembers(String... members) throws RestApiException {
        throw new UnsupportedOperationException("STUB: not implemented");
    }
}
