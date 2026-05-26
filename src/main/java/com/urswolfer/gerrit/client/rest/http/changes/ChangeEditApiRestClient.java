/*
 * Copyright 2013-2014 Urs Wolfer
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
package com.urswolfer.gerrit.client.rest.http.changes;

import com.google.gerrit.extensions.api.changes.ChangeEditApi;
import com.google.gerrit.extensions.api.changes.FileContentInput;
import com.google.gerrit.extensions.api.changes.PublishChangeEditInput;
import com.google.gerrit.extensions.common.EditInfo;
import com.google.gerrit.extensions.restapi.BinaryResult;
import com.google.gerrit.extensions.restapi.RestApiException;
import com.google.gerrit.extensions.restapi.Url;
import com.google.gson.JsonElement;
import com.urswolfer.gerrit.client.rest.RestClient.HttpVerb;
import com.urswolfer.gerrit.client.rest.http.GerritRestClient;
import com.urswolfer.gerrit.client.rest.http.changes.parsers.CommitInfosParser;
import com.urswolfer.gerrit.client.rest.http.util.BinaryResultUtils;
import org.apache.http.HttpResponse;
import java.io.IOException;
import java.util.Optional;
import static com.urswolfer.gerrit.client.rest.RestClient.HttpVerb.GET;

/**
 * @author Jun Qiu
 */
public class ChangeEditApiRestClient extends ChangeEditApi.NotImplemented implements ChangeEditApi {

    private final GerritRestClient gerritRestClient;

    private final String id;

    private final CommitInfosParser commitInfosParser;

    public ChangeEditApiRestClient(GerritRestClient gerritRestClient, CommitInfosParser commitInfosParser, String id) {
        this.gerritRestClient = gerritRestClient;
        this.id = id;
        this.commitInfosParser = commitInfosParser;
    }

    @Override
    public Optional<EditInfo> get() throws RestApiException {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public void delete() throws RestApiException {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public void rebase() throws RestApiException {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public void publish() throws RestApiException {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public void publish(PublishChangeEditInput input) throws RestApiException {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public Optional<BinaryResult> getFile(String filePath) throws RestApiException {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public void renameFile(String oldFilePath, String newFilePath) throws RestApiException {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public void restoreFile(String filePath) throws RestApiException {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    private void changeFile(ChangeEditInput input) throws RestApiException {
        String json = gerritRestClient.getGson().toJson(input);
        gerritRestClient.postRequest(getRequestPath(), json);
    }

    @Override
    public void modifyFile(String filePath, FileContentInput input) throws RestApiException {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public void deleteFile(String filePath) throws RestApiException {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public String getCommitMessage() throws RestApiException {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public void modifyCommitMessage(String newCommitMessage) throws RestApiException {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public void modifyCommitMessage(ChangeEditMessageInput input) throws RestApiException {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    protected String getRequestPath() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    protected static class ChangeEditInput {

        public String restore_path;

        public String old_path;

        public String new_path;
    }

    public static class ChangeEditMessageInput {

        public String message;
    }
}
