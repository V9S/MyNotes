### 删除docker中的镜像

1、停止docker中正在运行的镜像

```
docker rm id
```

![image-20200826160417349](C:\Users\ZLM\AppData\Roaming\Typora\typora-user-images\image-20200826160417349.png)

2、移除容器中的镜像：

```
docker rm id
```

3、移除image中的镜像：

```
docker rmi id 
```

![image-20200826160645904](C:\Users\ZLM\AppData\Roaming\Typora\typora-user-images\image-20200826160645904.png)

### Docker修改IP地址的方法

1、查看docker ip得知

```
root@master:/# ifconfig docker0
docker0: flags=4099<UP,BROADCAST,MULTICAST>  mtu 1500
        inet 172.17.10.1  netmask 255.255.0.0  broadcast 172.17.255.255
        ether 02:42:4e:31:70:a8  txqueuelen 0  (Ethernet)
        RX packets 0  bytes 0 (0.0 B)
        RX errors 0  dropped 0  overruns 0  frame 0
        TX packets 0  bytes 0 (0.0 B)
        TX errors 0  dropped 0 overruns 0  carrier 0  collisions 0
```

2、修改IP地址（切勿与宿主机同网段）

```
vi /etc/docker/daemon.json
```

添加如下内容

```
{
	 "registry-mirrors": [
		 "https://docs.docker.com"
	  ],
	 "bip": "172.17.10.1/16"
}
```

3、重启docker服务

```
service docker restart
```

#### docker ps 如何查看完整command

```
docker ps --no-trunc
```

#### docker 查看详细配置信息

```
docker inspect <CONTAINER-NAME> OR <CONTAINER-ID>
```

