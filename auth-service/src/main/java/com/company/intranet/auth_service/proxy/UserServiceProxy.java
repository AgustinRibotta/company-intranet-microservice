package com.company.intranet.auth_service.proxy;

import org.springframework.cloud.openfeign.FeignClient;

@FeignClient(name = "user-service", url ="localhost:8100" )
public interface UserServiceProxy {

}
