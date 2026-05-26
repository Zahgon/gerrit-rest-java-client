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
package com.urswolfer.gerrit.client.rest.http.projects;

import com.google.common.base.Strings;
import com.google.gerrit.extensions.api.access.ProjectAccessInfo;
import com.google.gerrit.extensions.api.access.ProjectAccessInput;
import com.google.gerrit.extensions.api.config.AccessCheckInfo;
import com.google.gerrit.extensions.api.config.AccessCheckInput;
import com.google.gerrit.extensions.api.projects.BranchApi;
import com.google.gerrit.extensions.api.projects.BranchInfo;
import com.google.gerrit.extensions.api.projects.ChildProjectApi;
import com.google.gerrit.extensions.api.projects.CommitApi;
import com.google.gerrit.extensions.api.projects.ConfigInfo;
import com.google.gerrit.extensions.api.projects.ConfigInput;
import com.google.gerrit.extensions.api.projects.DescriptionInput;
import com.google.gerrit.extensions.api.projects.HeadInput;
import com.google.gerrit.extensions.api.projects.IndexProjectInput;
import com.google.gerrit.extensions.api.projects.LabelApi;
import com.google.gerrit.extensions.api.projects.ParentInput;
import com.google.gerrit.extensions.api.projects.ProjectApi;
import com.google.gerrit.extensions.api.projects.ProjectInput;
import com.google.gerrit.extensions.api.projects.TagApi;
import com.google.gerrit.extensions.api.projects.TagInfo;
import com.google.gerrit.extensions.common.BatchLabelInput;
import com.google.gerrit.extensions.common.ProjectInfo;
import com.google.gerrit.extensions.restapi.NotImplementedException;
import com.google.gerrit.extensions.restapi.RestApiException;
import com.google.gerrit.extensions.restapi.Url;
import com.google.gson.JsonElement;
import com.urswolfer.gerrit.client.rest.http.GerritRestClient;
import com.urswolfer.gerrit.client.rest.http.projects.parsers.ProjectCommitInfoParser;
import com.urswolfer.gerrit.client.rest.http.util.UrlUtils;
import java.util.List;

/**
 * @author Thomas Forrer
 */
public class ProjectApiRestClient extends ProjectApi.NotImplemented implements ProjectApi {

    private final GerritRestClient gerritRestClient;

    private final ProjectsParser projectsParser;

    private final BranchInfoParser branchInfoParser;

    private final TagInfoParser tagInfoParser;

    private final ProjectCommitInfoParser projectCommitInfoParser;

    private final String name;

    public ProjectApiRestClient(GerritRestClient gerritRestClient, ProjectsParser projectsParser, BranchInfoParser branchInfoParser, TagInfoParser tagInfoParser, ProjectCommitInfoParser projectCommitInfoParser, String name) {
        this.gerritRestClient = gerritRestClient;
        this.projectsParser = projectsParser;
        this.branchInfoParser = branchInfoParser;
        this.tagInfoParser = tagInfoParser;
        this.projectCommitInfoParser = projectCommitInfoParser;
        this.name = name;
    }

    @Override
    public ProjectApi create() throws RestApiException {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public ProjectApi create(ProjectInput in) throws RestApiException {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public ProjectInfo get() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public String description() throws RestApiException {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public ProjectAccessInfo access() throws RestApiException {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public ProjectAccessInfo access(ProjectAccessInput p) throws RestApiException {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public AccessCheckInfo checkAccess(AccessCheckInput in) throws RestApiException {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public ConfigInfo config() throws RestApiException {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public ConfigInfo config(ConfigInput in) throws RestApiException {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public void description(DescriptionInput in) throws RestApiException {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public ListRefsRequest<BranchInfo> branches() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public BranchApi branch(String ref) throws RestApiException {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    private List<BranchInfo> getBranches(ListRefsRequest<BranchInfo> lbr) throws RestApiException {
        String request = projectsUrl() + branchesUrl(lbr);
        JsonElement branches = gerritRestClient.getRequest(request);
        return branchInfoParser.parseBranchInfos(branches);
    }

    @Override
    public ListRefsRequest<TagInfo> tags() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public TagApi tag(String ref) throws RestApiException {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    private List<TagInfo> getTagInfos(ListRefsRequest<TagInfo> lrr) throws RestApiException {
        String request = projectsUrl() + tagsUrl(lrr);
        JsonElement tags = gerritRestClient.getRequest(request);
        return tagInfoParser.parseTagInfos(tags);
    }

    @Override
    public List<ProjectInfo> children() throws RestApiException {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public List<ProjectInfo> children(boolean recursive) throws RestApiException {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public ChildProjectApi child(String name) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public CommitApi commit(String commit) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public String head() throws RestApiException {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public void head(String head) throws RestApiException {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public String parent() throws RestApiException {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public void parent(String parent) throws RestApiException {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public void index(boolean indexChildren) throws RestApiException {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public void indexChanges() throws RestApiException {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public LabelApi label(String labelName) throws RestApiException {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public void labels(BatchLabelInput input) throws RestApiException {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    protected String projectsUrl() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    private String branchesUrl(ListRefsRequest<BranchInfo> lbr) {
        String query = "";
        if (lbr.getLimit() != 0) {
            query = UrlUtils.appendToUrlQuery(query, "n=" + lbr.getLimit());
        }
        if (lbr.getStart() != 0) {
            query = UrlUtils.appendToUrlQuery(query, "s=" + lbr.getStart());
        }
        if (!Strings.isNullOrEmpty(lbr.getSubstring())) {
            query = UrlUtils.appendToUrlQuery(query, "m=" + lbr.getSubstring());
        }
        if (!Strings.isNullOrEmpty(lbr.getRegex())) {
            query = UrlUtils.appendToUrlQuery(query, "r=" + lbr.getRegex());
        }
        String url = "/branches";
        if (!Strings.isNullOrEmpty(query)) {
            url += '?' + query;
        }
        return url;
    }

    private String tagsUrl(ListRefsRequest<TagInfo> lrr) {
        String query = "";
        if (lrr.getLimit() != 0) {
            query = UrlUtils.appendToUrlQuery(query, "n=" + lrr.getLimit());
        }
        if (lrr.getStart() != 0) {
            query = UrlUtils.appendToUrlQuery(query, "s=" + lrr.getStart());
        }
        if (!Strings.isNullOrEmpty(lrr.getSubstring()) || !Strings.isNullOrEmpty(lrr.getRegex())) {
            throw new NotImplementedException();
        }
        String url = "/tags";
        if (!Strings.isNullOrEmpty(query)) {
            url += '?' + query;
        }
        return url;
    }
}
