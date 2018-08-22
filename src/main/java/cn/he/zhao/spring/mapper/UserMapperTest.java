package cn.he.zhao.spring.mapper;

import cn.he.zhao.spring.entity.UserEntity;
import cn.he.zhao.spring.enums.UserSexEnum;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserMapperTest {
	public static final Logger logger = LoggerFactory.getLogger(UserMapperTest.class);

	@Autowired
	private UserMapper UserMapper;

	@Test
	public void testInsert() throws Exception {
		UserMapper.insert(new UserEntity("aa", "a123456", UserSexEnum.MAN));
		UserMapper.insert(new UserEntity("bb", "b123456", UserSexEnum.WOMAN));
		UserMapper.insert(new UserEntity("cc", "b123456", UserSexEnum.WOMAN));
		UserMapper.insert(new UserEntity("dd", "b123456", UserSexEnum.MAN));

		Assert.assertEquals(4, UserMapper.getAll().size());
	}

	@Test
	public void testQuery() throws Exception {
		PageHelper.startPage(1, 4);
		List<UserEntity> users = UserMapper.getAll();
		logger.info(users.toString());
		PageInfo<UserEntity> pageInfo = new PageInfo<UserEntity>(users);
		for (UserEntity entity: pageInfo.getList() ) {
			logger.info(entity.toString());
		}
		logger.info(pageInfo.getList().toString());
	}
	
	
	@Test
	public void testUpdate() throws Exception {
		UserEntity user = UserMapper.getOne(31L);
		System.out.println(user.toString());
		user.setNickName("neo");
		UserMapper.update(user);
		Assert.assertTrue(("neo".equals(UserMapper.getOne(31L).getNickName())));
	}

}