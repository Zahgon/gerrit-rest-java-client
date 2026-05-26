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
package com.urswolfer.gerrit.client.rest.http.changes.parsers;

import com.google.common.reflect.TypeToken;
import com.google.gerrit.extensions.api.changes.IncludedInInfo;
import com.google.gerrit.extensions.common.ChangeInfo;
import com.google.gerrit.extensions.common.ChangeInput;
import com.google.gson.Gson;
import com.google.gson.JsonElement;
import java.lang.reflect.Type;
import java.util.Collections;
import java.util.List;
import java.util.Set;

/**
 * Parser for the information related to a change.
 *
 * @author Thomas Forrer - EFregnan
 */
public class ChangeInfosParser {

    private static final Type CHANGEINFO_TYPE = new TypeToken<List<ChangeInfo>>() {
    }.getType();

    private static final Type HASHTAG_TYPE = new TypeToken<Set<String>>() {
    }.getType();

    private final Gson gson;

    public ChangeInfosParser(Gson gson) {
        this.gson = gson;
    }

    public List<ChangeInfo> parseChangeInfos(JsonElement result) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public ChangeInfo parseSingleChangeInfo(JsonElement result) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public String generateChangeInput(ChangeInput input) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public Set<String> parseHashtags(JsonElement result) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public IncludedInInfo parseIncludedInInfos(JsonElement jsonElement) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }
}
