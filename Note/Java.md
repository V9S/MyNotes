## 深克隆与浅克隆 
###为什么克隆：
克隆可以保存你想要克隆对象的值，而new出来的对象中没有属性值。clone是一个native方法，快。
### 如何实现克隆： ###
- 被克隆的类实现标识接口Cloneable
- 覆盖Object中的clone()方法
- 在clone()方法中调用super.clone();
### 深克隆与浅克隆定义 ###
- 浅克隆：是指拷贝对象时仅仅拷贝对象本身（包括对象中的基本变量），而不拷贝对象包含的引用指向的对象（类，数组，接口等）。
> 浅克隆不会拷贝对象中包含的引用指向的对象，只会克隆一份对象的引用。所以，被克隆出来的对象与原对象中所包含的类、数组、接口等复杂数据类型，指向的是同一块内存地址。用equals（）方法比较，结果为true。

- 深克隆：不仅拷贝对象本身，而且拷贝对象包含的引用指向的所有对象
> 深克隆会将被克隆对象完全克隆一份，被克隆对象中的类、数组、接口等都会被复制一份，equals方法结果为false。
### 深克隆解决方案 ###
#### 方案1：通过浅克隆的递归方式####
当被克隆对象中包含引用数据类型，对引用数据类型进行浅克隆，从而整体上实现深克隆。
#### 方案2：通过序列化操作实现深克隆 ####
将需要复制的对象进行序列化，将对象写入流中。再从流中读取对象。完成反序列化。
	
    ByteArrayOutputStream bos=new ByteArrayOutputStream();// 将对象写入流中
    	ObjectOutputStream oos= null;
    	oos.writeObject(this);
    	oos.flush();

    ByteArrayInputStream bis=new ByteArrayInputStream(bos.toByteArray());//将对象从流中取出
    	ObjectInputStream ois=new ObjectInputStream(bis);
    	return (Person)ois.readObject();
### Java 8 foreach&lambda ###

###  ###







