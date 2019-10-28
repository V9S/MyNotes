### 导入代码格式化样式 ###
- 在Windows-Preferences-Java-CodeStyle-Formatter中导入"..\p3c\p3c-formatter\eclipse-codestyle.xml"
- 在Windows-Preferences-Java-CodeStyle-CodeTemplates中导入"..\p3c\p3c-formatter\eclipse-codeTemplate.xml"
### 阿里编码规约扫描 ###
- 将目录"..\p3c\eclipse-plugin"下【features】及【plugins】复制到eclipse目录，重启eclipse
- 或者在Help-Install New Software中添加https://p3c.alibaba.com/plugin/eclipse/update地址进行安装
### debug ###
- 断点处右键选择Breakpoint Properties，勾选Conditional可以添加断点条件
### 快捷键 ###
- 查看一个方法都被谁调用过：选中方法后Ctrl+Alt+H 或者Ctrl+Shift+G
- 快速添加作者日期等注释信息：ALT + SHIFT +J
- 进入列编辑模式：ALT + SHIFT + A
- SHIFT + F2 ：将光标放在方法或者类上，打开文档