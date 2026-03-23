# *******************************************************************
# * PROVIDER *
# *******************************************************************
terraform {
  required_providers {
    aws = {
      source  = "hashicorp/aws"
      version = "~> 6.0"
    }
  }
  required_version = ">= 1.0.0"
}

provider "aws" {
  region = "ap-northeast-1"

}

# *******************************************************************
# * NETWORK*
# *******************************************************************

data "aws_security_group" "existing_sg" {
  name = "let it come"

}

resource "aws_subnet" "subnet2" {
  vpc_id            = "vpc-061ddbfa1a2e0d135"
  cidr_block        = "172.31.16.0/20"  # subnet 1  172.31.0.0/20
  availability_zone = "ap-northeast-1c" #subnet 1 ap-northeast-1a
  tags = {
    Name = "subnet2"
  }
}

#Route Table Association For subnet2  
resource "aws_route_table_association" "all-in-one-public-rta" {
  subnet_id      = aws_subnet.subnet2.id
  route_table_id = "rtb-034d7025dba647e8a"
}

# *******************************************************************
# * COMPUTE *
# *******************************************************************


module "ec2_instance_subnet1" {
  # not using  local module  instaead using terraform registry module
  # change the source to local path if you want to use local module
  count                       = 1 # create 3 instances
  source                      = "terraform-aws-modules/ec2-instance/aws"
  name                        = "public_instance_subnet1"
  instance_type               = "t3.micro"
  key_name                    = "Kissme"
  subnet_id                   = "subnet-01cb8d0fde70c4da2" # subnet 1
  vpc_security_group_ids      = [data.aws_security_group.existing_sg.id]
  associate_public_ip_address = true
  ami                         = "ami-08f0737412a47a5ed"
  user_data                   = <<-EOF
                                #!/bin/bash 
                                yes | sudo dnf update 
                                yes | sudo dnf  install httpd 
                                echo "<h1>Server Details</h1><p><strong>Hostname:</strong> $(hostname)</p><p><strong>IP Address:</strong> $(hostname -I | cut -d" " -f1)</p>" > /var/www/html/index.html 
                                sudo systemctl restart httpd
                                EOF
}


module "ec2_instance_subnet2" {
  # not using  local module  instaead using terraform registry module
  # change the source to local path if you want to use local module
  count                       = 1 # create 3 instances
  source                      = "terraform-aws-modules/ec2-instance/aws"
  name                        = "public_instance_subnet2"
  instance_type               = "t3.micro"
  key_name                    = "Kissme"
  subnet_id                   = aws_subnet.subnet2.id # subnet 2
  vpc_security_group_ids      = [data.aws_security_group.existing_sg.id]
  associate_public_ip_address = true
  ami                         = "ami-08f0737412a47a5ed"
  user_data                   = <<-EOF
                                #!/bin/bash 
                                yes | sudo dnf update 
                                yes | sudo dnf  install httpd 
                                echo "<h1>Server Details</h1><p><strong>Hostname:</strong> $(hostname)</p><p><strong>IP Address:</strong> $(hostname -I | cut -d" " -f1)</p>" > /var/www/html/index.html 
                                sudo systemctl restart httpd
                                EOF
}
# *******************************************************************
