package com.moon.cms.service.impl;

import com.moon.cms.mapper.WebSiteMapper;
import com.moon.cms.service.IWebSiteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class WebSiteService implements IWebSiteService {
    @Autowired
    private WebSiteMapper webSiteMapper;
    @Override
    public Map getSiteInfo() {
        return webSiteMapper.getSiteInfo();
    }
}
