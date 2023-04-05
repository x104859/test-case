package com.yxs.testcase.componet;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.List;

@RunWith(MockitoJUnitRunner.class)
public class VerifyTest {

    @Test
    public void test(){
        List list = Mockito.mock(List.class);
        list.add("a");
        //Mockito.times()不写默认指调用1次
        Mockito.verify(list).add("a");
        Mockito.verify(list,Mockito.times(1)).add("a");
        //判读list.add方法被调用2次
        list.add("a");
        Mockito.verify(list,Mockito.times(2)).add("a");
    }
}
