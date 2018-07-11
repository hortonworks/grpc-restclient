package com.hw.qe.grpc.rest.api;

import java.util.List;

public class CommandReq {

    String hostName;
    List commandParts;
    String runAsUser;
    String workingDir;

    public String getHostName() {
        return hostName;
    }

    public void setHostName(String hostName) {
        this.hostName = hostName;
    }

    public List getCommandParts() {
        return commandParts;
    }

    public void setCommandParts(List commandParts) {
        this.commandParts = commandParts;
    }

    public String getRunAsUser() {
        return runAsUser;
    }

    public void setRunAsUser(String runAsUser) {
        this.runAsUser = runAsUser;
    }

    public String getWorkingDir() {
        return workingDir;
    }

    public void setWorkingDir(String workingDir) {
        this.workingDir = workingDir;
    }
}
