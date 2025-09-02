# Insatll Docker on RockyLinux8 
## 1. Remove old versions
``` 
sudo dnf remove -y docker \
    docker-client \
    docker-client-latest \
    docker-common \
    docker-latest \
    docker-latest-logrotate \
    docker-logrotate \
    docker-engine

```
## 2. Remove Podman and its dependencies
```
sudo dnf remove -y podman podman-catatonit runc
```
## 3. Add Docker CE repository
```
sudo dnf config-manager --add-repo https://download.docker.com/linux/centos/docker-ce.repo

```
## 4. Install Docker Engine
```
sudo dnf install -y docker-ce docker-ce-cli containerd.io
```
## 5. Start and enable Docker
```
sudo systemctl enable --now docker
sudo systemctl status docker
```
## 6. Verify Docker
```
docker --version
sudo docker run hello-world
```
