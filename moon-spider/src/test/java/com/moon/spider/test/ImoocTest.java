package com.moon.spider.test;

import com.moon.spider.backend.FastSpiderBackendService;
import com.moon.spider.domain.ExitWayEnum;
import com.moon.spider.domain.SpiderConfig;
import com.moon.spider.fast.FastConfigContext;
import com.moon.spider.fast.FastConfigEnum;

public class ImoocTest {
    public static void main(String[] args) {
        String userId="1175248";
        SpiderConfig config = FastConfigContext.parseConfig(FastConfigEnum.IMOOC);
        config.setUserId(userId)
                .setExitWay(ExitWayEnum.URL_COUNT)
                .setCount(3);

        FastSpiderBackendService service=new FastSpiderBackendService(config);
        service.start();
    }
}
