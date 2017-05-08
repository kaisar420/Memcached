package com.memcached;
import net.spy.memcached.MemcachedClient;
import java.net.InetSocketAddress;
import java.util.concurrent.Future;
/**
 * Created by iparhan on 17-5-8.
 */
public class Testset {
    public static void main(String[] args) {
        Testset testset = new Testset();
        testset.setMemcached();
    }
        public void  setMemcached(){
            try{
                MemcachedClient memcachedClient = new MemcachedClient(new InetSocketAddress("127.0.0.1",11211));
                System.out.println("SUCCESS");
                /**
                 * store data
                 * key ==  kasiar
                 * expriy time == 900seconds
                 * value == freeEducation
                 */
                Future future = memcachedClient.set("kaisar",1,"freeEducation");
                //check store status
                System.out.println(future.get());
                //print value
                System.out.println(memcachedClient.get("kaisar"));
                //shutdown
                memcachedClient.shutdown();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

    }

