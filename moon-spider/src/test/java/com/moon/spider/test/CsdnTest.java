package com.moon.spider.test;

import com.moon.spider.backend.FastSpiderBackendService;
import com.moon.spider.domain.ExitWayEnum;
import com.moon.spider.domain.SpiderConfig;
import com.moon.spider.fast.FastConfigContext;
import com.moon.spider.fast.FastConfigEnum;

public class CsdnTest {
    public static void main(String[] args) {
        //注意要设置cookie,否则爬取不到
        String userId="u011197448";
        SpiderConfig config = FastConfigContext.parseConfig(FastConfigEnum.CSDN);
        config.setUserId(userId)
        .setExitWay(ExitWayEnum.URL_COUNT)
        .setCount(3);

        FastSpiderBackendService service=new FastSpiderBackendService(config);
        service.start();

    }
}
