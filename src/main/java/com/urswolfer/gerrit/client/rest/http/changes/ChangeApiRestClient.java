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
import com.google.common.collect.Iterables;
import com.google.gerrit.extensions.api.changes.*;
import com.google.gerrit.extensions.client.ListChangesOption;
import com.google.gerrit.extensions.common.*;
import com.google.gerrit.extensions.restapi.RestApiException;
import com.google.gerrit.extensions.restapi.Url;
import com.google.gson.JsonElement;
import com.urswolfer.gerrit.client.rest.http.GerritRestClient;
import com.urswolfer.gerrit.client.rest.http.accounts.AccountsParser;
import com.urswolfer.gerrit.client.rest.http.changes.parsers.*;
import com.urswolfer.gerrit.client.rest.http.config.ServerRestClient;
import com.urswolfer.gerrit.client.rest.http.config.parsers.ServerConfigParser;
import com.urswolfer.gerrit.client.rest.http.util.UrlUtils;
import java.util.*;

/**
 * @author Urs Wolfer
 */
public class ChangeApiRestClient extends ChangeApi.NotImplemented implements ChangeApi {

    private final GerritRestClient gerritRestClient;

    private final ChangesRestClient changesRestClient;

    private final ChangeInfosParser changeInfosParser;

    private final CommentsParser commentsParser;

    private final FileInfoParser fileInfoParser;

    private final ReviewResultParser reviewResultParser;

    private final ReviewerInfosParser reviewerInfosParser;

    private final CommitInfosParser commitInfosParser;

    private final AccountsParser accountsParser;

    private final MergeableInfoParser mergeableInfoParser;

    private final ReviewInfoParser reviewInfoParser;

    private final ServerConfigParser serverConfigParser;

    private final String id;

    private final ServerRestClient serverRestClient;

    public ChangeApiRestClient(GerritRestClient gerritRestClient, ChangesRestClient changesRestClient, ChangeInfosParser changeInfosParser, CommentsParser commentsParser, FileInfoParser fileInfoParser, ReviewResultParser reviewResultParser, ReviewerInfosParser reviewerInfosParser, CommitInfosParser commitInfosParser, AccountsParser accountsParser, MergeableInfoParser mergeableInfoParser, ReviewInfoParser reviewInfoParser, ServerConfigParser serverConfigParser, String id) {
        this.gerritRestClient = gerritRestClient;
        this.changesRestClient = changesRestClient;
        this.changeInfosParser = changeInfosParser;
        this.commentsParser = commentsParser;
        this.fileInfoParser = fileInfoParser;
        this.reviewResultParser = reviewResultParser;
        this.reviewerInfosParser = reviewerInfosParser;
        this.commitInfosParser = commitInfosParser;
        this.accountsParser = accountsParser;
        this.mergeableInfoParser = mergeableInfoParser;
        this.reviewInfoParser = reviewInfoParser;
        this.serverConfigParser = serverConfigParser;
        this.id = id;
        this.serverRestClient = new ServerRestClient(gerritRestClient, serverConfigParser);
    }

    @Override
    public String id() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public RevisionApi current() throws RestApiException {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public RevisionApi revision(int id) throws RestApiException {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public RevisionApi revision(String id) throws RestApiException {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public void abandon() throws RestApiException {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public void abandon(AbandonInput abandonInput) throws RestApiException {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public void restore() throws RestApiException {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public void restore(RestoreInput restoreInput) throws RestApiException {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public void move(String destinationBranch) throws RestApiException {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public void move(MoveInput moveInput) throws RestApiException {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public ChangeApi revert() throws RestApiException {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public ChangeApi revert(RevertInput revertInput) throws RestApiException {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public RevertSubmissionInfo revertSubmission() throws RestApiException {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public RevertSubmissionInfo revertSubmission(RevertInput in) throws RestApiException {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public void publish() throws RestApiException {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public void delete() throws RestApiException {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public String topic() throws RestApiException {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public void topic(String topic) throws RestApiException {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public IncludedInInfo includedIn() throws RestApiException {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Deprecated
    @Override
    public List<ReviewerInfo> listReviewers() throws RestApiException {
        return reviewers();
    }

    @Override
    public List<ReviewerInfo> reviewers() throws RestApiException {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public AddReviewerResult addReviewer(AddReviewerInput in) throws RestApiException {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public AddReviewerResult addReviewer(String in) throws RestApiException {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public SuggestedReviewersRequest suggestReviewers() throws RestApiException {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public SuggestedReviewersRequest suggestReviewers(String query) throws RestApiException {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    private List<SuggestedReviewerInfo> suggestReviewers(SuggestedReviewersRequest r) throws RestApiException {
        String encodedQuery = Url.encode(r.getQuery());
        return getSuggestedReviewers(String.format("q=%s&n=%s", encodedQuery, r.getLimit()));
    }

    private List<SuggestedReviewerInfo> getSuggestedReviewers(String queryPart) throws RestApiException {
        String request = getRequestPath() + String.format("/suggest_reviewers?%s", queryPart);
        JsonElement suggestedReviewers = gerritRestClient.getRequest(request);
        return reviewerInfosParser.parseSuggestReviewerInfos(suggestedReviewers);
    }

    @Override
    public ChangeInfo get(EnumSet<ListChangesOption> options) throws RestApiException {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public ChangeInfo get() throws RestApiException {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public ChangeInfo info() throws RestApiException {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public EditInfo getEdit() throws RestApiException {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public ChangeEditApi edit() throws RestApiException {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public void setMessage(String message) throws RestApiException {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public void setMessage(CommitMessageInput in) throws RestApiException {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public void setHashtags(HashtagsInput input) throws RestApiException {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public Set<String> getHashtags() throws RestApiException {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public AccountInfo setAssignee(AssigneeInput input) throws RestApiException {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public AccountInfo getAssignee() throws RestApiException {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public List<AccountInfo> getPastAssignees() throws RestApiException {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public AccountInfo deleteAssignee() throws RestApiException {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public ChangeInfo check() throws RestApiException {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public ChangeInfo check(FixInput in) throws RestApiException {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public Map<String, List<CommentInfo>> comments() throws RestApiException {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public Map<String, List<RobotCommentInfo>> robotComments() throws RestApiException {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public Map<String, List<CommentInfo>> drafts() throws RestApiException {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public void index() throws RestApiException {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public List<ChangeInfo> submittedTogether() throws RestApiException {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public List<ChangeMessageInfo> messages() throws RestApiException {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public void ignore(boolean ignore) throws RestApiException {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public void rebase(RebaseInput in) throws RestApiException {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    protected String getRequestPath() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }
}
