package com.github.seedm.service.shiro;

import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.ExcessiveAttemptsException;
import org.apache.shiro.authc.credential.HashedCredentialsMatcher;
import org.apache.shiro.cache.Cache;
import org.apache.shiro.cache.CacheManager;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * 凭证匹配实现，输入密码错误5次，账号将被冻结一段时间
 * @author Eugene
 */
public class RetryLimitHashedCredentialsMatcher extends HashedCredentialsMatcher {
    /**
     * 声明一个缓存接口，这个接口是Shiro缓存管理的一部分，它的具体实现可以通过外部容器注入
     */
    private Cache<String, AtomicInteger> passwordRetryCache;

    public RetryLimitHashedCredentialsMatcher(CacheManager cacheManager) {
        passwordRetryCache = cacheManager.getCache("passwordRetryCache");
    }

    @Override
    public boolean doCredentialsMatch(AuthenticationToken token, AuthenticationInfo info) {
        //获取账号
        String account = (String) token.getPrincipal();
        AtomicInteger retryCount = passwordRetryCache.get(account);
        if (retryCount == null) {
            retryCount = new AtomicInteger(0);
            passwordRetryCache.put(account, retryCount);
        }
        //自定义一个验证过程：当用户连续输入密码错误5次以上禁止用户登录一段时间
        if (retryCount.incrementAndGet() > 5) {
            //抛出登陆次数过多异常
            throw new ExcessiveAttemptsException();
        }
        boolean match = super.doCredentialsMatch(token, info);
        if (match) {
            passwordRetryCache.remove(account);
        }
        return match;
    }
}
