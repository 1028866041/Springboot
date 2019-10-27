package com.example.classloader;

import com.example.classloader.MessageHandler;

/**
 * Created by Administrator on 2019/10/27 0027.
 */
public class ClassloaderTest {
    public static void main(String[] args) {
        new Thread(new MessageHandler()).start();
    }
}
