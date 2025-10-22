output "ssh_commands" {
  description = "Individual SSH commands for connecting to each instance."
  # The 'for' expression iterates over the list of public_ip attributes
  # (one for each count index) and formats them into a usable command string.
  value = [
    for ip in module.ec2_instance[*].public_ip : "ssh -i kissme ec2-user@${ip}"
  ]
}

# output "instance_names" {
#   description = "Names of the created instances."
#   value       = module.ec2_instance[*].name
# }

output "instance_public_ips" {
  description = "Public IP addresses for the instances."
  value       = module.ec2_instance[*].public_ip
}
