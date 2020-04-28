# MySQL备份恢复系统

### 核心功能

- MySQL数据备份
- MySQL数据还原

相关部署直接采用springboot的部署方式即可。针对不同的系统平台，Windows、Linux相关备份命令已做系统自动识别的调整。

### 注意事项

1、当项目部署在Windows下时，项目文件夹下有一个 mysqldump.exe 文件，这个文件来源于Windows系统安装的mysql的根目录的bin下，否则报错mysqldump不是内部命令，有些人会想到命令中指定详细目录，例如：C:\Program Files\MySQL\MySQL Server 5.7\bin\mysqldump.exe 同样存在一个问题，C:\Program Files 无法识别，因为含有空格，这个是Windows系统自带的空格，无法避免。所以部署Windows时，你需要将你本地mysqldump.exe文件覆盖项目中mysqldump.exe。

### 预览图

