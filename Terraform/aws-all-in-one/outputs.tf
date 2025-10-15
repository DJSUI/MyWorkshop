output "Instance_public_ip" {
  value = aws_instance.all-in-one-ec2.public_ip
}

output "vpc_id" {
  value = aws_vpc.main.id
}
