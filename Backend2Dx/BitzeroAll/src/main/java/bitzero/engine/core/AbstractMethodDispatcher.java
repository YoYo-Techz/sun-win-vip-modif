package bitzero.engine.core;

import java.lang.reflect.Method;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public abstract class AbstractMethodDispatcher implements IMethodDispatcher {
     protected Map methodDictionary = new ConcurrentHashMap();

     public void callMethod(String key, Object[] params) throws Exception {
          String methodName = (String)this.methodDictionary.get(key);
          if (methodName == null) {
               throw new IllegalArgumentException("No method was found for key: " + key);
          } else {
               Class[] arguments = new Class[params.length];
               Class clazz = this.getClass();

               for(int j = 0; j < params.length; ++j) {
                    arguments[j] = params[j].getClass();
               }

               Method method = clazz.getMethod(methodName, arguments);
               method.invoke(this, params);
          }
     }

     public void registerMethod(String key, String methodName) {
          this.methodDictionary.put(key, methodName);
     }

     public void unregisterKey(String key) {
          this.methodDictionary.remove(key);
     }
}
