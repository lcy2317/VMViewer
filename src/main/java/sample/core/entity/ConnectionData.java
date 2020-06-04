package sample.core.entity;

import java.io.Serializable;

/**
 * @Description 服务器连接信息
 * @Author lichengyang
 * @Date 2020/6/4 19:06
 */
public class ConnectionData implements Serializable {
    //主机
    private String host;
    //别名
    private String alias;
    //登录账号
    private String userName;
    //密码
    private String password;

    public String getHost() {
        return host;
    }

    public void setHost(String host) {
        this.host = host;
    }

    public String getAlias() {
        return alias;
    }

    public void setAlias(String alias) {
        this.alias = alias;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
