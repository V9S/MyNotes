### 数据库导入 ###
#### 普通导入 ####
- 1、创建表空间

    CREATE TABLESPACE np_test LOGGING DATAFILE 'E:\app\ZLM\oradata\orcl\np_test.DBF' size 1000m autoextend on next 10m maxsize unlimited;
- 2、创建用户

    CREATE USER np_test IDENTIFIED BY np_test DEFAULT TABLESPACE np_test;
- 3、授权

    grant dba,connect,resource to np_test;
- 4、导入

    imp np_test/np_test@orcl file=E:\test_np.DMP full=y ignore=y;
#### 数据泵导入（数据库较大时） ####
 
- 1、重复 普通导入的前三部
- 2、创建文件夹

    Create directory DMP_DIR as 'D:\oracle_beifen';
- 3、给用户授权文件夹权限

    Grant read,write on directory DMP_DIR to np_test;
- 4、给用户授权导入导出权限

    grant exp_full_database,imp_full_database to np_test;
- 5、导入

    impdp np_test/np_test@orcl directory=DMP_DIR dumpfile=NP_TEST.DMP  logfile=np_test.log;
### 删除操作 ###
- 删除用户

    drop user np_test cascade;
- 删除表空间

    drop tablespace np_test including contents and datafiles cascade constraint;