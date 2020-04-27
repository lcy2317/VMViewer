package sample.core.utils;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.InputStream;
import java.io.InputStreamReader;

/**
 * @Description 解析command命令
 * @Author lichengyang
 * @Date 2020/4/20 22:12
 */
public class CommandReader implements Closeable {
    private String command;
    private Process process;
    private InputStream inputStream;
    private InputStreamReader inputStreamReader;
    private BufferedReader bufferedReader;

    public CommandReader(String command) {
        this.command = command;
        init();
    }

    private void init() {
        try {
            this.process = Runtime.getRuntime().exec(command);
            this.inputStream = process.getInputStream();
            this.inputStreamReader = new InputStreamReader(inputStream, "GBK");
            this.bufferedReader = new BufferedReader(inputStreamReader);
        } catch (Exception e) {
            System.out.println("ERROR->init fail.");
        }
    }

    public String readLine() {
        String content = null;
        try {
            content = bufferedReader.readLine();
        } catch (Exception e) {
            System.out.println("ERROR->readLine fail.");
            e.printStackTrace();
        }
        return content;
    }

    public void close() {
        try {
            this.bufferedReader.close();
            this.inputStreamReader.close();
            this.inputStream.close();
            this.process.destroyForcibly();
        } catch (Exception e) {
            System.out.println("ERROR->close fail.");
        }
    }
}
