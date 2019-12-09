package com.fran.demo.app;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Builder;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Builder
@Getter
@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class EC2Info {
//    private final String instanceId = EC2MetadataUtils.getInstanceId();
//    private final String ec2InstanceRegion = EC2MetadataUtils.getEC2InstanceRegion();
//    private final String availabilityZone = EC2MetadataUtils.getAvailabilityZone();
//    private final String securityGroups = join(",", EC2MetadataUtils.getSecurityGroups());
//    private final String userData = EC2MetadataUtils.getUserData();
//    private final String localHostName = EC2MetadataUtils.getLocalHostName();

    private final String ipAddress;
    private final String hostName;
}
