/*
 * Decompiled with CFR 0.144.
 */
package com.vinplay._1pay;

public class BuyCardRequestObj {
    private String username;
    private String apiCode;
    private String apiUsername;
    private String requestId;
    private String serviceCode;
    private String price;
    private int quantity;
    private String dataSign;

    public String getUsername() {
        return this.username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getApiCode() {
        return this.apiCode;
    }

    public void setApiCode(String apiCode) {
        this.apiCode = apiCode;
    }

    public String getApiUsername() {
        return this.apiUsername;
    }

    public void setApiUsername(String apiUsername) {
        this.apiUsername = apiUsername;
    }

    public String getRequestId() {
        return this.requestId;
    }

    public void setRequestId(String requestId) {
        this.requestId = requestId;
    }

    public String getServiceCode() {
        return this.serviceCode;
    }

    public void setServiceCode(String serviceCode) {
        this.serviceCode = serviceCode;
    }

    public String getPrice() {
        return this.price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public int getQuantity() {
        return this.quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getDataSign() {
        return this.dataSign;
    }

    public void setDataSign(String dataSign) {
        this.dataSign = dataSign;
    }
}

