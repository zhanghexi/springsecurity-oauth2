# springsecurity-oauth2
一、该鉴权项目基本框架为spring boot + spring security + oauth2，基于springboot 2.0.1版本实现，具备了数据库配置客户端元数据信息和redis存储token的功能。
目前实现了authorization_code授权码和密码两种模式，其余模式和后续的补充将在以后提交。

二、现在的版本(20181203)加入redis集群配置，ORM框架改为mybatis