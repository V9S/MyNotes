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
