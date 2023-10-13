package bitzero.util.dao;

import bitzero.util.config.bean.ConstantMercury;
import bitzero.util.datacontroller.business.DataController;
import com.google.gson.Gson;

public class JDBObject implements IDBObject {
     static final long serialVersionUID = 1L;
     private static final String SHARED_KEY = "shared";
     public static final String SEPERATOR = "_";
     public static final Gson gson = new Gson();
     protected int uId = -1;

     public JDBObject(int uId) {
          this.uId = uId;
     }

     public void save() throws Exception {
          StringBuilder builder = new StringBuilder(ConstantMercury.PREFIX_SNSGAME_GENERAL);
          builder.append(this.uId).append("_").append(this.getClass().getSimpleName());
          DataController.getController().set(builder.toString(), gson.toJson(this));
     }

     public static Object load(int uId, Class c) throws Exception {
          StringBuilder builder = new StringBuilder(ConstantMercury.PREFIX_SNSGAME_GENERAL);
          builder.append(uId).append("_").append(c.getSimpleName());
          return gson.fromJson((String)DataController.getController().get(builder.toString()), c);
     }
}
