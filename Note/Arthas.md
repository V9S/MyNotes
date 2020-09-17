

### 	一、Arthas（阿尔萨斯） 能为你做什么？

`Arthas` 是Alibaba开源的Java诊断工具

当你遇到以下类似问题而束手无策时，`Arthas`可以帮助你解决：

1. 这个类从哪个 jar 包加载的？为什么会报各种类相关的 Exception？

2. 我改的代码为什么没有执行到？难道是我没 commit？分支搞错了？

3. 遇到问题无法在线上 debug，难道只能通过加日志再重新发布吗？

4. 线上遇到某个用户的数据处理有问题，但线上同样无法 debug，线下无法重现！

5. 是否有一个全局视角来查看系统的运行状况？

6. 有什么办法可以监控到JVM的实时运行状态？

7. 怎么快速定位应用的热点，生成火焰图？


**用户文档：https://arthas.aliyun.com/doc/index.html**

**教程地址：https://arthas.aliyun.com/doc/arthas-tutorials.html?language=cn**

### 二、安装

```
wget https://arthas.aliyun.com/arthas-boot.jar
wget https://arthas.aliyun.com/arthas-demo.jar
```

### 三、运行arthas

```
java -jar arthas-boot.jar 
如果出现端口占用，可以指定pid ： java -jar arthas-boot.jar  777
```

![image-20200907121246315](C:\Users\ZLM\AppData\Roaming\Typora\typora-user-images\image-20200907121246315.png)

### 四、常用命令

1、dashboard ：可以查看当前系统的实时数据面板，展示jvm的线程、内存、gc、运行环境等信息

<img src="C:\Users\ZLM\AppData\Roaming\Typora\typora-user-images\image-20200911004556793.png" alt="image-20200911004556793" style="zoom: 80%;" />

2、sysprop :可以打印所有的System Properties信息

- 也可以指定单个key： 

```
sysprop java.version
```

- 也可以通过`grep`来过滤： 

```
sysprop | grep user
```

- 可以设置新的value：

```
sysprop testKey testValue
```

- sysenv:命令可以获取到环境变量。和`sysprop`命令类似。

3、jvm :命令会打印出`JVM`的各种详细信息。

4、Thread：会打印线程ID 1的栈（Arthas支持管道）

```
thread 1 | grep 'main('
```

- -n	指定最忙的前N个线程并打印堆栈

5、sc ：命令来查找JVM里已加载的类：

- -d 打印详细信息

- -f 输出当前类的成员变量，与- d 配合使用

6、sm:	查看已加载类的方法信息

- -d 展示每个方法的详细信息

7、Jad ：反编译代码

8、Watch 可以查看函数的参数/返回值/异常信息。

```
watch demo.MathGame primeFactors returnObj
watch demo.MathGame primeFactors '{params,returnObj,throwExp}' -x 2
```

9、trace : 方法内部调用路径，并输出方法路径上的每个节点上耗时

### 五、案例

#### 1、性能排查

`trace` 命令能主动搜索 `class-pattern`／`method-pattern` 对应的方法调用路径，渲染和统计整个调用链路上的所有性能开销和追踪调用链路。

#### 2、热更新代码

下面介绍通过`jad`/`mc`/`redefine` 命令实现动态更新代码的功能。

1.  jad反编译的结果保存在 `/home/arthas/MathGame.java`文件里了

   ```
   jad --source-only demo.MathGame > /home/arthas/MathGame.java
   ```

   jad反编译的结果保存在/home/arthas/MathGame.java文件里了

   

2. 修改文件后进行保存

   ```
   vi MathGame.java
   ```

3. sc查找加载MathGame的ClassLoader

   ```
   sc -d demo.MathGame
   ```

4. 使用`mc`(Memory Compiler)命令来编译，并且通过`-c`或者`--classLoaderClass`参数指定ClassLoader：

   ```
   mc -c classLoaderhash(替换为classLoader hash值) /home/arthas/MathGame.java
   ```

5. 再使用`redefine`命令重新加载新编译好的`MathGame.java`

   ```
   redefine /home/arthas/demo/MathGame.class
   ```



#### 3、生成火焰图

```
profiler start	启动profiler，默认生成cpu的火焰图
profiler getSamples	获取已采集的sample的数量
profiler status	查看profiler状态
profiler stop	停止profiler
profiler stop --format html	生成html格式
profiler start --event alloc		可以用--event参数指定要采样的事件，比如对alloc事件进入采样：
```

