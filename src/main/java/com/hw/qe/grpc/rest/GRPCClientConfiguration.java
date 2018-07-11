/*
 * Copyright  (c) 2011-2018, Hortonworks Inc.  All rights reserved.
 *
 * Except as expressly permitted in a written agreement between your
 * company and Hortonworks, Inc, any use, reproduction, modification,
 * redistribution, sharing, lending or other exploitation of all or
 * any part of the contents of this file is strictly prohibited.
 */
package com.hw.qe.grpc.rest;

import io.dropwizard.Configuration;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.adrianwalker.multilinestring.Multiline;
import org.hibernate.validator.constraints.NotEmpty;

public class GRPCClientConfiguration extends Configuration {

    /**
     {
     "usage": [{
     "Title": "Show All Users",
     "URL": "",
     "Method": "POST",
     "URL Params": "none",
     "Data Params": "{'hostName':'remote hostname', 'linesToWrite':[ list of lines to be written], 'dstFile':'destination file ','owner':'file owner','group':'file grp', 'perm':'file permission', 'owerwrite':true|false}",
     "Response codes": "Success (200 OK), Bad Request (400), Unauthorized (401)"
     },

     {
     "Title": "Show All Users",
     "URL": "",
     "Method": "POST",
     "URL Params": "none",
     "Data Params": "{'hostName':'remote hostname', 'linesToWrite':[ list of lines to be written], 'dstFile':'destination file ','owner':'file owner','group':'file grp', 'perm':'file permission', 'owerwrite':true|false}",
     "Response codes": "Success (200 OK), Bad Request (400), Unauthorized (401)"
     }
     ]
     }
     */
    @Multiline
    @NotEmpty
    private String usage;

    public String getUsage() {
        return usage;
    }

    public void setUsage(String usage) {
        this.usage = usage;
    }



}