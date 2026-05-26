/*
 * Copyright 2013-2015 Urs Wolfer
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
package com.urswolfer.gerrit.client.rest.http.config;

import com.google.gerrit.extensions.api.config.ConsistencyCheckInfo;
import com.google.gerrit.extensions.api.config.ConsistencyCheckInput;
import com.google.gerrit.extensions.api.config.Server;
import com.google.gerrit.extensions.client.DiffPreferencesInfo;
import com.google.gerrit.extensions.client.EditPreferencesInfo;
import com.google.gerrit.extensions.client.GeneralPreferencesInfo;
import com.google.gerrit.extensions.common.ServerInfo;
import com.google.gerrit.extensions.restapi.RestApiException;
import com.google.gson.JsonElement;
import com.urswolfer.gerrit.client.rest.http.GerritRestClient;
import com.urswolfer.gerrit.client.rest.http.HttpStatusException;
import com.urswolfer.gerrit.client.rest.http.config.parsers.ServerConfigParser;
import java.util.concurrent.atomic.AtomicReference;
import static org.apache.http.HttpStatus.SC_NOT_FOUND;

/**
 * @author Urs Wolfer
 */
public class ServerRestClient extends Server.NotImplemented implements Server {

    private final GerritRestClient gerritRestClient;

    private final AtomicReference<String> version = new AtomicReference<>();

    private final ServerConfigParser serverConfigParser;

    public ServerRestClient(GerritRestClient gerritRestClient, ServerConfigParser serverConfigParser) {
        this.gerritRestClient = gerritRestClient;
        this.serverConfigParser = serverConfigParser;
    }

    @Override
    public String getVersion() throws RestApiException {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public ServerInfo getInfo() throws RestApiException {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public GeneralPreferencesInfo setDefaultPreferences(GeneralPreferencesInfo input) throws RestApiException {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public GeneralPreferencesInfo getDefaultPreferences() throws RestApiException {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public DiffPreferencesInfo setDefaultDiffPreferences(DiffPreferencesInfo input) throws RestApiException {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public DiffPreferencesInfo getDefaultDiffPreferences() throws RestApiException {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public EditPreferencesInfo setDefaultEditPreferences(EditPreferencesInfo input) throws RestApiException {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public EditPreferencesInfo getDefaultEditPreferences() throws RestApiException {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public ConsistencyCheckInfo checkConsistency(ConsistencyCheckInput input) throws RestApiException {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public String getVersionCached() throws RestApiException {
        throw new UnsupportedOperationException("STUB: not implemented");
    }
}
