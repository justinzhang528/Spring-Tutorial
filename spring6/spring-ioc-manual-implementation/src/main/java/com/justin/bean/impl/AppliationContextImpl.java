package com.justin.bean.impl;

import com.justin.anno.Bean;
import com.justin.bean.ApplicationContext;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.net.URL;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;

public class AppliationContextImpl implements ApplicationContext {
    // 創建map集合，放bean對象
    private Map<Class,Object> beanFactory = new HashMap<>();
    private static String rootPath;

    // 返回對象
    @Override
    public Object getBean(Class clazz) {
        return beanFactory.get(clazz);
    }

    // 創建有參構造，傳遞包路徑，設置包掃描規則
    // 當前包及子包，哪個類有@Bean註解，把這個類通過反射實例化
    public AppliationContextImpl(String basePackage) throws Exception {
        // com.justin
        // 1. 把.替換成\
        String packagePath = basePackage.replaceAll("\\.","\\\\");

        // 2. 獲取包絕對路徑
        Enumeration<URL> urls = Thread.currentThread().getContextClassLoader().getResources(packagePath);
        while(urls.hasMoreElements()){
            URL url = urls.nextElement();
            String filePath = URLDecoder.decode(url.getFile(), "utf-8");
            //獲取包前面的路徑部分，字符串截取，方便以後使用
            rootPath = filePath.substring(0,filePath.length()-packagePath.length());
            System.out.println(filePath);
            System.out.println(rootPath);
            // 包掃描
            loadBean(new File(filePath));
        }
    }

    private void loadBean(File file) throws Exception {
        // 1.判斷當前是否為文件夾
        if(file.isDirectory()){
            // 2.獲取文件夾裡面所有內容
            File[] subFiles = file.listFiles();

            // 3.判斷文件夾裡面為空，直接返回
            if(subFiles == null || subFiles.length == 0){
                return;
            }

            // 4.如果文件夾裡面不為空，遍歷文件夾所有內容
            for (File subFile:subFiles) {
                // 4.1. 遍歷得到的每個File對象，繼續判斷，如果還是文件夾，遞歸
                if(subFile.isDirectory()){
                    //遞歸
                    loadBean(subFile);
                } else {
                    // 4.2. 遍歷得到的File對象不是文件夾，是文件的話,得到包路徑+類名稱部分-字符串截取
                    String pathWithClass = subFile.getAbsolutePath().substring(rootPath.length() - 1);

                    // 4.4. 判斷當前文件類型是否.class
                    if(pathWithClass.endsWith(".class")){
                        // 4.5. 如果是.class類型，把路徑\替換成. 並把.class去掉
                        String allName = pathWithClass.replaceAll("\\\\", ".")
                                .replace(".class", "");

                        // 4.6. 判斷類上面是否有註解@Bean，如果有就實例化過程
                        Class<?> clazz = Class.forName(allName);
                        if(!clazz.isInterface()){
                            Bean annotation = clazz.getAnnotation(Bean.class);
                            if(annotation != null){
                                // 進行實例化
                                Object instance = clazz.getConstructor().newInstance();
                                // 把對象進行實例化之後，放到map集合beanFactory
                                // 判斷當前類如果有接口，讓接口class作為map的key
                                if(clazz.getInterfaces().length>0){
                                    beanFactory.put(clazz.getInterfaces()[0],instance);
                                } else { // 如果沒有接口，自己的class作為map的key
                                    beanFactory.put(clazz,instance);
                                }
                            }
                        }
                    }
                }

            }

        }
    }
}
