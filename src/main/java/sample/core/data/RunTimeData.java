package sample.core.data;

import sample.core.entity.JavaProcess;

import java.util.List;

/**
 * @Description
 * @Author lichengyang
 * @Date 2020/6/4 18:43
 */
public class RunTimeData {
    //正在连接的pid
    private volatile String Pid;
    //当前主机上的Java进程;
    private volatile List<JavaProcess> JavaProcess;


    public synchronized String getPid() {
        return Pid;
    }

    public synchronized void setPid(String pid) {
        Pid = pid;
    }

    public synchronized List<sample.core.entity.JavaProcess> getJavaProcess() {
        return JavaProcess;
    }

    public synchronized void setJavaProcess(List<sample.core.entity.JavaProcess> javaProcess) {
        JavaProcess = javaProcess;
    }

    private RunTimeData() {
    }

    public static RunTimeData getInstences() {
        return new RunTimeData();
    }
}
