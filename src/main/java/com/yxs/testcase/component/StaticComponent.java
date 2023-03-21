package com.yxs.testcase.component;

import org.apache.shiro.subject.Subject;
import org.apache.shiro.util.ThreadContext;
import org.springframework.stereotype.Service;

/**
 * @author 洋小松
 * @date 2023/3/21
 */
@Service
public class StaticComponent {

    public String getUserId(){
        Subject localSubject = ThreadContext.getSubject();
        if (localSubject == null) {
            return null;
        }
        Object localObject = localSubject.getPrincipal();
        if (localObject != null) {
            return localObject.toString();
        }
        return null;
    }
}
