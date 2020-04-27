package sample.core.parser;


import sample.core.entity.JStatClass;
import sample.core.utils.Command;
import sample.core.utils.CommandReader;

/**
 * @Description jstat 命令解析器
 * @Author lichengyang
 * @Date 2020/4/20 22:18
 */
public class JStatResolver extends Resolver{
    private static JStatResolver instance = new JStatResolver();

    private JStatResolver() {
    }

    public static JStatResolver getInstance() {
        return instance;
    }

    //解析Jstat -class -pid
    public JStatClass getJStatClass(String pid) {
        String command = Command.JSTAT_COMMAND_0 + pid;
        CommandReader commandReader = new CommandReader(command);
        String title = commandReader.readLine();//标题
        if(null == title){
            System.out.println("ERROR->pid:"+pid+" not fund");
            return null;
        }
        String[] contents = commandReader.readLine().trim().replaceAll(" {2,}", " ").split(" ");
        return new JStatClass(contents[0], contents[1], contents[2], contents[3], contents[4]);
    }

    public static void main(String[] args) {
        getInstance().getJStatClass("6201");
    }
}
