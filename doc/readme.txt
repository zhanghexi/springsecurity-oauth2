1、授权地址：
    http://localhost:8085/oauth/authorize?client_id=redisTokenDemo&redirect_uri=http://www.baidu.com&response_type=code&scope=read
2、请求token地址(POST)：
    http://localhost:8085/oauth/token?grant_type=authorization_code&code=o4YrCS&client_id=redisTokenDemo
    &client_secret=123456&redirect_uri=http://www.baidu.com
3、客户端模式：
    http://localhost:8085/oauth/token?grant_type=client_credentials&client_id=redisTokenDemo&client_secret=123456
4、请求资源实例：
    http://localhost:8085/redis/getRedisValue/userInfo

warning:
在升级到2.0.1版本后,spring-security-oauth2要升级到2.3.3版本才能保证token信息存到redis里面不会报错