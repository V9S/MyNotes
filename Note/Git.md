# Git相关知识 #

----------

## git配置 ##
配置git时用到一些变量，这些变量可以存放在以下三个不同的地方：


- /etc/gitconfig 文件：系统中对所有用户都普遍适用的配置。若使用 git config 时用 --system 选项，读写的就是这个文件。
- ~/.gitconfig文件：用户目录下的配置文件只适用于该用户。若使用 git config 时用 --global 选项，读写
的就是这个文件。
- .git/config文件：当前项目的 git 目录中的配置文件（也就是工作目录中的 .git/config 文件）：这里的配置仅仅针对当前
项目有效。**每一个级别的配置都会覆盖上层的相同配置，所以 .git/config 里的配置会覆盖 /etc/gitconfig
中的同名变量。**
- .gitignore 一般我们总会有些文件无需纳入 Git 的管理，也不希望它们总出现在未跟踪文件列表，这时可以配置gitignore文件。
## 取得项目的git仓库 ##
- 通过命令`git init`：如果想要使用git管理某个项目，只需要在此项目的目录执行该命令，就会出现一个.git的目录，所有Git所需要的数据和资源都存放在这个目录中。但是此时还没有开始跟踪管理项目中的任何一个文件。如果需要将文件纳入版本控制，先要使用`git add <file>`命令告诉Git开始对这些文件进行跟踪，然后提交。
- 从现有仓库克隆：使用`git clong [url]`命令从现有仓库进行克隆项目
## Git命令 ##
- git status：检查当前文件状态。</br>
文件只要出现在 **Untracked files**这行下面，就说明文件未被跟踪（没有commit add）。</br>
文件只要出现在 **Changes to be committed**这行下面，就说明文件已被跟踪，是已暂存状态。</br>
文件只要出现在 **Changed but not updated**这行下面，说明已跟踪文件的内容发生了变化，但还没有放到暂存区。</br>
同一个文件同时出现在上述两个标识下边，标识在进行暂存后又对该文件进行了修改，这时进行提交是提交的修改之前的文件，如果需要提交新更改的文件，需要从新将文件放入暂存区（commit add）
- git add <file>：踪一个新文件</br>
git add 后可以接要跟踪的文件或目录的路径。如果是目录的话，就说明要递归跟踪所有该目录下的文件。
- git commit -m "提交信息"：提交更新</br>
提交的是暂存区(git add)的文件。
- **git commit -a：自动把所有已经跟踪过的文件暂存起来一并提交，从而跳过 git add 步骤**

- git rm： 从暂存区移除文件。如果手动删除会出现**Changed but not updated**，</br>
当git rm后，这时git status后会出现**Changes to be committed**，再commit和push进行删除git仓库中的文件。
- git rm --cached：将文件从git仓库中删除，但是**工作目录中的文件保存**
- git log：查看历史提交记录**-p 显示每次提交差异内容，-2 仅显示最近两次更新**
- git mv *file1* *file2*:将file1重命名为file2
- git reset HEAD *file*：取消已暂存的文件。
- git checkout --*file*:取消对文件的修改（**如果该文件被添加到暂存区过，那么拉去的是暂存区的文件，如果从来没有被添加到暂存区过，那么拉去的是git仓库中的**）
- git branch *分支名*：创建新分支，**不会切换分支**
- git checkout *分支名*：切换分支
- git checkout -b *分支名*：创建新分支并切换到新分支
- git branch -d *分支名*：删除分支
- git merge *分支名*：合并分支
- git branch：列出全部分支
- git stash:暂存

先执行 git config --global credential.helper store
然后执行 git pull origin master
输入用户名密码后可以记住用户名密码，避免频繁输入

- git status是发现有些文件是修改过的，但是如果要查看文件更改了哪些内容的话，可以使用git diff + 文件名进行查看
#### git如何撤销commit(未push) ####
撤销commit一般用git reset ，语法如下：

    git reset [ --mixed | --soft | --hard] [<commit ID>]
- 1.使用参数--mixed(默认参数)，如`git reset --mixed <commit ID>或git reset <commit ID>`
撤销git commit，撤销git add，保留编辑器改动代码
- 2.使用参数--soft，如`git reset --soft<commit ID>`
撤销git commit，不撤销git add，保留编辑器改动代码
- 3.使用参数--hard，如`git reset --hard <commit ID>`——**此方撤销git commit，撤销git add，删除编辑器改动代码

输入git log，我们可以看到最近的3次提交，最近一次提交是test3，最早的一次是test1，其中一大串黄色的字母是commit id（版本号） 

- git clone制定分支代码：`git clone -b <分支名> <下载地址>`

- 执行命令： `git config --global core.quotepath false` GitBash设置zh_CN UTF-8 后执行命令刷新控制台，可显示中文

- 使用git pull拉取代码的时候，无法拉取最新代码，报"unable to update local ref"错误：

  1、切换到之前clone代码目录下，执行命令

  ```
  git gc --prune=now或者git gc 
  ```

  2、再执行命令

  ```
  git pull
  ```

  3、有问题再执行后再做pull操作 

  ```
  git remote prune origin
  ```

  ### 删除保存在本地的git账户
  
  ```
  git credential-manager uninstall
  ```
  
  ### 缓存账户
  
  ```
  git config --global credential.helper wincred
  ```
  
  ### 每次都无法克隆代码
  
  ```
  git config –global http.emptyAuth true
  这条语句导致，改成false
  ```
  
  