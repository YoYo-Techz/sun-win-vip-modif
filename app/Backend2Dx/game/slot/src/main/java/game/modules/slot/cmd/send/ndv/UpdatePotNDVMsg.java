package game.modules.slot.cmd.send.ndv;

import bitzero.server.extensions.data.BaseMsg;
import java.nio.ByteBuffer;

public class UpdatePotNDVMsg extends BaseMsg {
     public long value;
     public byte x2 = 0;

     public UpdatePotNDVMsg() {
          super((short)3002);
     }

     public byte[] createData() {
          ByteBuffer bf = this.makeBuffer();
          bf.putLong(this.value);
          bf.put(this.x2);
          return this.packBuffer(bf);
     }
}
