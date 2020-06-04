package sample.core.utils;

import java.io.*;

/**
 * @Description 序列化
 * @Author lichengyang
 * @Date 2020/6/4 19:15
 */
public class SerializeUtil<T> {
    /**
     * 序列化对象到文件
     *
     * @param fileName
     */
    public void serialize(String fileName, Object object) {
        try {
            ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(fileName));
            out.writeObject(object);
            out.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 从文件中反序列化对象
     *
     * @param fileName
     */
    @SuppressWarnings("unchecked")
    public T deserialize(String fileName) {
        try {
            File file = new File(fileName);
            if(!file.exists()){
                return null;
            }
            ObjectInputStream in = new ObjectInputStream(new FileInputStream(fileName));
            return (T) in.readObject();
        } catch (Exception e) {
            System.out.println("读取失败");
        }
        return null;
    }
}


