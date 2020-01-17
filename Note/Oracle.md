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
### 数据库导出 ###
#### 普通导出 ####
- 1、完全导出：

	`exp xinxiaoyong/123456@127.0.0.1:1521/orcl file="e:\temp.dmp" full = y;`
- 2、部分表的导入导出：

	`exp(imp)  username/password@SERVICENAME:1521 file="e：\temp.dmp" tabels=(table1,table2,table3,...);`
- 3、表空间tablespaces导入导出（一个数据库实例可以有N个表空间(tablespace)，一个表空间下可以有N张表(table)）：

	`exp(imp)  username/password@SERVICENAME:1521 file="e:\temp.dmp" tablespaces=(tablespace1,tablespace2,tablespace3,...);`
- 4、用户名username对象导入导出：

	`exp(imp) username/password@SERVICENAME:1521 file="e:\temp.dmp" owner(username1,username2,username3);`
#### 数据泵导出 ####
- 1、创建目录
- 2、导出数据库

    `expdp xinxiaoyong/123456@127.0.0.1:1521 schemas=xinxiaoyong dumpfile=test.dmplogfile=test.log directory=testdata1;`
（schemas：导出操作的用户名;dumpfile：导出的文件;logfile:导出的日志文件,可以不写；directory:创建的文件夹名称;remap_schema=源数据库用户名:目标数据库用户名,二者不同时必写，相同可以省略;）
	
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

- 查询：select * 
- 
-  (select rownum rw,ID  from np_user order by ID desc ) where rw>100 ;

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
### 查询以0结尾的字段 ###
- select telephone from  np_user where telephone like  '%0'
- 查询包含5522的字段：select telephone from  np_user where telephone like  '%5522%'
- 使用plsql导出表，不同表空间、用户名无法导入



- 关键词 DISTINCT 用于返回唯一不同的值。  
	`SELECT DISTINCT Company FROM Orders`
    



- 查询登录次数:
`SELECT resource_name,resource_type,limit FROM dba_profiles WHERE profile='DEFAULT';`



- 设置登录次数无限次：
`alter profile default limit FAILED_LOGIN_ATTEMPTS unlimited;`



- 解锁锁定用户：
    `alter user np_test_new account unlock;`

- oracle违反唯一性约束，表定位SQL语句：
`select cu.* from user_cons_columns cu, user_constraints au where cu.constraint_name = au.constraint_name and au.constraint_type = 'P' and au.constraint_name='SYS_C0054500';`
- oracle违反完整性约束，标定位SQL语句：    
```
SELECT A.constraint_name, A.table_name, b.constraint_name
  FROM user_constraints A, user_constraints b
 WHERE A.constraint_type = 'R'
   AND b.constraint_type = 'P'
   AND A.r_constraint_name = b.constraint_name
   AND A.constraint_name = UPPER('FKACFPI7FJUU60FQUY0S54CGYP5')
```


- 生成uuid：
`sys_guid()`
- 创建索引：
`create index index_name on table (column_name);`

- 插入其他表数据：
```
1、insert into table_1  select * from table_2;
2、insert into table1 (column_name(s)) SELECT column_name(s) from table2;
```
    

- oracle 一次insert多条记录
` insert all 
 into gams_jc_temp values  ('c767fa0f4c27436082a88f60c06cbdc8', 'TY2013000283')
 into gams_jc_temp values ('accdf7280c1d46b39d24a9704789b3d2', 'TY2013000289')
 select 1 from dual;`
- 多条语句更新自身字段：
`update gams_jc_assetclass b set b.app_template = replace(b.detail_table,'core.gams_card','app.card.card');`

- 可以查询出所有的用户表:
`select * from user_tables`


- 查询所有表，包括其他用户表:
    `select owner,table_name from all_tables;`
    
































### LeetCode中的知识点 ###
**题目1**：编写一个 SQL 查询，满足条件：无论 person 是否有地址信息，都需要基于上述两表提供 person 的以下信息：
- join和where的区别：`where a.PersonId = b.PersonId`是内连接，内连接只会查处两个表都存在的记录，如果Pserson表中有，而Address表中没有的记录，就没有办法查出来。外链接可以保证在其中一个没有数据的时候用null来代替它。
```
1、select a.FirstName, a.LastName, b.City, b.State from Person a,Address b where a.PersonId=b.PersonId
2、select a.FirstName, a.LastName, b.City, b.State from Person a left join Address b on b.PersonId  = a.PersonId;
```
- 子查询代替join：
```
select FirstName, LastName, 
(select City from Address where Address.PersonId = Person.PersonId ) as City,
(select State from Address where Address.PersonId = Person.PersonId ) as State 
from Person
```
- 去重提高效率：
```
select A.FirstName, A.LastName, B.City, B.State
from Person A
left join (select distinct PersonId, City, State from Address) B
on A.PersonId=B.PersonId;
```
**题目2**：如果一个国家的面积超过300万平方公里，或者人口超过2500万，那么这个国家就是大国家。
- 初级：
```
select w.name,w.population,w.area from World w where w.area > '3000000' or w.population > '25000000';
```
- 使用union all代替or

```
1、 对OR语句求并集，如查询SELECT * FROM TB1 WHERE c1="xxx" OR c2=""xxx"时，如果c1和c2列上分别有索引，可以按照c1和c2条件进行查询，再将查询结果合并（union all）操作，得到最终结果

2、 对AND语句求交集，如查询SELECT * FROM TB1 WHERE c1="xxx" AND c2=""xxx"时，如果c1和c2列上分别有索引，可以按照c1和c2条件进行查询，再将查询结果取交集（intersect）操作，得到最终结果
```
**题目3**：给定一个 Weather 表，编写一个 SQL 查询，来查找与之前（昨天的）日期相比温度更高的所有日期的 Id。
- DATEDIFF是两个日期的天数差集（SQLServer才有，oracle中没有）
**题目4**：编写一个 SQL 查询，查找 Person 表中所有重复的电子邮箱。
- sql语句中GROUP BY 和 HAVING的使用 count()：
```
having是分组（group by）后的筛选条件，分组后的数据组内再筛选
where则是在分组前筛选
```

```
通过使用GROUP BY 子句，可以让SUM 和 COUNT 这些函数对属于一组的数据起作用。 
当你指定 GROUP BY region 时， 属于同一个region（地区）的一组数据将只能返回一行值． 
也就是说，表中所有除region（地区）外的字段，只能通过 SUM, COUNT等聚合函数运算后返回一个值． 

HAVING子句可以让我们筛选成组后的各组数据． 
WHERE子句在聚合前先筛选记录．也就是说作用在GROUP BY 子句和HAVING子句前． 
而 HAVING子句在聚合后对组记录进行筛选。
```

```java
-- 解法1
select email from person group by email having count(email)>1

--解法2
select email from (select count(1) as t,email from person group by email)r  where r.t>1;

--解法3
select distinct(p1.Email) from Person p1  
join Person  p2 on p1.Email = p2.Email AND p1.Id!=p2.Id
```