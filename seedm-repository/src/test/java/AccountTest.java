import com.github.seedm.repository.mapper.seed.IAccountMapper;
import com.github.seedm.repository.vo.AccountVO;
import com.github.toolkit.core.CodecKit;
import com.github.toolkit.core.StringKit;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.Date;
import java.util.List;
import java.util.UUID;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:spring-core.xml"})
//@Transactional
public class AccountTest {

    @Autowired
    private IAccountMapper accountMapper;

    private static CodecKit codecKit;

    private static StringKit stringKit;

    @BeforeClass
    public static void beforClass() {
        codecKit = new CodecKit();
        stringKit = new StringKit();
    }

    @Test
    public void testInsert() {
        System.out.println(this.accountMapper);
        AccountVO accountVO = new AccountVO();
        accountVO.setId(UUID.randomUUID().toString());
        accountVO.setName("超级管理员");
        accountVO.setPassword(codecKit.hex("666666".getBytes(), CodecKit.ALGORITHMS_MD5));
        accountVO.setBirthday(new Date());
        accountVO.setIdcardNo(codecKit.encodeBase64("5100078888888888"));
        accountVO.setUserId(stringKit.randomByType(6, StringKit.RANDOM_TYPE_NUMBER));
        accountVO.setNickname("管理员");
        accountVO.setMobile(codecKit.encodeBase64("139000000000"));
        this.accountMapper.insert(accountVO);

        List<AccountVO> result = this.accountMapper.selectAll();
        Assert.assertEquals(1, result.size());
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
