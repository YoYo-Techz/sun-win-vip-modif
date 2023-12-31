package game.modules.slot.cmd.send.ndv;

import bitzero.server.extensions.data.BaseMsg;
import java.nio.ByteBuffer;

public class NDVX2Msg extends BaseMsg {
     public String ngayX2;
     public byte remain;
     public long currentMoney;

     public NDVX2Msg() {
          super((short)3009);
     }

     public byte[] createData() {
          ByteBuffer bf = this.makeBuffer();
          this.putStr(bf, this.ngayX2);
          bf.put(this.remain);
          bf.putLong(this.currentMoney);
          return this.packBuffer(bf);
     }
}
