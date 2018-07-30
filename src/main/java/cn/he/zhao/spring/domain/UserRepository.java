package cn.he.zhao.spring.domain;

import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.jpa.repository.JpaRepository;

@CacheConfig(cacheNames = "users")
public interface UserRepository extends JpaRepository<User, Long> {

    @Cacheable(value="users", key = "#p0")
    User findByName(String name);

    @Cacheable(value="users", key = "#p0")
    User findById(Long id);

    @CachePut(value="users", key = "#p0.name")
    User save(User user);

}
