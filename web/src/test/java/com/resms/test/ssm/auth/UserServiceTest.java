package com.resms.test.ssm.auth;

import com.resms.ssm.auth.AuthRuntimeException;
import com.resms.ssm.auth.service.UserService;
import com.resms.ssm.auth.service.impl.UserServiceImpl;
import com.resms.ssm.gen.mybatis.bean.User;
import com.resms.ssm.gen.mybatis.mapper.UserMapper;
import org.easymock.EasyMock;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.powermock.api.easymock.PowerMock;
import org.powermock.core.classloader.annotations.PowerMockIgnore;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

import static org.junit.Assert.assertEquals;

@RunWith(PowerMockRunner.class)
@PrepareForTest({UserMapper.class})
@PowerMockIgnore("javax.management.*")
public class UserServiceTest {
    @Test
    public void getUserById(){
        User expectUser = new User();
        expectUser.setId(1001L);
        expectUser.setAge(35);
        expectUser.setUserName("sam");

        UserMapper mock = PowerMock.createMock(UserMapper.class);
//        EasyMock.expect(mock.selectByPrimaryKey(1001L))//精确匹配
        EasyMock.expect(mock.selectByPrimaryKey(EasyMock.isA(Long.class)))//只要类型匹配就命中
//                .andThrow(new AuthRuntimeException("test throw exception!"))
                .andReturn(expectUser);

        PowerMock.replay(mock);

        UserService service = new UserServiceImpl();
        ((UserServiceImpl) service).setUserMapper(mock);
        try {
            User user = service.getUserById(1001L);
            assertEquals(expectUser, user);
        }
        catch (AuthRuntimeException ex)
        {
            ex.printStackTrace();
        }
        PowerMock.verify(mock);
    }
}
