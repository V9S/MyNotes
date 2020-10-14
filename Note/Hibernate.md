### hibernate 里 unique与unique-key的区别

hibernate 建表的 映射文件里 ，如果配置了unique=“true”,那么每个字段都是一个独立的唯一约束字段。如果两个字段同时配置了unique-key=“true”,那么在这张表中这两个字段会组成一对唯一约束条件组合，只有两个字段同时重复才会违反约束条件，其中一个重复是没有问题的。

