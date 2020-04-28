package com.moon.common.exception.user;

/**
 * 用户锁定异常类
 * 
 * @author moon
 */
public class UserBlockedException extends UserException
{
    private static final long serialVersionUID = 1L;

    public UserBlockedException()
    {
        super("user.blocked", null);
    }
}
