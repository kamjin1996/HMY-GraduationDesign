package com.zxx.hmy520.graduationdesign.configuration;

import org.springframework.cache.annotation.CachingConfigurerSupport;


/**
 * @author kam
 * @Description: RedisConfig
 * @date 2018/5/12 14:18
 */
//@Slf4j
//@Configuration
//@EnableCaching
public class RedisConfig extends CachingConfigurerSupport {
    //
    //@Value("${spring.redis.host}")
    //private String host;
    //
    //@Value("${spring.redis.port}")
    //private int port;
    //
    //@Value("${spring.redis.timeout}")
    //private int timeout;
    //
    //@Value("${spring.redis.password}")
    //private String password;
    //
    //@Value("${spring.redis.database}")
    //private int database;
    //
    //@Value("${spring.redis.pool.max-active}")
    //private int maxActive;
    //
    //@Value("${spring.redis.pool.max-wait}")
    //private int maxWait;
    //
    //@Value("${spring.redis.pool.max-idle}")
    //private int maxIdle;
    //
    //@Value("${spring.redis.pool.min-idle}")
    //private int minIdle;
    //
    //
    ///**
    // * 注解@Cache的管理器，设置过期时间的单位是秒
    // *
    // * @param redisTemplate
    // * @return
    // */
    //@Bean
    //public CacheManager cacheManager(RedisTemplate redisTemplate) {
    //    //cacheManager.setDefaultExpiration(24 * 60 * 60); //设置key-value超时时间秒 1天
    //    return new RedisCacheManager(redisTemplate);
    //}
    //
    ///**
    // * RedisTemplate配置
    // *
    // * @param factory
    // * @return
    // */
    //@Bean
    //public RedisTemplate<String, String> redisTemplate(RedisConnectionFactory factory) {
    //    StringRedisTemplate template = new StringRedisTemplate(factory);
    //
    //    //定义value的序列化方式
    //    Jackson2JsonRedisSerializer jackson2JsonRedisSerializer = new Jackson2JsonRedisSerializer(Object.class);
    //    ObjectMapper om = new ObjectMapper();
    //    om.setVisibility(PropertyAccessor.ALL, JsonAutoDetect.Visibility.ANY);
    //    om.enableDefaultTyping(ObjectMapper.DefaultTyping.NON_FINAL);
    //    jackson2JsonRedisSerializer.setObjectMapper(om);
    //
    //    template.setKeySerializer(jackson2JsonRedisSerializer);
    //    template.setHashKeySerializer(jackson2JsonRedisSerializer);
    //
    //    template.setValueSerializer(jackson2JsonRedisSerializer);
    //    template.setHashValueSerializer(jackson2JsonRedisSerializer);
    //    template.afterPropertiesSet();
    //    return template;
    //}
    //
    ///**
    // * redis连接的基础设置
    // *
    // * @return
    // * @Description:
    // */
    //@Bean
    //public JedisConnectionFactory redisConnectionFactory() {
    //    JedisConnectionFactory factory = new JedisConnectionFactory();
    //    factory.setHostName(host);
    //    factory.setPort(port);
    //    factory.setPassword(password);
    //    //存储的库
    //    factory.setDatabase(database);
    //    //设置连接超时时间
    //    factory.setTimeout(timeout);
    //    factory.setUsePool(true);
    //    factory.setPoolConfig(jedisPoolConfig());
    //    return factory;
    //}
    //
    ///**
    // * 连接池配置
    // *
    // * @return
    // * @Description:
    // */
    //@Bean
    //public JedisPoolConfig jedisPoolConfig() {
    //    JedisPoolConfig jedisPoolConfig = new JedisPoolConfig();
    //    jedisPoolConfig.setMaxIdle(maxIdle);
    //    jedisPoolConfig.setMinIdle(minIdle);
    //    jedisPoolConfig.setMaxTotal(maxActive);
    //    jedisPoolConfig.setMaxWaitMillis(maxWait);
    //    return jedisPoolConfig;
    //}
    //
    //
    ///**
    // * redis数据操作异常处理
    // * 这里的处理：在日志中打印出错误信息，但是放行
    // * 保证redis服务器出现连接等问题的时候不影响程序的正常运行，使得能够出问题时不用缓存
    // *
    // * @return
    // */
    //@Bean
    //@Override
    //public CacheErrorHandler errorHandler() {
    //    CacheErrorHandler cacheErrorHandler = new CacheErrorHandler() {
    //        @Override
    //        public void handleCacheGetError(RuntimeException exception, Cache cache, Object key) {
    //            log.error("redis异常：chche=[{}] key=[{}]", cache.getName(), key, exception);
    //        }
    //
    //        @Override
    //        public void handleCachePutError(RuntimeException exception, Cache cache, Object key, Object value) {
    //            log.error("redis异常：chche=[{}] key=[{}]", cache.getName(), key, exception);
    //        }
    //
    //        @Override
    //        public void handleCacheEvictError(RuntimeException exception, Cache cache, Object key) {
    //            log.error("redis异常：chche=[{}] key=[{}]", cache.getName(), key, exception);
    //        }
    //
    //        @Override
    //        public void handleCacheClearError(RuntimeException exception, Cache cache) {
    //            log.error("redis异常：chche=[{}]", cache.getName(), exception);
    //        }
    //    };
    //    return cacheErrorHandler;
    //}
}
