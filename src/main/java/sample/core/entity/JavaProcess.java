package sample.core.entity;

/**
 * @Description 解析 jps -l 对应的实体类
 * @Author lichengyang
 * @Date 2020/4/20 22:16
 */

public class JavaProcess {

    private String pid;

    private String path;

    public String getPid() {
        return pid;
    }

    public void setPid(String pid) {
        this.pid = pid;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public JavaProcess(String pid, String path) {
        this.pid = pid;
        this.path = path;
    }

    public JavaProcess() {
    }
}
