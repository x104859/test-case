package com.yxs.testcase.componet;

import org.junit.*;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author 洋小松
 * @date 2023/4/4
 */
@RunWith(MockitoJUnitRunner.class)
public class AnnotationTest {
    public static final Logger log = LoggerFactory.getLogger(AnnotationTest.class);
    @Before
    public void init(){
        log.info("@Before call");
    }
    @BeforeClass
    public static void beforeClass(){
        log.info("@BeforeClass call");
    }

    @After
    public void after(){
        log.info("@After call");
    }

    @AfterClass
    public static void afterClass(){
        log.info("@AfterClass call");
    }

    @Test
    public void test01(){
        log.info("test01 call");
    }

    @Test
    public void test02(){
        log.info("test02 call");
    }
}
