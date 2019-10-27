package com.example.classloader;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;

/**
 * Created by Administrator on 2019/10/27 0027.
 */
public class MyClassLoader extends ClassLoader {

    private String classpath;

    public MyClassLoader(String classpath) {
        super(ClassLoader.getSystemClassLoader());
        this.classpath = classpath;
    }

    protected Class<?> findClass(String name) throws ClassNotFoundException{
        byte[] data= this.loadClassData(name);
        return this.defineClass(name, data, 0, data.length);
    }

    private byte[] loadClassData(String name) {
        try{
            name= name.replace(".", "//");
            FileInputStream is = new FileInputStream(new File(classpath+ name+ ".class"));
            ByteArrayOutputStream bos = new ByteArrayOutputStream();
            int b= 0;
            while((b= is.read())!= -1){
                bos.write(b);
            }
            is.close();
            return bos.toByteArray();
        }catch(Exception e){
            e.printStackTrace();
        }
        return null;
    }
}
