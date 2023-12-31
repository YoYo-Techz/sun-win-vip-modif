package bitzero.engine.io.protocols.text;

import bitzero.engine.data.IPacket;
import bitzero.engine.data.Packet;
import bitzero.engine.io.IRequest;
import bitzero.engine.io.IResponse;
import bitzero.engine.io.Request;
import bitzero.engine.io.protocols.AbstractProtocolCodec;

public class TextProtocolCodec extends AbstractProtocolCodec {
     private String defaultControllerId = "text";

     public String getDefaultControllerId() {
          return this.defaultControllerId;
     }

     public void setDefaultControllerId(String defaultControllerId) {
          this.defaultControllerId = defaultControllerId;
     }

     public void onPacketRead(IPacket packet) {
          this.dispatchRequestToController(this.packet2Request(packet), this.defaultControllerId);
     }

     public void onPacketWrite(IResponse response) {
          IPacket packet = new Packet();
          packet.setId((Short)response.getId());
          packet.setRecipients(response.getRecipients());
          packet.setData(response.getContent());
          this.ioHandler.onDataWrite(packet);
     }

     private IRequest packet2Request(IPacket packet) {
          IRequest request = new Request();
          String message = (String)packet.getData();
          String[] slices = message.split("\\:");
          if (slices.length == 2) {
               request.setId(slices[0]);
               request.setContent(slices[1]);
          } else {
               request.setId("generic");
               request.setContent(message);
          }

          request.setSender(packet.getSender());
          return request;
     }
}
