package org.example;

import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.core.io.ClassPathResource;
import org.yaml.snakeyaml.DumperOptions;
import org.yaml.snakeyaml.Yaml;

import java.io.*;
import java.lang.management.ManagementFactory;
import java.util.HashMap;
import java.util.Map;

/**
 * Hello world!
 */
@SpringBootApplication()
public class App implements ApplicationRunner {
    public static void main(String[] args) throws FileNotFoundException {
        SpringApplication.run(App.class, args);


        // get name representing the running Java virtual machine.
        String name = ManagementFactory.getRuntimeMXBean().getName();
        System.out.println(name);
        // get pid
        String pid = name.split("@")[0];
        System.out.println("Pid is:" + pid); //  7928@sixsix

        System.out.println(excuteCMDCommand(pid));


    }

    /**
     * Callback used to run the bean.
     *
     * @param args incoming application arguments
     * @throws Exception on error
     */
    @Override
    public void run(ApplicationArguments args) throws Exception {
        System.out.println("hello world");

        System.out.println(System.getProperty("user.dir"));
    }


    /**
     * 执行一个cmd命令
     *
     * @param cmdCommand cmd命令
     * @return 命令执行结果字符串，如出现异常返回null
     */
    public static String excuteCMDCommand(String cmdCommand) {

        String pre = "TASKKILL /F /FI PID ge " + cmdCommand;
        System.out.println("pre = " + pre);
        StringBuilder stringBuilder = new StringBuilder();
        Process process = null;
        try {
            process = Runtime.getRuntime().exec(pre);
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(process.getInputStream(), "GBK"));
            String line = null;
            while ((line = bufferedReader.readLine()) != null) {
                stringBuilder.append(line + "\n");
            }
            return stringBuilder.toString();
        }
        catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }


    public static void main2(String[] args) {

        ClassPathResource resource = new ClassPathResource("application.yml");
//        InputStream asStream = this.getClass().getClassLoader().getResourceAsStream("application.yml");

        // 读取YAML文件
        try (InputStream inputStream = resource.getInputStream();) {
            Yaml yaml = new Yaml();
            // 将YAML文件内容加载到Map中
            Map<String, Object> data = yaml.load(inputStream);

            for (String s : data.keySet()) {
                System.out.println(s + " : " + data.get(s));
            }

            // 修改数据
//            HashMap<String, Object> value = new HashMap<>();

            HashMap<String, HashMap<String, Object>> value = new HashMap<>();
            HashMap<String, Object> objectObjectHashMap = new HashMap<>();
            objectObjectHashMap.put("a", 1);
            objectObjectHashMap.put("dsa", 1);
            objectObjectHashMap.put("idCard", "sdasjkldjas");
            objectObjectHashMap.put("qwqw", 1);
            HashMap<String, Object> objectObjectHashMap2 = new HashMap<>();
            objectObjectHashMap2.put("a", 1);
            objectObjectHashMap2.put("dsa", 1);
            objectObjectHashMap2.put("dsadsa", "sdasjkldjas");
            objectObjectHashMap2.put("qwqw", 1);
            HashMap<String, Object> objectObjectHashMap3 = new HashMap<>();

            if (objectObjectHashMap3.size() != 0) {
                value.put("password", objectObjectHashMap3);
            }
            value.put("age", objectObjectHashMap);
            value.put("username", objectObjectHashMap2);

            data.put("user", value);

            // 写入YAML文件（保持原格式）
            DumperOptions options = new DumperOptions();
            options.setDefaultFlowStyle(DumperOptions.FlowStyle.BLOCK); // 保持块状格式
            yaml = new Yaml(options);
            FileWriter writer = new FileWriter(resource.getFile());
            yaml.dump(data, writer);


            System.out.println("YAML文件修改成功！");
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }

}
