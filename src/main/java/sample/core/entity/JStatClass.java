package sample.core.entity;

import lombok.Data;

/**
 * @Description 解析jstat -class pid对应的实体类
 * @Author lichengyang
 * @Date 2020/4/20 22:14
 */
@Data
public class JStatClass {

    private String loaded;

    private String loadedSize;

    private String unloaded;

    private String unloadedSize;

    private String time;

    public JStatClass(String loaded, String loadedSize, String unloaded, String unloadedSize, String time) {
        this.loaded = loaded;
        this.loadedSize = loadedSize;
        this.unloaded = unloaded;
        this.unloadedSize = unloadedSize;
        this.time = time;
    }
}
