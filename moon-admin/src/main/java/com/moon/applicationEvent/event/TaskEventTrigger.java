package com.moon.applicationEvent.event;

import com.alibaba.fastjson.JSON;
import com.moon.applicationEvent.ApplicationEvent;
import com.moon.applicationEvent.ApplicationEventDefined;
import com.moon.applicationEvent.IApplicationEvent;
import org.springframework.stereotype.Component;

/**
 * 定时任务被触发或者被手工触发
 */
@ApplicationEvent({ApplicationEventDefined.ON_SCHEDULER_EXECUTED, ApplicationEventDefined.ON_SCHEDULER_EXECUTED_BY_HAND})
@Component
public class TaskEventTrigger  implements IApplicationEvent {
    @Override
    public void onTrigger(Object source, Object params) {
        System.out.println("系统任务被触发："+source.toString()+"\t\t"+ JSON.toJSONString(params));
    }
}
