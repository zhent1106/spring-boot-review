### Maven中的dependencyManagement 意义

       1.在Maven中dependencyManagement的作用其实相当于一个对所依赖jar包进行版本管理的管理器。
       
       2.pom.xml文件中，jar的版本判断的两种途径
       
       1：如果dependencies里的dependency自己没有声明version元素，那么maven就
       
       会倒dependencyManagement里面去找有没有对该artifactId和groupId进行过版本声明，如果有，就继承它，如果
       
       没有就会报错，告诉你必须为dependency声明一个version
       
       2：如果dependencies中的dependency声明了version，那么无论dependencyManagement中有无对该jar的version声明，都以dependency里的version为准


### Spring Boot SSL [https]
       SSL：SSL(Secure Sockets Layer 安全套接层)，用以保障在Internet上数据传输之安全，利用数据加密(Encryption)技术，可确保数据在网络上之传输过程中不会被截取及窃听。

       TLS：安全传输层协议（TLS）用于在两个通信应用程序之间提供保密性和数据完整性。该协议由两层组成： TLS 记录协议（TLS Record）和 TLS 握手协议（TLS Handshake）。

       HTTPS：是以安全为目标的HTTP通道，简单讲是HTTP的安全版。即HTTP下加入SSL层，HTTPS的安全基础是SSL，因此加密的详细内容就需要SSL。

       Truststore and Keystore：主要用于Java中存储证书，它们之间的区别是truststore用于存储public证书，而keystore用于存储private证书