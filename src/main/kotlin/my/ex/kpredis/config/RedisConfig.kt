package my.ex.kpredis.config

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.data.redis.connection.RedisConnectionFactory
import org.springframework.data.redis.connection.RedisStandaloneConfiguration
import org.springframework.data.redis.connection.lettuce.LettuceConnectionFactory
import org.springframework.data.redis.core.RedisTemplate
import org.springframework.data.redis.core.StringRedisTemplate
import javax.annotation.PostConstruct

@Configuration
class RedisConfig(
//    private val redisConnectionFactory: RedisConnectionFactory,
    private val redisTemplate: RedisTemplate<Any, Any>,
    private val stringRedisTemplate: StringRedisTemplate
) {

    @Bean
    fun redisConnectionFactory(): RedisConnectionFactory {
        val redisConfiguration = RedisStandaloneConfiguration("localhost", 9379)
        return LettuceConnectionFactory(redisConfiguration)
    }

    @PostConstruct
    private fun init() {
        println("redisTemplate = $redisTemplate")
        println("stringRedisTemplate = $stringRedisTemplate")
    }

}