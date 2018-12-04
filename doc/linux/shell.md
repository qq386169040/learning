```
# Linux查看版本当前操作系统内核信息
uname -a

# Linux查看当前操作系统版本信息
cat /proc/version

```

login shell:  ~/.profile
normal shell
interactive shell:  read ~/.bashrc 
/etc/profile sources ~/.bashrc

在刚登录Linux时，首先启动 /etc/profile 文件，然后再启动用户目录下的 ~/.bash_profile、 ~/.bash_login或 ~/.profile文件中的其中一个，执行的顺序为：~/.bash_profile、 ~/.bash_login、 ~/.profile。如果 ~/.bash_profile文件存在的话，一般还会执行 ~/.bashrc文件

```
/etc/profile: 此文件为系统的每个用户设置环境信息,当用户第一次登录时,该文件被执行.并从/etc/profile.d目录的配置文件中搜集shell的设置.
/etc/bashrc:  为每一个运行bash shell的用户执行此文件.当bash shell被打开时,该文件被读取.
~/.bash_profile: 每个用户都可使用该文件输入专用于自己使用的shell信息,当用户登录时,该文件仅仅执行一次!默认情况下,他设置一些环境变量,执行用户的.bashrc文件.
~/.bashrc: 该文件包含专用于你的bash shell的bash信息,当登录时以及每次打开新的shell时,该该文件被读取.
~/.bash_logout: 当每次退出系统(退出bash shell)时,执行该文件.
 
另外,/etc/profile中设定的变量(全局)的可以作用于任何用户,而~/.bashrc等中设定的变量(局部)只能继承/etc/profile中的变量,他们是"父子"关系.
```

```
# unalias
alias:  
    alias egrep='egrep --color=auto'
　　alias fgrep='fgrep --color=auto'
　　alias grep='grep --color=auto'
　　alias l='ls -CF'
　　alias la='ls -A'
　　alias ll='ls -alF'
　　alias ls='ls --color=auto'

　　alias hp="http_proxy=http://localhost:8123"
```