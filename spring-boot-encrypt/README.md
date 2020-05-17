
### 配置文件中的数据进行加密
#### 直接运行 JAR 包方式对敏感信息加密的命令如下所示


```
加密url：
java -cp jasypt-1.9.2.jar org.jasypt.intf.cli.JasyptPBEStringEncryptionCLI input="jdbc:mysql://127.0.0.1:3306/test?serverTimezone=Asia/Shanghai&useUnicode=true&characterEncoding=UTF-8&useSSL=false" password=zhent1616 algorithm=PBEWithMD5AndDES
```

#### 在程序中设置密文需要使用如下格式：
    
    ENC(密文)
    
    
###项目文章链接：
    https://www.cnblogs.com/zz0412/p/jasypt-001.html