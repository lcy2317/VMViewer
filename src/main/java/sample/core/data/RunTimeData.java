package sample.core.data;

import sample.core.entity.ConnectionData;
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
    //所有连接信息
    private volatile List<ConnectionData> connectionList;


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

    public synchronized List<ConnectionData> getConnectionList() {
        return connectionList;
    }

    public synchronized void setConnectionList(List<ConnectionData> connectionList) {
        this.connectionList = connectionList;
    }


    private RunTimeData() {
    }

    public static RunTimeData getInstences() {
        return new RunTimeData();
    }
}
