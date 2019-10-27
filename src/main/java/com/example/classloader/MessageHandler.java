package com.example.classloader;

/**
 * Created by Administrator on 2019/10/27 0027.
 */
public class MessageHandler implements Runnable {
    @Override
    public void run() {
        while(true){
            BaseManager manager =  ManagerFactory.getManager(ManagerFactory.MY_MANAGER);
            manager.manage();
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
