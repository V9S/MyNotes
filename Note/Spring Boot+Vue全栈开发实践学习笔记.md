# 报错 #
- The type org.springframework.beans.factory.support.BeanNameGenerator cannot be resolved. It is indirectly referenced from required .class files</br>
    
> 解决：


# 注解 #

- @EnableAutoConfiguration 注解表示开启自动化配直
- @ComponentScan 进行包扫描
- ＠Spring BootApplication代替前两个注解，添加在**启动类**上。
- @restController组合注解可以代替@Controller和@ResponseBody注解

- @Transactional注解的方法中同一事务可以拿到数据（如先update，在select虽然update没有提交，但是因为在同一事物中，select可以拿到update后的值，其他事物无法拿到，还是原值）