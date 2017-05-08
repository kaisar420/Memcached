package iparhan.kaisar.client;

import iparhan.kaisar.impl.TestMemcachedImpl;

import java.io.IOException;

/**
 * Created by iparhan on 17-5-8.
 */
public class TestMain {
     TestMemcachedImpl testMemcached= new TestMemcachedImpl();

    public TestMain() throws Exception {
        System.out.println("TestMain");
    }


    public static void main(String[] args) throws Exception {
        //init class
        TestMain testMain =  new TestMain();
        //invoke testSet function
        testMain.testMemcached.testSet();
        //invoke testAdd function
        testMain.testMemcached.testAdd();
        //replace
        testMain.testMemcached.testReplace();
        //append
        testMain.testMemcached.testAppend();
        //incr/decr
        testMain.testMemcached.testIncrDecr();
    }

    }

