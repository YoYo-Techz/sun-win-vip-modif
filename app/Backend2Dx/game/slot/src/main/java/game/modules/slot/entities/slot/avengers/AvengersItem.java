package game.modules.slot.entities.slot.avengers;

public enum AvengersItem {
     NONE("NONE", 0, "none", (byte)-1),
     SCATTER("SCATTER", 1, "Scatter", (byte)0),
     BONUS("BONUS", 2, "Bonus", (byte)1),
     WILD("WILD", 3, "Wild", (byte)2),
     JACK_POT("JACK_POT", 4, "Jackpot", (byte)3),
     NAM_TAY("NAM_TAY", 5, "NamTay", (byte)4),
     BUA("BUA", 6, "Bua", (byte)5),
     KHIEN("KHIEN", 7, "Khien", (byte)6),
     KIM_CUONG("KIM_CUONG", 8, "KimCuong", (byte)7),
     DAI_BANG("DAI_BANG", 9, "DaiBang", (byte)8),
     NGUOI_NHEN("NGUOI_NHEN", 10, "NguoiNhen", (byte)9),
     RADAR("RADAR", 11, "Radar", (byte)10);

     private String name;
     private byte id;

     private AvengersItem(String s, int n, String name, byte id) {
          this.name = name;
          this.id = id;
     }

     public void setName(String name) {
          this.name = name;
     }

     public String getName() {
          return this.name;
     }

     public void setId(byte id) {
          this.id = id;
     }

     public byte getId() {
          return this.id;
     }

     public static AvengersItem findItem(byte id) {
          AvengersItem[] values;
          int length = (values = values()).length;

          for(int i = 0; i < length; ++i) {
               AvengersItem entry = values[i];
               if (entry.getId() == id) {
                    return entry;
               }
          }

          return null;
     }
}
