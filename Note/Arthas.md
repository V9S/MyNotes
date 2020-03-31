- 执行：`java -jar arthas-boot.jar --target-ip 0.0.0.0`
- arthas-boot是Arthas的启动程序，它启动后，会列出所有的Java进程，用户可以选择需要诊断的目标进程。
- `dashboard` 命令可以查看当前系统的实时数据面板。
- 输入` Q `或者 `Ctrl+C` 可以退出dashboard命令。
- `thread 1` 可以打印线程id为1的栈。同时Arthas支持管道可以使用
`> thread 1 | grep 'main('` 查找main class
- `sc` 命令来查找JVM里已经加载的类，如果搜索的是接口，还会搜索所有的实现类。通过`-d`参数，可以打印出类加载的具体信息，很方便查找类加载问题。
- `sm`命令则是查找类的具体函数，通过`-d`参数可以打印函数的具体属性
- `jad`命令来反编译代码，`--source-only`参数可以只打印出在反编译的源代码：
- `watch`通过watch命令可以查看函数的参数/返回值/异常信息。输入 `Q` 或者 `Ctrl+C` 退出watch命令。如果想把获取到的结果展开，可以用-x参数：eg:watch com.example.demo.arthas.user.UserController * '{params, throwExp}' -x 2
- 用 `exit` 或者 `quit` 命令可以退出Arthas。`exit/quit`命令只是退出当前session，arthas server还在目标进程中运行。想完全退出Arthas，可以执行 `shutdown` 命令。
- `sysprop` 可以打印所有的System Properties信息。
- 也可以指定单个key： `sysprop java.version`
- 也可以通过grep来过滤： `sysprop | grep user`
- 可以设置新的value： `sysprop testKey testValue`
- `sysenv` 命令可以获取到环境变量。和`sysprop`命令类似。
- `jvm` 命令会打印出JVM的各种详细信息。
- 在Arthas里，有一个单独的`ognl`命令，可以动态执行代码。
- `trace`监控方法执行时间
### 在windows下如何使用arthas ####
- 执行as.bat [进程号]（该方法需要配置JAVA_HOME，可以直接运行）
- 执行java -jar arthas-boot.jar
## 下载安装 ##
- 下载：`curl -O https://alibaba.github.io/arthas/arthas-boot.jar`
- 