// Copyright (C) 2013 The Android Open Source Project
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
package com.google.gerrit.extensions.api.changes;

import static com.google.gerrit.extensions.client.ReviewerState.REVIEWER;
import com.google.gerrit.extensions.client.Comment;
import com.google.gerrit.extensions.client.ReviewerState;
import com.google.gerrit.extensions.common.FixSuggestionInfo;
import com.google.gerrit.extensions.restapi.DefaultInput;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/**
 * Input passed to {@code POST /changes/[id]/revisions/[id]/review}.
 */
public class ReviewInput {

    @DefaultInput
    public String message;

    public String tag;

    public Map<String, Short> labels;

    public Map<String, List<CommentInput>> comments;

    public Map<String, List<RobotCommentInput>> robotComments;

    /**
     * How to process draft comments already in the database that were not also described in this
     * input request.
     *
     * <p>If not set, the default is {@link DraftHandling#KEEP}. If {@link #onBehalfOf} is set, then
     * no other value besides {@code KEEP} is allowed.
     */
    public DraftHandling drafts;

    /**
     * Who to send email notifications to after review is stored.
     */
    public NotifyHandling notify;

    public Map<RecipientType, NotifyInfo> notifyDetails;

    /**
     * If true check to make sure that the comments being posted aren't already present.
     */
    public boolean omitDuplicateComments;

    /**
     * Account ID, name, email address or username of another user. The review will be posted/updated
     * on behalf of this named user instead of the caller. Caller must have the labelAs-$NAME
     * permission granted for each label that appears in {@link #labels}. This is in addition to the
     * named user also needing to have permission to use the labels.
     */
    public String onBehalfOf;

    /**
     * Reviewers that should be added to this change.
     */
    public List<AddReviewerInput> reviewers;

    /**
     * If true mark the change as work in progress. It is an error for both {@link #workInProgress}
     * and {@link #ready} to be true.
     */
    public boolean workInProgress;

    /**
     * If true mark the change as ready for review. It is an error for both {@link #workInProgress}
     * and {@link #ready} to be true.
     */
    public boolean ready;

    /**
     * Users that should be added to the attention set of this change.
     */
    public List<AttentionSetInput> addToAttentionSet;

    /**
     * Users that should be removed from the attention set of this change.
     */
    public List<AttentionSetInput> removeFromAttentionSet;

    /**
     * Users in the attention set will only be added and removed based on {@link #addToAttentionSet}
     * and {@link #removeFromAttentionSet}. Normally, they are also added and removed when some events
     * occur. E.g, adding/removing reviewers, marking a change ready for review or work in progress,
     * and replying on changes.
     */
    public boolean ignoreAutomaticAttentionSetRules;

    public enum DraftHandling {

        /**
         * Leave pending drafts alone.
         */
        KEEP,
        /**
         * Publish pending drafts on this revision only.
         */
        PUBLISH,
        /**
         * Publish pending drafts on all revisions.
         */
        PUBLISH_ALL_REVISIONS
    }

    public static class CommentInput extends Comment {
    }

    public static class RobotCommentInput extends CommentInput {

        public String robotId;

        public String robotRunId;

        public String url;

        public Map<String, String> properties;

        public List<FixSuggestionInfo> fixSuggestions;
    }

    public ReviewInput message(String msg) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public ReviewInput label(String name, short value) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public ReviewInput label(String name, int value) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public ReviewInput label(String name) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public ReviewInput reviewer(String reviewer) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public ReviewInput reviewer(String reviewer, ReviewerState state, boolean confirmed) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public ReviewInput addUserToAttentionSet(String user, String reason) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public ReviewInput removeUserFromAttentionSet(String user, String reason) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public ReviewInput blockAutomaticAttentionSetRules() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public ReviewInput setWorkInProgress(boolean workInProgress) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public ReviewInput setReady(boolean ready) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public static ReviewInput recommend() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public static ReviewInput dislike() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public static ReviewInput noScore() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public static ReviewInput approve() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public static ReviewInput reject() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public static ReviewInput create() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }
}
