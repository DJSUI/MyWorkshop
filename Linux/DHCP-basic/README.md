# DHCP-basic


## Install Dhcp server 
```
yum -y install dhcp-server
```

## Reference Doc 
```
/usr/share/doc/dhcp-server/dhcpd.conf.example
```

## Basic  example

###  dhcp main config    
```
subnet 10.5.5.0 netmask 255.255.255.224 {
  range 10.5.5.26 10.5.5.30;
  option domain-name-servers ns1.internal.example.org;
  option domain-name "internal.example.org";
  option routers 10.5.5.1;
  option broadcast-address 10.5.5.31;
  default-lease-time 600;
  max-lease-time 7200;
}
```

### dhcp bundle  IP  config (Optional)

```
host fantasia {
  hardware ethernet 08:00:07:26:c0:a5;
  fixed-address fantasia.example.com;
}
```

