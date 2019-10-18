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