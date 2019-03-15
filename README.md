# spring-boot-cloud-demo
1.Springboot-集成注册到eureka-server并且通过spirng-boot-admin进行服务管理

2.集成mybatis,数据库，注册到微服务，关联管理项目eureka-server,spring-boot-admin,

3.需要主要的是数据库读写，如果不需要读写分离，删除项目下包资源 datasource目录，application.yml文件中切换一下自定义的数据源配置，和默认spring数据源配置

4.请使用注解事物

相关的表
CREATE TABLE `user_info` (
  `id` int(8) NOT NULL AUTO_INCREMENT,
  `name` varchar(20) NOT NULL,
  `age` int(2) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;
