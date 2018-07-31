package cn.he.zhao.spring.mapper;

import cn.he.zhao.spring.entity.UserEntity;
import cn.he.zhao.spring.enums.UserSexEnum;
import org.apache.ibatis.annotations.*;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;

import java.util.List;

@CacheConfig(cacheNames = "users")
public interface UserMapper {
	
	@Select("SELECT * FROM users")
	@Results({
		@Result(property = "userSex",  column = "user_sex", javaType = UserSexEnum.class),
		@Result(property = "nickName", column = "nick_name")
	})
	List<UserEntity> getAll();
	
	@Select("SELECT * FROM users WHERE id = #{id}")
	@Results({
		@Result(property = "userSex",  column = "user_sex", javaType = UserSexEnum.class),
		@Result(property = "nickName", column = "nick_name")
	})
	@Cacheable(value="users", key = "#p0")
	UserEntity getOne(Long id);

	@CachePut(value="users", key = "#p0.userName")
	@Insert("INSERT INTO users(userName,passWord,user_sex) VALUES(#{userName}, #{passWord}, #{userSex})")
	@SelectKey(statement="select LAST_INSERT_ID()", keyProperty="id", before=false, resultType=long.class)
	void insert(UserEntity user);

	@CachePut(value="users", key = "#p0.userName")
	@Update("UPDATE users SET userName=#{userName},nick_name=#{nickName} WHERE id =#{id}")
	void update(UserEntity user);

	@CacheEvict(value="users", key = "#p0")
	@Delete("DELETE FROM users WHERE id =#{id}")
	void delete(Long id);

}