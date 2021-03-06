package com.wanted.exception;

import android.util.Log;

/**
 * Created by xlin2 on 2015/11/13.
 */
public class ClientException extends Exception {
    private int errNo;
    private String errMsg;

    public ClientException(ErrType type) {
        setErrNo(type.ordinal());
        setErrMsg(type.toString());
    }

    public int getErrNo() {
        return errNo;
    }

    public void setErrNo(int errNo) {
        this.errNo = errNo;
    }

    /**
     * Get error message
     * @return error message string
     */
    public String getErrMsg() {
        switch(errNo) {
            case 0:
                return "Input is empty.";
            case 1:
                return "Invalid email.";
            case 2:
                return "Invalid password.";
            default:
                return "Unknown error.";
        }
    }

    public void setErrMsg(String errMsg) {
        this.errMsg = errMsg;
    }

    /**
     * Handle the exception and write the error into log file
     */
    public void handle() {
        Log.e("Input Exception", this.toString());
        switch(errNo) {
            case 0:
                Log.e("Input Exception", "Input is empty.");
                break;
            case 1:
                Log.e("Input Exception", "Invalid email.");
                break;
            case 2:
                Log.e("Input Exception", "Invalid password.");
                break;
        }
    }
}
