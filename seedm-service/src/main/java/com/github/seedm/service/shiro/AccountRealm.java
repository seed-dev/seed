package com.github.seedm.service.shiro;

import com.github.seedm.repository.vo.seed.AccountVo;
import com.github.seedm.service.IAccountService;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
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
        String mobile = principals.getPrimaryPrincipal().toString();
//        AccountVo accountVO = new AccountVo();
//        accountVO.setMobile(mobile);
//        SimpleAuthorizationInfo simpleAuthorizationInfo = new SimpleAuthorizationInfo();
//        simpleAuthorizationInfo.setRoles();
        return null;
    }

    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
        this.logger.info("===============用户登陆认证===============");
        final int ACCOUNT_LOCKED = 2;
        //获取账号
        String mobile = token.getPrincipal().toString();
        AccountVo accountVo = new AccountVo();
        accountVo.setMobile(mobile);
        AccountVo account = this.accountService.queryActive(accountVo);

        if (account == null) {
            //账号不存在抛出异常
            throw new UnknownAccountException();
        }else if (account.getStatus().getStatus() == ACCOUNT_LOCKED) {
            //账号锁定抛出异常
            throw new LockedAccountException();
        }

        AuthenticationInfo authenticationInfo = new SimpleAuthenticationInfo(account.getMobile(), account.getPassword(), "accountRealm");
        return authenticationInfo;
    }
}
