package com.moon.web.controller.system;

import com.moon.cms.util.CmsConstants;
import com.moon.common.core.controller.BaseController;
import com.moon.common.core.domain.AjaxResult;
import com.moon.common.utils.ServletUtils;
import com.moon.common.utils.StringUtils;
import com.moon.framework.util.ShiroUtils;
import com.moon.system.domain.SysUser;
import com.moon.system.service.ISysConfigService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 登录验证
 * 
 * @author moon
 */
@Controller
public class SysLoginController extends BaseController
{
    @Autowired
    private ISysConfigService configService;

    private String getLoginPageCode(){
        return configService.selectConfigByKey(CmsConstants.KEY_LOGIN_PAGE);
    }
    @GetMapping("/login")
    public String login(HttpServletRequest request, HttpServletResponse response)
    {
        SysUser user = ShiroUtils.getSysUser();
        if(user!=null){
            return "redirect:/index";
        }
        // 如果是Ajax请求，返回Json字符串。
        if (ServletUtils.isAjaxRequest(request))
        {
            return ServletUtils.renderString(response, "{\"code\":\"1\",\"msg\":\"未登录或登录超时。请重新登录\"}");
        }
        String loginPageCode=getLoginPageCode();
        if(StringUtils.isEmpty(loginPageCode)){
            return "login";
        }else{
            //配置了login.page参数
            return "loginPage/"+loginPageCode+"/login";//页面在cms模块loginPage文件夹下
        }

    }

    @PostMapping("/login")
    @ResponseBody
    public AjaxResult ajaxLogin(String username, String password, Boolean rememberMe)
    {
        UsernamePasswordToken token = new UsernamePasswordToken(username, password, rememberMe);
        Subject subject = SecurityUtils.getSubject();
        try
        {
            subject.login(token);
            ServletUtils.setLoginCookie(username, password, rememberMe);
            return success();
        }
        catch (AuthenticationException e)
        {
            String msg = "用户或密码错误";
            if (StringUtils.isNotEmpty(e.getMessage()))
            {
                msg = e.getMessage();
            }
            return error(msg);
        }
    }

    @GetMapping("/unauth")
    public String unauth()
    {
        return "error/unauth";
    }
}
