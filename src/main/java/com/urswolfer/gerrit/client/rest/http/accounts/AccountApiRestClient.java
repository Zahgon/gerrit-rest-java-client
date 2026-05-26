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
package com.urswolfer.gerrit.client.rest.http.accounts;

import com.google.gerrit.extensions.api.accounts.DeleteDraftCommentsInput;
import com.google.gerrit.extensions.api.accounts.DeletedDraftCommentInfo;
import com.google.gerrit.extensions.api.accounts.DisplayNameInput;
import com.google.gerrit.extensions.api.accounts.EmailApi;
import com.google.gerrit.extensions.api.accounts.EmailInput;
import com.google.gerrit.extensions.api.accounts.StatusInput;
import com.google.gerrit.extensions.api.changes.StarsInput;
import com.google.gerrit.extensions.client.DiffPreferencesInfo;
import com.google.gerrit.extensions.client.EditPreferencesInfo;
import com.google.gerrit.extensions.client.GeneralPreferencesInfo;
import com.google.gerrit.extensions.client.ProjectWatchInfo;
import com.google.gerrit.extensions.common.AccountDetailInfo;
import com.google.gerrit.extensions.common.AccountExternalIdInfo;
import com.google.gerrit.extensions.common.AccountInfo;
import com.google.gerrit.extensions.common.ChangeInfo;
import com.google.gerrit.extensions.common.EmailInfo;
import com.google.gerrit.extensions.common.HttpPasswordInput;
import com.google.gerrit.extensions.common.SshKeyInfo;
import com.google.gerrit.extensions.restapi.BinaryResult;
import com.google.gerrit.extensions.restapi.RestApiException;
import com.google.gerrit.extensions.restapi.Url;
import com.google.gson.JsonElement;
import com.urswolfer.gerrit.client.rest.RestClient.HttpVerb;
import com.urswolfer.gerrit.client.rest.accounts.AccountApi;
import com.urswolfer.gerrit.client.rest.http.GerritRestClient;
import com.urswolfer.gerrit.client.rest.http.changes.parsers.ChangeInfosParser;
import com.urswolfer.gerrit.client.rest.http.util.BinaryResultUtils;
import org.apache.http.HttpResponse;
import java.io.IOException;
import java.util.List;
import java.util.SortedSet;
import static com.urswolfer.gerrit.client.rest.RestClient.HttpVerb.GET;

/**
 * @author Urs Wolfer
 */
public class AccountApiRestClient extends AccountApi.NotImplemented implements AccountApi {

    private final AccountsParser accountsParser;

    private final SshKeysParser sshKeysParser;

    private final ChangeInfosParser changeInfosParser;

    private final GerritRestClient gerritRestClient;

    private final String name;

    public AccountApiRestClient(GerritRestClient gerritRestClient, AccountsParser accountsParser, SshKeysParser sshKeysParser, ChangeInfosParser changeInfosParser, String name) {
        this.gerritRestClient = gerritRestClient;
        this.accountsParser = accountsParser;
        this.sshKeysParser = sshKeysParser;
        this.changeInfosParser = changeInfosParser;
        this.name = name;
    }

    @Override
    public AccountInfo get() throws RestApiException {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public AccountDetailInfo detail() throws RestApiException {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public boolean getActive() throws RestApiException {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public void setActive(boolean active) throws RestApiException {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public GeneralPreferencesInfo getPreferences() throws RestApiException {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public GeneralPreferencesInfo setPreferences(GeneralPreferencesInfo input) throws RestApiException {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public DiffPreferencesInfo getDiffPreferences() throws RestApiException {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public DiffPreferencesInfo setDiffPreferences(DiffPreferencesInfo input) throws RestApiException {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public EditPreferencesInfo getEditPreferences() throws RestApiException {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public EditPreferencesInfo setEditPreferences(EditPreferencesInfo input) throws RestApiException {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public List<ProjectWatchInfo> getWatchedProjects() throws RestApiException {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public List<ProjectWatchInfo> setWatchedProjects(List<ProjectWatchInfo> in) throws RestApiException {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public void deleteWatchedProjects(List<ProjectWatchInfo> in) throws RestApiException {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public void starChange(String id) throws RestApiException {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public void unstarChange(String id) throws RestApiException {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public void setStars(String changeId, StarsInput input) throws RestApiException {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public SortedSet<String> getStars(String changeId) throws RestApiException {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public List<ChangeInfo> getStarredChanges() throws RestApiException {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * Starred-endpoint added in Gerrit 2.8.
     */
    private String createStarredUrl(String id) {
        return getRequestPath() + "/starred.changes/" + id;
    }

    /**
     * Stars endpoint from 2.13 onward provides labels to stars
     */
    private String createStarsUrl(String id) {
        return getRequestPath() + "/stars.changes/" + id;
    }

    @Override
    public List<EmailInfo> getEmails() throws RestApiException {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public void deleteEmail(String email) throws RestApiException {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public EmailApi createEmail(String email) throws RestApiException {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public EmailApi createEmail(EmailInput input) throws RestApiException {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public EmailApi email(String email) throws RestApiException {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public void setStatus(String status) throws RestApiException {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public void setStatus(StatusInput input) throws RestApiException {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public void setDisplayName(String displayName) throws RestApiException {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public void setDisplayName(DisplayNameInput input) throws RestApiException {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public BinaryResult downloadAvatar(int size) throws RestApiException {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public SshKeyInfo addSshKey(String key) throws RestApiException {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public List<SshKeyInfo> listSshKeys() throws RestApiException {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public void deleteSshKey(int seq) throws RestApiException {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public void index() throws RestApiException {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public List<AccountExternalIdInfo> getExternalIds() throws RestApiException {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public void deleteExternalIds(List<String> externalIds) throws RestApiException {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public List<DeletedDraftCommentInfo> deleteDraftComments(DeleteDraftCommentsInput input) throws RestApiException {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public String generateHttpPassword() throws RestApiException {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public String setHttpPassword(String httpPassword) throws RestApiException {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public String setHttpPassword(HttpPasswordInput input) throws RestApiException {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public void deleteHttpPassword() throws RestApiException {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    private String getRequestPath() {
        return "/accounts/" + Url.encode(name);
    }
}
