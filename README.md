### Maven中的dependencyManagement 意义

       1.在Maven中dependencyManagement的作用其实相当于一个对所依赖jar包进行版本管理的管理器。
       
       2.pom.xml文件中，jar的版本判断的两种途径
       
       1：如果dependencies里的dependency自己没有声明version元素，那么maven就
       
       会倒dependencyManagement里面去找有没有对该artifactId和groupId进行过版本声明，如果有，就继承它，如果
       
       没有就会报错，告诉你必须为dependency声明一个version
       
       2：如果dependencies中的dependency声明了version，那么无论dependencyManagement中有无对该jar的version声明，都以dependency里的version为准

