package com.github.seedm.service.shiro;

import com.github.seedm.repository.vo.seed.AccountVo;
import com.github.seedm.service.IAccountService;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * 自定义账号相关的Shiro安全实体数据源
 */
public class AccountRealm extends AuthorizingRealm {

    private final Logger logger = LoggerFactory.getLogger(AccountRealm.class);

    @Autowired
    private IAccountService accountService;

    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
        this.logger.info("===============用户授权认证===============");
        //获取账号
        String account = principals.getPrimaryPrincipal().toString();
//        AccountVo accountVO = new AccountVo();
//        accountVO.setMobile(mobile);
//        SimpleAuthorizationInfo simpleAuthorizationInfo = new SimpleAuthorizationInfo();
//        simpleAuthorizationInfo.setRoles();
//        simpleAuthorizationInfo.addObjectPermissions();
        return null;
    }

    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
        this.logger.info("===============用户登陆认证===============");
        //账号已冻结
        final int ACCOUNT_LOCKED = 2;
        //获取账号
        String account = token.getPrincipal().toString();
        //获取密码
        String password = new String((char[]) token.getCredentials());

        AccountVo condition = new AccountVo();
        condition.setMobile(account);
        AccountVo accountVo = null;
//        AccountVo accountVo = this.accountService.queryActive(condition);
//
//        if (accountVo == null || !accountVo.getMobile().equals(account)) {
//            //账号不存在抛出异常
//            throw new UnknownAccountException();
//        }else if (!accountVo.getPassword().equals(password)) {
//            //错误的密码抛出异常
//            throw new IncorrectCredentialsException();
//        }else if (accountVo.getStatus().getStatus() == ACCOUNT_LOCKED) {
//            //账号锁定抛出异常
//            throw new LockedAccountException();
//        }

        AuthenticationInfo authenticationInfo = new SimpleAuthenticationInfo(accountVo.getMobile(), accountVo.getPassword(), "accountRealm");
        return authenticationInfo;
    }
}
