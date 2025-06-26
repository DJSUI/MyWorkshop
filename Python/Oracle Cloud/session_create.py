import oci
import time
import json 

#Read session info file 
with open('iplist.json','r') as f :
    session_info = json.load(f)


#Parameters  required by session 
bastionocid = session_info["bastionocid"] #Bastion OCID
target_port = session_info["target_port"]  #PORT
publickey = session_info["publickey"] #Publickey  -- It's used to set up sesssion ,and client could use private key to connect session
ip_list = session_info["ips"] # list of Server IP 
ssh_commands = []

#Prepare create session 
config = oci.config.from_file()
bastion_client = oci.bastion.BastionClient(config)

print("Ready to create Session , it would be cost 1 minute ")


for ip in ip_list:
    print(f"Creating session for {ip} ...")
    #Session config
    create_session_details = oci.bastion.models.CreateSessionDetails(
        display_name = "TestCreateByPython",
        bastion_id = bastionocid,
        key_details = oci.bastion.models.PublicKeyDetails(public_key_content=publickey),
        session_ttl_in_seconds = 10800,
        target_resource_details = oci.bastion.models.CreatePortForwardingSessionTargetResourceDetails(
            session_type = "PORT_FORWARDING",
            target_resource_private_ip_address = ip,
            target_resource_port = target_port,  
        ),
    )
    #Create Session
    create_session_response = bastion_client.create_session(
        create_session_details=create_session_details
    )
    #Check if session is active or not 
    while True:
        session = bastion_client.get_session(session_id=create_session_response.data.id)
        state = session.data.lifecycle_state
        if state == "ACTIVE":
            sshcmd = session.data.ssh_metadata["command"]
            ssh_commands.append(f"{ip}: {sshcmd}")
            break
        else:
            print(f"Session state: {state}, waiting...")
            time.sleep(5)
    

print("********All IP have been Generated !!!! ***********************************")
for cmd in ssh_commands:
    print(cmd)
