### 安装 ###
- 将文件解压到文件夹中
- 将bin文件夹路径添加到环境变量中
- 在dos命令中输入`mvn -v`检查验证是否安装成功，成功显示版本等信息
- 创建本地仓库文件夹
- 在解压文件夹中的**./conf/settings.xml**文件中将`<localRepository>/path/to/local/repo</localRepository>`标签的注释打开，配置本地仓库。（如果不配置本地仓库，默认路径为C:\Users\用户名\.m2）
- 在eclipse中依次打开Windows——>Preferences——>Maven——>Installations添加Maven路径
### 配置淘宝中央仓库 ###
- maven会默认从国外的中心仓库下载依赖，速度较慢。
- 在**./conf/settings.xml**文件中在<mirrors></mirrors>标签中加入配置
> <mirror>
>     <id>aliyunMaven</id>
>     <mirrorOf>*</mirrorOf>
>     <name>aliyun maven</name>
>    <url>http://maven.aliyun.com/nexus/content/groups/public</url>
> </mirror>

#### maven项目maven Dependencies下的jar包有的颜色变灰色了

pom依赖

```pom
	<dependency>
		<groupId>org.springframework.boot</groupId>
		<artifactId>spring-boot-starter-test</artifactId>
		<scope>test</scope>
	</dependency>
```
由于<scope>标签，test表示只能在src下的test文件夹下面才可
如果在main 文件夹下使用	去掉scope 即可

#### 手动加载jar包到仓库

```
mvn install:install-file -Dfile=E:\Google\kaptcha-2.3.0.jar -DgroupId=com.google.code.kaptcha -DartifactId=kaptcha -Dversion=2.3 -Dpackaging=jar
```

