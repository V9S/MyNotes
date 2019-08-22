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
