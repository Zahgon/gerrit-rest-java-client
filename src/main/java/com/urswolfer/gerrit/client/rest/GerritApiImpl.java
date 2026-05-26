/*
 * Copyright 2013-2021 Urs Wolfer
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
package com.urswolfer.gerrit.client.rest;

import com.google.common.base.Suppliers;
import com.google.gerrit.extensions.api.GerritApi;
import com.google.gerrit.extensions.api.changes.Changes;
import com.google.gerrit.extensions.api.config.Config;
import com.google.gerrit.extensions.api.groups.Groups;
import com.google.gerrit.extensions.api.projects.Projects;
import com.urswolfer.gerrit.client.rest.accounts.Accounts;
import com.urswolfer.gerrit.client.rest.http.GerritRestClient;
import com.urswolfer.gerrit.client.rest.http.HttpClientBuilderExtension;
import com.urswolfer.gerrit.client.rest.http.HttpRequestExecutor;
import com.urswolfer.gerrit.client.rest.http.accounts.AccountsParser;
import com.urswolfer.gerrit.client.rest.http.accounts.AccountsRestClient;
import com.urswolfer.gerrit.client.rest.http.accounts.SshKeysParser;
import com.urswolfer.gerrit.client.rest.http.changes.*;
import com.urswolfer.gerrit.client.rest.http.changes.parsers.*;
import com.urswolfer.gerrit.client.rest.http.config.ConfigRestClient;
import com.urswolfer.gerrit.client.rest.http.config.parsers.ServerConfigParser;
import com.urswolfer.gerrit.client.rest.http.groups.GroupsParser;
import com.urswolfer.gerrit.client.rest.http.groups.GroupsRestClient;
import com.urswolfer.gerrit.client.rest.http.projects.BranchInfoParser;
import com.urswolfer.gerrit.client.rest.http.projects.ProjectsParser;
import com.urswolfer.gerrit.client.rest.http.projects.ProjectsRestClient;
import com.urswolfer.gerrit.client.rest.http.projects.TagInfoParser;
import com.urswolfer.gerrit.client.rest.http.projects.parsers.ProjectCommitInfoParser;
import com.urswolfer.gerrit.client.rest.http.tools.ToolsRestClient;
import com.urswolfer.gerrit.client.rest.tools.Tools;
import java.util.function.Supplier;

/**
 * @author Urs Wolfer
 */
public class GerritApiImpl extends GerritApi.NotImplemented implements GerritRestApi {

    private final GerritRestClient gerritRestClient;

    private final Supplier<GroupsRestClient> groupsRestClient = Suppliers.memoize(new com.google.common.base.Supplier<GroupsRestClient>() {

        @Override
        public GroupsRestClient get() {
            throw new UnsupportedOperationException("STUB: not implemented");
        }
    });

    private final Supplier<AccountsRestClient> accountsRestClient = Suppliers.memoize(new com.google.common.base.Supplier<AccountsRestClient>() {

        @Override
        public AccountsRestClient get() {
            throw new UnsupportedOperationException("STUB: not implemented");
        }
    });

    private final Supplier<ChangesRestClient> changesRestClient = Suppliers.memoize(new com.google.common.base.Supplier<ChangesRestClient>() {

        @Override
        public ChangesRestClient get() {
            throw new UnsupportedOperationException("STUB: not implemented");
        }
    });

    private final Supplier<ConfigRestClient> configRestClient = Suppliers.memoize(new com.google.common.base.Supplier<ConfigRestClient>() {

        @Override
        public ConfigRestClient get() {
            throw new UnsupportedOperationException("STUB: not implemented");
        }
    });

    private final Supplier<ProjectsRestClient> projectsRestClient = Suppliers.memoize(new com.google.common.base.Supplier<ProjectsRestClient>() {

        @Override
        public ProjectsRestClient get() {
            throw new UnsupportedOperationException("STUB: not implemented");
        }
    });

    private final Supplier<ToolsRestClient> toolsRestClient = Suppliers.memoize(new com.google.common.base.Supplier<ToolsRestClient>() {

        @Override
        public ToolsRestClient get() {
            throw new UnsupportedOperationException("STUB: not implemented");
        }
    });

    public GerritApiImpl(GerritAuthData authData, HttpRequestExecutor httpRequestExecutor, HttpClientBuilderExtension... httpClientBuilderExtensions) {
        this.gerritRestClient = new GerritRestClient(authData, httpRequestExecutor, httpClientBuilderExtensions);
    }

    @Override
    public Accounts accounts() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public Changes changes() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public Config config() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public Groups groups() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public Projects projects() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public Tools tools() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public RestClient restClient() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }
}
