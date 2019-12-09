###User data for ASG on AWS
#!/bin/bash
yum -y update
yum install -y ruby
cd /home/ec2-user
curl -O https://aws-codedeploy-eu-west-1.s3.amazonaws.com/latest/install
chmod +x ./install
./install auto 

---
###Create the JAR
mvn clean install

###Build the images
docker build -t garridomosqueira/awsdemo .

###Push the image into my repository
docker push garridomosqueira/awsdemo

###Run the image
docker run -p 8080:8080 garridomosqueira/awsdemo


