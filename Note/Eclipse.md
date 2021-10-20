### 导入代码格式化样式 ###
- 在Windows-Preferences-Java-CodeStyle-Formatter中导入"..\p3c\p3c-formatter\eclipse-codestyle.xml"
- 在Windows-Preferences-Java-CodeStyle-CodeTemplates中导入"..\p3c\p3c-formatter\eclipse-codeTemplate.xml"
### 阿里编码规约扫描 ###
- 将目录"..\p3c\eclipse-plugin"下【features】及【plugins】复制到eclipse目录，重启eclipse
- 或者在Help-Install New Software中添加https://p3c.alibaba.com/plugin/eclipse/update地址进行安装
### debug ###
- 断点处右键选择Breakpoint Properties，勾选Conditional可以添加断点条件
### 快捷键 ###
- 查看一个方法都被谁调用过：选中方法后Ctrl+Alt+H 或者Ctrl+Shift+G
- 快速添加作者日期等注释信息：ALT + SHIFT +J
- 进入列编辑模式：ALT + SHIFT + A
- SHIFT + F2 ：将光标放在方法或者类上，打开文档
- ctrl + shift + x : 将字母转换为大写
- ctrl + shift + y : 将字母转换为小写
- alt + shift +l ：自动生成变量名

### JVM设置

- -Xmx4096m ：设置JVM最大可用内存为4096。

- -Xms512m：设置JVM促使内存为3550m。此值可以设置与-Xmx相同，以避免每次垃圾回收完成后JVM重新分配内存。

- -Xmn2g：设置年轻代大小为2G。整个JVM内存大小=年轻代大小 + 年老代大小 + 持久代大小。持久代一般固定大小为64m，所以增大年轻代后，将会减小年老代大小。此值对系统性能影响较大，Sun官方推荐配置为整个堆的3/8。
- -Xss128k：设置每个线程的堆栈大小。JDK5.0以后每个线程堆栈大小为1M，以前每个线程堆栈大小为256K。更具应用的线程所需内存大小进行调整。在相同物理内存下，减小这个值能生成更多的线程。但是操作系统对一个进程内的线程数还是有限制的，不能无限生成，经验值在3000~5000左右。
  java -Xmx3550m -Xms3550m -Xss128k -XX:NewRatio=4 -XX:SurvivorRatio=4 -XX:MaxPermSize=16m -XX:MaxTenuringThreshold=0
- -XX:NewRatio=4:设置年轻代（包括Eden和两个Survivor区）与年老代的比值（除去持久代）。设置为4，则年轻代与年老代所占比值为1：4，年轻代占整个堆栈的1/5
- -XX:SurvivorRatio=4：设置年轻代中Eden区与Survivor区的大小比值。设置为4，则两个Survivor区与一个Eden区的比值为2:4，一个Survivor区占整个年轻代的1/6
- -XX:MaxPermSize=16m:设置持久代大小为16m。
- -XX:MaxTenuringThreshold=0：设置垃圾最大年龄。如果设置为0的话，则年轻代对象不经过Survivor区，直接进入年老代。对于年老代比较多的应用，可以提高效率。如果将此值设置为一个较大值，则年轻代对象会在Survivor区进行多次复制，这样可以增加对象再年轻代的存活时间，增加在年轻代即被回收的概论。
