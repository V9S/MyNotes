### 数据库导入 ###
#### 普通导入 ####
- 1、创建表空间

    CREATE TABLESPACE np_test LOGGING DATAFILE 'E:\app\ZLM\oradata\orcl\np_test.DBF' size 1000m autoextend on next 10m maxsize unlimited;
- 2、创建用户

    CREATE USER np_test IDENTIFIED BY np_test DEFAULT TABLESPACE np_test;
- 3、授权

    grant dba,connect,resource to np_test;
- 4、导入（在cmd下）

    imp np_test/np_test@orcl file=E:\test_np.DMP full=y ignore=y;
#### 数据泵导入（数据库较大时） ####
 
- 1、重复 普通导入的前三步
- 2、创建文件夹

    Create or replace directory DMP_DIR as 'D:\oracle_beifen';
- 3、给用户授权文件夹权限

    Grant read,write on directory DMP_DIR to np_test;
- 4、给用户授权导入导出权限

    grant exp_full_database,imp_full_database to np_test;
- 5、导入（在cmd下）

    impdp np_test/np_test@orcl directory=DMP_DIR dumpfile=NP_TEST.DMP  logfile=np_test.log;
### 删除操作 ###
- 删除用户

    drop user np_test cascade;
- 删除表空间

    drop tablespace np_test including contents and datafiles cascade constraint;
## 错误 ##
- ORA-39001: 参数值无效
  ORA-39000: 转储文件说明错误
  ORA-39143: 转储文件 "E:\a.dmp" 可能是原始的导出转储文件
> 问题原因：dmp文件是使用exp命令导出的，故应该用imp命令导出，而不能用impdp命令。