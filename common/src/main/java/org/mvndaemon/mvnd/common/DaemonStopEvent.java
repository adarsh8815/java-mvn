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
package org.mvndaemon.mvnd.common;

import java.io.Serializable;
import java.text.DateFormat;
import java.util.Date;
import java.util.Objects;

/**
 * Information regarding when and why a daemon was stopped.
 *
 * File origin:
 * https://github.com/gradle/gradle/blob/v5.6.2/subprojects/launcher/src/main/java/org/gradle/launcher/daemon/registry/DaemonStopEvent.java
 */
public class DaemonStopEvent implements Serializable {

    private final String daemonId;
    private final long timestamp;
    private final DaemonExpirationStatus status;
    private final String reason;

    public DaemonStopEvent(String daemonId, long timestamp, DaemonExpirationStatus status, String reason) {
        this.daemonId = daemonId;
        this.timestamp = timestamp;
        this.status = status;
        this.reason = reason != null ? reason : "";
    }

    public String getDaemonId() {
        return daemonId;
    }

    public long getTimestamp() {
        return timestamp;
    }

    public DaemonExpirationStatus getStatus() {
        return status;
    }

    public String getReason() {
        return reason;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DaemonStopEvent that = (DaemonStopEvent) o;
        return Objects.equals(daemonId, that.daemonId)
                && timestamp == that.timestamp
                && status == that.status
                && Objects.equals(reason, that.reason);
    }

    @Override
    public int hashCode() {
        return Objects.hash(timestamp, daemonId, status, reason);
    }

    @Override
    public String toString() {
        return "DaemonStopEvent{"
                + "daemonId=" + daemonId
                + ", timestamp=" + DateFormat.getDateTimeInstance().format(new Date(timestamp))
                + ", status=" + status
                + ", reason=" + reason
                + "}";
    }
}
