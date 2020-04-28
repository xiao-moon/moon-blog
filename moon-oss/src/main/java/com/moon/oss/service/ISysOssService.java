package com.moon.oss.service;

import com.moon.oss.domain.SysOss;

import java.util.List;

/**
 * 文件上传
 */
public interface ISysOssService
{
    /**
     * 列表查询方法
     * @param sysOss
     * @return
     * @author zmr
     */
    List<SysOss> getList(SysOss sysOss);

    /**
     * @param ossEntity
     * @author zmr
     */
    int save(SysOss ossEntity);

    /**
     * @param ossId
     * @return
     * @author zmr
     */
    SysOss findById(Long ossId);

    /**
     * @param sysOss
     * @return
     * @author zmr
     */
    int update(SysOss sysOss);

    /**
     * @param ids
     * @return
     * @author zmr
     */
    int deleteByIds(String ids);
}
