#!/bin/bash

echo '***Step 1: 登录EC2'
echo 'ssh -i "<xxx.pem>" ec2-user@<host>'

echo '***Step 2: 添加用户'
echo '修改root密码：sudo passwd root'
echo '修改/etc/ssh/sshd_config -> PasswordAuthentication yes'
echo '/sbin/service sshd restart'
echo '修改ec2-user密码：passwd ec2-user'

echo '***Step 3: 使用pub key方式登录'
echo 'copy id_rsa.pub到ec2 ~/.ssh/authorized_keys'
echo '配置本机~/.ssh/config'

echo '***Step 4: 安装oracle jdk 1.8'
echo '下载oracle jdk：wget --no-check-certificate --no-cookies --header "Cookie: oraclelicense=accept-securebackup-cookie" http://download.oracle.com/otn-pub/java/jdk/8u131-b11/d54c1d3a095b4ff2b6607d096fa80163/jdk-8u131-linux-x64.rpm'
echo 'rpm 安装：rpm -i <jdk binary file>'

echo '***Step 5: 安装maven'
echo 'wget http://apache.fayea.com/maven/maven-3/3.5.0/binaries/apache-maven-3.5.0-bin.tar.gz'
echo 'tar -xvf apache-maven-3.5.0-bin.tar.gz'
echo '修改~/.bash_profile'

echo '***Step 6: 安装docker'
echo '参考：http://www.jianshu.com/p/040f711efc34'
echo 'aws linux请参考：https://serverfault.com/questions/836198/how-to-install-docker-on-aws-ec2-instance-with-ami-ce-ee-update'

echo '***Step 7: 安装docker-compose'
echo 'curl -L https://github.com/docker/compose/releases/download/1.13.0/docker-compose-`uname -s`-`uname -m` > docker-compose'
