/*
 * Copyright  (c) 2011-2018, Hortonworks Inc.  All rights reserved.
 *
 * Except as expressly permitted in a written agreement between your
 * company and Hortonworks, Inc, any use, reproduction, modification,
 * redistribution, sharing, lending or other exploitation of all or
 * any part of the contents of this file is strictly prohibited.
 */
package com.hw.qe.grpc.rest;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.hw.qe.grpc.rest.health.TemplateHealthCheck;
import com.hw.qe.grpc.rest.resources.GRPCClientResource;
import io.dropwizard.Application;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;

public class GRPCClientApplication extends Application<GRPCClientConfiguration> {
    public static void main(String[] args) throws Exception {
        new GRPCClientApplication().run(args);
    }

    @Override
    public String getName() {
        return "Rest client for GRPC";
    }

    @Override
    public void initialize(Bootstrap<GRPCClientConfiguration> bootstrap) {
        bootstrap.getObjectMapper().disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES);
        bootstrap.getObjectMapper().disable(SerializationFeature.FAIL_ON_EMPTY_BEANS);

    }

    @Override
    public void run(GRPCClientConfiguration configuration,
                    Environment environment) {
        final GRPCClientResource resource = new GRPCClientResource(
                configuration.getUsage()
        );
        environment.jersey().register(resource);


        final TemplateHealthCheck healthCheck =
                new TemplateHealthCheck(configuration.getUsage());
        environment.healthChecks().register("usage", healthCheck);
        environment.jersey().register(resource);
    }
}