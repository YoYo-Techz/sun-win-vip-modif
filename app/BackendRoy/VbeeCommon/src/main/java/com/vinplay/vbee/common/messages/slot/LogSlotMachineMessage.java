/*
 * Decompiled with CFR 0.144.
 */
package com.vinplay.vbee.common.messages.slot;

import com.vinplay.vbee.common.messages.BaseMessage;

public class LogSlotMachineMessage
extends BaseMessage {
    private static final long serialVersionUID = 1L;
    public long referenceId;
    public String gameName;
    public String username;
    public long betValue;
    public String matrix;
    public String linesBetting;
    public String linesWin;
    public String prizesOnLine;
    public short result;
    public long totalPrizes;
    public String time;
}

