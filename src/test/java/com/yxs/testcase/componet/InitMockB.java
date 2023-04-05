package com.yxs.testcase.componet;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author 洋小松
 * @date 2023/4/4
 */
@RunWith(MockitoJUnitRunner.class)
public class InitMockB {
    public static final Logger log = LoggerFactory.getLogger(InitMockB.class);
    @Test
    public void test01(){
        log.info("run test01");
    }
}
