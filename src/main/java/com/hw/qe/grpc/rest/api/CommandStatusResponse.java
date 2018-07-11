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
