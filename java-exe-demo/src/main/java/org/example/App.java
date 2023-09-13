package org.example;

import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.core.io.ClassPathResource;
import org.springframework.util.ResourceUtils;
import org.yaml.snakeyaml.DumperOptions;
import org.yaml.snakeyaml.Yaml;

import java.io.*;
import java.util.HashMap;
import java.util.Map;

/**
 * Hello world!
 */
@SpringBootApplication()
public class App implements ApplicationRunner {
    public static void main2(String[] args) throws FileNotFoundException {
        // SpringApplication.run(App.class, args);

        File file = ResourceUtils.getFile("classpath:application.yml");
        Yaml yaml = new Yaml();
        //读入文件
        // load方法支持String，InputStream，Reader作为输入
        Iterable<Object> objects = yaml.loadAll(new FileInputStream(file));
        for (Object object : objects) {
            System.out.println(object.getClass());
            System.out.println(object);
        }

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


    public static void main(String[] args) {

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
