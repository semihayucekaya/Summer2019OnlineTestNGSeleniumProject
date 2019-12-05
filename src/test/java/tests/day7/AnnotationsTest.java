package tests.day7;

import org.testng.Assert;
import org.testng.annotations.*;

public class AnnotationsTest {//runs only ones before beforemethod and before all tests
    @BeforeClass
    public void beforeClass(){
        System.out.println("Before Class!");
    }
    //runs only ones after aftermethod, and after all tests
    @AfterClass
    public void afterclass(){
        System.out.println("After Class!");
    }
    //runs automatically before every test
    @BeforeMethod
    public void setup(){
        //some code that will be running before every test,like:test 1,test2, test3
        //we can use annotation method with @BeforeMethos annotation

        System.out.println("Before Method!");
    }
    @AfterMethod
    public void tearDown(){
        System.out.println("After Method!");

    }
    @Test
    public void test1(){
        System.out.println("Test 1");
        Assert.assertTrue(5==5);
    }
    @Test
    public void test2(){
        System.out.println("Test 2!");
    }
    @Test
    public void test3(){
        System.out.println("Test 3!");
    }

}
