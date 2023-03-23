package com.yxs.testcase.component;

import org.springframework.stereotype.Service;

/**
 * @author 洋小松
 * @date 2023/3/23
 */
@Service
public class PrivateComponent {

    public Integer entranceMethod(Integer i){
        methodA(i);
        System.out.println("call methodA end");
        i = methodB(i);
        System.out.println("call methodB end");
        i = methodC(i);
        System.out.println("call methodC end");
        return i;
    }

    private void methodA(Integer i){
        System.out.println("do methodA i = " + i);
        methodA2(i);
    }

    private void methodA2(Integer i){
        System.out.println("do methodA2 i = " + i);
    }

    private Integer methodB(Integer i){
        ++i;
        System.out.println("do methodB");
        return i;
    }

    private Integer methodC(Integer i){
        ++i;
        System.out.println("do methodC");
        return i;
    }
}
