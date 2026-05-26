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
package com.urswolfer.gerrit.client.rest.http.changes;

import com.google.common.base.Strings;
import com.google.gerrit.extensions.api.changes.*;
import com.google.gerrit.extensions.client.SubmitType;
import com.google.gerrit.extensions.common.*;
import com.google.gerrit.extensions.restapi.BinaryResult;
import com.google.gerrit.extensions.restapi.RestApiException;
import com.google.gerrit.extensions.restapi.Url;
import com.google.gson.JsonElement;
import com.google.gson.reflect.TypeToken;
import com.urswolfer.gerrit.client.rest.http.GerritRestClient;
import com.urswolfer.gerrit.client.rest.http.changes.parsers.*;
import com.urswolfer.gerrit.client.rest.http.util.BinaryResultUtils;
import org.apache.http.HttpResponse;
import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.SortedMap;
import static com.urswolfer.gerrit.client.rest.RestClient.HttpVerb.GET;

/**
 * @author Urs Wolfer
 */
public class RevisionApiRestClient extends RevisionApi.NotImplemented implements RevisionApi {

    private final GerritRestClient gerritRestClient;

    private final ChangeApiRestClient changeApiRestClient;

    private final CommentsParser commentsParser;

    private final FileInfoParser fileInfoParser;

    private final ReviewResultParser reviewResultParser;

    private final CommitInfosParser commitInfosParser;

    private final MergeableInfoParser mergeableInfoParser;

    private final ReviewInfoParser reviewInfoParser;

    private final String revision;

    public RevisionApiRestClient(GerritRestClient gerritRestClient, ChangeApiRestClient changeApiRestClient, CommentsParser commentsParser, FileInfoParser fileInfoParser, ReviewResultParser reviewResultParser, CommitInfosParser commitInfosParser, MergeableInfoParser mergeableInfoParser, ReviewInfoParser reviewInfoParser, String revision) {
        this.gerritRestClient = gerritRestClient;
        this.changeApiRestClient = changeApiRestClient;
        this.commentsParser = commentsParser;
        this.fileInfoParser = fileInfoParser;
        this.reviewResultParser = reviewResultParser;
        this.commitInfosParser = commitInfosParser;
        this.mergeableInfoParser = mergeableInfoParser;
        this.reviewInfoParser = reviewInfoParser;
        this.revision = revision;
    }

    public String revision() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public void delete() throws RestApiException {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public ReviewResult review(ReviewInput reviewInput) throws RestApiException {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public void submit() throws RestApiException {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public void submit(SubmitInput submitInput) throws RestApiException {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public void publish() throws RestApiException {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public ChangeApi cherryPick(CherryPickInput in) throws RestApiException {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public ChangeApi rebase() throws RestApiException {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public ChangeApi rebase(RebaseInput in) throws RestApiException {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public void setReviewed(String path, boolean reviewed) throws RestApiException {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public MergeableInfo mergeable() throws RestApiException {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * Support starting from Gerrit 2.7.
     */
    @Override
    public SortedMap<String, List<CommentInfo>> comments() throws RestApiException {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public SortedMap<String, List<CommentInfo>> drafts() throws RestApiException {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public Set<String> reviewed() throws RestApiException {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    private SortedMap<String, List<CommentInfo>> comments(String type) throws RestApiException {
        String request = getRequestPath() + '/' + type + '/';
        JsonElement jsonElement = gerritRestClient.getRequest(request);
        return commentsParser.parseCommentInfos(jsonElement);
    }

    @Override
    public Map<String, List<RobotCommentInfo>> robotComments() throws RestApiException {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public DraftApi createDraft(DraftInput in) throws RestApiException {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public DraftApi draft(String id) throws RestApiException {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public CommentApi comment(String id) throws RestApiException {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public RobotCommentApi robotComment(String id) throws RestApiException {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public Map<String, FileInfo> files() throws RestApiException {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public Map<String, FileInfo> files(int parentNum) throws RestApiException {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public FileApi file(String path) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public CommitInfo commit(boolean addLinks) throws RestApiException {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public BinaryResult patch() throws RestApiException {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public Map<String, ActionInfo> actions() throws RestApiException {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public SubmitType submitType() throws RestApiException {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public BinaryResult submitPreview() throws RestApiException {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public BinaryResult submitPreview(String format) throws RestApiException {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public SubmitType testSubmitType(TestSubmitRuleInput in) throws RestApiException {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public String description() throws RestApiException {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    protected String getRequestPath() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }
}
