import com.github.pagehelper.PageHelper;
import com.github.seedm.repository.mapper.seed.IAccountMapper;
import com.github.seedm.repository.vo.AccountVO;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.Date;
import java.util.List;
import java.util.Random;
import java.util.UUID;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:spring-mybatis.xml"})
public class AccountTest {

    @Autowired
    private IAccountMapper accountMapper;

    @Test
    public void testInsert() {
        System.out.println(this.accountMapper);
//        AccountVO accountVO = new AccountVO();
//        accountVO.setId(UUID.randomUUID().toString());
//        accountVO.setName("超级管理员");
//        accountVO.setPassword("666666");
//        accountVO.setBirthday(new Date());
//        accountVO.setIdcardNo("8888888888888888");
//        accountVO.setUserId(String.valueOf(new Random().nextInt(10)));
//        accountVO.setNickname("管理员");
//        accountVO.setMobile("139000000000");

        AccountVO accountVO = new AccountVO();
        accountVO.setId(UUID.randomUUID().toString());
        accountVO.setName("陈志恒");
        accountVO.setPassword("hh*963.-+");
        accountVO.setBirthday(new Date());
        accountVO.setIdcardNo("510112198403236016");
        accountVO.setUserId(String.valueOf(new Random().nextInt(10)));
        accountVO.setNickname("Eugene");
        accountVO.setMobile("18980840323");
        this.accountMapper.insert(accountVO);
    }

    @Test
    public void testSelectActive() {
        AccountVO accountVO = new AccountVO();
        accountVO.setUserId("super");
//        accountVO.setMobile("139000000000");
        AccountVO result = this.accountMapper.selectActive(accountVO);
        System.out.println(result.getPassword());
    }

    @Test
    public void testSelectAll() {
//        PageHelper.startPage(1, 5);
//        PageHelper.offsetPage(1, 5);
        List<AccountVO> accounts = this.accountMapper.selectAll();
        System.out.println(accounts.size());
        Assert.assertEquals(2, accounts.size());
    }
}
