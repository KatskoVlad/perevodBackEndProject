package com.bank.perevod.domain.to;

import java.sql.Date;
import java.util.Objects;

public class Process {

        private static final String STATUS_PEREVODA = "Correct process";

        private int procUser_id;
        private int procRole_id;
        private int procPerevod_id;
        private int procAccount_id;
        private int procBank_id;
        private int procCard_id;
        private String statusProc;

    public Process() {
        statusProc = STATUS_PEREVODA;
    }

    public int getProcUser_id() {
        return procUser_id;
    }

    public void setProcUser_id(int procUser_id) {
        this.procUser_id = procUser_id;
    }

    public int getProcRole_id() {
        return procRole_id;
    }

    public void setProcRole_id(int procRole_id) {
        this.procRole_id = procRole_id;
    }

    public int getProcPerevod_id() {
        return procPerevod_id;
    }

    public void setProcPerevod_id(int procPerevod_id) {
        this.procPerevod_id = procPerevod_id;
    }

    public int getProcAccount_id() {
        return procAccount_id;
    }

    public void setProcAccount_id(int procAccount_id) {
        this.procAccount_id = procAccount_id;
    }

    public int getProcBank_id() {
        return procBank_id;
    }

    public void setProcBank_id(int procBank_id) {
        this.procBank_id = procBank_id;
    }

    public int getProcCard_id() {
        return procCard_id;
    }

    public void setProcCard_id(int procCard_id) {
        this.procCard_id = procCard_id;
    }

    public String getStatusProc() {
        return statusProc;
    }

    public void setStatusProc(String statusProc) {
        this.statusProc = statusProc;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Process process = (Process) o;
        return procUser_id == process.procUser_id &&
                procRole_id == process.procRole_id &&
                procPerevod_id == process.procPerevod_id &&
                procAccount_id == process.procAccount_id &&
                procBank_id == process.procBank_id &&
                procCard_id == process.procCard_id &&
                statusProc.equals(process.statusProc);
    }

    @Override
    public int hashCode() {
        return Objects.hash(procUser_id, procRole_id, procPerevod_id, procAccount_id, procBank_id, procCard_id, statusProc);
    }

    @Override
    public String toString() {
        return "Process{" +
                "procUser_id=" + procUser_id +
                ", procRole_id=" + procRole_id +
                ", procPerevod_id=" + procPerevod_id +
                ", procAccount_id=" + procAccount_id +
                ", procBank_id=" + procBank_id +
                ", procCard_id=" + procCard_id +
                ", statusProc='" + statusProc + '\'' +
                '}';
    }
}
