package sample.core.center;

import java.util.concurrent.ConcurrentHashMap;

/**
 * @Description 登记所有的controller
 * @Author lichengyang
 * @Date 2020/4/27 22:59
 */
public class RegisterCenter {
    private static ConcurrentHashMap<Class, Object> controllerMap = new ConcurrentHashMap<>();

    private RegisterCenter() {
    }
    
    @SuppressWarnings("unchecked")
    public static <T> T getController(Class<T> cls) {
        return (T) controllerMap.get(cls);
    }
    
    public static void setController(Class cls, Object object) {
        controllerMap.put(cls, object);
    }
}
