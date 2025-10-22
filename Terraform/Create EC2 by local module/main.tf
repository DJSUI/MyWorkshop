provider "aws" {
  region = "ap-northeast-1"
}

data "aws_security_group" "existing_sg" {
  name = "let it come"

}


module "ec2_instance" {
  source                 = "./modules/ec2_instance"
  name                   = "dj-single-instance"
  instance_type          = "t3.micro"
  key_name               = "Kissme"
  subnet_id              = "subnet-01cb8d0fde70c4da2"
  vpc_security_group_ids = [data.aws_security_group.existing_sg.id]
  ami                    = "ami-08f0737412a47a5ed"

}
