# local-maven-repository-to-dependencies
扫描本地maven库,生成所有本地库的依赖并存储到文本文件中
java -jar Test1 local-maven-directory c:dependencies.txt
示例如下
```xml
<groupId>org.jboss.shrinkwrap</groupId>
<artifactId>shrinkwrap-bom</artifactId>
<version>1.0.1</version>
```
