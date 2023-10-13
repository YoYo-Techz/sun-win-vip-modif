/*
 * Decompiled with CFR 0.144.
 *
 * Could not load the following classes:
 *  bitzero.server.extensions.data.BaseMsg
 */
package game.modules.slot.cmd.send.tamhung;

import bitzero.server.extensions.data.BaseMsg;

import java.nio.ByteBuffer;

public class ResultSlotMsg
extends BaseMsg {
    public long referenceId;
    public byte result;
    public String matrix = "";
    public String linesWin = "";
    public String haiSao = "";
    public long prize;
    public long currentMoney;
    public byte isFreeSpin = 0;
    public byte ratio = 0;
    public byte currentNumberFreeSpin = 0;

    public ResultSlotMsg() {
        super((short)14001);
    }

    public byte[] createData() {
        ByteBuffer bf = this.makeBuffer();
        bf.putLong(this.referenceId);
        bf.put(this.result);
        this.putStr(bf, this.matrix);
        this.putStr(bf, this.linesWin);
        this.putStr(bf, this.haiSao);
        bf.putLong(this.prize);
        bf.putLong(this.currentMoney);
        bf.put(this.isFreeSpin); // co phai quay freeSpin hay khong
        bf.put(this.ratio); // so luong free spin thang
        bf.put(this.currentNumberFreeSpin); // so luong freeSpin con lai
        return this.packBuffer(bf);
    }
}

