
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
# * NETWORK RESOURCES *
# *******************************************************************
#VPC
resource "aws_vpc" "main" {
  cidr_block           = "10.0.0.0/16"
  enable_dns_support   = true
  enable_dns_hostnames = true
  tags = {
    Name = "all-in-one-vpc"
  }
}

#Public Subnet  
resource "aws_subnet" "public_subnet" {
  vpc_id            = aws_vpc.main.id
  cidr_block        = "10.0.1.0/24"
  availability_zone = "ap-northeast-1a"
  tags = {
    Name = "all-in-one-public-subnet"
  }
}

#Private Subnet  
resource "aws_subnet" "private_subnet" {
  vpc_id            = aws_vpc.main.id
  cidr_block        = "10.0.2.0/24"
  availability_zone = "ap-northeast-1a"
  tags = {
    Name = "all-in-one-private-subnet"
  }
}

#Internet Gateway 
resource "aws_internet_gateway" "igw" {
  vpc_id = aws_vpc.main.id
  tags = {
    Name = "all-in-one-igw"
  }
}

#Route Table For Public Subnet  
resource "aws_route_table" "public_rt" {
  vpc_id = aws_vpc.main.id
  route {
    cidr_block = "10.0.0.0/16"
    gateway_id = "local"
  }
  route {
    cidr_block = "0.0.0.0/0"
    gateway_id = aws_internet_gateway.igw.id
  }
  tags = {
    Name = "all-in-one-public-rt"
  }
}

#Route Table Association For Public Subnet  
resource "aws_route_table_association" "all-in-one-public-rta" {
  subnet_id      = aws_subnet.public_subnet.id
  route_table_id = aws_route_table.public_rt.id
}

#Route Table For Private Subnet  
resource "aws_route_table" "private_rt" {
  vpc_id = aws_vpc.main.id
  route {
    cidr_block = "10.0.0.0/16"
    gateway_id = "local"
  }
  tags = {
    Name = "all-in-one-private-rt"
  }
}
#Route Table Association For Private Subnet  
resource "aws_route_table_association" "all-in-one-private-rta" {
  subnet_id      = aws_subnet.private_subnet.id
  route_table_id = aws_route_table.private_rt.id
}

#Security Group 
resource "aws_security_group" "all-in-one-sg" {
  vpc_id = aws_vpc.main.id
  name   = "all-in-one-sg"

  ingress {
    description = "Allow ALL Inbound Traffic"
    from_port   = 0
    to_port     = 0
    protocol    = "-1"
    cidr_blocks = ["0.0.0.0/0"]

  }
  egress {
    description = "Allow ALL Outbound Traffic"
    from_port   = 0
    to_port     = 0
    protocol    = "-1"
    cidr_blocks = ["0.0.0.0/0"]
  }
  tags = {
    Name = "all-in-one-sg"
  }
}

# *******************************************************************
# * EC2 RESOURCE *
# *******************************************************************

#EC2 Public Instances
module "ec2_public_instances" {
  count                       = 1 # create numbers instances
  source                      = "terraform-aws-modules/ec2-instance/aws"
  ami                         = "ami-08f0737412a47a5ed" # Amazon Linux 2 AMI (HVM), SSD Volume Type
  name                        = "public_${count.index + 1}_instance"
  instance_type               = "t3.micro"
  key_name                    = "Kissme"
  subnet_id                   = aws_subnet.public_subnet.id
  vpc_security_group_ids      = [aws_security_group.all-in-one-sg.id]
  associate_public_ip_address = true

}

#EC2 Private Instances
module "ec2_private_instances" {
  count                       = 3 # create 3 instances
  source                      = "terraform-aws-modules/ec2-instance/aws"
  ami                         = "ami-08f0737412a47a5ed" # Amazon Linux 2 AMI (HVM), SSD Volume Type
  name                        = "private_${count.index + 1}_instance"
  instance_type               = "t3.micro"
  key_name                    = "Kissme"
  subnet_id                   = aws_subnet.private_subnet.id
  vpc_security_group_ids      = [aws_security_group.all-in-one-sg.id]
  associate_public_ip_address = false

}






