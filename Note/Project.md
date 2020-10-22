- 前端项目内存溢出 </br>
在 ./node_modules/.bin/webpack-dev-server.cmd 文件中node后添加 "--max_old_space_size=6096"
- 后端无法启动注意NP分支为gams2
- Unable to start web server; nested exception is org.springframework.boot.web.server.WebServerException: Unable to start embedded Tomcat
- 项目遇到问题时，先clean一下
- vue项目打包去掉中console：在项目中的build/webpack.prod.conf.js文件中及收入以下配置，这样就可以在打包后去掉控制台打印输出了
> 
new webpack.optimize.UglifyJsPlugin({
  compress: {
    warnings: false,
    drop_debugger: true,
    drop_console: true
  },
### linux授权 ###
chmod -R 777 NpServer
- 查看运行在java虚拟机上的程序：ps -ef|grep java
### 熔断 ###
当请求响应时间过长，触发了熔断器，所以导致了请求失败。
报错：Error while sending response to client: java.io.IOException: 你的主机中的软件中止了一个已建立的连接。
Error during filtering
com.netflix.zuul.exception.ZuulException: Filter threw Exception
解决方案：添加配置
hystrix:
  command:
    default:
      execution:
        isolation:
          thread:
            timeoutInMilliseconds: 60000
- young gc 过于频繁导致系统变慢：后端程序添加配置
```json
server:
  	tomcat:
    	backgroundProcessorDelay: 90000
```

迁移数据重新迁移后要执行语句

```
update gams_unitdatatrans_detail l set l.isfinishtrans=0;

SELECT l.ISFINISHTRANS FROM gams_unitdatatrans_detail l;
```

工作流问题：

问题：提交走的流程定义是最新的（uuid），审批、取回走的流程定义是元数据的（英文字母）

解决方法：是因为workiteminfo表的workitemid比较小，比如到2000，但是nodeinstancelog表里的workItemId可能已经到6000了，所以nodeinstancelog表就不会生成新纪录，会对应之前生成的2000，所以就对应错了。alter table workiteminfo AUTO_INCREMENT=6001;用这个语句让他从6001开始生成就可以了。



### Could not find process e4fffce1-1ecd-4d1b-a6b8-db7350576f84 when restoring process instance 46

