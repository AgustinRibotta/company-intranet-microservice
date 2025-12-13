package com.company.intranet.user_service.proxy;

import com.company.intranet.user_service.config.RHServiceFeignConfig;
import com.company.intranet.user_service.dtos.request.RhRequest;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(
        name = "rh-service",
        configuration = RHServiceFeignConfig .class
)
public interface RhServiceProxy {

    @PostMapping("rh-service/profiles/create")
    public ResponseEntity<Void> create(@RequestBody RhRequest request);
}
