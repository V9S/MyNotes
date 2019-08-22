## 深克隆与浅克隆 
###为什么克隆：
克隆可以保存你想要克隆对象的值，而new出来的对象中没有属性值。clone是一个native方法，快。
###如何实现克隆：
- 被克隆的类实现标识接口Cloneable
- 覆盖Object中的clone()方法
- 在clone()方法中调用super.clone();
###深克隆与浅克隆定义




