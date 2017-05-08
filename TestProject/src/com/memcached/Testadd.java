package com.memcached;

import net.spy.memcached.MemcachedClient;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.util.concurrent.Future;

/**
 * Created by iparhan on 17-5-8.
 */
public class Testadd {
    /**
     * main
     * @param args
     */
    public static void main(String[] args) {
        try {
            Testset testset = new Testset();
            testset.setMemcached();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public void Testadd(){


    }

    }

