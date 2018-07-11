/*
 * Copyright  (c) 2011-2018, Hortonworks Inc.  All rights reserved.
 *
 * Except as expressly permitted in a written agreement between your
 * company and Hortonworks, Inc, any use, reproduction, modification,
 * redistribution, sharing, lending or other exploitation of all or
 * any part of the contents of this file is strictly prohibited.
 */
package com.hw.qe.grpc.rest.resources;


import com.codahale.metrics.annotation.Timed;
import com.hw.qe.grpc.rest.api.CommandReq;
import com.hw.qe.grpc.rest.api.CommandStatusResponse;
import com.hw.qe.grpc.rest.api.ReadFileReq;
import com.hw.qe.grpc.rest.api.UploadFileReq;
import com.hw.qe.grpc.rest.service.GRPCClientService;
import org.hw.qe.CommandStatus;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import java.util.concurrent.atomic.AtomicLong;
import java.util.Optional;

@Path("/grpc-client")
@Produces(MediaType.APPLICATION_JSON)
public class GRPCClientResource {
    private final String usage;

    private final GRPCClientService clientService = new GRPCClientService();

    public GRPCClientResource(String usage) {
        this.usage = usage;
    }

    @GET
    @Timed
    public CommandStatusResponse usage(@QueryParam("name") Optional<String> name) {
        return new CommandStatusResponse<String>(0, usage);
    }


    /**
     * Executes the command and resturns the status code with std out / err out.
     * @param cmdReq
     * @return
     * @throws Exception
     */
    @POST
    @Path("/runcommand")
    @Timed
    public CommandStatusResponse<String> runCommand(@NotNull @Valid final CommandReq cmdReq) throws Exception {
        CommandStatus status = clientService.runCommand(cmdReq);
        StringBuilder output = new StringBuilder();
        int code = -1;
        boolean returnVal = status.getCode() == 0 ? true : false;
        if(!returnVal && status.getStderrList().size() > 0){
            status.getStderrList().forEach(error->output.append(error));
            code = status.getCode();

        }
        else if(returnVal){
            status.getStdoutList().forEach(info->output.append(info));
            code = status.getCode();
        }

        return new CommandStatusResponse<String>(code, output.toString());
    }

    /**
     * Writes the list of lines to the file.
     * @param fileReq
     * @return
     * @throws Exception
     */
    @POST
    @Path("/writetofile")
    @Timed
    public CommandStatusResponse<Boolean> writeToFile(@NotNull @Valid final UploadFileReq fileReq) throws Exception {
        boolean status = clientService.writeToFile(fileReq);
        return new CommandStatusResponse<Boolean>(0, status);
    }

    /**
     * Read and returns the file content of file.
     * @param fileReq
     * @return
     * @throws Exception
     */

    @POST
    @Path("/readfile")
    @Timed
    public CommandStatusResponse<byte[]> readFile(@NotNull @Valid final ReadFileReq fileReq) throws Exception {
        byte[] content = clientService.readFile(fileReq);
        if( content != null)
            return new CommandStatusResponse<byte[]>(0, content);
        else
            return new CommandStatusResponse<byte[]>(-1, content);

    }

}
