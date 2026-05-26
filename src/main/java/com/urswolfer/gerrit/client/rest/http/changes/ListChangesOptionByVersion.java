/*
 * Copyright (C) 2020 GerritForge Ltd.
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

import com.google.gerrit.extensions.client.ListChangesOption;
import java.util.EnumSet;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

class ListChangesOptionByVersion {

    static final Map<String, ListChangesOption> MAX_CHANGE_OPTION_BY_VERSION = new HashMap<>();

    static final Pattern VERSION_PATTERN = Pattern.compile("(\\d+)\\.(\\d+)\\..*");

    static {
        put("2.6", ListChangesOption.DETAILED_ACCOUNTS);
        put("2.7", ListChangesOption.MESSAGES);
        put("2.8", ListChangesOption.DOWNLOAD_COMMANDS);
        put("2.9", ListChangesOption.DOWNLOAD_COMMANDS);
        put("2.10", ListChangesOption.WEB_LINKS);
        put("2.11", ListChangesOption.CHANGE_ACTIONS);
        put("2.12", ListChangesOption.PUSH_CERTIFICATES);
        put("2.13", ListChangesOption.REVIEWER_UPDATES);
        put("2.14", ListChangesOption.SUBMITTABLE);
        put("2.15", ListChangesOption.TRACKING_IDS);
        put("2.16", ListChangesOption.SKIP_MERGEABLE);
    }

    private static void put(String version, ListChangesOption maxOption) {
        MAX_CHANGE_OPTION_BY_VERSION.put(version, maxOption);
    }

    static boolean isSupportedOnVersion(ListChangesOption listChangesOption, String gerritVersion) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    static EnumSet<ListChangesOption> allSupported(String gerritVersion) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }
}
