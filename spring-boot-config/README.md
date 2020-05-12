# spring-boot-config模块
## 1.SpringBoot启动banner配置

 > resources目录下的banner.txt 是自定义的SpringBoot应用启动图标文件

[在线ASCII艺术字生成网站](https://tools.kalvinbg.cn/txt/ascii)
 
## 2.application.properties
> 属性定义时候出现波浪线："Cannot resolve configuration property"
> 可以使用SpringBoot 的 configuration processor 模块来解决问题
```$xslt
<dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-configuration-processor</artifactId>
    <optional>true</optional>
</dependency>
```
然后在配置类上添加 @ConfigurationProperties 注解即可

## 3.Tomcat的相关配置


## 4.HTTPS的配置
[Spring Boot SSL [https]配置例子](https://www.cnblogs.com/chenpi/p/9696371.html)

- 创建自签证书，通过java keytool命令生成

         keytool -genkey -alias selfsigned_localhost_sslserver -keyalg RSA -keysize 2048 -validity 700 -keypass changeit -storepass changeit -keystore ssl-server.jks

         解释：
         -genkey – keytool命令，用于生成证书,事实上keytool是一个多用途和健壮的工具，支持丰富的命令参数；
         -alias selfsigned_localhost_sslserver 声明证书的别名，SSL/TLS层使用；
         -keyalg RSA -keysize 2048 -validity 700 –设置加密算法、秘钥大小、validity参数.
         -keypass changeit -storepass changeit– truststore 和 keystore的密码；
         -keystore ssl-server.jks – 存储证书、公钥私钥的文件，使用JKS格式 – Java Key Store，除了JKS外，还有其它格式可选择

- 查看证书内部

           keytool -list -keystore ssl-server.jks
           
## 5.在配置文件中自定义配置属性
- 定义
- 读取



