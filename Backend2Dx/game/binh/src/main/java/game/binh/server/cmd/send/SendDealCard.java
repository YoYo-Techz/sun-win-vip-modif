/*
 * Decompiled with CFR 0.144.
 * 
 * Could not load the following classes:
 *  bitzero.server.extensions.data.BaseMsg
 */
package game.binh.server.cmd.send;

import bitzero.server.extensions.data.BaseMsg;
import java.nio.ByteBuffer;

public class SendDealCard
extends BaseMsg {
    public byte[] cards = new byte[13];
    public int maubinh = 0;
    public int gameId;

    public SendDealCard() {
        super((short)3105);
    }

    public byte[] createData() {
        ByteBuffer bf = this.makeBuffer();
        this.putByteArray(bf, this.cards);
        bf.put((byte)this.maubinh);
        bf.putInt(this.gameId);
        bf.put((byte)60);
        return this.packBuffer(bf);
    }
}

