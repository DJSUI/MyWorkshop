output "instance_public_ips" {
  description = "Public IP addresses for the instances."
  value       = module.ec2_public_instances[*].public_ip
}

output "instance_private_ips" {
  description = "Private IP addresses for the instances."
  value       = module.ec2_private_instances[*].private_ip
}
