/*
 * Decompiled with CFR 0.144.
 */
package com.vinplay.usercore.entities;

public class LogSMSPlus {
    private String nickname;
    private String mobile;
    private String moMessage;
    private int amount;
    private String shortCode;
    private String errorCode;
    private String errorMessage;
    private String requestId;
    private String requestTime;
    private int code;
    private String des;
    private int money;
    private String timeLog;

    public LogSMSPlus(String nickname, String mobile, String moMessage, int amount, String shortCode, String errorCode, String errorMessage, String requestId, String requestTime, int code, String des, int money, String timeLog) {
        this.nickname = nickname;
        this.mobile = mobile;
        this.moMessage = moMessage;
        this.amount = amount;
        this.shortCode = shortCode;
        this.errorCode = errorCode;
        this.errorMessage = errorMessage;
        this.requestId = requestId;
        this.requestTime = requestTime;
        this.code = code;
        this.des = des;
        this.money = money;
        this.timeLog = timeLog;
    }

    public LogSMSPlus() {
    }

    public String getNickname() {
        return this.nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getMobile() {
        return this.mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getMoMessage() {
        return this.moMessage;
    }

    public void setMoMessage(String moMessage) {
        this.moMessage = moMessage;
    }

    public int getAmount() {
        return this.amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public String getShortCode() {
        return this.shortCode;
    }

    public void setShortCode(String shortCode) {
        this.shortCode = shortCode;
    }

    public String getErrorCode() {
        return this.errorCode;
    }

    public void setErrorCode(String errorCode) {
        this.errorCode = errorCode;
    }

    public String getErrorMessage() {
        return this.errorMessage;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    public String getRequestId() {
        return this.requestId;
    }

    public void setRequestId(String requestId) {
        this.requestId = requestId;
    }

    public String getRequestTime() {
        return this.requestTime;
    }

    public void setRequestTime(String requestTime) {
        this.requestTime = requestTime;
    }

    public int getCode() {
        return this.code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getDes() {
        return this.des;
    }

    public void setDes(String des) {
        this.des = des;
    }

    public int getMoney() {
        return this.money;
    }

    public void setMoney(int money) {
        this.money = money;
    }

    public String getTimeLog() {
        return this.timeLog;
    }

    public void setTimeLog(String timeLog) {
        this.timeLog = timeLog;
    }
}

