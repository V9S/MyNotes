#### 字符函数

拼接字符串connat（str a,str b...）

ifnull（a,0）

select * from gams_card where jiaz between 100 and 200;



length() 获取字节数



LPAD("字段"，长度，‘字符’)：左填充，填充为指定长度



RPAD("字段"，长度，‘字符’)：右填充



replace（“字段”，“被替换字符”，“替换字符”）



#### 数学函数

round（字段）：四舍五入

round（字段，n）：四舍五入保留n位

ceil（字段）：向上取整

floor（字段）：向下取整

truncate（字符，n）：这届截取n位

mod（a,b）：取余

#### 日期函数

now()：返回系统当前日期+时间

curdate():返回系统当前日期

curtime():返回当前时间

#### 其他函数

select version()：数据库版本

select database（）：当前数据库

select user() ： 当前用户

#### 流程控制函数

select if(a>b,"true","false")

case函数：

case a when b then c ... else d end;

#### 删除

```
delete 删除表，在插入数据，自增列的值从断点开始。
truncate删除表，再插入数据，从1开始。
delete 删除有返回值，可以回滚。
truncate删除没有返回值，不可以回滚。
```

### 库操作

#### 创建库

```
create database if not exists books;
```

#### 更改库的字符集

```
alter database books character set gbk;
```

#### 删除库

```
drop database if exists books;
```

### 表操作

#### 创建表

```
create table 表名(列明 类型 【(长度) 约束】，....);
```

#### 修改表

```
改列名：alter table books change column 列名 新列名 类型;
改列类型:alter table books modify column 列名 类型;
添加新列: alter table books add column 列名 类型;
删除列:alter table books drop column 列名;
修改表名: alter table books remame to 新表名;
```

#### 删除表

```
drop table books;
```

#### 表复制

```sql
仅复制表的结构：create table book like books;
复制结构及数据：create table book select * from books;
```

### 常见数据类型

数值型：

​			整型

​			小数：定点数、浮点数

字符型：

​			较短文本：char、varchar

​			较长文本：text、blob（较长二进制数据）

### 约束

约束分类：

```sql
not null
default：默认值
primary key：主键，保证字段值唯一且非空
unique：唯一，可为空
check：检查约束（mysql中不支持）
foreign key：外键，限制两个表的关系，用于保证该字段必须来源于主表关联列的值。
```

### 指令

```
show engines; 显示mysql引擎。
```

```
show variables;显示系统变量。
```



#### 将多个语句作为为同一事务

```
set autocommit = 1;
start transaction;
语句1，语句2...
commit;(rollback)
```

### 事务隔离级别

```
					脏读	不可重复读	幻读
read uncommitted	1		1		1
read committed		0		1		1
repeatable read		0		0		1
serializable		0		0		0

mysql默认repeatable read
oracle默认read committed

查看隔离级别
select @@tx_isolation;
设置隔离级别
set session|global transaction isolation level 隔离级别;
```

#### 保存点：savepoint（搭配rollback使用）

```
set autocommit = 1;
start transaction;
语句1，

savepoint a;//设置保存点

语句2...
rollback to a;
```

### 视图

```
创建：create or replace view name as select * from a;
修改：alter view name as select * from a;
删除：drop view name;
查看：desc name;
```

视图和表一样可以进行增、删、改（部分）、查操作，但是一般会给视图限制权限，只读。

### 变量

系统变量：

​			全局变量

​			会话变量

自定义变量：

​			用户变量

​			局部变量

```
全局变量：变量由系统提供。
作用域：服务器每次启动将为所有全局变量赋初始值，针对所有会话（连接）有效，但不能跨重启。
1、查看所有系统变量
show global|【session】 variables;
2、带条件系统变量
show global|【session】 variables like '%a';
3、查看指定变量值
select @@global|【session】.变量名;
4、赋值
（1）set global|【session】 变量名 = 值;
（1）set @@global|【session】.变量名 = 值;
```

```
会话变量
作用域：仅仅针对当前会话（连接）有效。
1、查看所有会话变量
（1）show  variables;
（2）show session variables;
2、带条件系统变量
show session variables like '%a';
3、查看指定变量值
select @@session.变量名;
4、赋值
（1）set session 变量名 = 值;
（1）set @@session.变量名 = 值;
```

```
用户变量
作用域：针对当前会话(连接)有效，同于会话变量作用域。
1、声明并初始化 = 或：=
(1)set @用户变量名 = 值;
(2)set @用户变量名：= 值;
(3)select @用户变量名：= 值;
2、赋值
（1） 与声明语句相同
（2）通过select into
select 字段 into 变量名 from 表;
3、查看变量值
select @用户变量名;
```

```
局部变量
作用域：仅仅在定义它的begin end 中有效,应用在begin end 中的第一句话。
1、声明
declare 变量名 类型 【default 值】；
2、赋值
方式一：
(1)set @局部变量名 = 值;
(2)set @局部变量名：= 值;
(3)select @局部变量名：= 值;
方式二：
(1)通过select into
(2)select 字段 into 局部变量名 from 表;
3、查看
select 局部变量名;
```

### 存储过程和函数

```
类似于java中的方法
好处：1、提高代码重用性；2、简化操作。
```

#### 存储过程

```
含义：一组预先编译好的SQL语句的集合，理解成批处理语句。
```

```
语法：
一、创建
create procedure 存储过程名(参数列表)
begin 
	存储过程体（一组合法的SQL语句）
end
注意：
1、参数列表包含三部分
参数模式、参数名、参数类型
参数模式：
in ：该参数可作为输入，需要调用方传入值。
out：该参数可以作为输出。可作为返回值。
inout：既可以作为输入，也可以作为返回值。
2、如果存储过程体只有一句话，begin end 可省略。
过程体中的每条SQL语句结尾必须加分号。存储过程结尾可以使用delimiter 重新设置
语法：
delimiter 结束标记
delimiter $
二、调用
call 存储过程名（实参列表）;
```

