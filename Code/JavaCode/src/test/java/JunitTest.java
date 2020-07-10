package test.java;


import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;

import main.java.BreakPointTest;

public class JunitTest {

    @BeforeClass
    public static void fun1() {
        System.out.println("@BeforeClass");
    }
    @After
    public void fun2() {
        System.out.println("@After");
    }
    @Before
    public void fun3() {
        System.out.println("@Before");
    }
    @AfterClass
    public static void fun4() {
        System.out.println("@AfterClass");
    }
    @Ignore
    public void fun5() {
        System.out.println("@Ignore");
    }
    @Test
    public void fun() {
        BreakPointTest breakPointTest = new BreakPointTest();
        breakPointTest.fun();
    }
}
