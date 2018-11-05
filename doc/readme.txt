1、授权地址：
    http://localhost:8085/oauth/authorize?response_type=code&client_id=redisTokenDemo&redirect_uri=http://www.baidu.com
2、请求token地址(POST)：
    http://localhost:8085/oauth/token?grant_type=authorization_code&code=o4YrCS&client_id=redisTokenDemo
    &client_secret=123456&redirect_uri=http://www.baidu.com