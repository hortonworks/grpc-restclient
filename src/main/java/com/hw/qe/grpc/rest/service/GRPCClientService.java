package com.hw.qe.grpc.rest.service;

import com.hw.qe.grpc.rest.api.CommandReq;
import com.hw.qe.grpc.rest.api.ReadFileReq;
import com.hw.qe.grpc.rest.api.UploadFileReq;
import org.hw.qe.CommandStatus;
import org.hw.qe.File;
import org.hw.qe.HwqeClient;
import org.hw.qe.HwqeException;
import org.hw.qe.HwqeUtils;
import java.util.Collections;


public class GRPCClientService {

    private HwqeClient hwqeClient;

    public CommandStatus runCommand(CommandReq req) throws HwqeException{
        hwqeClient = HwqeUtils.getHwqeClient(req.getHostName());
        CommandStatus status = null;
        String runAs = (req.getRunAsUser() != null && !req.getRunAsUser().isEmpty()) ? req.getRunAsUser() :  "root";
        String workingDir = (req.getWorkingDir() != null) ? req.getWorkingDir() :  "";
        status = hwqeClient.runCommand(req.getCommandParts(), runAs, Collections.EMPTY_LIST, workingDir);
        return status;
    }

    public boolean writeToFile(UploadFileReq uploadReq) {
        hwqeClient = HwqeUtils.getHwqeClient(uploadReq.getHostName());
        boolean status = false;
        status = hwqeClient.writeToFile(uploadReq.getLinesToWrite(), uploadReq.isOverwrite(), uploadReq.getDstFile(),
        uploadReq.getOwner(), uploadReq.getGroup(), uploadReq.getPerm());
        return status;
    }

    public byte[] readFile(ReadFileReq readReq) throws HwqeException {
        hwqeClient = HwqeUtils.getHwqeClient(readReq.getHostName());
        byte[] bFile = null;
        File file = hwqeClient.readFile(readReq.getFilePath());
        bFile = file.getBytesData().getData().toByteArray();
        return bFile;
    }

}
