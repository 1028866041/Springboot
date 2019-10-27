package com.example.classloader;

import java.io.File;
import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Administrator on 2019/10/27 0027.
 */
public class ManagerFactory {

    private static final Map<String, LoadInfo> loader = new HashMap<>();
    public static final String CLASS_PATH= "E:\\JavaProjects\\Springboot\\target\\classes\\com\\example\\classloader\\";
    public static final String MY_MANAGER = "com.example.classloader.MyManager";

    public static BaseManager getManager(String className){

        File loadFile = new File(CLASS_PATH+ className.replaceAll("\\.","/")+ ".class");
        long modify = loadFile.lastModified();
        if(loader.get(className)== null){
            load(className, modify);
        }else if(loader.get(className).getTime() != modify) {
            load(className, modify);
        }
        return loader.get(className).getManager();
    }

    public static void load(String classname, long modify){
        MyClassLoader myClassLoader = new MyClassLoader(CLASS_PATH);
        Class<?> loadClass = null;
        try{
            loadClass = myClassLoader.loadClass(classname);
        }catch(ClassNotFoundException e){
            e.printStackTrace();
        }

        BaseManager manager = newInstance(loadClass);
        LoadInfo loadInfo = new LoadInfo(myClassLoader, modify);
        loadInfo.setManager(manager);
        loader.put(classname, loadInfo);
    }

    private static BaseManager newInstance(Class<?> loadClass) {
        try {
             return (BaseManager)loadClass.getConstructor(new Class[]{}).newInstance(new Object[]{});
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }
        return null;
    }
}
