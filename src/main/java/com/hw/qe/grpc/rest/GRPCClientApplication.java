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
        // nothing to do yet
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


     /*   final TemplateHealthCheck healthCheck =
                new TemplateHealthCheck(configuration.getTemplate());
        environment.healthChecks().register("template", healthCheck);
        environment.jersey().register(resource);*/
    }
}