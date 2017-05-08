package com.memcached;

import com.danga.MemCached.MemCachedClient;
import com.danga.MemCached.SockIOPool;

import java.util.Date;

/**
 * Created by iparhan on 17-5-8.
 */
public class TestMemcached {
    protected  static MemCachedClient memCachedClient = new MemCachedClient();
    protected static  TestMemcached testMemcached = new TestMemcached();

    static {
        String[] server = {"127.0.0.1:11211 "};
        Integer[] weight = {3};

        SockIOPool sockIOPool = SockIOPool.getInstance();

        sockIOPool.setServers(server);
        sockIOPool.setWeights(weight);

        sockIOPool.setInitConn(5);
        sockIOPool.setMinConn(5);
        sockIOPool.setMaxConn(250);
        sockIOPool.setMaxIdle(1000*60*6*6);

        sockIOPool.setMaintSleep(30);

        //TCP
        sockIOPool.setNagle(false);
        sockIOPool.setSocketTO(3000);
        sockIOPool.setSocketConnectTO(0);

        sockIOPool.initialize();

       // memCachedClient.setCompressEnable(true);
        //memCachedClient.setCompressThreshold(64*1024);


    }

    /**
     * Constrctor
     */
    public TestMemcached() {
    }

    public static TestMemcached getInstance(){
        return testMemcached;
    }

    /**
     * add a value to Cache
     */
    public boolean add(String key ,Object value){
        return memCachedClient.add(key,value);
    }

    public boolean add(String key , Object value ,Date expiry){
        return memCachedClient.add(key,value,expiry);
    }

    public  boolean replace (String key ,Object value){
        return  memCachedClient.replace(key,value);
    }

    public boolean replace(String key , Object value ,Date expiry){
        return memCachedClient.replace(key,value,expiry);
    }


    /*
    get Object from memcached
     */
    public Object get(String key){
        return memCachedClient.get(key);
    }

    /*
    main
     */
    public static void main(String[] args) {
        TestMemcached testMemcached = TestMemcached.getInstance();
        testMemcached.add("hello",234);
        System.out.println(testMemcached.get("hello"));
    }


}
