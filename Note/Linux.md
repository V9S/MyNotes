## 命令 ##
- wget + 地址：下载文件

- pwd :显示当前目录

- 查看Linux内核版本

  ```shell
  1、cat/proc/version
  2、uname -a
  ```

  

- 查看Linux系统版本的命令

  ```shell
  1、lsb_release -a，即可列出所有版本信息;
  2、cat /etc/redhat-release，这种方法只适合Redhat系的Linux：
  3、cat /etc/issue，此命令也适用于所有的Linux发行版。
  ```

  **uname**

  ```
  
  ```

  ```
  find . -name "Portainer"
  ```

  

  ### Docker

  显示docker中运行程序：`docker ps`

  进入mysql bash ：`docker  exec -it mysql bash`

  ### Oracle

  ```
  进入oracle数据库终端：
  su - oracle
  cd /u01/app/oracle/product/11.2.0/db_1/bin
  ./sqlplus /nolog
  
  连接oracle用户：
  conn  jlgsnp_new/jlgsnp_new
  
  
  ```

  ### 防火墙

  ```
  临时关闭防火墙
  systemctl stop firewalld
  永久防火墙开机自关闭
  systemctl disable firewalld
  临时打开防火墙
  systemctl start firewalld
  防火墙开机启动
  systemctl enable firewalld
  查看防火墙状态
  systemctl status firewalld
  ```

  ### SELinux

  ```
  临时关闭SELinux
  setenforce 0
  临时打开SELinux
  setenforce 1
  查看SELinux状态
  getenforce
  开机关闭SELinux
  编辑/etc/selinux/config文件，如下：
  vi /etc/selinux/config 将SELINUX=enforcing 改为SELINUX=disabled
  ```

  

  ## Linux下安装MySQL

  1、创建文件夹：

  ```
  mkdir mysql;
  ```

  2、解压压缩包

  ```
  1、安装解压缩文件：yum install xz -y
  2、解压为tar文件：xz -d  filename
  3、解压tar文件：tar -xvf filename
  ```

  3、创建文件夹data，储存数据

  ```
  mkdir  /usr/local/mysql/data
  ```

  4、创建用户级用户组

  ```
  用户组：groupadd mysql
  
  用户 （用户名/密码）：useradd -g mysql mysql
  ```

  5、授权

  ```
  chown -R mysql.mysql /usr/local/mysql/
  ```

  6、初始化

  ```
  1、cd /usr/local/mysql/mysql-8.0.21-linux-glibc2.12-i686/bin
  2、
  ```

  ## Linux下安装Oracle19c

  1、查看依赖软件包安装情况

  ```
  rpm --query --queryformat "%{NAME}-%{VERSION}.%{RELEASE} (%{ARCH})\n" bc binutils compat-libcap1 compat-libstdc++-33 gcc gcc-c++ glibc glibc-devel ksh libaio libaio-devel libgcc libstdc++ libstdc++-devel make sysstat elfutils-libelf elfutils-libelf-devel fontconfig-devel libxcb smartmontools libX11 libXau libXtst libXrender libXrender-devel
  ```

  2、安装软件包

  ```
  yum install -y compat-libcap1 compat-libstdc++-33 gcc-c++ ksh libaio-devel libstdc++-devel elfutils-libelf-devel fontconfig-devel libXrender-devel（未完全安装，需手动yum install 安装）
  ```

  3、创建oracle用户组

  ```
  groupadd oinstall
  groupadd dba
  groupadd asmdba
  groupadd backupdba
  groupadd dgdba
  groupadd kmdba
  groupadd racdba
  groupadd oper
  useradd -g oinstall -G dba,asmdba,backupdba,dgdba,kmdba,racdba,oper -m oracle
  ```

  4、配置域名解析文件（暂定）

  ```
  vi /etc/hosts
  ```

  5、配置系统内核参数

  ```
  1、vi /etc/sysctl.conf 
  2、赋值下列配置：
  fs.aio-max-nr = 1048576
  fs.file-max = 6815744
  kernel.shmall = 16451328
  kernel.shmmax = 33692319744
  kernel.shmmni = 4096
  kernel.sem = 250 32000 100 128
  net.ipv4.ip_local_port_range = 9000 65500
  net.core.rmem_default = 262144
  net.core.rmem_max = 4194304
  net.core.wmem_default = 262144
  net.core.wmem_max = 1048576
  3、输入sysctl -P使配置生效：/sbin/sysctl -p
  ```

  6、关闭selinux和防火墙

  7、配置用户环境

  ```
  1、登入oracle：su - oracle
  2、修改文件：vi .bash_profile 
  
  # Get the aliases and functions
  if [ -f ~/.bashrc ]; then
          . ~/.bashrc
  fi
  
  # User specific environment and startup programs
  
  PATH=$PATH:$HOME/.local/bin:$HOME/bin
  
  export PATH
  
  export ORACLE_BASE=/u01/app/oracle
  export ORACLE_HOME=/u01/app/oracle/product/19.5.0
  export PATH=$PATH:$ORACLE_HOME/bin:/usr/local/bin
  export ORACLE_HOSTNAME=ywxtdb
  export ORACLE_SID=ywxtdb
  export LD_LIBRARY_PATH=$ORACLE_HOME/lib:$ORACLE_HOME/rdbms/lib:$ORACLE_HOME/network/lib:/lib:/usr/lib
  export CLASSPATH=$ORACLE_HOME/jlib:$ORACLE_HOME/rdbms/jlib:$ORACLE_HOME/network/jlib
  
  3、创建oracle安装目录
  [root@host-173-16-87-178 ~]# mkdir /u01
  [root@host-173-16-87-178 ~]# chmod 777 /u01
  ```

  8、修改用户的Shell限制

  ```
  1、vi /etc/security/limits.conf 
  
  # /etc/security/limits.conf
  #
  #This file sets the resource limits for the users logged in via PAM.
  #It does not affect resource limits of the system services.
  #
  #Also note that configuration files in /etc/security/limits.d directory,
  #which are read in alphabetical order, override the settings in this
  #file in case the domain is the same or more specific.
  #That means for example that setting a limit for wildcard domain here
  #can be overriden with a wildcard setting in a config file in the
  #subdirectory, but a user specific setting here can be overriden only
  #with a user specific setting in the subdirectory.
  #
  #Each line describes a limit for a user in the form:
  #
  #<domain>        <type>  <item>  <value>
  #
  #Where:
  #<domain> can be:
  #        - a user name
  #        - a group name, with @group syntax
  #        - the wildcard *, for default entry
  #        - the wildcard %, can be also used with %group syntax,
  #                 for maxlogin limit
  #
  #<type> can have the two values:
  #        - "soft" for enforcing the soft limits
  #        - "hard" for enforcing hard limits
  #
  #<item> can be one of the following:
  #        - core - limits the core file size (KB)
  #        - data - max data size (KB)
  #        - fsize - maximum filesize (KB)
  #        - memlock - max locked-in-memory address space (KB)
  #        - nofile - max number of open file descriptors
  "/etc/security/limits.conf" 67L, 2542C
  #        - fsize - maximum filesize (KB)
  #        - memlock - max locked-in-memory address space (KB)
  #        - nofile - max number of open file descriptors
  #        - rss - max resident set size (KB)
  #        - stack - max stack size (KB)
  #        - cpu - max CPU time (MIN)
  #        - nproc - max number of processes
  #        - as - address space limit (KB)
  #        - maxlogins - max number of logins for this user
  #        - maxsyslogins - max number of logins on the system
  #        - priority - the priority to run user process with
  #        - locks - max number of file locks the user can hold
  #        - sigpending - max number of pending signals
  #        - msgqueue - max memory used by POSIX message queues (bytes)
  #        - nice - max nice priority allowed to raise to values: [-20, 19]
  #        - rtprio - max realtime priority
  #
  #<domain>      <type>  <item>         <value>
  #
  
  #*               soft    core            0
  #*               hard    rss             10000
  #@student        hard    nproc           20
  #@faculty        soft    nproc           20
  #@faculty        hard    nproc           50
  #ftp             hard    nproc           0
  #@student        -       maxlogins       4
  
  # End of file
  # Set Oracle Database Server
  @oinstall soft nofile 2048
  @oinstall hard nofile 65536
  @oinstall soft nproc 16384
  @oinstall soft stack 10240
  ```

  