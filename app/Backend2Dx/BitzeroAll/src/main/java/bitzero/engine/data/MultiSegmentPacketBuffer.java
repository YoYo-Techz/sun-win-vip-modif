package bitzero.engine.data;

public class MultiSegmentPacketBuffer implements IPacketBuffer {
     private byte[] segment = null;
     private byte[] data = null;
     private int position = 0;
     private int currSegment = 0;
     private int segmentSize = 1;
     private boolean multiSegment = false;

     public MultiSegmentPacketBuffer(int segmentSize) {
          this.segmentSize = segmentSize;
     }

     public MultiSegmentPacketBuffer(byte[] segment) {
          this.data = null;
          this.segment = segment;
     }

     public boolean isMultiSegment() {
          return this.multiSegment;
     }

     public int getSize() {
          return this.segment.length;
     }

     public byte[] getSegment() {
          return this.segment;
     }

     public int getPosition() {
          return this.position;
     }

     public int getRemaining() {
          return this.getSize() - this.position;
     }

     public void setSegment(byte[] segment) {
          this.segment = segment;
          this.position = 0;
     }

     public void setData(byte[] data, int segmentSize) {
          this.data = data;
          this.currSegment = 0;
          this.segmentSize = segmentSize;
          this.multiSegment = true;
     }

     public boolean hasMoreSegments() {
          boolean res = false;
          if (this.isMultiSegment()) {
               res = this.currSegment * this.segmentSize < this.data.length;
          }

          return res;
     }

     public byte[] nextSegment() {
          if (this.data == null) {
               throw new IllegalStateException("This write buffer does not allow segmentation!");
          } else {
               int sourceStart = this.currSegment * this.segmentSize;
               int amountToCopy = this.segmentSize;
               if (sourceStart >= this.data.length) {
                    throw new IllegalStateException("There's no more segmentes available!");
               } else {
                    if (sourceStart + amountToCopy >= this.data.length) {
                         amountToCopy = this.data.length - sourceStart;
                    }

                    byte[] newSegment = new byte[amountToCopy];
                    System.arraycopy(this.data, sourceStart, newSegment, 0, amountToCopy);
                    ++this.currSegment;
                    return newSegment;
               }
          }
     }

     public void forward(int delta) {
          this.position += delta;
          if (this.position >= this.getSize()) {
               this.position = this.getSize() - 1;
               throw new ArrayIndexOutOfBoundsException("position exceeds size!");
          }
     }

     public void backward(int delta) {
          this.position -= delta;
          if (this.position < 0) {
               this.position = 0;
               throw new ArrayIndexOutOfBoundsException("position is negative!");
          }
     }
}
