package sample.core.center;

import java.util.concurrent.ConcurrentHashMap;

/**
 * @Description 登记所有的controller
 * @Author lichengyang
 * @Date 2020/4/27 22:59
 */
public class RegisterCenter {
    private static ConcurrentHashMap<String, Object> controllerMap = new ConcurrentHashMap<>();

    private RegisterCenter() {
    }


    public static ConcurrentHashMap getInstance() {
        return controllerMap;
    }
}
