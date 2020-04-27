package sample.core.utils;

/**
 * @Description
 * @Author lichengyang
 * @Date 2020/4/20 22:12
 */
public class Command {
    /**
     * 功能描述: jps是用于查看有权访问的hotspot虚拟机的进程. 当未指定hostid时，默认查看本机jvm进程，否者查看指定的hostid机器上的jvm进程，此时hostid所指机器必须开启jstatd服务。 jps可以列出jvm进程lvmid，主类类名，main函数参数, jvm参数，jar名称等信息。
     *
     * 命令选项及功能:
     *
     * 没添加option的时候，默认列出VM标示符号和简单的class或jar名称.如下:
     *
     * -q :仅仅显示VM 标示，不显示jar,class, main参数等信息.
     *
     * -m:输出主函数传入的参数. 下的hello 就是在执行程序时从命令行输入的参数
     *
     * -l: 输出应用程序主类完整package名称或jar完整名称.
     *
     * -v: 列出jvm参数, -Xms20m -Xmx50m是启动程序指定的jvm参数
     *
     * -V: 输出通过.hotsportrc或-XX:Flags=<filename>指定的jvm参数
     *
     * -Joption:传递参数到javac 调用的java lancher.
     * */
    public static final String JPS_COMMAND_0 = "jps";

    public static final String JPS_COMMAND_1 = "jps -l";

    public static final String JPS_COMMAND_2 = "jps -v";

    public static final String JSTAT_COMMAND_0 = "jstat -class ";
}
