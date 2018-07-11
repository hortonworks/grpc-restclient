/*
 * Copyright  (c) 2011-2018, Hortonworks Inc.  All rights reserved.
 *
 * Except as expressly permitted in a written agreement between your
 * company and Hortonworks, Inc, any use, reproduction, modification,
 * redistribution, sharing, lending or other exploitation of all or
 * any part of the contents of this file is strictly prohibited.
 */
package com.hw.qe.grpc.rest.api;

import com.fasterxml.jackson.annotation.JsonProperty;

public class CommandStatusResponse<T> {

    private long code;

    private T data;

    public CommandStatusResponse() {
        // Jackson deserialization
    }

    public CommandStatusResponse(long code, T data) {
        this.code = code;
        this.data = data;
    }

    @JsonProperty
    public long getCode() {
        return code;
    }

    @JsonProperty
    public T getData() {
        return data;
    }}
