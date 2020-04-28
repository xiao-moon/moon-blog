package com.moon.spider.resolver;

import com.moon.spider.domain.SpiderConfig;
import us.codecraft.webmagic.Page;

/**
 * 页面解析器
 */
public interface Resolver {
    void process(Page page, SpiderConfig spiderConfig);
}
