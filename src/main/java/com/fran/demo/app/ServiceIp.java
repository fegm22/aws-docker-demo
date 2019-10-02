package com.fran.demo.app;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;
import software.amazon.awssdk.regions.internal.util.EC2MetadataUtils;

import java.net.InetAddress;
import java.net.UnknownHostException;

@Slf4j
@RequiredArgsConstructor
@Service
public class ServiceIp {

    public Mono<String> getIp() {

        InetAddress ip = null;
        String hostname;

        try {
            ip = InetAddress.getLocalHost();
        } catch (UnknownHostException e) {
            log.error(e.getMessage());
        }

        assert ip != null;

        hostname = ip.getHostName();
        log.info("Your current IP address : " + ip);
        log.info("Your current Hostname : " + hostname);

        return Mono.just(EC2MetadataUtils.getInstanceId()
                + "<p>" + EC2MetadataUtils.getEC2InstanceRegion()
                + "<p>" + EC2MetadataUtils.getAvailabilityZone()
                + "<p>" + EC2MetadataUtils.getSecurityGroups()
                + "<p>" + EC2MetadataUtils.getUserData()
                + "<p>" + EC2MetadataUtils.getPrivateIpAddress()
                + "<p>" + ip.toString()
        );

    }
}
