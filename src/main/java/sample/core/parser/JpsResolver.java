package sample.core.parser;


import sample.core.entity.JavaProcess;
import sample.core.utils.Command;
import sample.core.utils.CommandReader;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @Description jps 解析器
 * @Author lichengyang
 * @Date 2020/4/20 22:20
 */
public class JpsResolver extends Resolver{

    //解析 jps -l
    public static List<JavaProcess> getJpsList() {
        String command = Command.JPS_COMMAND_1;
        List<JavaProcess> javaProcessList = new ArrayList<>();
        try (CommandReader commandReader = new CommandReader(command)) {
            String content = commandReader.readLine();
            while (content != null) {
                String[] str = content.split(" ");
                JavaProcess javaProcess = new JavaProcess();
                if (str.length == 2) {
                    javaProcess.setPid(str[0]);
                    javaProcess.setPath(str[1]);
                } else {
                    javaProcess.setPid(str[0]);
                    javaProcess.setPath("");
                }
                javaProcessList.add(javaProcess);
                content = commandReader.readLine();
            }
        } catch (Exception e) {
            System.out.println("ERROR->" + command + "parse fail.");
        }
        return javaProcessList.stream()
                .sorted(Comparator.comparing(JavaProcess::getPid))
                .collect(Collectors.toList());
    }

    //解析 jps -v
    public static String getVMSettings() {
        String command = Command.JPS_COMMAND_2;
        CommandReader commandReader = new CommandReader(command);
        String content = commandReader.readLine();
        while (content != null) {
            System.out.println(content);
            content = commandReader.readLine();
        }
        return content;
    }

}
