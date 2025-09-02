# Insatll Kubernetes on RockyLinux8 
## Prerequisites 
    docker have been installed 
    K8s  have been installed 

## ON MASTER NDOE
### make sure all pods are working in name space awx 
``` 
 kubectl  get all -n awx
``` 
### create storageclass for awx database using 
``` 
kubectl get storageclass  
wget https://raw.githubusercontent.com/rancher/local-path-provisioner/v0.0.24/deploy/local-path-storage.yaml
kubectl  apply -f local-path-storage.yaml
kubectl get storageclass
``` 
### clone repository and apply to kube 
    (it would create instance and pvc at same time )
``` 
 git clone https://github.com/ansible/awx-operator.git
 cd awx-operator
 kubectl apply  -k .
``` 
### check 
``` 
 kubectl get pods -n awx
 kubectl get pvc -n awx 
 kubectl get svc  -n awx
``` 
### forward port  
``` 
kubectl port-forward --address 0.0.0.0 svc/awx-demo-service -n awx 8080:80
``` 

### check password of admin 
``` 
 kubectl get secret  -n awx

kubectl -n awx get secret xxxxx -o go-template='{{range $k,$v := .data}}{{printf "%s: " $k}}{{if not $v}}{{$v}}{{else}}{{$v | base64decode}}{{end}}{{"\n"}}{{end}}'
``` 






