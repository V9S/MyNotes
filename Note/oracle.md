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

### 删除100行以后的数据 ###

- 查询：select * from (select rownum rw,ID  from np_user order by ID desc ) where rw>100 ;

- 删除：delete from np_user where ID in （select ID from (select rownum rw, ID from np_user order by ID desc ) where rw>100 ）;

### 创建新字段 ###
- 默认非空：alter table np_user add test varchar(20 char)  Default 0 NOT NULL;



- 默认为空：alter table np_user add test varchar(20 char)  NULL;
### 删除字段 ###

ALTER TABLE np_user DROP COLUMN test; 

### 字段间数据导入 ###
- 同表字段间数据导入：update np_user set test = sex;
- 异表间字段数据导入：update np_user t set test = (select sex  from np_user_temp b where t.id=b.id  );
- 不同数据库之间：update  npzc_xgd.gams_card t  set (t.cunfdd_old,t.shiybm_old,t.shiyr_old)=(select s.存放地名称,s.领用单位名,s.人员编号  from zcgl_jy.s1 s where t.billcode=s.仪器编号 )
### 根据已有表创建新表 ###
- create table np_user_temp as select * from np_user;
- 创建新表：CREATE TABLE contrast_xgd(
departmentid varchar(100),
departmentname varchar（100）,
sdepartmentid  varchar（100）,
sdepartmentname varchar（100）
)

- 将表的只读模式改为读写模式，可以在plsql中手动添加数据
### 删除表 ###
- 删除表：drop table contrast_xgd
- 强制删除表（带有外键）：drop table gams_jc_department cascade constraints;
- 删除表中数据：delete from tablename
### 收回dba权限 ###
- revoke dba from npzc_xgd
### 当前用户被授予的角色 ###
-  select * from user_role_privs;



