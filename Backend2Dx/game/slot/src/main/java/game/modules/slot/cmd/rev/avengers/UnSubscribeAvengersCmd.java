package game.modules.slot.cmd.rev.avengers;

import bitzero.server.extensions.data.BaseCmd;
import bitzero.server.extensions.data.DataCmd;
import java.nio.ByteBuffer;

public class UnSubscribeAvengersCmd extends BaseCmd {
     public byte roomId;

     public UnSubscribeAvengersCmd(DataCmd dataCmd) {
          super(dataCmd);
          this.unpackData();
     }

     public void unpackData() {
          ByteBuffer bf = this.makeBuffer();
          this.roomId = bf.get();
     }
}
