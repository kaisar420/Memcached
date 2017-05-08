package iparhan.kaisar.service;

/**
 * Created by iparhan on 17-5-8.
 */
public interface TestMemcached {
    public void testSet() throws Exception;
    public void testAdd() throws Exception;
    public void testReplace();
    public void testAppend();
    public void  testCAS();
    public void testIncrDecr() throws Exception;
}
