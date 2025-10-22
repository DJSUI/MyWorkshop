provider "aws" {
  region = "ap-northeast-1"
}

data "aws_security_group" "existing_sg" {
  name = "let it come"

}


module "ec2_instance" {
  # not using  local module  instaead using terraform registry module
  # change the source to local path if you want to use local module
  count                       = 1 # create 3 instances
  source                      = "terraform-aws-modules/ec2-instance/aws"
  name                        = "dj-${count.index + 1}-instance"
  instance_type               = "t3.micro"
  key_name                    = "Kissme"
  subnet_id                   = "subnet-01cb8d0fde70c4da2"
  vpc_security_group_ids      = [data.aws_security_group.existing_sg.id]
  associate_public_ip_address = true
  ami                         = "ami-08f0737412a47a5ed"

}


#Tow way to create multiple instances
# 1. Using multiple module blocks (commented out below)

# 2. Using count or for_each (not implemented here)
#for example:  Using count or for_each  
# module "ec2_instances" {
#   source                      = "terraform-aws-modules/ec2-instance/aws"
#   count                  = 3
#   name                        = "dj-${each.key}-instance"
#   instance_type               = "t3.micro"
#   key_name                    = "Kissme"
#   subnet_id                   = "subnet-01cb8d0fde70c4da2"
#   vpc_security_group_ids      = [data.aws_security_group.existing_sg.id]
#   associate_public_ip_address = true
#   ami                         = "ami-08f0737412a47a5ed"
# }



# module "ec2_instance_two" {
#   source                      = "terraform-aws-modules/ec2-instance/aws"
#   name                        = "dj-second-instance"
#   instance_type               = "t3.micro"
#   key_name                    = "Kissme"
#   subnet_id                   = "subnet-01cb8d0fde70c4da2"
#   vpc_security_group_ids      = [data.aws_security_group.existing_sg.id]
#   associate_public_ip_address = true
#   ami                         = "ami-08f0737412a47a5ed"

# }
# module "ec2_instance_three" {
#   source                      = "terraform-aws-modules/ec2-instance/aws"
#   name                        = "dj-third-instance"
#   instance_type               = "t3.micro"
#   key_name                    = "Kissme"
#   subnet_id                   = "subnet-01cb8d0fde70c4da2"
#   vpc_security_group_ids      = [data.aws_security_group.existing_sg.id]
#   associate_public_ip_address = true
#   ami                         = "ami-08f0737412a47a5ed"

# }
