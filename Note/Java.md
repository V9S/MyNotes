## 深克隆与浅克隆 
###为什么克隆：
克隆可以保存你想要克隆对象的值，而new出来的对象中没有属性值。clone是一个native方法，快。
### 如何实现克隆： ###
- 被克隆的类实现标识接口Cloneable
- 覆盖Object中的clone()方法
- 在clone()方法中调用super.clone();
### 深克隆与浅克隆定义 ###
- 浅克隆：是指拷贝对象时仅仅拷贝对象本身（包括对象中的基本变量），而不拷贝对象包含的引用指向的对象（类，数组，接口等）。
> 浅克隆不会拷贝对象中包含的引用指向的对象，只会克隆一份对象的引用。所以，被克隆出来的对象与原对象中所包含的类、数组、接口等复杂数据类型，指向的是同一块内存地址。用equals（）方法比较，结果为true。

- 深克隆：不仅拷贝对象本身，而且拷贝对象包含的引用指向的所有对象
> 深克隆会将被克隆对象完全克隆一份，被克隆对象中的类、数组、接口等都会被复制一份，equals方法结果为false。
### 深克隆解决方案 ###
#### 方案1：通过浅克隆的递归方式####
当被克隆对象中包含引用数据类型，对引用数据类型进行浅克隆，从而整体上实现深克隆。
#### 方案2：通过序列化操作实现深克隆 ####
将需要复制的对象进行序列化，将对象写入流中。再从流中读取对象。完成反序列化。
	
    ByteArrayOutputStream bos=new ByteArrayOutputStream();// 将对象写入流中
    	ObjectOutputStream oos= null;
    	oos.writeObject(this);
    	oos.flush();
    
    ByteArrayInputStream bis=new ByteArrayInputStream(bos.toByteArray());//将对象从流中取出
    	ObjectInputStream ois=new ObjectInputStream(bis);
    	return (Person)ois.readObject();
### Java 8 foreach&lambda ###

###  ###
- @Deprecated注解 ：若某类或某方法加上该注解之后，表示此方法或类不再建议使用，调用时也会出现删除线，但并不代表不能用，只是说，不推荐使用，因为还有更好的方法可以调用





#### 自动拆箱与自动装箱

自动装箱是通过包装类的valueOf（）实现的

自动拆箱是通过包装类对象的xxxValue（）实现的

源码：Integer integer=1; //装箱        int i=integer; //拆箱

反编译：Integer integer=Integer.valueOf(1);         int i=integer.intValue(); 

#### jvm

```
-server: 一定要作为第一个参数，在多个CPU时性能佳 
-Xms：java Heap初始大小。 默认是物理内存的1/64。
-Xmx：java heap最大值。建议均设为物理内存的一半。不可超过物理内存。 
-XX:PermSize:设定内存的永久保存区初始大小，缺省值为64M。
-XX:MaxPermSize:设定内存的永久保存区最大 大小，缺省值为64M。
-XX:SurvivorRatio=2  :生还者池的大小,默认是2，如果垃圾回收变成了瓶颈，您可以尝试定制生成池设置
-XX:NewSize: 新生成的池的初始大小。 缺省值为2M。
-XX:MaxNewSize: 新生成的池的最大大小。缺省值为32M。



分配内存 堆配置推荐 
2G -Xmx1344M -Xms1344M -Xmn448M -XX:MaxMetaspaceSize=192M -XX:MetaspaceSize=192M 
3G -Xmx2048M -Xms2048M -Xmn768M -XX:MaxMetaspaceSize=256M -XX:MetaspaceSize=256M 
4G -Xmx2688M -Xms2688M -Xmn960M -XX:MaxMetaspaceSize=256M -XX:MetaspaceSize=256M 
5G -Xmx3392M -Xms3392M -Xmn1216M -XX:MaxMetaspaceSize=512M -XX:MetaspaceSize=512M 
6G -Xmx4096M -Xms4096M -Xmn1536M -XX:MaxMetaspaceSize=512M -XX:MetaspaceSize=512M 
7G -Xmx4736M -Xms4736M -Xmn1728M -XX:MaxMetaspaceSize=512M -XX:MetaspaceSize=512M 
8G -Xmx5440M -Xms5440M -XX:MaxMetaspaceSize=512M -XX:MetaspaceSize=512M
```



### jvm指令

- jps 查看正在运行的java进程

- jstat：查看jvm统计信息

  ```
  jstat -<option> [-t] [-h<lines>] <vmid> [<interval> [<count>]]
  ```

  ##### 参数：

  ```
  interval：指定统计数据周期，单位毫秒。即查询间隔。
  
  count：指定查询总次数。
  
  -t ：显示程序运行时间，单位秒。即程序总计运行时间。
  
  -h：多少秒再次后输出表头
  ```

  ##### option

  ```
  gc
  ```

  

- jinfo：实时查看和修改jvm配置参数

  ```
  jinfo [option] <pid>
  ```

  查看：

  jinfo -sysprops pid

  jinfo -flags pid 查看曾经赋过值的一些参数

  jinfo -flag 具体参数 pid 查看具体指

  修改(只有部分可修改)：

  针对boolean值 ：jinfo -flag [+|-] 具体参数 pid

  非boolean值：jinfo -flag 具体参数 = 值 pid

- jmap：导出内存映像文件和内存使用情况

  手动导出：

  ```
  jmap -dump:format=b,file=<filename.hprof> <pid>
  
  jmap -dump:live,format=b,file=<filename.hprof> <pid>(只保存堆中存活的对象)
  ```

  自动方式：

  ```
  #出现 OOME 时生成堆 dump: 
  -XX:+HeapDumpOnOutOfMemoryError
  #生成堆文件地址：
  -XX:HeapDumpPath=/home/liuke/jvmlogs/
  ```

- 

  