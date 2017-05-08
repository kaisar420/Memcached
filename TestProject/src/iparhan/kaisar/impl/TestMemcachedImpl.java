package iparhan.kaisar.impl;

import iparhan.kaisar.service.TestMemcached;
import net.spy.memcached.CASResponse;
import net.spy.memcached.CASValue;
import net.spy.memcached.MemcachedClient;

import java.net.InetSocketAddress;
import java.util.concurrent.Future;

/**
 * Created by iparhan on 17-5-8.
 */
public class TestMemcachedImpl  implements TestMemcached{
    //util
    private MemcachedClient memcachedClient = new MemcachedClient(new InetSocketAddress("127.0.0.1",11211));
    private Future set = memcachedClient.set("?",0,"?");
    private Future add = memcachedClient.add("?",0,"?");
    private Future replace = memcachedClient.replace("?",0,"?");
    private Future append = memcachedClient.append("?",0);
    private CASResponse cas = memcachedClient.cas("?",0,"?");


    public TestMemcachedImpl() throws Exception {
        System.out.println("Impl Exception");
    }

    /**
     * set function
     * @throws Exception
     */
    @Override
    public void testSet() throws Exception {
        //store data
        try {
            //Future future = memcachedClient.set("anwar",900,"ukam");
            //System.out.println(future.get());
            //System.out.println(memcachedClient.get("anwar"));
           // memcachedClient.shutdown();

            set = memcachedClient.set("anwar",9000,"ukamm");
            System.out.println(set.get());
            System.out.println(memcachedClient.get("anwar"));
            //memcachedClient.shutdown();
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    /**
     * add function
     */
    @Override
    public void testAdd() throws Exception {
        try {
            //add data
            TestMemcachedImpl testMemcached = new TestMemcachedImpl();
            testMemcached.testSet();
            add = memcachedClient.add("Stanford", 9000, "USA");
            System.out.println(add.get());
            System.out.println(memcachedClient.get("Stanford"));
            //memcachedClient.shutdown();
        }catch (Exception e){
            e.printStackTrace();
        }





    }

    /**
     * Replace
     */
    @Override
    public void testReplace() {
        try{
            TestMemcachedImpl testMemcached = new TestMemcachedImpl();
            testMemcached.testAdd();
            replace = memcachedClient.replace("anwar",900,"Bugvr of Xinjiang");
            System.out.println(replace.get());
            System.out.println(memcachedClient.get("anwar"));
           // memcachedClient.shutdown();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    /**
     * testAppend
     */
    @Override
    public void testAppend() {
        try{
            TestMemcachedImpl testMemcached = new TestMemcachedImpl();
            testMemcached.testSet();
            append = memcachedClient.append("anwar",900);
            System.out.println(append.get());
            System.out.println(memcachedClient.get("anwar"));

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * CAS
     */
    @Override
    public void testCAS() {
        try {
            TestMemcachedImpl testMemcached = new TestMemcachedImpl();
            testMemcached.testSet();
            CASValue casValue = (CASValue) memcachedClient.get("anwar");
            System.out.println(casValue);
            cas = memcachedClient.cas("anwar",900,"Korla Xinjiang");
            System.out.println(cas);
            System.out.println(memcachedClient.get("anwar"));
        }catch (Exception e){
            e.printStackTrace();
        }

    }

    /**
     * Incr/Decr
     */
    @Override
    public void testIncrDecr() throws Exception {
      set = memcachedClient.set("number",900,"1000");
      System.out.println(set);
      System.out.println(memcachedClient.get("number"));
      System.out.println(memcachedClient.incr("number",20));
      System.out.println(memcachedClient.decr("number",30));
    }


}
