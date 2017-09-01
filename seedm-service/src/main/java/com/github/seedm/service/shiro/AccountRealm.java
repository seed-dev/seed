package com.github.seedm.service.shiro;

import com.github.seedm.repository.vo.seed.AccountVO;
import com.github.seedm.service.IAccountService;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * 自定义账号相关的Shiro安全实体数据源
 */
@Component
public class AccountRealm extends AuthorizingRealm {

    private final Logger logger = LoggerFactory.getLogger(AccountRealm.class);

    @Autowired
    private IAccountService accountService;

    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
        this.logger.info("===============用户授权认证===============");
//        String mobile = principals.getPrimaryPrincipal().toString();
//        AccountVO accountVO = new AccountVO();
//        accountVO.setMobile(mobile);
//        SimpleAuthorizationInfo simpleAuthorizationInfo = new SimpleAuthorizationInfo();
//        simpleAuthorizationInfo.setRoles();
        return null;
    }

    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
        this.logger.info("===============用户登陆认证===============");
        String mobile = token.getPrincipal().toString();
        AccountVO accountVO = new AccountVO();
        accountVO.setMobile(mobile);
        AccountVO account = this.accountService.queryActive(accountVO);
        if (account != null) {
            AuthenticationInfo authenticationInfo = new SimpleAuthenticationInfo(account.getMobile(), account.getPassword(), "accountRealm");
            return authenticationInfo;
        }
        return null;
    }
}
