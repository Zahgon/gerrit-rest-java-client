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
package com.urswolfer.gerrit.client.rest.http;

import com.google.common.base.Optional;
import com.urswolfer.gerrit.client.rest.GerritAuthData;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.impl.client.BasicCookieStore;
import org.apache.http.protocol.HttpContext;
import org.apache.http.protocol.HttpCoreContext;

/**
 * @author Urs Wolfer
 */
public class LoginCache {

    private final BasicCookieStore cookieStore;

    private final GerritAuthData authData;

    private boolean githubOAuthDetected;

    private Optional<String> gerritAuthOptional = Optional.absent();

    // remember when host does not support gerrit-auth login method so we don't have to try again
    private boolean hostSupportsGerritAuth = true;

    private String lastConnection;

    public LoginCache(GerritAuthData authData, BasicCookieStore cookieStore) {
        this.authData = authData;
        this.cookieStore = cookieStore;
    }

    public void setGerritAuthOptional(Optional<String> gerritAuthOptional) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public Optional<String> getGerritAuthOptional() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public boolean getHostSupportsGerritAuth() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public void invalidate() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public boolean isGithubOAuthDetected() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public boolean isGitHubOAuthRequested(HttpContext loginContext) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * GerritAuthData can change at runtime (when getters are implemented dynamically so they return e.g. application
     * settings. So let's check if we can re-use cached login data. Resetting them on any config change.
     * Any getter-call in this class must call this method first.
     */
    private void invalidateLoginDataOnNewSettings() {
        String authDataString = "" + authData.getHost() + authData.getLogin() + authData.getPassword();
        if (!authDataString.equals(lastConnection)) {
            invalidate();
            lastConnection = authDataString;
        }
    }
}
