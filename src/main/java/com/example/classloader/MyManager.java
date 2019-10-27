package com.example.classloader;

/**
 * Created by Administrator on 2019/10/27 0027.
 */
public class MyManager implements BaseManager{
    @Override
    public void manage() {
        System.out.println("classloader");
    }
}
