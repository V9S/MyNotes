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

  查看防火墙：`systemctl status firewalld`