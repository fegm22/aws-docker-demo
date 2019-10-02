package com.fran.demo.app;

import lombok.Builder;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import software.amazon.awssdk.regions.internal.util.EC2MetadataUtils;

import static java.lang.String.join;

@RequiredArgsConstructor
@Builder
@Getter
public class EC2Info {
    private final String InstanceId = EC2MetadataUtils.getInstanceId();
    private final String EC2InstanceRegion = EC2MetadataUtils.getEC2InstanceRegion();
    private final String AvailabilityZone = EC2MetadataUtils.getAvailabilityZone();
    private final String SecurityGroups = join(",", EC2MetadataUtils.getSecurityGroups());
    private final String UserData = EC2MetadataUtils.getUserData();
    private final String LocalHostName = EC2MetadataUtils.getLocalHostName();
}
