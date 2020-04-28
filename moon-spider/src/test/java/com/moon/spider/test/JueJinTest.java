package com.moon.spider.test;

import com.moon.spider.backend.FastSpiderBackendService;
import com.moon.spider.domain.ExitWayEnum;
import com.moon.spider.domain.SpiderConfig;
import com.moon.spider.fast.FastConfigContext;
import com.moon.spider.fast.FastConfigEnum;

public class JueJinTest {
    public static void main(String[] args) {
        String userId="5b90662de51d450e8b1370f6";

        SpiderConfig config = FastConfigContext.parseConfig(FastConfigEnum.JUEJIN);
        config.setUserId(userId)
        .setExitWay(ExitWayEnum.URL_COUNT)
        .setCount(3);

        FastSpiderBackendService service=new FastSpiderBackendService(config);
        service.start();

    }
}
