# Getting Started


####User Data for ASG
#!/bin/bash
yum -y update
yum install -y ruby
cd /home/ec2-user
curl -O https://aws-codedeploy-eu-west-1.s3.amazonaws.com/latest/install
chmod +x ./install
./install auto
 sudo amazon-linux-extras install java-openjdk11 