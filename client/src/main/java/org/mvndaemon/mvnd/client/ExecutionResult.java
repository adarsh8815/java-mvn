/*
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */
package org.mvndaemon.mvnd.client;

import java.util.List;

/**
 * A result of a {@code mvnd} build.
 */
public interface ExecutionResult {

    boolean isSuccess();

    ExecutionResult assertFailure();

    ExecutionResult assertSuccess();

    int getExitCode();

    public static StringBuilder appendCommand(StringBuilder sb, List<String> args) {
        sb.append("mvnd");
        for (String arg : args) {
            sb.append(" \"").append(arg).append('"');
        }
        return sb;
    }
}
