package com.example.classloader;

/**
 * Created by Administrator on 2019/10/27 0027.
 */
public class LoadInfo {

    private MyClassLoader loader;
    private long time;
    private BaseManager manager;

    public LoadInfo(MyClassLoader loader, long time) {
        super();
        this.loader = loader;
        this.time = time;
    }

    public long getTime() {
        return time;
    }

    public BaseManager getManager() {
        return manager;
    }

    public void setTime(long time) {
        this.time = time;
    }

    public void setManager(BaseManager manager) {
        this.manager = manager;
    }
}

