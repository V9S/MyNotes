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

