# Ansible 安装流程 

# 安装python 3 安装包 （ansible 依赖于python）
```
 yum install rust cargo python3-cryptography -y
 ```
# 安装pip （脚本在文件夹内）
```
 chmod 777 get-pip.py
./get-pip.py
 ```
# 使用pip3 安装最最新的ansible
``` 
pip3 install ansible -i https://pypi.org/simple
```
# 使用命令检查ansible 
```
ansible --version
```
# 安装流程结束 ##########################################################


# ansible配置文件 
	文件夹中

# ansible 从本地测试方法 
* using Ansible command line:

```bash
ansible-playbook --connection=local 127.0.0.1 playbook.yml
```

* using inventory:

```ini
127.0.0.1 ansible_connection=local
```

* using Ansible configuration file:

```ini
[defaults]
transport = local
```

* using playbook header:

```yaml
- hosts: 127.0.0.1
  connection: local
```