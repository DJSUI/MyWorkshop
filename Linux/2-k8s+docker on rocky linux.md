# Insatll Kubernetes on RockyLinux8 
## Prerequisites 
    docker have been installed 

## ON ALL NODES
### disable swap   
``` 
sudo swapoff -a
sudo sed -i '/ swap / s/^/#/' /etc/fstab
``` 
### shutdown security  
``` 
setenforce 0
sed -i --follow-symlinks 's/SELINUX=enforcing/SELINUX=disabled/g' /etc/sysconfig/selinux
```
### create kubernetes repo  
```
[kubernetes]
name=Kubernetes
baseurl=https://pkgs.k8s.io/core:/stable:/v1.28/rpm/
enabled=1
gpgcheck=1
gpgkey=https://pkgs.k8s.io/core:/stable:/v1.28/rpm/repodata/repomd.xml.key
```
### install kube  
```
sudo yum  install -y kubelet kubeadm kubectl
```
### change conatinerd config file 
```
sudo mv /etc/containerd/config.toml /etc/containerd/config.toml.bak
sudo containerd config default | sudo tee /etc/containerd/config.toml
crictl config runtime-endpoint unix:///run/containerd/containerd.sock
```
### restart and enable relative service 
```
systemctl enable --now  kubectl 
systemctl enable --now  containerd   
```
### 

## ON MASTER NODE 
### set k8s inner network 
```
sudo kubeadm init --pod-network-cidr=10.244.0.0/16
kubeadm join 192.168.8.134:6443 --token 8opq5e.cvfof0yl6z1bfenb \
        --discovery-token-ca-cert-hash sha256:0bb59766624a95d201441c5cfa2e6e05220d60332077dd467ea95d3bb72eb0de

```
### set k8s access directory 
```

mkdir -p $HOME/.kube
sudo cp -i /etc/kubernetes/admin.conf $HOME/.kube/config
sudo chown $(id -u):$(id -g) $HOME/.kube/config
```
### install flannel plug 
 ```
 kubectl apply -f https://raw.githubusercontent.com/flannel-io/flannel/master/Documentation/kube-flannel.yml
```
### feature hotkey 
```
sudo yum install bash-completion
echo "source <(kubectl completion bash)" >> ~/.bashrc
source ~/.bashrc
```








