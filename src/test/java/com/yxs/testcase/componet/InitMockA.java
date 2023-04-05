package com.yxs.testcase.componet;

import org.junit.Before;
import org.junit.Test;
import org.mockito.MockitoAnnotations;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author 洋小松
 * @date 2023/4/4
 */
public class InitMockA {

    public static final Logger log = LoggerFactory.getLogger(InitMockA.class);

    @Before
    public void init(){
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void test01(){
        log.info("run test01");
    }
}
