# spring-cloud-demo
spring cloud 脚手架，搭建基本的服务，后续只需添加业务服务即可。
## 1.技术架构
![tech_structure](docs/imgs/tech_structure.png)

## 2.网络架构
![NET_STRUCTURE](docs/imgs/net_structure.PNG)

## 3.技术选型
* 注册中心 Eureka
* 网关 Gateway
* 认证授权中心 security、oauth2
* 配置中心 nacos
* 缓存 redis
* job调度 XXL-Job
* MQ消息 RocketMQ
* 搜索 ElasticSearch

## 4.组件服务
### 4.1 Eureka
各个服务注册与发现
    
### 4.2 Gateway
* 请求转发
* 限流
* 熔断
* token认证
用户请求登陆，网关调用认证中心服务生成token，客户端再携带token请求调用，网关校验token继而转发下游服务。时序图如下：
![登陆时序图](docs/imgs/登陆时序图.png)

### 4.3 auth
* 认证 security
* 授权 oauth2

