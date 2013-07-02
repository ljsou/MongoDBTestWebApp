/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package test.mongodb.test;

import junit.framework.TestCase;
import test.mongodb.control.MongoDBManagedBean;

/**
 *
 * @author javier
 */
public class MongoDBManagedBeanTest extends TestCase {

    private String collName;

    public MongoDBManagedBeanTest(String testName) {
        super(testName);
    }

    @Override
    protected void setUp() throws Exception {
        super.setUp();
        this.collName = "users";
    }

    @Override
    protected void tearDown() throws Exception {
        super.tearDown();
    }

    /**
     * Test of test method, of class MongoDBManagedBean.
     */
    public void testTest() {
        System.out.println("\ntest");
        MongoDBManagedBean instance = new MongoDBManagedBean();
        instance.test();
    }

    /**
     * Test of testB method, of class MongoDBManagedBean.
     */
    public void testTestB() {
        System.out.println("\ntestB");
        MongoDBManagedBean instance = new MongoDBManagedBean();
        String expResult = "{ \"_id\" : 2.0 , \"nombre\" : \"Leidy\" , \"apellido\" : \"Suarez\" , \"edad\" : 24.0 , \"nacimiento\" : \"May 31, 1986\" , \"premios\" : [ \"x\" , \"y\" , \"z\"]}";
        String result = instance.testB(this.collName);
        assertEquals(expResult, result);
    }

    /**
     * Test of testC method, of class MongoDBManagedBean.
     */
    public void testTestC() {
        System.out.println("\ntestC");
        MongoDBManagedBean instance = new MongoDBManagedBean();
        String expResult = "{ \"_id\" : 2.0 , \"nombre\" : \"Leidy\" , \"apellido\" : \"Suarez\" , \"edad\" : 24.0 , \"nacimiento\" : \"May 31, 1986\" , \"premios\" : [ \"x\" , \"y\" , \"z\"]}";
        String result = instance.testC(this.collName);
        assertEquals(expResult, result);
    }

    /**
     * Test of testD method, of class MongoDBManagedBean.
     */
    public void testTestD() {
        System.out.println("\ntestD");
        MongoDBManagedBean instance = new MongoDBManagedBean();
        String expResult = "{ \"_id\" : 2.0 , \"nombre\" : \"Leidy\" , \"apellido\" : \"Suarez\" , \"edad\" : 24.0 , \"nacimiento\" : \"May 31, 1986\" , \"premios\" : [ \"x\" , \"y\" , \"z\"]}\n"
                + "{ \"_id\" : 3 , \"nombre\" : \"Luis\" , \"apellido\" : \"Suarez\" , \"edad\" : 54 , \"nacimiento\" : 1959 , \"premios\" : [ \"d\" , \"f\" , \"g\"]}" + "\n";
        String result = instance.testD(this.collName);
        assertEquals(expResult, result);
    }

    /**
     * Test of testE method, of class MongoDBManagedBean.
     */
    public void testTestE() {
        System.out.println("\ntestE");
        MongoDBManagedBean instance = new MongoDBManagedBean();
        String expResult = "{ \"_id\" : 2.0 , \"nombre\" : \"Leidy\" , \"apellido\" : \"Suarez\" , \"edad\" : 24.0 , \"nacimiento\" : \"May 31, 1986\" , \"premios\" : [ \"x\" , \"y\" , \"z\"]}\n" +
"{ \"_id\" : 3 , \"nombre\" : \"Luis\" , \"apellido\" : \"Suarez\" , \"edad\" : 54 , \"nacimiento\" : 1959 , \"premios\" : [ \"d\" , \"f\" , \"g\"]}\n" +
"{ \"_id\" : 4 , \"nombre\" : \"Gilma\" , \"apellido\" : \"Meza\" , \"edad\" : 45 , \"nacimiento\" : \"Jul 21, 1968\" , \"premios\" : [ \"t\" , \"r\" , \"d\"]}\n" +
"";
        String result = instance.testE(this.collName);
        assertEquals(expResult, result);
    }
}
