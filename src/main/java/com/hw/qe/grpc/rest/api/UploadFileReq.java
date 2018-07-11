package com.hw.qe.grpc.rest.api;

import java.util.List;

public class UploadFileReq {

    String hostName;
    List<String> linesToWrite;
    String dstFile;
    String owner;
    String group;
    String perm;
    boolean overwrite;

    public String getHostName() {
        return hostName;
    }

    public void setHostName(String hostName) {
        this.hostName = hostName;
    }

    public boolean isOverwrite() {
        return overwrite;
    }

    public void setOverwrite(boolean overwrite) {
        this.overwrite = overwrite;
    }

    public List<String> getLinesToWrite() {
        return linesToWrite;
    }

    public void setLinesToWrite(List<String> linesToWrite) {
        this.linesToWrite = linesToWrite;
    }

    public String getDstFile() {
        return dstFile;
    }

    public void setDstFile(String dstFile) {
        this.dstFile = dstFile;
    }

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    public String getGroup() {
        return group;
    }

    public void setGroup(String group) {
        this.group = group;
    }

    public String getPerm() {
        return perm;
    }

    public void setPerm(String perm) {
        this.perm = perm;
    }


}
