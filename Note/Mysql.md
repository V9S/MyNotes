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