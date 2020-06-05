package sample.core.entity;

/**
 * @Description 解析jstat -class pid对应的实体类
 * @Author lichengyang
 * @Date 2020/4/20 22:14
 */

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

    public String getLoaded() {
        return loaded;
    }

    public void setLoaded(String loaded) {
        this.loaded = loaded;
    }

    public String getLoadedSize() {
        return loadedSize;
    }

    public void setLoadedSize(String loadedSize) {
        this.loadedSize = loadedSize;
    }

    public String getUnloaded() {
        return unloaded;
    }

    public void setUnloaded(String unloaded) {
        this.unloaded = unloaded;
    }

    public String getUnloadedSize() {
        return unloadedSize;
    }

    public void setUnloadedSize(String unloadedSize) {
        this.unloadedSize = unloadedSize;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }
}
