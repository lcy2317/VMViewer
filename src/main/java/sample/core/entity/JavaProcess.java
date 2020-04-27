package sample.core.entity;

import lombok.Data;

/**
 * @Description 解析 jps -l 对应的实体类
 * @Author lichengyang
 * @Date 2020/4/20 22:16
 */
@Data
public class JavaProcess {

    private String pid;

    private String path;
}
